package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ValoresCuentaCartera", namespace = "http://www.mibanco.com/ValoresCuentaCartera")
public class ValoresCuentaCartera {
    @XmlElement(name = "Valor")
    private List<ValorCuentaCartera> valores;

    public List<ValorCuentaCartera> getValores() {
        return valores;
    }

    public void setValores(List<ValorCuentaCartera> valores) {
        this.valores = valores;
    }

}

