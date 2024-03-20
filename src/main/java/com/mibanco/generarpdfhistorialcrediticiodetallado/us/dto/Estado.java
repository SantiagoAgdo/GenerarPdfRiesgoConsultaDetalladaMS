package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Estado {
    @XmlAttribute(name = "codigo")
    private String codigo;

    @XmlAttribute(name = "fecha")
    private String fecha;

    // Getters y setters...
}
