package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Consulta", namespace = "http://www.mibanco.com/Consulta")
public class Consulta {

    @XmlAttribute(name = "fecha")
    private String fecha;

    @XmlAttribute(name = "tipoCuenta")
    private String tipoCuenta;

    @XmlAttribute(name = "entidad")
    private String entidad;

    @XmlAttribute(name = "oficina")
    private String oficina;

    @XmlAttribute(name = "ciudad")
    private String ciudad;

    @XmlAttribute(name = "razon")
    private String razon;

    @XmlAttribute(name = "cantidad")
    private String cantidad;

    @XmlAttribute(name = "nitSuscriptor")
    private String nitSuscriptor;

    @XmlAttribute(name = "sectorConsulta")
    private String sector;

    @XmlElement(name = "Llave")
    private String llave;

}

