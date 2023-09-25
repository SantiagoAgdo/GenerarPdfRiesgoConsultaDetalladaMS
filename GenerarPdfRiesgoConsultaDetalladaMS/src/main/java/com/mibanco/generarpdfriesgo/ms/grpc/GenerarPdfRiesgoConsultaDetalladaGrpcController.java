package com.mibanco.generarpdfriesgo.ms.grpc;

import com.mibanco.generarpdfriesgo.ms.ConsultarUrlArchivoMasRecienteXmlGrpcGrpc;
import com.mibanco.generarpdfriesgo.ms.GenerarRiesgoConsultaDetalladaInput;
import com.mibanco.generarpdfriesgo.ms.ResponseGenerarRiesgoConsultaDetallada;
import com.mibanco.generarpdfriesgo.ms.services.impl.GenerarPdfRiesgoConsultaDetalladaImpl;
import com.mibanco.generarpdfriesgo.ms.utils.exceptions.ApplicationExceptionValidation;
import com.mibanco.generarpdfriesgo.ms.utils.mappers.RiesgoConsultaMapperGrpc;
import com.mibanco.generarpdfriesgo.ms.utils.validators.GenerarPdfRiesgoConsultaDetalladaValidator;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.stub.StreamObserver;
import io.quarkus.grpc.GrpcClient;
import io.quarkus.grpc.GrpcService;
import io.smallrye.common.annotation.Blocking;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@GrpcService
public class GenerarPdfRiesgoConsultaDetalladaGrpcController extends ConsultarUrlArchivoMasRecienteXmlGrpcGrpc.ConsultarUrlArchivoMasRecienteXmlGrpcImplBase {

    public static final Logger LOG = LoggerFactory.getLogger(GenerarPdfRiesgoConsultaDetalladaGrpcController.class);

    @Inject
    GenerarPdfRiesgoConsultaDetalladaImpl service;

    @Inject
    RiesgoConsultaMapperGrpc mapper;


    @Inject
    GenerarPdfRiesgoConsultaDetalladaValidator validator;

    @Override
    @Blocking
    public void generarRiesgoHistoricoEndeudamiento(GenerarRiesgoConsultaDetalladaInput request, StreamObserver<ResponseGenerarRiesgoConsultaDetallada> responseObserver){

        LOG.info("Inicia generacion de riesgo Historico por GRPC");
        try {

            validator.validarConsulta(request);
            boolean rptService = service.generarRiesgoHistoricoEndeudamiento(request.getTipoDocumento(),request.getNumeroDocumento(), request.getDigitoVerificacion());

            ResponseGenerarRiesgoConsultaDetallada response = ResponseGenerarRiesgoConsultaDetallada.newBuilder().setObj(rptService).build();
            LOG.info("Finaliza generacion de riesgo Historico por GRPC");

            responseObserver.onNext(response);
            responseObserver.onCompleted();

        } catch (ApplicationExceptionValidation e) {

            StatusException statusException = responseExceptionGrpc(Status.INVALID_ARGUMENT, e.getMessage());
            responseObserver.onError(statusException);

        } catch (Exception e) {
            StatusException statusException = responseExceptionGrpc(Status.INTERNAL, e.getMessage());
            responseObserver.onError(statusException);
        }
    }

    private StatusException responseExceptionGrpc(Status statusCode, String exceptionMessage) {

        LOG.error(exceptionMessage + "Exception: " + exceptionMessage);

        Metadata metadata = new Metadata();
        metadata.put(Metadata.Key.of("Error: ", Metadata.ASCII_STRING_MARSHALLER), exceptionMessage);

        return statusCode.asException(metadata);
    }
}
