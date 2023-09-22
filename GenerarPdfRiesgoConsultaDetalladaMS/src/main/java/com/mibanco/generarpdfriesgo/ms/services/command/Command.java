package com.mibanco.generarpdfriesgo.ms.services.command;

import com.mibanco.generarpdfriesgo.ms.ConsultarUrlArchivoMasRecienteXmlInput;

public interface Command {
    Object execute();

    Object execute(ConsultarUrlArchivoMasRecienteXmlInput parametro);
}
