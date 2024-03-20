package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.util.Date;

@XmlAccessorType(XmlAccessType.FIELD)
public class Score {

    public Razon Razon;
    @XmlAttribute(name = "tipo")
    public int tipo;
    @XmlAttribute(name = "puntaje")
    public double puntaje;
    @XmlAttribute(name = "clasificacion")
    public String clasificacion;

    @XmlAttribute(name = "fecha")
    public Date fecha;
    @XmlAttribute(name = "poblacion")
    public int poblacion;

}

