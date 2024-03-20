package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class ResumenInfoAgregadaMicrocredito {

    @XmlElement(name = "PerfilGeneral")
    private PerfilGeneral perfilGeneral;

    @XmlElement(name = "VectorSaldosYMoras")
    private VectorSaldosYMoras vectorSaldosYMoras;

    @XmlElement(name = "EndeudamientoActual")
    private EndeudamientoActual endeudamientoActual;

    @XmlElement(name = "ImagenTendenciaEndeudamiento")
    private ImagenTendenciaEndeudamiento imagenTendenciaEndeudamiento;

}

