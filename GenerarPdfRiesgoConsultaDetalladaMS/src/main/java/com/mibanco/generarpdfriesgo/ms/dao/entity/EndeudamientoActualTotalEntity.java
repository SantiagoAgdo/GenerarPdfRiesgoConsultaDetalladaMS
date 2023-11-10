package com.mibanco.generarpdfriesgo.ms.dao.entity;


import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RegisterForReflection
public class EndeudamientoActualTotalEntity {

    private Float porcentajeDeuda;
    private Float porcentajePart;
    private Float saldoActual;
    private Float saldoEnMora;
    private Float valorCuota;
    private Float vlrOCupoInicial;
}
