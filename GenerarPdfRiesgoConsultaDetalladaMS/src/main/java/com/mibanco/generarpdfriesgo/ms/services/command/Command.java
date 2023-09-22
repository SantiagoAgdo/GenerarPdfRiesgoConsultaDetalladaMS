package com.mibanco.generarpdfriesgo.ms.services.command;


import com.mibanco.historialconsultaclientecentralriesgo.es.ConsultarUrlArchivoMasRecienteXmlInput;

public interface Command {
    Object execute();

    Object execute(ConsultarUrlArchivoMasRecienteXmlInput parametro);
}
