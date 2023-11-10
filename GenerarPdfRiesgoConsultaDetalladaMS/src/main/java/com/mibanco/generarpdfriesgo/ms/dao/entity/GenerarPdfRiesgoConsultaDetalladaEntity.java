package com.mibanco.generarpdfriesgo.ms.dao.entity;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RegisterForReflection(targets = {ClienteBaseEntity.class,
        CentralRiesgoEntity.class})
public class GenerarPdfRiesgoConsultaDetalladaEntity {

    private ClienteBaseEntity cliente;
    private CentralRiesgoEntity centralRiesgo;

}
