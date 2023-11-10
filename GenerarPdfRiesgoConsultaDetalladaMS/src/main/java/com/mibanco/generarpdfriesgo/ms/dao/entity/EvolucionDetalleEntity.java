package com.mibanco.generarpdfriesgo.ms.dao.entity;

import com.mibanco.generarpdfriesgo.ms.gen.type.TIpoSectorXmlEnum;
import com.mibanco.generarpdfriesgo.ms.gen.type.TipoCarteraXmlEnum;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RegisterForReflection
public class EvolucionDetalleEntity {

    private TIpoSectorXmlEnum sector;
    private TipoCarteraXmlEnum cartera;
    private Float cupoInicial;
    private Float saldo;
    private Float saldoEnMora;
    private Float valorCuota;
    private Float porcentajeDeuda;
    private String menorCalificacion;

}
