package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class EstadoPlastico {
    @XmlAttribute(name = "codigo")
    private String codigo;

    @XmlAttribute(name = "fecha")
    private String fecha;

    // Getters y setters...
}

