package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class CaracteristicasTarjeta {
    @XmlAttribute(name = "franquicia")
    private int franquicia;

    @XmlAttribute(name = "clase")
    private int clase;

    @XmlAttribute(name = "marca")
    private String marca;

    @XmlAttribute(name = "calidadDeudor")
    private String calidadDeudor;

    @XmlAttribute(name = "amparada")
    private boolean amparada;

    @XmlAttribute(name = "codigoAmparada")
    private String codigoAmparada;

    @XmlAttribute(name = "garantia")
    private String garantia;

    
}

