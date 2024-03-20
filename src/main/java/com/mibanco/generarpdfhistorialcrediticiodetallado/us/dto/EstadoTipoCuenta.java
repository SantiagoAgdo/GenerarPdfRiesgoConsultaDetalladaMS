package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;


@XmlAccessorType(XmlAccessType.FIELD)
public class EstadoTipoCuenta {
    @XmlAttribute(name = "codigo")
    private String codigo;

    @XmlAttribute(name = "cantidad")
    private String cantidad;

    // Getters y setters...
}

