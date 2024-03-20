package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class AnalisisPromedio {
    @XmlAttribute(name = "cuota")
    private Double cuota;

    @XmlAttribute(name = "cupoTotal")
    private Double cupoTotal;

    @XmlAttribute(name = "saldo")
    private Double saldo;

    @XmlAttribute(name = "porcentajeUso")
    private Double porcentajeUso;

    @XmlAttribute(name = "score")
    private Double score;

    @XmlAttribute(name = "calificacion")
    private Integer calificacion;

    @XmlAttribute(name = "aperturaCuentas")
    private Double aperturaCuentas;

    @XmlAttribute(name = "cierreCuentas")
    private Double cierreCuentas;

    @XmlAttribute(name = "totalAbiertas")
    private Double totalAbiertas;

    @XmlAttribute(name = "totalCerradas")
    private Double totalCerradas;

    @XmlAttribute(name = "moraMaxima")
    private String moraMaxima;

    // Getters y setters
}

