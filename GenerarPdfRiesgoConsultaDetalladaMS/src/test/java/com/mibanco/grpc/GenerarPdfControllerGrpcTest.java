package com.mibanco.grpc;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.mibanco.generarpdfriesgo.ms.ConsultarUrlArchivoMasRecienteXmlGrpc;
import com.mibanco.generarpdfriesgo.ms.gen.type.GenerarRiesgoConsultaDetalladaInput;
import com.mibanco.generarpdfriesgo.ms.services.impl.GenerarPdfRiesgoConsultaDetalladaImpl;
import com.mibanco.generarpdfriesgo.ms.utils.mappers.RiesgoConsultaMapperGrpc;
import io.quarkus.grpc.GrpcClient;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import static org.junit.jupiter.api.Assertions.assertThrows;


@QuarkusTest
public class GenerarPdfControllerGrpcTest {

    @GrpcClient
    ConsultarUrlArchivoMasRecienteXmlGrpc client;

    @Inject
    GenerarPdfRiesgoConsultaDetalladaImpl serviceImpl;
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
            String jsonString = new String(Files.readAllBytes(Paths.get("src/main/resources/json/ms-generarconsulta-api.json")), StandardCharsets.UTF_8);
            GenerarRiesgoConsultaDetalladaInput consultaType = objectMapper.readValue(jsonString, GenerarRiesgoConsultaDetalladaInput.class);

            client.generarRiesgoHistoricoEndeudamiento(mapperGRPC.consultaToGRPC(consultaType))
                    .subscribe()
                    .with(reply -> message.complete(reply.getObj()));

            message.get(5, TimeUnit.SECONDS).booleanValue();
        });
    }



}
