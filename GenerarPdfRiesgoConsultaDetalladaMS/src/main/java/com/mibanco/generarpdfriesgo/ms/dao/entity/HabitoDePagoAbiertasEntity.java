package com.mibanco.generarpdfriesgo.ms.dao.entity;

import com.mibanco.generarpdfriesgo.ms.gen.type.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HabitoDePagoAbiertasEntity {

    private String _47meses;
    private Date adjetivoFecha;
    private String calificacion;
    private String cuotasMVigencia;
    private String desacuerdoInformacion;
    private String entidadInformante;
    private EstadoObligacionXmlEnum estadoObligacion;
    private String estadoTitular;
    private Date fechaActualizacion;
    private Date fechaApertura;
    private Date fechaLimitePago;
    private Date fechaPago;
    private Date fechaVencimiento;
    private TipoMarcaClaseXmlEnum marcaClase;
    private String moraMaxima;
    private Integer numeroCuenta;
    private Integer numeroChequeDevueltos;
    private String oficinaDeudor;
    private Integer perm;
    private Float porcentajeDeuda;
    private Float saldoActual;
    private Float saldoMora;
    private TIpoSectorXmlEnum sector;
    private TipoCuentaXmlEnum tipoCuenta;
    private TipoGarantiaXmlEnum tipoGarantia;
    private Float valorCuota;
    private Float vrlOcupoInicial;

}
