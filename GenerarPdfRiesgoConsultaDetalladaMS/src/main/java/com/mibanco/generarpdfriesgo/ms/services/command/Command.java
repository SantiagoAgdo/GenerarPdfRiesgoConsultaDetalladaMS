package com.mibanco.generarpdfriesgo.ms.services.command;

public interface Command {
    Object execute();

    Object execute(IParam parametro);
}
