package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class CuentaAhorro {

    @XmlElement(name = "Caracteristicas")
    public Caracteristicas Caracteristicas;

    @XmlElement(name = "ValoresCuentaAhorro")
    public Valores Valores;

    @XmlElement(name = "Estado")
    public Estado Estado;

    @XmlElement(name = "Llave")
    public String Llave;

    @XmlAttribute(name = "bloqueada")
    public boolean bloqueada;

    @XmlAttribute(name = "entidad")
    public String entidad;

    @XmlAttribute(name = "numero")
    public String numero;

    @XmlAttribute(name = "fechaApertura")
    public String fechaApertura;

    @XmlAttribute(name = "calificacion")
    public int calificacion;

    @XmlAttribute(name = "situacionTitular")
    public int situacionTitular;

    @XmlAttribute(name = "oficina")
    private String oficina;

    @XmlAttribute(name = "ciudad")
    private String ciudad;

    @XmlAttribute(name = "codigoDaneCiudad")
    private String codigoDaneCiudad;

    @XmlAttribute(name = "tipoIdentificacion")
    private int tipoIdentificacion;

    @XmlAttribute(name = "identificacion")
    private String identificacion;

    @XmlAttribute(name = "sector")
    public int sector;
    @XmlAttribute(name = "text")
    public double text;


}


