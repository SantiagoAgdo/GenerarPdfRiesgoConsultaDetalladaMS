package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Estados", namespace = "http://www.mibanco.com/Estados")
public class Estados {

    @XmlElement(name = "EstadoCuenta")
    private EstadoCuenta estadoCuenta;

    @XmlElement(name = "EstadoOrigen")
    private EstadoOrigen estadoOrigen;

    @XmlElement(name = "EstadoPago")
    private EstadoPago estadoPago;
}
