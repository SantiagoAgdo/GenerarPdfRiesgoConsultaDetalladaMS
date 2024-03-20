package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Valores", namespace = "http://www.mibanco.com/Valores")
public class Valores {
    @XmlElement(name = "Valor")
    private List<Valor> valores;

    public List<Valor> getValores() {
        return valores;
    }

    public void setValores(List<Valor> valores) {
        this.valores = valores;
    }

}

