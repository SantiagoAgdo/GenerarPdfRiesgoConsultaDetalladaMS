package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.Date;
import java.util.List;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Informe {
    @XmlElement(name = "NaturalNacional")
    public NaturalNacional NaturalNacional;

    @XmlElement(name = "Score")
    public Score Score;

    @XmlElement(name = "CuentaAhorro")
    public List<CuentaAhorro> CuentaAhorro;

    @XmlElement(name = "TarjetaCredito")
    public List<TarjetaCredito> TarjetaCredito;

    @XmlElement(name = "CuentaCartera")
    public List<CuentaCartera> CuentaCartera;

    @XmlElement(name = "EndeudamientoGlobal")
    public List<EndeudamientoGlobal> EndeudamientoGlobal;

    @XmlElement(name = "Consulta")
    public List<Consulta> Consulta;

    @XmlElement(name = "RespuestaPersonalizada")
    public RespuestaPersonalizada RespuestaPersonalizada;

    @XmlElement(name = "InfoAgregada")
    public InfoAgregada InfoAgregada;

    @XmlElement(name = "InfoAgregadaMicrocredito")
    public InfoAgregadaMicrocredito InfoAgregadaMicrocredito;

    @XmlElement(name = "fechaConsulta")
    public Date fechaConsulta;

    @XmlElement(name = "respuesta")
    public int respuesta;

    @XmlElement(name = "codSeguridad")
    public String codSeguridad;

    @XmlElement(name = "tipoIdDigitado")
    public int tipoIdDigitado;

    @XmlElement(name = "identificacionDigitada")
    public int identificacionDigitada;

    @XmlElement(name = "apellidoDigitado")
    public String apellidoDigitado;

    @XmlElement(name = "text")
    public String text;

}

