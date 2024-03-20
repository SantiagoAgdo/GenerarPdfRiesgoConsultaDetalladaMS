package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Totales", namespace = "http://www.mibanco.com/Totales")
public class Totales {
    @XmlElement(name = "TipoCuenta")
    private List<TipoCuenta> tipoCuentas;

    // Getters y setters
    public List<TipoCuenta> getTipoCuentas() {
        return tipoCuentas;
    }

    public void setTipoCuentas(List<TipoCuenta> tipoCuentas) {
        this.tipoCuentas = tipoCuentas;
    }
}

