package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.util.Date;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Identificacion {

    @XmlAttribute(name = "estado")
    public int estado;

    @XmlAttribute(name = "fechaExpedicion")
    public Date fechaExpedicion;

    @XmlAttribute(name = "ciudad")
    public String ciudad;

    @XmlAttribute(name = "departamento")
    public String departamento;

    @XmlAttribute(name = "genero")
    public int genero;

    @XmlAttribute(name = "numero")
    public int numero;

    @XmlAttribute(name = "idRegistro")
    public int idRegistro;

    @XmlAttribute(name = "lugarExpedicion")
    public int lugarExpedicion;

    @XmlAttribute(name = "nitReporta")
    public int nitReporta;

    @XmlAttribute(name = "razonSocial")
    public String razonSocial;
}

