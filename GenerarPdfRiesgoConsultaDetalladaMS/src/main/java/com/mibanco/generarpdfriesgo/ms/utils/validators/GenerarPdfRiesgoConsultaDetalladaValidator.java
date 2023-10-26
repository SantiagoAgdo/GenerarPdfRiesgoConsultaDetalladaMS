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


    public boolean validarConsulta(String numeroCliente) {

        LOG.info("Inician Validaciones");
        if (numeroCliente.isEmpty() || numeroCliente == null) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constants.ERROR_SERVICIO + " numero de documento invalido"
            );
        }
        return true;
    }

}
