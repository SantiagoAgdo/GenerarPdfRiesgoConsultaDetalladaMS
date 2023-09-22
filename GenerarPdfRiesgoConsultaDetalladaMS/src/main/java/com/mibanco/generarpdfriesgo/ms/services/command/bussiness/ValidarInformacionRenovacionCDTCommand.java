package com.mibanco.generarpdfriesgo.ms.services.command.bussiness;

import com.mibanco.generarpdfriesgo.ms.dto.GenerarPdfRiesgoConsultaDetalladaDTO;
import com.mibanco.generarpdfriesgo.ms.services.command.Command;
import com.mibanco.generarpdfriesgo.ms.services.command.IParam;
import com.mibanco.historialconsultaclientecentralriesgo.es.ConsultarUrlArchivoMasRecienteXmlInput;
import jakarta.enterprise.context.ApplicationScoped;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

@ApplicationScoped
public class ValidarInformacionRenovacionCDTCommand implements Command {


    @Override
    public Object execute(ConsultarUrlArchivoMasRecienteXmlInput parametro) {

        return tieneAtributosNulos(parametro);
    }

    private boolean tieneAtributosNulos(ConsultarUrlArchivoMasRecienteXmlInput obj) {
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

        return isValidateSuccess;
    }

    @Override
    public Object execute() {
        return null;
    }

}
