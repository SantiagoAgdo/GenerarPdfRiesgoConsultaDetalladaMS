package com.mibanco.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.mibanco.generarpdfriesgo.ms.controller.GenerarPdfRiesgoController;
import com.mibanco.generarpdfriesgo.ms.gen.type.GenerarPdfRiesgoConsultaDetalladaInput;
import com.mibanco.generarpdfriesgo.ms.gen.type.GenerarRiesgoConsultaDetalladaInput;
import com.mibanco.generarpdfriesgo.ms.services.impl.GenerarPdfRiesgoConsultaDetalladaImpl;
import com.mibanco.generarpdfriesgo.ms.utils.validators.GenerarPdfRiesgoConsultaDetalladaValidator;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@QuarkusTest
public class GenerarPdfControllerTest {

    @Inject
    ObjectMapper objectMapper;

    @Mock
    private ObjectMapper mockObjectMapper;

    @Mock
    private GenerarPdfRiesgoConsultaDetalladaImpl service;
    @Mock
    private GenerarPdfRiesgoConsultaDetalladaValidator validator;

    private GenerarPdfRiesgoController controller;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        service = mock(GenerarPdfRiesgoConsultaDetalladaImpl.class);
        validator = mock(GenerarPdfRiesgoConsultaDetalladaValidator.class);
        controller = new GenerarPdfRiesgoController();
    }

    @Test
    void generaRiesgoHistorialTestCatch() throws IOException {

        when(mockObjectMapper.readValue(any(byte[].class), any(Class.class))).thenReturn(new GenerarPdfRiesgoConsultaDetalladaInput());

        String jsonString = new String(Files.readAllBytes(Paths.get("src/main/resources/json/ms-generarconsulta-api.json")), StandardCharsets.UTF_8);
        GenerarRiesgoConsultaDetalladaInput inputRequest = objectMapper.readValue(jsonString, GenerarRiesgoConsultaDetalladaInput.class);

        given()
                .contentType(ContentType.JSON)
                .body(inputRequest)
                .when()
                .post("v1/ms/central-riesgo/detallada/pdf/CC/10002/1")
                .then()
                .statusCode(500);
    }

    @Test
    void generaRiesgoHistorialTestCatchValidators() throws IOException {

        when(mockObjectMapper.readValue(any(byte[].class), any(Class.class))).thenReturn(new GenerarPdfRiesgoConsultaDetalladaInput());

        String jsonString = new String(Files.readAllBytes(Paths.get("src/main/resources/json/ms-generarconsulta-api.json")), StandardCharsets.UTF_8);
        GenerarRiesgoConsultaDetalladaInput inputRequest = objectMapper.readValue(jsonString, GenerarRiesgoConsultaDetalladaInput.class);

        given()
                .contentType(ContentType.JSON)
                .body(inputRequest)
                .when()
                .post("v1/ms/central-riesgo/detallada/pdf/CC/10002/999")
                .then()
                .statusCode(400);
    }
}
