package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
public class Linea {

    @XmlAttribute(name = "consecutivo")
    private String consecutivo;

    @XmlValue
    private String valor;

    // Getters y setters
}

