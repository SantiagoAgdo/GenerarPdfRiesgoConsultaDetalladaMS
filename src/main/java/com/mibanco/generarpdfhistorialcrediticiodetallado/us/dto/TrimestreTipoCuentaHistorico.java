package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class TrimestreTipoCuentaHistorico {

    @XmlAttribute(name = "fecha")
    private String fecha;

    @XmlAttribute(name = "totalCuentas")
    private int totalCuentas;

    @XmlAttribute(name = "cuentasConsideradas")
    private int cuentasConsideradas;

    @XmlAttribute(name = "saldo")
    private double saldo;

    // Getters y setters
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getTotalCuentas() {
        return totalCuentas;
    }

    public void setTotalCuentas(int totalCuentas) {
        this.totalCuentas = totalCuentas;
    }

    public int getCuentasConsideradas() {
        return cuentasConsideradas;
    }

    public void setCuentasConsideradas(int cuentasConsideradas) {
        this.cuentasConsideradas = cuentasConsideradas;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
