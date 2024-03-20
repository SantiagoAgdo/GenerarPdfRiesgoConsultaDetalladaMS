package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class ImagenTendenciaEndeudamiento {

    @XmlElement(name = "Series")
    private List<Series> series;

    // Constructor, getters y setters

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Series {

        @XmlAttribute(name = "serie")
        private String serie;

        @XmlElement(name = "Valores")
        private ValoresSeries valores;

        // Constructor, getters y setters

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "ValoresSeries", namespace = "http://www.mibanco.com/ValoresSeries")
        public static class ValoresSeries {

            @XmlElement(name = "Valor")
            private List<Valor> valor;

            // Constructor, getters y setters
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "Valor", namespace = "http://www.mibanco.com/Valor")
        public static class Valor {

            @XmlAttribute(name = "valor")
            private double valor;

            @XmlAttribute(name = "fecha")
            private String fecha;

            // Constructor, getters y setters
        }
    }
}

