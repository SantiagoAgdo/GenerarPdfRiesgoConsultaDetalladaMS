package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class MesComportamiento {
    @XmlAttribute(name = "fecha")
    private String fecha;
    // Atributos para uso en `Comportamiento`
    @XmlAttribute(name = "comportamiento")
    private String comportamiento;

    @XmlAttribute(name = "cantidad")
    private Integer cantidad;

    // Getters y setters
}

