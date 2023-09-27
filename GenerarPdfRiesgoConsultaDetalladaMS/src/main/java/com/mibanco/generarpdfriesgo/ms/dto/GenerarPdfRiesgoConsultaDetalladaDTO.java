package com.mibanco.generarpdfriesgo.ms.dto;

import com.mibanco.generarpdfriesgo.ms.gen.type.CentralRiesgoType;
import com.mibanco.generarpdfriesgo.ms.gen.type.ClienteBaseType;
import com.mibanco.generarpdfriesgo.ms.services.command.IParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenerarPdfRiesgoConsultaDetalladaDTO implements IParam {

    private ClienteBaseType clienteBaseType;
    private CentralRiesgoType centralRiesgoType;
}
