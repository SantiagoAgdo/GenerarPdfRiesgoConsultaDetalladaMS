package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class EstadoCuentaCartera {

    @XmlElement(name = "EstadoCuenta")
    private EstadoCuenta estadoCuenta;

    @XmlElement(name = "EstadoOrigen")
    private EstadoOrigen estadoOrigen;

    @XmlElement(name = "EstadoPago")
    private EstadoPago estadoPago;

    @XmlAttribute(name = "codigo")
    private String codigo;

    @XmlAttribute(name = "fecha")
    private String fecha;

    

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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    
}

