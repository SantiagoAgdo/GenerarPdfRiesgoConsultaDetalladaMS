package com.mibanco.generarpdfriesgo.ms.dao.entity;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RegisterForReflection(targets = DetalleResumenEndeudamientoGlobalEntity.class)
public class ResumenEndeudamientoGlobalEntity {

    private Date fechaCorte;
    private List<DetalleResumenEndeudamientoGlobalEntity> detalleResumenEndeudamientoGlobal;
}
