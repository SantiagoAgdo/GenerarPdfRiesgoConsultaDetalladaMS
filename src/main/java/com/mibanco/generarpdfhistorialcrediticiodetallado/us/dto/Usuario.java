package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Usuario {

    @XmlElement(name = "Cuenta")
    public List<Cuenta> Cuenta;

    @XmlAttribute(name = "tipoUsuario")
    public String tipoUsuario;

}
