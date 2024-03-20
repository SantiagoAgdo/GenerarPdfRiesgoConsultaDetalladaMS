package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class MesSaldos {
    @XmlAttribute(name = "fecha")
    private String fecha;
    @XmlAttribute(name = "saldoTotalMora")
    private Double saldoTotalMora;

    @XmlAttribute(name = "saldoTotal")
    private Double saldoTotal;
}

