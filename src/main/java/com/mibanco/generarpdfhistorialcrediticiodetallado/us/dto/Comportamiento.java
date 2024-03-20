package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Comportamiento {
    @XmlElement(name = "Mes")
    private List<MesComportamiento> meses;

    // Getters y setters
}

