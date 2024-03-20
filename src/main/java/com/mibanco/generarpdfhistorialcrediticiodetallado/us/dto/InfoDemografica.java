package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class InfoDemografica {

    @XmlElement(name = "OperacionesInternacionales")
    private OperacionesInternacionales operacionesInternacionales;

    @XmlElement(name = "Identificacion")
    private Identificacion Identificacion;

}


