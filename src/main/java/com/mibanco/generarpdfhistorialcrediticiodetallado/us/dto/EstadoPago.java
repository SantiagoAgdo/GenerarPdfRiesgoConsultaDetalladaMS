package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class EstadoPago {
    @XmlAttribute(name = "codigo")
    private String codigo;

    @XmlAttribute(name = "fecha")
    private String fecha;

    @XmlAttribute(name = "meses")
    private int meses;

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

    public int getMeses() {
        return meses;
    }

    public void setMeses(int meses) {
        this.meses = meses;
    }

    
}

