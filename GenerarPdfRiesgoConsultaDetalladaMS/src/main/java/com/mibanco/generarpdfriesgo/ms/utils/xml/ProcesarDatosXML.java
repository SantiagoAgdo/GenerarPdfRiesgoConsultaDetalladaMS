package com.mibanco.generarpdfriesgo.ms.utils.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.mibanco.archivofic.us.ArchivoConsultado;
import lombok.Data;

@Data
@JacksonXmlRootElement(localName = "CentralRiesgoType")
public class ProcesarDatosXML {

    @JacksonXmlProperty
    private ArchivoConsultado centralRiesgoType;
}
