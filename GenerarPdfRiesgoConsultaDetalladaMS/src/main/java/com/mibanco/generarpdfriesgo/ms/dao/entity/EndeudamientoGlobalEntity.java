package com.mibanco.generarpdfriesgo.ms.dao.entity;

import com.mibanco.generarpdfriesgo.ms.gen.type.TIpoSectorXmlEnum;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RegisterForReflection
public class EndeudamientoGlobalEntity {

    private TIpoSectorXmlEnum sector;
    private Float comercialMiles;
    private Integer comercialNumero;
    private String entidadInformante;
    private String calificacion;
    private Float hipotecarioMiles;
    private Integer hipotecarioNumero;
    private Integer numero;
    private Float consumoYTarjetaCreditoMiles;
    private Float saldoTotal;
    private Integer consumoYTarjetaCreditoNumero;
    private Float microcreditoMiles;
    private Integer microcreditoNumero;
    private String garantiaTipo;
    private Date garantiafechaAvaluo;
    private Float garantiaValor;
    private String moneda;
    private String fuente;
}
