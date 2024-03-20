package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class ComposicionPortafolio {

    @XmlElement(name = "TipoCuentaComposicionPortafolio")
    private List<TipoCuentaComposicionPortafolio> tipoCuentas;

    // Constructor, Getters y Setters
    public ComposicionPortafolio() {}

    public List<TipoCuentaComposicionPortafolio> getTipoCuentas() {
        return tipoCuentas;
    }

    public void setTipoCuentas(List<TipoCuentaComposicionPortafolio> tipoCuentas) {
        this.tipoCuentas = tipoCuentas;
    }
}
