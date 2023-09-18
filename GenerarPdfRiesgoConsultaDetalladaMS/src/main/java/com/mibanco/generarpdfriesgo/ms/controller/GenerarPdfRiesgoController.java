package com.mibanco.generarpdfriesgo.ms.controller;

import com.mibanco.generarpdfriesgo.ms.gen.contract.V1GenerarPdfRiesgoConsultaDetallada;
import com.mibanco.generarpdfriesgo.ms.gen.type.TipoDocumentoEnum;
import com.mibanco.generarpdfriesgo.ms.services.impl.PdfGeneratorService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import java.io.File;
import java.io.IOException;

public class GenerarPdfRiesgoController implements V1GenerarPdfRiesgoConsultaDetallada {

    @Inject
    PdfGeneratorService pdfGeneratorService;

    @Override
    public Response generaRiesgoHistorial(TipoDocumentoEnum tipoDocumento, String numeroDocumento, String digitoVerificacion) {
        try {
            String outputPath = "/Users/santiagoagudelo/Documents/pdfpruebaa/generaRiesgoHistorial.pdf";
            pdfGeneratorService.generatePdf(outputPath, "funciona");

            File file = new File(outputPath);
            return Response.ok(file)
                    .header("Content-Disposition", "attachment; filename=output.pdf")
                    .build();
        } catch (IOException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error al generar el PDF: " + e.getMessage())
                    .build();
        }
    }

}
