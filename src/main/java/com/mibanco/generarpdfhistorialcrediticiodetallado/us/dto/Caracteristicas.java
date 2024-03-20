package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class Caracteristicas {
    @XmlAttribute(name = "clase")
    private String clase;
    @XmlAttribute(name = "franquicia")
    private String franquicia;
    @XmlAttribute(name = "marca")
    private String marca;
    @XmlAttribute(name = "amparada")
    private boolean amparada;
    @XmlAttribute(name = "codigoAmparada")
    private String codigoAmparada;
    @XmlAttribute(name = "garantia")
    private String garantia;
    @XmlAttribute(name = "tipoCuenta")
    public String tipoCuenta;
    @XmlAttribute(name = "tipoObligacion")
    public int tipoObligacion;
    @XmlAttribute(name = "tipoContrato")
    public int tipoContrato;
    @XmlAttribute(name = "ejecucionContrato")
    public int ejecucionContrato;
    @XmlAttribute(name = "mesesPermanencia")
    public int mesesPermanencia;
    @XmlAttribute(name = "calidadDeudor")
    public int calidadDeudor;
    public String getClase() {
        return clase;
    }
    public void setClase(String clase) {
        this.clase = clase;
    }
    public String getFranquicia() {
        return franquicia;
    }
    public void setFranquicia(String franquicia) {
        this.franquicia = franquicia;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public boolean isAmparada() {
        return amparada;
    }
    public void setAmparada(boolean amparada) {
        this.amparada = amparada;
    }
    public String getCodigoAmparada() {
        return codigoAmparada;
    }
    public void setCodigoAmparada(String codigoAmparada) {
        this.codigoAmparada = codigoAmparada;
    }
    public String getGarantia() {
        return garantia;
    }
    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }
    public String getTipoCuenta() {
        return tipoCuenta;
    }
    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }
    public int getTipoObligacion() {
        return tipoObligacion;
    }
    public void setTipoObligacion(int tipoObligacion) {
        this.tipoObligacion = tipoObligacion;
    }
    public int getTipoContrato() {
        return tipoContrato;
    }
    public void setTipoContrato(int tipoContrato) {
        this.tipoContrato = tipoContrato;
    }
    public int getEjecucionContrato() {
        return ejecucionContrato;
    }
    public void setEjecucionContrato(int ejecucionContrato) {
        this.ejecucionContrato = ejecucionContrato;
    }
    public int getMesesPermanencia() {
        return mesesPermanencia;
    }
    public void setMesesPermanencia(int mesesPermanencia) {
        this.mesesPermanencia = mesesPermanencia;
    }
    public int getCalidadDeudor() {
        return calidadDeudor;
    }
    public void setCalidadDeudor(int calidadDeudor) {
        this.calidadDeudor = calidadDeudor;
    }

    
}


