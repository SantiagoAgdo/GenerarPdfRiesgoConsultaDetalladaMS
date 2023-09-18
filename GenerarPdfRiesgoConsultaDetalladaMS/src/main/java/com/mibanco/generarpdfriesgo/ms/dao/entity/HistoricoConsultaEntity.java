package com.mibanco.generarpdfriesgo.ms.dao.entity;

import com.mibanco.generarpdfriesgo.ms.gen.type.TipoCuentaXmlEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoricoConsultaEntity {

    private String ciudad;
    private String consultanteMotivoConsulta;
    private Date fecha;
    private Integer numeroConsultas;
    private String oficina;
    private TipoCuentaXmlEnum tipoCuenta;

}
