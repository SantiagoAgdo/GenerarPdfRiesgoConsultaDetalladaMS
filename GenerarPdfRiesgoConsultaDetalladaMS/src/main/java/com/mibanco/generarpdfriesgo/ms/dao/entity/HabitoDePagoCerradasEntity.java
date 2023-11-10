package com.mibanco.generarpdfriesgo.ms.dao.entity;

import com.mibanco.generarpdfriesgo.ms.gen.type.EstadoObligacionXmlEnum;
import com.mibanco.generarpdfriesgo.ms.gen.type.TIpoSectorXmlEnum;
import com.mibanco.generarpdfriesgo.ms.gen.type.TipoCuentaXmlEnum;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RegisterForReflection
public class HabitoDePagoCerradasEntity {

    private String _47meses;
    private Date adjetivoFecha;
    private String calificacion;
    private String ciudadFechaVencimiento;
    private String desacuerdoInformacion;
    private String entidadInformante;
    private EstadoObligacionXmlEnum estadoObligacion;
    private Date fechaApertura;
    private Date fechaCierre;
    private Integer numeroCuenta;
    private String oficinaDeudor;
    private TIpoSectorXmlEnum sector;
    private TipoCuentaXmlEnum tipoCuenta;
    private Float vrlOCupoInicial;

}
