package com.mibanco.generarpdfriesgo.ms.dao.entity;

import com.mibanco.generarpdfriesgo.ms.gen.type.TIpoSectorXmlEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PerfilSectorEntity {

    private Date antiguedadDesde;
    private Integer consultaUltimos6Meses;
    private Integer creditosCerrados;
    private Integer creditosReestructurados;
    private Integer creditosRefinanciados;
    private Integer creditosVigentes;
    private Integer desacuerdosVigentesAFecha;
    private TIpoSectorXmlEnum sector;
}
