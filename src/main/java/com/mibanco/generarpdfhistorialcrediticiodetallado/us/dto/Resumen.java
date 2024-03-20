package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Resumen {
    @XmlElement(name = "Principales")
    private Principales principales;

    @XmlElement(name = "Saldos")
    private Saldos saldos;

    @XmlElement(name = "Comportamiento")
    private Comportamiento comportamiento;

    // Getters y setters
}
