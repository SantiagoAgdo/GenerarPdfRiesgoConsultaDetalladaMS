package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
public class Saldos {

    @XmlElement(name = "Sector")
    private List<Sector> Sector;
    @XmlAttribute(name = "saldoTotalEnMora")
    private double saldoTotalEnMora;

    @XmlAttribute(name = "saldoM30")
    private double saldoM30;

    @XmlAttribute(name = "saldoM60")
    private double saldoM60;

    @XmlAttribute(name = "saldoM90")
    private double saldoM90;

    @XmlAttribute(name = "cuotaMensual")
    private double cuotaMensual;

    @XmlAttribute(name = "saldoCreditoMasAlto")
    private double saldoCreditoMasAlto;

    @XmlAttribute(name = "saldoTotal")
    private double saldoTotal;

    @XmlElement(name = "Mes")
    private List<MesSaldos> meses;

}

