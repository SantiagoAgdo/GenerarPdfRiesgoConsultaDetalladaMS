package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class EvolucionDeudaInfoAgregadaMicrocredito {

    @XmlElementWrapper(name = "Trimestres")
    @XmlElement(name = "Trimestre")
    private List<String> trimestres;

    @XmlElement(name = "EvolucionDeudaSector")
    private List<EvolucionDeudaSector> evolucionDeudaSectores;

    // Constructor, getters y setters

    // Clase interna para EvolucionDeudaSector
    @Data
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class EvolucionDeudaSector {

        @XmlAttribute(name = "codSector")
        private String codSector;

        @XmlAttribute(name = "nombreSector")
        private String nombreSector;

        @XmlElement(name = "EvolucionDeudaTipoCuenta")
        private List<EvolucionDeudaTipoCuenta> evolucionDeudaTipoCuentas;

        // Constructor, getters y setters

        // Clase interna para EvolucionDeudaTipoCuenta
        @Data
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "EvolucionDeudaTipoCuenta", namespace = "http://www.mibanco.com/EvolucionDeudaTipoCuenta")
        public static class EvolucionDeudaTipoCuenta {

            @XmlAttribute(name = "tipoCuenta")
            private String tipoCuenta;

            @XmlElement(name = "EvolucionDeudaValorTrimestre")
            private List<EvolucionDeudaValorTrimestre> evolucionDeudaValorTrimestres;

            // Constructor, getters y setters

            // Clase interna para EvolucionDeudaValorTrimestre
            @Data
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "EvolucionDeudaValorTrimestre", namespace = "http://www.mibanco.com/EvolucionDeudaValorTrimestre")
            public static class EvolucionDeudaValorTrimestre {

                @XmlAttribute(name = "trimestre")
                private String trimestre;

                @XmlAttribute(name = "tipoCuenta")
                private String tipoCuenta;

                @XmlAttribute(name = "num")
                private int num;

                @XmlAttribute(name = "cupoInicial")
                private double cupoInicial;

                @XmlAttribute(name = "saldo")
                private double saldo;

                @XmlAttribute(name = "saldoMora")
                private double saldoMora;

                @XmlAttribute(name = "cuota")
                private double cuota;

                @XmlAttribute(name = "porcentajeDeuda")
                private double porcentajeDeuda;

                @XmlAttribute(name = "codMenorCalificacion")
                private String codMenorCalificacion;

                @XmlAttribute(name = "textoMenorCalificacion")
                private String textoMenorCalificacion;

                // Constructor, getters y setters
            }
        }
    }
}
