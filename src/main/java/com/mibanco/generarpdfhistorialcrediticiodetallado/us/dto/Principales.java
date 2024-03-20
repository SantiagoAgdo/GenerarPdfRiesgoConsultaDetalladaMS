package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.util.Date;

@XmlAccessorType(XmlAccessType.FIELD)
public class Principales {
    @XmlAttribute(name = "creditoVigentes")
    public int creditoVigentes;
    @XmlAttribute(name = "creditosCerrados")
    public int creditosCerrados;
    @XmlAttribute(name = "creditosActualesNegativos")
    public int creditosActualesNegativos;
    @XmlAttribute(name = "histNegUlt12Meses")
    public int histNegUlt12Meses;
    @XmlAttribute(name = "cuentasAbiertasAHOCCB")
    public int cuentasAbiertasAHOCCB;
    @XmlAttribute(name = "cuentasCerradasAHOCCB")
    public int cuentasCerradasAHOCCB;
    @XmlAttribute(name = "consultadasUlt6meses")
    public int consultadasUlt6meses;
    @XmlAttribute(name = "desacuerdosALaFecha")
    public int desacuerdosALaFecha;
    @XmlAttribute(name = "antiguedadDesde")
    public Date antiguedadDesde;
    @XmlAttribute(name = "reclamosVigentes")
    public int reclamosVigentes;
}
