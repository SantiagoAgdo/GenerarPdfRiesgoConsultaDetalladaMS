package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;


@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Adjetivo", namespace = "http://www.mibanco.com/Adjetivo")
public class Adjetivo {
    @XmlAttribute(name = "codigo")
    private String codigo;

    @XmlAttribute(name = "fecha")
    private String fecha;

}