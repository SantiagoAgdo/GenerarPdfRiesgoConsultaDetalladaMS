package com.mibanco.grpc;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.mibanco.generarpdfriesgo.ms.ConsultarUrlArchivoMasRecienteXmlGrpc;
import com.mibanco.generarpdfriesgo.ms.gen.type.GenerarRiesgoConsultaDetalladaInput;
import com.mibanco.generarpdfriesgo.ms.utils.mappers.RiesgoConsultaMapperGrpc;
import io.quarkus.grpc.GrpcClient;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import static org.junit.jupiter.api.Assertions.assertThrows;


@QuarkusTest
public class GenerarPdfControllerGrpcTest {

    @GrpcClient
    ConsultarUrlArchivoMasRecienteXmlGrpc client;

    @Inject
    ObjectMapper objectMapper;

    @Inject
    RiesgoConsultaMapperGrpc mapperGRPC;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void generarPdfConsultaDetalladaGRPCCatchTest()  {
        CompletableFuture<Boolean> message = new CompletableFuture<>();

        assertThrows(TimeoutException.class, () -> {
            String jsonString = Files.readString(Paths.get("src/main/resources/json/ms-generarconsulta-api.json"));
            GenerarRiesgoConsultaDetalladaInput consultaType = objectMapper.readValue(jsonString, GenerarRiesgoConsultaDetalladaInput.class);

            client.generarRiesgoHistoricoEndeudamiento(mapperGRPC.consultaToGRPC(consultaType))
                    .subscribe()
                    .with(reply -> message.complete(reply.getObj()));

            message.get(5, TimeUnit.SECONDS);
        });
    }



}
