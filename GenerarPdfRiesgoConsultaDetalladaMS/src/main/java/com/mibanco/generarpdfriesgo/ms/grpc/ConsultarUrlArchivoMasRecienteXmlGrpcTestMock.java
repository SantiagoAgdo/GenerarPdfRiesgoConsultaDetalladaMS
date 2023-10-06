package com.mibanco.generarpdfriesgo.ms.grpc;

import com.mibanco.generarpdfriesgo.ms.utils.exceptions.ApplicationExceptionValidation;
import com.mibanco.historialconsultaclientecentralriesgo.es.ConsultarUrlArchivoMasRecienteXmlGrpcGrpc;
import com.mibanco.historialconsultaclientecentralriesgo.es.ConsultarUrlArchivoMasRecienteXmlInput;
import com.mibanco.historialconsultaclientecentralriesgo.es.ResponseConsultaUrlArchivoMasRecienteXmlOutput;
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
public class ConsultarUrlArchivoMasRecienteXmlGrpcTestMock  extends ConsultarUrlArchivoMasRecienteXmlGrpcGrpc.ConsultarUrlArchivoMasRecienteXmlGrpcImplBase {

    public static final Logger LOG = LoggerFactory.getLogger(ConsultarUrlArchivoMasRecienteXmlGrpcTestMock.class);

    @Override
    @Blocking
    public void consultarUrlArchivoMasRecienteXml(ConsultarUrlArchivoMasRecienteXmlInput request, StreamObserver<ResponseConsultaUrlArchivoMasRecienteXmlOutput> responseObserver){

        LOG.info("Inicia consultarUrlArchivoMasRecienteXml por GRPC Test MOCK");
        try {

            ResponseConsultaUrlArchivoMasRecienteXmlOutput response = ResponseConsultaUrlArchivoMasRecienteXmlOutput.newBuilder()
                    .setUrl("url1")
                    .build();

            LOG.info("Finaliza consultarUrlArchivoMasRecienteXml por GRPC Test MOCK");
            responseObserver.onNext(response);
            responseObserver.onCompleted();

        } catch (ApplicationExceptionValidation e) {
            LOG.error("Error de validaciones en consultarUrlArchivoMasRecienteXml  por GRPC Test MOCK");
            responseObserver.onError(e);

        } catch (Exception e) {
            StatusException statusException = responseExceptionGrpc(Status.INTERNAL, e.getMessage());
            responseObserver.onError(statusException);
        }

    }

    private StatusException responseExceptionGrpc(Status statusCode, String exceptionMessage) {

        LOG.error("Exception: " + exceptionMessage);

        Metadata metadata = new Metadata();
        metadata.put(Metadata.Key.of("Error: ", Metadata.ASCII_STRING_MARSHALLER), exceptionMessage);

        return statusCode.asException(metadata);
    }
}
