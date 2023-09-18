package com.mibanco.generarpdfriesgo.ms.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenerarPdfRiesgoConsultaDetalladaEntity {

    private ClienteBaseEntity cliente;
    private CentralRiesgoEntity centralRiesgo;

}
