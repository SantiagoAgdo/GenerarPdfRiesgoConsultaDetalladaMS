//package com.mibanco.generarpdfriesgo.ms.grpc;
//
//import com.mibanco.archivo.us.ArchivoByUrlGrpc;
//import com.mibanco.archivo.us.ArchivoGrpc;
//import com.mibanco.archivo.us.ArchivoServiceGrpcGrpc;
//import com.mibanco.archivo.us.Creado;
//import com.mibanco.generarpdfriesgo.ms.utils.exceptions.ApplicationExceptionValidation;
//import com.mibanco.historialconsultaclientecentralriesgo.es.ConsultarUrlArchivoMasRecienteXmlGrpcGrpc;
//import com.mibanco.historialconsultaclientecentralriesgo.es.ConsultarUrlArchivoMasRecienteXmlInput;
//import com.mibanco.historialconsultaclientecentralriesgo.es.ResponseConsultaUrlArchivoMasRecienteXmlOutput;
//import io.grpc.Metadata;
//import io.grpc.Status;
//import io.grpc.StatusException;
//import io.grpc.stub.StreamObserver;
//import io.quarkus.grpc.GrpcService;
//import io.smallrye.common.annotation.Blocking;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.text.MessageFormat;
//
//@GrpcService
//public class ArchivoGrpcControllerTestMock extends ArchivoServiceGrpcGrpc.ArchivoServiceGrpcImplBase {
//
//    public static final Logger LOG = LoggerFactory.getLogger(ArchivoGrpcControllerTestMock.class);
//
//    @Override
//    @Blocking
//    public void consultarArchivoPorUbicacion(ArchivoByUrlGrpc archivoByUrlGrpc, StreamObserver<Creado> responseObserver) {
//        LOG.info("Inicia consultarArchivoPorUbicacion gRPC Test MOCK");
//
//        try {
//            ArchivoGrpc archivo = ArchivoGrpc.newBuilder()
//                    .setArchivoID("1")
//                    .setExtensionArchivo(".pdf")
//                    .setNombreArchivo("url1")
//                    .setUrl("www.url1.com")
//                    .setUrlPublica(true)
//                    .build();
//
//            Creado response = Creado.newBuilder().setArchivo(archivo).build();
//
//            LOG.info("Termina consultarArchivoPorUbicacion gRPC Test MOCK");
//            responseObserver.onNext(response);
//            responseObserver.onCompleted();
//
//        } catch (Exception e) {
//            handleGrpcException(responseObserver, Status.INTERNAL, e.getMessage());
//        }
//    }
//
//    private void handleGrpcException(StreamObserver<?> responseObserver, Status statusCode, String exceptionMessage) {
//        LOG.error("Excepción: " + exceptionMessage);
//
//        Metadata metadata = new Metadata();
//        metadata.put(Metadata.Key.of("Error: ", Metadata.ASCII_STRING_MARSHALLER), exceptionMessage);
//
//        responseObserver.onError(statusCode.asException(metadata));
//    }
//
//}
