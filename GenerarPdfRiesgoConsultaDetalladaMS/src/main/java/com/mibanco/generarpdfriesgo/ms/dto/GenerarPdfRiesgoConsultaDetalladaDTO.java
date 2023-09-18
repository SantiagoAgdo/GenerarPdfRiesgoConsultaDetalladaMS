package com.mibanco.generarpdfriesgo.ms.dto;

import com.mibanco.generarpdfriesgo.ms.gen.type.CentralRiesgoType;
import com.mibanco.generarpdfriesgo.ms.gen.type.ClienteBaseType;
import com.mibanco.generarpdfriesgo.ms.services.command.IParam;


public class GenerarPdfRiesgoConsultaDetalladaDTO implements IParam {

    private ClienteBaseType clienteBaseType;
    private CentralRiesgoType centralRiesgoType;

    public GenerarPdfRiesgoConsultaDetalladaDTO(ClienteBaseType clienteBaseType, CentralRiesgoType centralRiesgoType) {
        this.clienteBaseType = clienteBaseType;
        this.centralRiesgoType = centralRiesgoType;
    }

    public GenerarPdfRiesgoConsultaDetalladaDTO() {
    }

    public ClienteBaseType getClienteBaseType() {
        return clienteBaseType;
    }

    public void setClienteBaseType(ClienteBaseType clienteBaseType) {
        this.clienteBaseType = clienteBaseType;
    }

    public CentralRiesgoType getCentralRiesgoType() {
        return centralRiesgoType;
    }

    public void setCentralRiesgoType(CentralRiesgoType centralRiesgoType) {
        this.centralRiesgoType = centralRiesgoType;
    }
}
