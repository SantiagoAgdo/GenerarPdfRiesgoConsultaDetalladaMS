package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SectorTrimestreResumenEndeudamiento", namespace = "http://www.mibanco.com/SectorTrimestreResumenEndeudamiento")
public class SectorTrimestreResumenEndeudamiento {
    @XmlAttribute(name = "sector")
    private String sector;
    @XmlAttribute(name = "codigoSector")
    private String codigoSector;
    @XmlAttribute(name = "garantiaAdmisible")
    private String garantiaAdmisible;
    @XmlAttribute(name = "garantiaOtro")
    private String garantiaOtro;
    @XmlElement(name = "Cartera")
    private List<Cartera> carteras;

    // Getters y setters
}