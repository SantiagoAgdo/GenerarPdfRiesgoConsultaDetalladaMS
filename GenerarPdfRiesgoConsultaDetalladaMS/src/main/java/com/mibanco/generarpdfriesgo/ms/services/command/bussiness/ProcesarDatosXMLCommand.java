package com.mibanco.generarpdfriesgo.ms.services.command.bussiness;

import com.mibanco.archivofic.us.ArchivoConsultado;
import com.mibanco.generarpdfriesgo.ms.services.command.Command;
import com.mibanco.generarpdfriesgo.ms.utils.xml.ProcesarDatosXML;
import com.mibanco.historialconsultaclientecentralriesgo.es.ConsultarUrlArchivoMasRecienteXmlInput;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProcesarDatosXMLCommand implements Command {

    @Override
    public Object execute(ArchivoConsultado parametro) {
        ProcesarDatosXML procesarDatosXML = new ProcesarDatosXML();
        procesarDatosXML.setCentralRiesgoType(parametro);
        return procesarDatosXML;
    }

    @Override
    public Object execute(ConsultarUrlArchivoMasRecienteXmlInput parametro) {
        return null;
    }
}
