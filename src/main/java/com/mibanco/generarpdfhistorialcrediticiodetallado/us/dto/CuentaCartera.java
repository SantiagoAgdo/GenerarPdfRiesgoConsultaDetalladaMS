package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class CuentaCartera {
    @XmlAttribute(name = "bloqueada")
    private boolean bloqueada;

    @XmlAttribute(name = "entidad")
    private String entidad;

    @XmlAttribute(name = "numero")
    private String numero;

    @XmlAttribute(name = "fechaApertura")
    private String fechaApertura;

    @XmlAttribute(name = "fechaVencimiento")
    private String fechaVencimiento;

    @XmlAttribute(name = "comportamiento")
    private String comportamiento;

    @XmlAttribute(name = "formaPago")
    private int formaPago;

    @XmlAttribute(name = "probabilidadIncumplimiento")
    private double probabilidadIncumplimiento;

    @XmlAttribute(name = "calificacion")
    private int calificacion;

    @XmlAttribute(name = "situacionTitular")
    private int situacionTitular;

    @XmlAttribute(name = "oficina")
    private String oficina;

    @XmlAttribute(name = "ciudad")
    private String ciudad;

    @XmlAttribute(name = "codigoDaneCiudad")
    private String codigoDaneCiudad;

    @XmlAttribute(name = "codSuscriptor")
    private String codSuscriptor;

    @XmlAttribute(name = "tipoIdentificacion")
    private int tipoIdentificacion;

    @XmlAttribute(name = "identificacion")
    private String identificacion;

    @XmlAttribute(name = "sector")
    private int sector;

    @XmlAttribute(name = "calificacionHD")
    private boolean calificacionHD;

    @XmlElement(name = "Caracteristicas")
    private CaracteristicasCuentaCartera caracteristicas;

    @XmlElement(name = "Valores")
    private ValoresCuentaCartera valores;

    @XmlElement(name = "Estados")
    private Estados estados;

    @XmlElement(name = "Llave")
    private String llave;

    @XmlElement(name = "Adjetivo")
    private Adjetivo adjetivo;
    
}


