package com.mibanco.generarpdfriesgo.ms.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EvolucionDeudaEntity {

    private List<EvolucionDetalleEntity> evolucionDetalle;
    private String trimestre;
}
