package com.mibanco.generarpdfriesgo.ms.dao.entity;

import com.mibanco.generarpdfriesgo.ms.gen.type.TIpoSectorXmlEnum;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RegisterForReflection
public class DetalleResumenEndeudamientoGlobalEntity {
    private TIpoSectorXmlEnum sector;
    private Float comercialMiles;
    private Integer comercialNumero;
    private Float hipotecarioMiles;
    private Integer hipotecarioNumero;
    private Float consumoYTarjetaCreditoMiles;
    private Integer consumoYTarjetaCreditoNumero;
    private Float microcreditoMiles;
    private Integer microcreditoNumero;
    private Float porcentajeParticipacion;

}
