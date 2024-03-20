package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;
@XmlAccessorType(XmlAccessType.FIELD)
public class TipoCuentaComposicionPortafolio {

    @XmlAttribute(name = "tipo")
    private String tipo;

    @XmlAttribute(name = "calidadDeudor")
    private String calidadDeudor;

    @XmlAttribute(name = "porcentaje")
    private double porcentaje;

    @XmlAttribute(name = "cantidad")
    private int cantidad;

    @XmlElement(name = "Estado")
    private List<EstadoTipoCuenta> estados;

}

