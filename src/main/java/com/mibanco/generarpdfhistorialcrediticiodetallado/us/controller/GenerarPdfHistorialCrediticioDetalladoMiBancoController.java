package com.mibanco.generarpdfhistorialcrediticiodetallado.us.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mibanco.generarpdfhistorialcrediticiodetallado.us.constants.Constants;
import com.mibanco.generarpdfhistorialcrediticiodetallado.us.gen.contract.V1GenerarSolicitudCreditoTS;
import com.mibanco.generarpdfhistorialcrediticiodetallado.us.gen.type.HistorialCreditoBaseArchivoXmlInput;
import com.mibanco.generarpdfhistorialcrediticiodetallado.us.gen.type.HistorialCreditoBaseArchivoXmlOutput;
import com.mibanco.generarpdfhistorialcrediticiodetallado.us.gen.type.HistorialCreditoBaseXmlInput;
import com.mibanco.generarpdfhistorialcrediticiodetallado.us.service.contract.IGenerarPdfHistorialCrediticioDetalladoMiBancoService;
import com.mibanco.generarpdfhistorialcrediticiodetallado.us.util.exceptions.ApplicationException;
import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import net.sf.jasperreports.engine.JRException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@RegisterForReflection(targets = {HistorialCreditoBaseArchivoXmlInput.class, HistorialCreditoBaseArchivoXmlOutput.class})
public class GenerarPdfHistorialCrediticioDetalladoMiBancoController implements V1GenerarSolicitudCreditoTS {

    public static final Logger LOG = LoggerFactory.getLogger(GenerarPdfHistorialCrediticioDetalladoMiBancoController.class);
    @Inject
    ObjectMapper objectMapper;
    @Inject
    IGenerarPdfHistorialCrediticioDetalladoMiBancoService generarSolicitudCreditoMiBancoControllerService;

    @Override
    public Response generarPDFHistorialCreditoBaseArchivoXml(String jwt, HistorialCreditoBaseArchivoXmlInput historialCreditoBaseArchivoXmlInput) {

        LOG.info("Inicia generarPDFHistorialCreditoBaseArchivoXml en GenerarPdfHistorialCrediticioDetalladoMiBancoController");
        try {

            LOG.info("Termina generarPDFHistorialCreditoBaseArchivoXml en GenerarPdfHistorialCrediticioDetalladoMiBancoController");
            return Response.status(Response.Status.CREATED).entity(generarSolicitudCreditoMiBancoControllerService.generarPDFHistorialCreditoBaseArchivoXml(historialCreditoBaseArchivoXmlInput)).build();
        } catch (IOException | JAXBException | JRException e) {

            LOG.error(Constants.ERROR_SERVICIO + "generarPDFHistorialCreditoBaseArchivoXml en GenerarPdfHistorialCrediticioDetalladoMiBancoController excepción: " + e.getMessage());
            throw new ApplicationException("Error al generar el PDF " + e.getMessage());
        } catch (Exception e) {

            LOG.error(Constants.ERROR_SERVICIO + "generarPDFHistorialCreditoBaseArchivoXml en GenerarPdfHistorialCrediticioDetalladoMiBancoController excepción: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Constants.ERROR_SERVICIO + "generarPDFHistorialCreditoBaseArchivoXml, excepción: " + e.getMessage()).build();
        }
    }


    @Override
    public Response generarPDFHistorialCreditoBaseXml(String requestInput, String jwt, HistorialCreditoBaseXmlInput historialCreditoBaseXmlInput) {
        return null;
    }
}

