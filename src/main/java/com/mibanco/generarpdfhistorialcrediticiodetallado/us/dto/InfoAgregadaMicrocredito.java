package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class InfoAgregadaMicrocredito {

    @XmlElement(name = "Resumen")
    private ResumenInfoAgregadaMicrocredito resumen;

    @XmlElement(name = "AnalisisVectores")
    private AnalisisVectores analisisVectores;

    @XmlElement(name = "EvolucionDeuda")
    private EvolucionDeudaInfoAgregadaMicrocredito evolucionDeuda;

}

