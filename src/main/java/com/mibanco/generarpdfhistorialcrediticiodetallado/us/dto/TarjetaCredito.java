package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import lombok.Data;

import javax.xml.bind.annotation.*;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TarjetaCredito", namespace = "http://www.mibanco.com/TarjetaCredito")
public class TarjetaCredito {

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

    @XmlAttribute(name = "tipoIdentificacion")
    private int tipoIdentificacion;

    @XmlAttribute(name = "identificacion")
    private String identificacion;

    @XmlAttribute(name = "sector")
    private int sector;

    @XmlAttribute(name = "calificacionHD")
    private boolean calificacionHD;

    @XmlElement(name = "Caracteristicas")
    private CaracteristicasTarjeta caracteristicas;

    @XmlElement(name = "Valores")
    private ValoresCuentaCartera valores;

    @XmlElement(name = "Estados")
    private EstadoTarjeta estados;

    @XmlElement(name = "Llave")
    private String llave;

}

