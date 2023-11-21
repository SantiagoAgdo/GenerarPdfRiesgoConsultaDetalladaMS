package com.mibanco.generarpdfriesgo.ms.grpc;

import com.mibanco.generarpdfriesgo.ms.ConsultarUrlArchivoMasRecienteXmlGrpcGrpc;
import com.mibanco.generarpdfriesgo.ms.GenerarRiesgoConsultaDetalladaInput;
import com.mibanco.generarpdfriesgo.ms.ResponseGenerarRiesgoConsultaDetallada;
import com.mibanco.generarpdfriesgo.ms.services.impl.GenerarPdfRiesgoConsultaDetalladaImpl;
import com.mibanco.generarpdfriesgo.ms.utils.exceptions.ApplicationException;
import com.mibanco.generarpdfriesgo.ms.utils.exceptions.ApplicationExceptionValidation;
import com.mibanco.generarpdfriesgo.ms.utils.validators.GenerarPdfRiesgoConsultaDetalladaValidator;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.stub.StreamObserver;
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
    GenerarPdfRiesgoConsultaDetalladaValidator validator;

    @Override
    @Blocking
    public void generarRiesgoHistoricoEndeudamiento(GenerarRiesgoConsultaDetalladaInput request, StreamObserver<ResponseGenerarRiesgoConsultaDetallada> responseObserver) {

        LOG.info("Inicia generacion de riesgo Historico por GRPC");
        try {
            validator.validarConsulta(request.getNumeroCliente());
            boolean respuestaServicio = service.generarRiesgoHistoricoEndeudamiento(request.getNumeroCliente());

            ResponseGenerarRiesgoConsultaDetallada response =
                    ResponseGenerarRiesgoConsultaDetallada.newBuilder().setObj(respuestaServicio).build();
            LOG.info("Finaliza generación de riesgo Historico por GRPC");

            responseObserver.onNext(response);
            responseObserver.onCompleted();

        } catch (ApplicationException e) {
            handleGrpcException(responseObserver, Status.INVALID_ARGUMENT, e.getMessage());

        } catch (Exception e) {
            handleGrpcException(responseObserver, Status.INTERNAL, e.getMessage());
        }
    }

    private void handleGrpcException(StreamObserver<ResponseGenerarRiesgoConsultaDetallada> responseObserver,  Status status, String exceptionMessage) {
        LOG.error("Excepción: " +  exceptionMessage);

        Metadata metadata = new Metadata();
        metadata.put(Metadata.Key.of("Error: ", Metadata.ASCII_STRING_MARSHALLER), exceptionMessage);

        responseObserver.onError(status.asException(metadata));
    }

}
