package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class PerfilGeneral {

    @XmlElement(name = "CreditosVigentes")
    private Creditos creditosVigentes;

    @XmlElement(name = "CreditosCerrados")
    private Creditos creditosCerrados;

    @XmlElement(name = "CreditosReestructurados")
    private Creditos creditosReestructurados;

    @XmlElement(name = "CreditosRefinanciados")
    private Creditos creditosRefinanciados;

    @XmlElement(name = "ConsultaUlt6Meses")
    private Creditos consultaUlt6Meses;

    @XmlElement(name = "Desacuerdos")
    private Creditos desacuerdos;

    @XmlElement(name = "AntiguedadDesde")
    private AntiguedadDesde antiguedadDesde;

    // Getters y setters
}
