package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@XmlRootElement(name = "Informes")
public class Informes {
    @XmlElement(name = "Informe")
    public List<Informe> Informe;

}
