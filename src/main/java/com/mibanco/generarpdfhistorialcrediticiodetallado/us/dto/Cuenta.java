package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class Cuenta {

    private String nameColmun;

    @XmlAttribute(name = "estadoActual")
    private String estadoActual;

    @XmlAttribute(name = "calificacion")
    private String calificacion;

    @XmlAttribute(name = "valorInicial")
    private double valorInicial;

    @XmlAttribute(name = "saldoActual")
    private double saldoActual;

    @XmlAttribute(name = "saldoMora")
    private double saldoMora;

    @XmlAttribute(name = "cuotaMes")
    private double cuotaMes;

    @XmlAttribute(name = "comportamientoNegativo")
    private boolean comportamientoNegativo;

    @XmlAttribute(name = "totalDeudaCarteras")
    private double totalDeudaCarteras;

    private String calidad;
    private String porcentajeParticipacion;
    private String porcentajeDeuda;

    //private List<CaracterFecha> CaracterFecha;

    @XmlAttribute(name = "entidad")
    private String entidad;

    public Cuenta(String nameColmun, String calidad, String estadoActual,  String calificacion, double valorInicial, double saldoActual, double saldoMora, double cuotaMes, String porcentajeParticipacion, String porcentajeDeuda) {
        this.nameColmun = nameColmun;
        this.estadoActual = estadoActual;
        this.calificacion = calificacion;
        this.saldoActual = saldoActual;
        this.valorInicial = valorInicial;
        this.saldoMora = saldoMora;
        this.cuotaMes = cuotaMes;
        this.calidad = calidad;
        this.porcentajeParticipacion = porcentajeParticipacion;
        this.porcentajeDeuda = porcentajeDeuda;
    }

    @XmlAttribute(name = "numeroCuenta")
    private int numeroCuenta;

    @XmlAttribute(name = "tipoCuenta")
    private String tipoCuenta;

    @XmlAttribute(name = "estado")
    private String estado;

    @XmlAttribute(name = "tipoCuenta")
    private boolean contieneDatos;


}
