package com.mibanco.generarpdfriesgo.ms.utils.validators;

import com.mibanco.generarpdfriesgo.ms.GenerarRiesgoConsultaDetalladaInput;
import com.mibanco.generarpdfriesgo.ms.constans.Constants;
import com.mibanco.generarpdfriesgo.ms.dto.GenerarPdfRiesgoConsultaDetalladaDTO;
import com.mibanco.generarpdfriesgo.ms.gen.type.TipoDocumentoEnum;
import com.mibanco.generarpdfriesgo.ms.utils.exceptions.ApplicationExceptionValidation;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;


@ApplicationScoped
public class GenerarPdfRiesgoConsultaDetalladaValidator {

    private static final Logger LOG = LoggerFactory.getLogger(GenerarPdfRiesgoConsultaDetalladaValidator.class);


    public boolean validarConsulta(GenerarRiesgoConsultaDetalladaInput data) {
        if (data.getNumeroDocumento() == null) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constants.ERROR_SERVICIO + " numero de documento es nulo"
            );
        }
        if (data.getDigitoVerificacion() == null) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constants.ERROR_SERVICIO + " digito de verificacion es nulo"
            );
        }
        if (data.getTipoDocumento() == null) { //validar que sea del enumerador
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constants.ERROR_SERVICIO + " tipo de documento es nulo"
            );
        }
        return true;
    }

    public boolean validarConsulta(TipoDocumentoEnum tipoDocumento, String numeroDocumento, String digitoVerificacion) {
        if (numeroDocumento == null) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constants.ERROR_SERVICIO + " numero de documento es nulo"
            );
        }
        if (digitoVerificacion == null) {
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constants.ERROR_SERVICIO + " digito de verificacion es nulo"
            );
        }
        if (tipoDocumento == null) { //validar que sea del enumerador
            throw new ApplicationExceptionValidation(
                    Response.Status.BAD_REQUEST.getStatusCode(), Constants.ERROR_SERVICIO + " tipo de documento es nulo"
            );
        }
        return true;
    }

    private boolean tieneAtributosNulos(Object obj) {
        boolean isValidateSuccess = true;
        try {
            BeanInfo bean = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] descripcionDePropiedades = bean.getPropertyDescriptors();

            for (PropertyDescriptor atr : descripcionDePropiedades) {
                Object valor = atr.getReadMethod().invoke(obj);
                if (valor == null) {
                    isValidateSuccess = false;
                }
            }
        } catch (IntrospectionException | ReflectiveOperationException e) {
            e.printStackTrace();
        }

        return !isValidateSuccess;
    }

}
