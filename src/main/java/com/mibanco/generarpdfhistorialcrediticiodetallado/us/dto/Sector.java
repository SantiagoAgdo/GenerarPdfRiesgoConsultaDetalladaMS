package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Sector {

    @XmlElement(name = "TipoCuenta")
    public List<TipoCuenta> TipoCuenta;

    @XmlAttribute(name = "codSector")
    public int codSector;

    @XmlElement(name = "Cuenta")
    public List<Cuenta> cuenta;

    /*@XmlElement(name = "Usuario")
    public MorasMaximas MorasMaximas;*/

    @XmlAttribute(name = "nombreSector")
    public String nombreSector;


}

