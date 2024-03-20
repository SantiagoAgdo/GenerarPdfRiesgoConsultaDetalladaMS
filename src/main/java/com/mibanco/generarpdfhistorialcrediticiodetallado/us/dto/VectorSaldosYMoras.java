package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class VectorSaldosYMoras {

    @XmlAttribute(name = "poseeSectorCooperativo")
    private boolean poseeSectorCooperativo;

    @XmlAttribute(name = "poseeSectorFinanciero")
    private boolean poseeSectorFinanciero;

    @XmlAttribute(name = "poseeSectorReal")
    private boolean poseeSectorReal;

    @XmlAttribute(name = "poseeSectorTelcos")
    private boolean poseeSectorTelcos;

    @XmlElement(name = "SaldosYMoras")
    private List<SaldosYMoras> saldosYMoras;


    @Data
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class SaldosYMoras {

        @XmlAttribute(name = "fecha")
        private String fecha;

        @XmlAttribute(name = "totalCuentasMora")
        private int totalCuentasMora;

        @XmlAttribute(name = "saldoDeudaTotalMora")
        private double saldoDeudaTotalMora;

        @XmlAttribute(name = "saldoDeudaTotal")
        private double saldoDeudaTotal;

        @XmlAttribute(name = "morasMaxSectorFinanciero")
        private String morasMaxSectorFinanciero;

        @XmlAttribute(name = "morasMaxSectorTelcos")
        private String morasMaxSectorTelcos;

        @XmlAttribute(name = "morasMaxSectorCooperativo")
        private String morasMaxSectorCooperativo;

        @XmlAttribute(name = "morasMaxSectorReal")
        private String morasMaxSectorReal;

        @XmlAttribute(name = "morasMaximas")
        private String morasMaximas;

        @XmlAttribute(name = "numCreditos30")
        private int numCreditos30;

        @XmlAttribute(name = "numCreditosMayorIgual60")
        private int numCreditosMayorIgual60;

    }

}

