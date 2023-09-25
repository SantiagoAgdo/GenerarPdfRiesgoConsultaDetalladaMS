package com.mibanco.generarpdfriesgo.ms.utils.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.mibanco.archivo.us.Creado;
import com.mibanco.generarpdfriesgo.ms.gen.type.CentralRiesgoType;
import lombok.Data;

@Data
@JacksonXmlRootElement(localName = "CentralRiesgoType")
public class ProcesarDatosXML {

    @JacksonXmlProperty
    private Creado centralRiesgoType;
}
