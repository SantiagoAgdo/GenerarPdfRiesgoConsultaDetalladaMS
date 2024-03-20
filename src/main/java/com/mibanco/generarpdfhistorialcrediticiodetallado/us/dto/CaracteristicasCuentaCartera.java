package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CaracteristicasCuentaCartera", namespace = "http://www.mibanco.com/CaracteristicasCuentaCartera")
public class CaracteristicasCuentaCartera {
    @XmlAttribute(name = "tipoCuenta")
    private String tipoCuenta;

    @XmlAttribute(name = "tipoObligacion")
    private String tipoObligacion;

    @XmlAttribute(name = "tipoContrato")
    private String tipoContrato;

    @XmlAttribute(name = "ejecucionContrato")
    private String ejecucionContrato;

    @XmlAttribute(name = "mesesPermanencia")
    private int mesesPermanencia;

    @XmlAttribute(name = "calidadDeudor")
    private String calidadDeudor;

    @XmlAttribute(name = "garantia")
    private String garantia;

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public String getTipoObligacion() {
        return tipoObligacion;
    }

    public void setTipoObligacion(String tipoObligacion) {
        this.tipoObligacion = tipoObligacion;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public String getEjecucionContrato() {
        return ejecucionContrato;
    }

    public void setEjecucionContrato(String ejecucionContrato) {
        this.ejecucionContrato = ejecucionContrato;
    }

    public int getMesesPermanencia() {
        return mesesPermanencia;
    }

    public void setMesesPermanencia(int mesesPermanencia) {
        this.mesesPermanencia = mesesPermanencia;
    }

    public String getCalidadDeudor() {
        return calidadDeudor;
    }

    public void setCalidadDeudor(String calidadDeudor) {
        this.calidadDeudor = calidadDeudor;
    }

    public String getGarantia() {
        return garantia;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }

    
}
