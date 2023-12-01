package com.mibanco.generarpdfriesgo.ms.services.command;


import com.mibanco.archivofic.us.ArchivoConsultado;
import com.mibanco.historialconsultaclientecentralriesgo.es.ConsultarUrlArchivoMasRecienteXmlInput;

public interface Command {

    Object execute(ConsultarUrlArchivoMasRecienteXmlInput parametro);

    Object execute(ArchivoConsultado parametro);
}
