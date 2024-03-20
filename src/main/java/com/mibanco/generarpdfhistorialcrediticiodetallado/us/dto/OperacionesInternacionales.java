package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.util.Date;

@XmlAccessorType(XmlAccessType.FIELD)
public class OperacionesInternacionales {

    @XmlAttribute(name = "idRegistro")
    public int idRegistro;

    @XmlAttribute(name = "operaInt")
    public boolean operaInt;

    @XmlAttribute(name = "fecha")
    public Date fecha;

    @XmlAttribute(name = "nitReporta")
    public int nitReporta;

    @XmlAttribute(name = "razonSocial")
    public String razonSocial;
}

