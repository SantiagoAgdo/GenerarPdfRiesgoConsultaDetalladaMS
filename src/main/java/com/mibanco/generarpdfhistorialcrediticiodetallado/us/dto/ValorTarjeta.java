package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class ValorTarjeta {

    @XmlAttribute(name = "moneda")
    private int moneda;

    @XmlAttribute(name = "fecha")
    private String fecha;

    @XmlAttribute(name = "calificacion")
    private String calificacion;

    @XmlAttribute(name = "saldoActual")
    private double saldoActual;

    @XmlAttribute(name = "saldoMora")
    private double saldoMora;

    @XmlAttribute(name = "disponible")
    private double disponible;

    @XmlAttribute(name = "cuota")
    private double cuota;

    @XmlAttribute(name = "cuotasMora")
    private int cuotasMora;

    @XmlAttribute(name = "diasMora")
    private int diasMora;

    @XmlAttribute(name = "fechaPagoCuota")
    private String fechaPagoCuota;

    @XmlAttribute(name = "fechaLimitePago")
    private String fechaLimitePago;

    @XmlAttribute(name = "cupoTotal")
    private double cupoTotal;

    // Constructor vacío
    public ValorTarjeta() {}

    public int getMoneda() {
        return moneda;
    }

    public void setMoneda(int moneda) {
        this.moneda = moneda;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    public double getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(double saldoActual) {
        this.saldoActual = saldoActual;
    }

    public double getSaldoMora() {
        return saldoMora;
    }

    public void setSaldoMora(double saldoMora) {
        this.saldoMora = saldoMora;
    }

    public double getDisponible() {
        return disponible;
    }

    public void setDisponible(double disponible) {
        this.disponible = disponible;
    }

    public double getCuota() {
        return cuota;
    }

    public void setCuota(double cuota) {
        this.cuota = cuota;
    }

    public int getCuotasMora() {
        return cuotasMora;
    }

    public void setCuotasMora(int cuotasMora) {
        this.cuotasMora = cuotasMora;
    }

    public int getDiasMora() {
        return diasMora;
    }

    public void setDiasMora(int diasMora) {
        this.diasMora = diasMora;
    }

    public String getFechaPagoCuota() {
        return fechaPagoCuota;
    }

    public void setFechaPagoCuota(String fechaPagoCuota) {
        this.fechaPagoCuota = fechaPagoCuota;
    }

    public String getFechaLimitePago() {
        return fechaLimitePago;
    }

    public void setFechaLimitePago(String fechaLimitePago) {
        this.fechaLimitePago = fechaLimitePago;
    }

    public double getCupoTotal() {
        return cupoTotal;
    }

    public void setCupoTotal(double cupoTotal) {
        this.cupoTotal = cupoTotal;
    }

    
}

