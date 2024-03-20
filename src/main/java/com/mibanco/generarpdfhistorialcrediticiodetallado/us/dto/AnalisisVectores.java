package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AnalisisVectores", namespace = "http://www.mibanco.com/AnalisisVectores")
public class AnalisisVectores {

    @XmlElement(name = "Sector")
    private List<SectorAnalisisVectores> sector;

    // Constructor, getters y setters

    @XmlAccessorType(XmlAccessType.FIELD)
    @Data
    @XmlType(name = "SectorAnalisisVectores", namespace = "http://www.mibanco.com/SectorAnalisisVectores")
    public static class SectorAnalisisVectores {

        @XmlAttribute(name = "nombreSector")
        private String nombreSector;

        @XmlElement(name = "Cuenta")
        private List<Cuenta> cuenta;

        @XmlElement(name = "MorasMaximas")
        private MorasMaximas morasMaximas;

        // Constructor, getters y setters

        @XmlAccessorType(XmlAccessType.FIELD)
        @Data
        @XmlType(name = "CuentaSectorAnalisisVectores", namespace = "http://www.mibanco.com/CuentaSectorAnalisisVectores")
        public static class Cuenta {

            @XmlAttribute(name = "entidad")
            private String entidad;

            @XmlAttribute(name = "numeroCuenta")
            private String numeroCuenta;

            @XmlAttribute(name = "tipoCuenta")
            private String tipoCuenta;

            @XmlAttribute(name = "estado")
            private String estado;

            @XmlAttribute(name = "contieneDatos")
            private boolean contieneDatos;

            @XmlElement(name = "CaracterFecha")
            private List<CaracterFecha> caracterFechas;

            // Constructor, getters y setters
        }

        @Data
        @XmlAccessorType(XmlAccessType.FIELD)
        public static class CaracterFecha {

            @XmlAttribute(name = "fecha")
            private String fecha;

            @XmlAttribute(name = "saldoDeudaTotalMora")
            private String saldoDeudaTotalMora;

            // Constructor, getters y setters
        }

        @Data
        @XmlAccessorType(XmlAccessType.FIELD)
        public static class MorasMaximas {

            @XmlElement(name = "CaracterFecha")
            private List<CaracterFecha> caracterFechas;

            // Constructor, getters y setters
        }
    }
}

