package com.mibanco.generarpdfriesgo.ms.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaldosYMorasEntity {

    private String morasMaxSectorReal;
    private String morasMaxSectorTelcos;
    private Float numCreditosConMoraIgual30Dias;
    private Float numCreditosConMoraIMayorOIgual60Dias;
    private String periodoSaldoYMoras;
    private Float saldoDeudaTotal;
    private Float saldoDeudaTotalEnMora;
    private String totalMorasMaximas;

}
