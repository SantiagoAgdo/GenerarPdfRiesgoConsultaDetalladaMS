package com.mibanco.generarpdfriesgo.ms.services.impl;


import com.mibanco.generarpdfriesgo.ms.*;
import com.mibanco.generarpdfriesgo.ms.dao.contract.impl.RiesgoConsultaDetalladaDaoImpl;
import com.mibanco.generarpdfriesgo.ms.dao.entity.GenerarPdfRiesgoConsultaDetalladaEntity;
import com.mibanco.generarpdfriesgo.ms.gen.type.TipoDocumentoEnum;
import com.mibanco.generarpdfriesgo.ms.services.command.bussiness.ValidarInformacionRenovacionCDTCommand;
import com.mibanco.generarpdfriesgo.ms.services.contract.IGenerarPdfRiesgoConsultaDetallada;
import com.mibanco.generarpdfriesgo.ms.utils.mappers.RiesgoConsultaMapper;
import com.mibanco.generarpdfriesgo.ms.utils.mappers.RiesgoConsultaMapperGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.quarkus.grpc.GrpcClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class GenerarPdfRiesgoConsultaDetalladaImpl implements IGenerarPdfRiesgoConsultaDetallada {

    public static final Logger LOG = LoggerFactory.getLogger(GenerarPdfRiesgoConsultaDetalladaImpl.class);

    @Inject
    ValidarInformacionRenovacionCDTCommand command;

    @Inject
    RiesgoConsultaMapperGrpc mapperGrpc;

    @Inject
    RiesgoConsultaDetalladaDaoImpl riesgoConsultaDetalladaDao;

    @GrpcClient("clientehistorialconsultariesgo")
    ConsultarUrlArchivoMasRecienteXmlGrpcGrpc.ConsultarUrlArchivoMasRecienteXmlGrpcBlockingStub serviceGrpc;

    @GrpcClient("clientearchivo")
    ConsultarUrlArchivoMasRecienteXmlGrpcGrpc.ConsultarUrlArchivoMasRecienteXmlGrpcBlockingStub serviceArchivoGrpc;

    @Override
    public boolean generarRiesgoHistoricoEndeudamiento(String tipoDocumento, String numeroDocumento, String digitoVerificacion) {
        LOG.info("Inicia consulta Detallada de riesgo ");
        ConsultarUrlArchivoMasRecienteXmlInput data = ConsultarUrlArchivoMasRecienteXmlInput.newBuilder()
                .setTipoDocumento(tipoDocumento)
                .setNumeroDocumento(numeroDocumento)
                .setDigitoVerificacion(digitoVerificacion)
                .build();
        LOG.info(serviceGrpc.toString());
        Boolean validacionCmd = (Boolean) command.execute(data);

        if (validacionCmd){
//            ResponseConsultaUrlArchivoMasRecienteXmlOutput rptGrpc = serviceGrpc.consultarUrlArchivoMasRecienteXml(data);
//            System.out.println(rptGrpc);

//            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8088).build();
//            ConsultarUrlArchivoMasRecienteXmlGrpcGrpc.ConsultarUrlArchivoMasRecienteXmlGrpcBlockingStub blockingStub
//                    = ConsultarUrlArchivoMasRecienteXmlGrpcGrpc.newBlockingStub(channel);
//
////            HelloRequest request = HelloRequest.newBuilder().setName("Bard").build();
//            ResponseConsultaUrlArchivoMasRecienteXmlOutput response = blockingStub.consultarUrlArchivoMasRecienteXml(data);

            ArchivoByUrlGrpc url = ArchivoByUrlGrpc.newBuilder().setUrl("www.test.com").build();
            Creado rptArchivo =  serviceArchivoGrpc.consultarArchivoPorUbicacion(url);

            System.out.println(rptArchivo);
//            System.out.println(response.getUrl());

//            channel.shutdown();
        }else{


        }
        GenerarPdfRiesgoConsultaDetalladaEntity dataRiesgoConsulta = riesgoConsultaDetalladaDao.generarRiesgoHistoricoEndeudamiento(tipoDocumento,numeroDocumento,digitoVerificacion);

        LOG.info("Termina consulta Detallada de riesgo");
        return dataRiesgoConsulta != null;
    }
}
