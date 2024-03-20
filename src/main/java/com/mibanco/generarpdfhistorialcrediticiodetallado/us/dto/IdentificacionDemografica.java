package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class IdentificacionDemografica {

    @XmlAttribute(name = "idRegistro")
    private int idRegistro;

    @XmlAttribute(name = "lugarExpedicion")
    private String lugarExpedicion;

    @XmlAttribute(name = "nitReporta")
    private String nitReporta;

    @XmlAttribute(name = "razonSocial")
    private String razonSocial;

}

