package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Edad {

    @XmlAttribute(name = "min")
    private int min;

    @XmlAttribute(name = "max")
    private int max;

    // Getters y setters...
}

