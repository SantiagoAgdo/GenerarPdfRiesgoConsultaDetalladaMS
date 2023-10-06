package com.mibanco.generarpdfriesgo.ms.utils.validators;

import com.mibanco.generarpdfriesgo.ms.GenerarRiesgoConsultaDetalladaInput;
import com.mibanco.generarpdfriesgo.ms.constans.Constants;
import com.mibanco.generarpdfriesgo.ms.gen.type.TipoDocumentoEnum;
import com.mibanco.generarpdfriesgo.ms.utils.exceptions.ApplicationExceptionValidation;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@ApplicationScoped
public class GenerarPdfRiesgoConsultaDetalladaValidator {

    private static final Logger LOG = LoggerFactory.getLogger(GenerarPdfRiesgoConsultaDetalladaValidator.class);


    public boolean validarConsulta(GenerarRiesgoConsultaDetalladaInput data) {

        LOG.info("Inician Validaciones");
        if (data.getNumeroDocumento() == null) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constants.ERROR_SERVICIO + " numero de documento es nulo"
            );
        }
        if (data.getDigitoVerificacion() == null || data.getDigitoVerificacion().length() > 2) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constants.ERROR_SERVICIO + " digito de verificacion es nulo"
            );
        }
        if (data.getTipoDocumento() == null) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constants.ERROR_SERVICIO + " tipo de documento es nulo"
            );
        }
        return true;
    }

    public boolean validarConsulta(TipoDocumentoEnum tipoDocumento, String numeroDocumento, String digitoVerificacion) {

        LOG.info("Inician Validaciones");
        if (numeroDocumento == null) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constants.ERROR_SERVICIO + " numero de documento es nulo"
            );
        }
        if (digitoVerificacion == null || digitoVerificacion.length() >2) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constants.ERROR_SERVICIO + " digito de verificacion es invalido"
            );
        }
        if (tipoDocumento == null) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constants.ERROR_SERVICIO + " tipo de documento es nulo"
            );
        }
        return true;
    }

}
