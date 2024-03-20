package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class EvolucionDeuda {
    @XmlElement(name = "Trimestre")
    private List<Trimestre> trimestres;

    @XmlElement(name = "AnalisisPromedio")
    private AnalisisPromedio analisisPromedio;

    // Getters y setters
}
