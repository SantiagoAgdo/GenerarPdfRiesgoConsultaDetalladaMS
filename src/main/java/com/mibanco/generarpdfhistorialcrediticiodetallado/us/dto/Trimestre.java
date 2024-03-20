package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import java.util.Date;

@XmlAccessorType(XmlAccessType.FIELD)
public class Trimestre {
    @XmlAttribute(name = "fecha")
    @XmlSchemaType(name = "date")
    private Date fecha;

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
    private String calificacion;

    @XmlAttribute(name = "aperturaCuentas")
    private Integer aperturaCuentas;

    @XmlAttribute(name = "cierreCuentas")
    private Integer cierreCuentas;

    @XmlAttribute(name = "totalAbiertas")
    private Integer totalAbiertas;

    @XmlAttribute(name = "totalCerradas")
    private Integer totalCerradas;

    @XmlAttribute(name = "moraMaxima")
    private String moraMaxima;

    @XmlAttribute(name = "mesesMoraMaxima")
    private Integer mesesMoraMaxima;

    // Getters y setters
}

