package com.mibanco.generarpdfriesgo.ms.dao.entity;

import com.mibanco.generarpdfriesgo.ms.gen.type.EstadoEndeudamientoActualXmlEnum;
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
public class EndeudamientoActualEntity {

    private String calidad;
    private String calificacion;
    private TipoCarteraXmlEnum cartera;
    private EstadoEndeudamientoActualXmlEnum estadoEndeudamientoActual;
    private Float porcentajeDeuda;
    private Float porcentajePart;
    private Float saldoActual;
    private Float saldoEnMora;
    private TIpoSectorXmlEnum sector;
    private Float valorCuota;
    private Float vlrOCupoInicial;

}
