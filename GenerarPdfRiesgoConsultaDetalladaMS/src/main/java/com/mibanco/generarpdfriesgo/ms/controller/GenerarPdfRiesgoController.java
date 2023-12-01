package com.mibanco.generarpdfriesgo.ms.controller;

import com.mibanco.generarpdfriesgo.ms.constants.Constants;
import com.mibanco.generarpdfriesgo.ms.gen.contract.V1GenerarPdfRiesgoConsultaDetallada;
import com.mibanco.generarpdfriesgo.ms.services.impl.GenerarPdfRiesgoConsultaDetalladaImpl;
import com.mibanco.generarpdfriesgo.ms.services.impl.PdfGeneratorService;
import com.mibanco.generarpdfriesgo.ms.utils.exceptions.ApplicationException;
import com.mibanco.generarpdfriesgo.ms.utils.validators.GenerarPdfRiesgoConsultaDetalladaValidator;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GenerarPdfRiesgoController implements V1GenerarPdfRiesgoConsultaDetallada {

    public static final Logger LOG = LoggerFactory.getLogger(GenerarPdfRiesgoController.class);

    @Inject
    GenerarPdfRiesgoConsultaDetalladaValidator validator;

    @Inject
    GenerarPdfRiesgoConsultaDetalladaImpl service;

    @Inject
    PdfGeneratorService pdf;


    @Override
    public Response generaRiesgoHistorial(String numeroCliente) {
        LOG.info("Inicia generaRiesgoHistorial en GenerarPdfRiesgoController");

        try {
//            validator.validarConsulta(numeroCliente);
//
            service.generarRiesgoHistoricoEndeudamiento(numeroCliente);
//
//            List<Byte> responseConsultaDetallada = new ArrayList<>();
//            String responseTxt = "Histórico Endeudamiento Generado";
//            responseConsultaDetallada.add(responseTxt.getBytes()[0]);

            pdf.generatePdf("/Users/santiagoagudelo/Documents/pdfpruebaa/generaRiesgoHistorial1222.pdf");

            LOG.info("Finaliza generaRiesgoHistorial en GenerarPdfRiesgoController");
            return Response.status(Response.Status.CREATED).entity("oki doki").build();


        } catch (ApplicationException e) {
            LOG.error("Error en validaciones para generar histórico de endeudamiento - GenerarPdfRiesgoController");
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();

        } catch (Exception e) {
            LOG.error(Constants.ERROR_SERVICIO + "generaRiesgoHistorial en GenerarPdfRiesgoController: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(Constants.ERROR_SERVICIO + "generaRiesgoHistorial, exception: " + e.getMessage()).build();
        }
    }


}
