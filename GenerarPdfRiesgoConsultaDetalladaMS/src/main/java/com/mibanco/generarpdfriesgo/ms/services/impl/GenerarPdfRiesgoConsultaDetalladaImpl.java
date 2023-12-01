package com.mibanco.generarpdfriesgo.ms.services.impl;



import com.mibanco.archivofic.us.ArchivoConsultado;
import com.mibanco.archivofic.us.ArchivoFicServiceGrpcGrpc;
import com.mibanco.archivofic.us.Empty;
import com.mibanco.generarpdfriesgo.ms.constants.Constants;
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
    PdfGeneratorService pdfGeneratorService;

    @Inject
    RiesgoConsultaDetalladaDaoImpl riesgoConsultaDetalladaDao;

    @GrpcClient("clientehistorialconsultariesgo")
    com.mibanco.historialconsultaclientecentralriesgo.es.ConsultarUrlArchivoMasRecienteXmlGrpcGrpc.ConsultarUrlArchivoMasRecienteXmlGrpcBlockingStub serviceGrpc;

    @GrpcClient("clientearchivo")
    ArchivoFicServiceGrpcGrpc.ArchivoFicServiceGrpcBlockingStub  serviceArchivoGrpc;

    @Override
    public boolean generarRiesgoHistoricoEndeudamiento(String numeroCliente) {
        LOG.info("Inicia consulta Detallada de riesgo");

        ConsultarUrlArchivoMasRecienteXmlInput consultarUrlArchivoMasRecienteXmlInput = ConsultarUrlArchivoMasRecienteXmlInput.newBuilder()
                .setTipoDocumento("CC")
                .setNumeroDocumento("10002")
                .setDigitoVerificacion("1")
                .build();

        if ((Boolean) comando.execute(consultarUrlArchivoMasRecienteXmlInput)) {

            LOG.info("Inicia proceso de composición");
            try {
                LOG.info("Inicia consulta a clienteHistorialConsultaRiesgo por gRPC");
                ResponseConsultaUrlArchivoMasRecienteXmlOutput respuestaGRPCService = serviceGrpc.consultarUrlArchivoMasRecienteXml(consultarUrlArchivoMasRecienteXmlInput);

                LOG.info("Inicia consulta a clienteArchivo por gRPC");
                Empty empty = Empty.newBuilder().build();
                ArchivoConsultado responseArchivoGrpc = serviceArchivoGrpc.consultarArchivo(empty);

//                commandXML.execute(responseArchivoGrpc);

                PdfGeneratorService.generatePdf("test");

            } catch (Exception e) {
                LOG.error("Error en consulta a clienteHistorialConsultaRiesgo por gRPC");
                throw new ApplicationException(
                        Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),
                        Constants.ERROR_SERVICIO + " generarRiesgoHistoricoEndeudamiento, error en consulta gRPC clienteHistorialConsultaRiesgo"
                );
            }
        } else {
            LOG.warn("Comandos no ejecutados");
            throw new ApplicationException(
                    Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),
                    Constants.ERROR_SERVICIO + " generarRiesgoHistoricoEndeudamiento, error en comando"
            );
        }

        GenerarPdfRiesgoConsultaDetalladaEntity generarPdfRiesgoConsultaDetalladaEntity = riesgoConsultaDetalladaDao.generarRiesgoHistoricoEndeudamiento(numeroCliente);

        LOG.info("Termina consulta Detallada de riesgo");
        return generarPdfRiesgoConsultaDetalladaEntity != null;
    }


}
