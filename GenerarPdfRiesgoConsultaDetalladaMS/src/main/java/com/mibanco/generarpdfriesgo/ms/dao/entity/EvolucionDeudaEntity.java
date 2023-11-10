package com.mibanco.generarpdfriesgo.ms.dao.entity;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RegisterForReflection(targets = EvolucionDetalleEntity.class)
public class EvolucionDeudaEntity {

    private List<EvolucionDetalleEntity> evolucionDetalle;
    private String trimestre;
}
