package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class InfoAgregada {
    @XmlElement(name = "Resumen")
    private Resumen resumen;

    @XmlElement(name = "Totales")
    private Totales totales;

    @XmlElement(name = "ComposicionPortafolio")
    private ComposicionPortafolio composicionPortafolio;

    @XmlElement(name = "Cheques")
    private Cheques cheques;

    @XmlElement(name = "EvolucionDeuda")
    private EvolucionDeuda evolucionDeuda;

    @XmlElement(name = "HistoricoSaldos")
    private HistoricoSaldos historicoSaldos;

    @XmlElement(name = "ResumenEndeudamiento")
    private ResumenEndeudamiento resumenEndeudamiento;

    // Getters y setters
}

