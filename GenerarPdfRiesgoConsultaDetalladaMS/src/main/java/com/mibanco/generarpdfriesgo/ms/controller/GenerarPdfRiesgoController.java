package com.mibanco.generarpdfriesgo.ms.controller;

import com.mibanco.generarpdfriesgo.ms.constans.Constants;
import com.mibanco.generarpdfriesgo.ms.gen.contract.V1GenerarPdfRiesgoConsultaDetallada;
import com.mibanco.generarpdfriesgo.ms.gen.type.TipoDocumentoEnum;
import com.mibanco.generarpdfriesgo.ms.services.impl.GenerarPdfRiesgoConsultaDetalladaImpl;
import com.mibanco.generarpdfriesgo.ms.utils.exceptions.ApplicationException;
import com.mibanco.generarpdfriesgo.ms.utils.exceptions.ApplicationExceptionValidation;
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


    @Override
    public Response generaRiesgoHistorial(TipoDocumentoEnum tipoDocumento, String numeroDocumento, String digitoVerificacion) {
        LOG.info("Inicia generaRiesgoHistorial en GenerarPdfRiesgoController");
        try {
            validator.validarConsulta(tipoDocumento, numeroDocumento, digitoVerificacion);
            service.generarRiesgoHistoricoEndeudamiento(tipoDocumento.toString(), numeroDocumento, digitoVerificacion);

            LOG.info("Finaliza generaRiesgoHistorial en GenerarPdfRiesgoController");
            return Response.status(Response.Status.CREATED).entity("Historico Endeudamiento Generado").build();

        } catch (ApplicationExceptionValidation e) {

            LOG.error("Error en validaciones de creacion de catalogo - CatalogoController");
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();

        } catch (ApplicationException e) {

            LOG.error(Constants.ERROR_SERVICIO + "crearClienteFIC en CatalogoServiceImpl exception: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(Constants.ERROR_SERVICIO + "crearCatalogo, exception: " + e.getMessage()).build();
        }
    }

}
