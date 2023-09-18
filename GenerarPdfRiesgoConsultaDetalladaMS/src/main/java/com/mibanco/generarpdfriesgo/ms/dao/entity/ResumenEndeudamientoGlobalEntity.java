package com.mibanco.generarpdfriesgo.ms.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumenEndeudamientoGlobalEntity {

    private Date fechaCorte;
    private List<DetalleResumenEndeudamientoGlobalEntity> detalleResumenEndeudamientoGlobal;
}
