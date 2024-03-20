package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrimestreResumenEndeudamiento", namespace = "http://www.mibanco.com/TrimestreResumenEndeudamiento")
public class TrimestreResumenEndeudamiento {
    @XmlAttribute(name = "fecha")
    private String fecha;
    @XmlElement(name = "Sector")
    private List<SectorTrimestreResumenEndeudamiento> sectores;

    // Getters y setters
}