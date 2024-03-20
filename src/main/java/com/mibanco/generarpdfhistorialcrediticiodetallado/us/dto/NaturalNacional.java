package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class NaturalNacional {

    @XmlElement(name = "Identificacion")
    public Identificacion Identificacion;

    @XmlElement(name = "Edad")
    public Edad Edad;

    @XmlElement(name = "InfoDemografica")
    public InfoDemografica InfoDemografica;

    @XmlAttribute(name = "nombres")
    public String nombres;

    @XmlAttribute(name = "primerApellido")
    public String primerApellido;

    @XmlAttribute(name = "segundoApellido")
    public String segundoApellido;

    @XmlAttribute(name = "nombreCompleto")
    public String nombreCompleto;

    @XmlAttribute(name = "validada")
    public boolean validada;

    @XmlAttribute(name = "rut")
    public boolean rut;

    @XmlAttribute(name = "genero")
    public int genero;
}


