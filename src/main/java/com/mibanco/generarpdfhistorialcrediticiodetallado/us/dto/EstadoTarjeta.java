package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class EstadoTarjeta {

    @XmlElement(name = "EstadoPlastico")
    private EstadoPlastico estadoPlastico;

    @XmlElement(name = "EstadoCuenta")
    private EstadoCuenta estadoCuenta;

    @XmlElement(name = "EstadoOrigen")
    private EstadoOrigen estadoOrigen;

    @XmlElement(name = "EstadoPago")
    private EstadoPago estadoPago;

    public EstadoPlastico getEstadoPlastico() {
        return estadoPlastico;
    }

    public void setEstadoPlastico(EstadoPlastico estadoPlastico) {
        this.estadoPlastico = estadoPlastico;
    }

    public EstadoCuenta getEstadoCuenta() {
        return estadoCuenta;
    }

    public void setEstadoCuenta(EstadoCuenta estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }

    public EstadoOrigen getEstadoOrigen() {
        return estadoOrigen;
    }

    public void setEstadoOrigen(EstadoOrigen estadoOrigen) {
        this.estadoOrigen = estadoOrigen;
    }

    public EstadoPago getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(EstadoPago estadoPago) {
        this.estadoPago = estadoPago;
    }

    
}

