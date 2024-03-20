package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;


@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class EndeudamientoGlobal {

    @XmlAttribute(name = "calificacion")
    private String calificacion;

    @XmlAttribute(name = "fuente")
    private String fuente;

    @XmlAttribute(name = "saldoPendiente")
    private long saldoPendiente;

    @XmlAttribute(name = "tipoCredito")
    private String tipoCredito;

    @XmlAttribute(name = "moneda")
    private String moneda;

    @XmlAttribute(name = "numeroCreditos")
    private int numeroCreditos;

    @XmlAttribute(name = "independiente")
    private String independiente;

    @XmlAttribute(name = "fechaReporte")
    private String fechaReporte;

    @XmlElement(name = "Entidad")
    private Entidad entidad;

    @XmlElement(name = "Garantia")
    private Garantia garantia;

    @XmlElement(name = "Llave")
    private String llave;

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "Entidad", namespace = "http://www.mibanco.com/Entidad")
    @Data
    public static class Entidad {
        @XmlAttribute(name = "nombre")
        private String nombre;

        @XmlAttribute(name = "nit")
        private String nit;

        @XmlAttribute(name = "sector")
        private int sector;

        // Getters y setters...
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "Garantia", namespace = "http://www.mibanco.com/Garantia")
    @Data
    public static class Garantia {
        @XmlAttribute(name = "tipo")
        private String tipo;

        @XmlAttribute(name = "valor")
        private double valor;

        @XmlAttribute(name = "fecha")
        private String fecha;

        // Getters y setters...
    }
}

