package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Cartera", namespace = "http://www.mibanco.com/Cartera")
public class Cartera {
    @XmlAttribute(name = "tipo")
    private String tipo;
    @XmlAttribute(name = "numeroCuentas")
    private int numeroCuentas;
    @XmlAttribute(name = "valor")
    private double valor;

    // Getters y setters
}