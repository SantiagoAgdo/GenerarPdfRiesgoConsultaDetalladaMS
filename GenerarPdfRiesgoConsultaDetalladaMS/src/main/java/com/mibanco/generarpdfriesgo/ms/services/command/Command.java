package com.mibanco.generarpdfriesgo.ms.services.command;


import com.mibanco.archivo.us.Creado;
import com.mibanco.generarpdfriesgo.ms.gen.type.CentralRiesgoType;
import com.mibanco.historialconsultaclientecentralriesgo.es.ConsultarUrlArchivoMasRecienteXmlInput;

public interface Command {

    Object execute(ConsultarUrlArchivoMasRecienteXmlInput parametro);

    Object execute(Creado parametro);
}
