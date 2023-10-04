package com.mibanco.generarpdfriesgo.ms.services.impl;


import com.mibanco.archivo.us.ArchivoByUrlGrpc;
import com.mibanco.archivo.us.ArchivoServiceGrpcGrpc;
import com.mibanco.archivo.us.Creado;
import com.mibanco.generarpdfriesgo.ms.constans.Constants;
import com.mibanco.generarpdfriesgo.ms.dao.contract.impl.RiesgoConsultaDetalladaDaoImpl;
import com.mibanco.generarpdfriesgo.ms.dao.entity.GenerarPdfRiesgoConsultaDetalladaEntity;
import com.mibanco.generarpdfriesgo.ms.services.command.bussiness.ProcesarDatosXMLCommand;
import com.mibanco.generarpdfriesgo.ms.services.command.bussiness.ValidarInformacionRenovacionCDTCommand;
import com.mibanco.generarpdfriesgo.ms.services.contract.IGenerarPdfRiesgoConsultaDetallada;
import com.mibanco.generarpdfriesgo.ms.utils.exceptions.ApplicationException;
import com.mibanco.historialconsultaclientecentralriesgo.es.ConsultarUrlArchivoMasRecienteXmlInput;
import com.mibanco.historialconsultaclientecentralriesgo.es.ResponseConsultaUrlArchivoMasRecienteXmlOutput;
import io.quarkus.grpc.GrpcClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class GenerarPdfRiesgoConsultaDetalladaImpl implements IGenerarPdfRiesgoConsultaDetallada {

    public static final Logger LOG = LoggerFactory.getLogger(GenerarPdfRiesgoConsultaDetalladaImpl.class);

    @Inject
    ValidarInformacionRenovacionCDTCommand comando;

    @Inject
    ProcesarDatosXMLCommand commandXML;

    @Inject
    RiesgoConsultaDetalladaDaoImpl riesgoConsultaDetalladaDao;

    @GrpcClient("clientehistorialconsultariesgo")
    com.mibanco.historialconsultaclientecentralriesgo.es.ConsultarUrlArchivoMasRecienteXmlGrpcGrpc.ConsultarUrlArchivoMasRecienteXmlGrpcBlockingStub serviceGrpc;

    @GrpcClient("clientearchivo")
    ArchivoServiceGrpcGrpc.ArchivoServiceGrpcBlockingStub serviceArchivoGrpc;

    @Override
    public boolean generarRiesgoHistoricoEndeudamiento(String tipoDocumento, String numeroDocumento, String digitoVerificacion) {

        LOG.info("Inicia consulta Detallada de riesgo ");

        ConsultarUrlArchivoMasRecienteXmlInput dataRequest = ConsultarUrlArchivoMasRecienteXmlInput.newBuilder()
                .setTipoDocumento(tipoDocumento)
                .setNumeroDocumento(numeroDocumento)
                .setDigitoVerificacion(digitoVerificacion)
                .build();

        Boolean command = (Boolean) comando.execute(dataRequest);

        if (command) {

            LOG.info("Inicia proceso de composicion");
            LOG.info("=============================");
            try {
                LOG.info("Inicia consulta a clienteHistorialConsultaRiesgo por GRPC");
                ResponseConsultaUrlArchivoMasRecienteXmlOutput respuestaGRPCService = serviceGrpc.consultarUrlArchivoMasRecienteXml(dataRequest);

                LOG.info("Inicia consulta a clienteArchivo por GRPC");
                ArchivoByUrlGrpc url = ArchivoByUrlGrpc.newBuilder().setUrl(respuestaGRPCService.getUrl().toString()).build();
                Creado responseArchivoGrpc = serviceArchivoGrpc.consultarArchivoPorUbicacion(url);

                commandXML.execute(responseArchivoGrpc);

            } catch (Exception e) {

                LOG.error("Error en consulta a clientehistorialconsultariesgo por GRPC");
                throw new ApplicationException(
                        Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), Constants.ERROR_SERVICIO + " generarRiesgoHistoricoEndeudamiento, error en consulta GRPC clientehistorialconsultariesgo"
                );
            }
        } else {

            LOG.warn("Commandos no ejecutados");
            throw new ApplicationException(
                    Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), Constants.ERROR_SERVICIO + " generarRiesgoHistoricoEndeudamiento, error en commando"
            );
        }

        GenerarPdfRiesgoConsultaDetalladaEntity dataRiesgoConsulta = riesgoConsultaDetalladaDao.generarRiesgoHistoricoEndeudamiento(tipoDocumento, numeroDocumento, digitoVerificacion);

        LOG.info("Termina consulta Detallada de riesgo");
        return dataRiesgoConsulta != null;
    }
}
