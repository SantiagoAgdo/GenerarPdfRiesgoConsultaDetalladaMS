package com.mibanco.generarpdfriesgo.ms.services.command.bussiness;

import com.mibanco.archivo.us.Creado;
import com.mibanco.generarpdfriesgo.ms.gen.type.CentralRiesgoType;
import com.mibanco.generarpdfriesgo.ms.services.command.Command;
import com.mibanco.generarpdfriesgo.ms.utils.xml.ProcesarDatosXML;
import com.mibanco.historialconsultaclientecentralriesgo.es.ConsultarUrlArchivoMasRecienteXmlInput;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProcesarDatosXMLCommand implements Command {


    @Override
    public Object execute(Creado parametro) {
        ProcesarDatosXML procesarDatosXML = new ProcesarDatosXML();
        procesarDatosXML.setCentralRiesgoType(parametro);
        return procesarDatosXML;
    }

    @Override
    public Object execute() {
        return null;
    }

    @Override
    public Object execute(ConsultarUrlArchivoMasRecienteXmlInput parametro) {
        return null;
    }
}
