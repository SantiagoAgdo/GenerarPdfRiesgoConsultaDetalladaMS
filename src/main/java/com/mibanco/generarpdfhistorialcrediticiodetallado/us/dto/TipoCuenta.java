package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class TipoCuenta {

    @XmlAttribute(name = "codigoTipo")
    private String codigoTipo;

    @XmlAttribute(name = "tipo")
    private String tipo;

    @XmlAttribute(name = "calidadDeudor")
    private String calidadDeudor;

    @XmlAttribute(name = "cupo")
    private double cupo;

    @XmlAttribute(name = "saldo")
    private double saldo;

    @XmlAttribute(name = "saldoMora")
    private double saldoMora;

    @XmlAttribute(name = "cuota")
    private double cuota;

    @XmlElement(name = "Estado")
    private Estado Estado;

    @XmlAttribute(name = "porcentaje")
    private double porcentaje;

    @XmlAttribute(name = "cantidad")
    private int cantidad;

    //private List<Trimestre> Trimestre;

    private List<Usuario> Usuario;

    @XmlAttribute(name = "tipoCuenta")
    private String tipoCuenta;

}
