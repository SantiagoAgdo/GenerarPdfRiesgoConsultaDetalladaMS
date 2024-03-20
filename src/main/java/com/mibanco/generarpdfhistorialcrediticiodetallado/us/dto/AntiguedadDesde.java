package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class AntiguedadDesde {

    private String name;

    @XmlAttribute(name = "sectorCooperativo")
    private String sectorCooperativo;

    @XmlAttribute(name = "sectorFinanciero")
    private String sectorFinanciero;

    @XmlAttribute(name = "sectorReal")
    private String sectorReal;

    @XmlAttribute(name = "sectorTelcos")
    private String sectorTelcos;

}
