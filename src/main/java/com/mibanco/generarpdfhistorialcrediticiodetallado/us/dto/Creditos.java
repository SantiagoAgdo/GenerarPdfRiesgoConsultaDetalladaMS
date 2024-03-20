package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@Data
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class Creditos {

    private String name;

    @XmlAttribute(name = "sectorFinanciero")
    private String sectorFinanciero;

    @XmlAttribute(name = "sectorCooperativo")
    private String sectorCooperativo;

    @XmlAttribute(name = "sectorReal")
    private String sectorReal;

    @XmlAttribute(name = "sectorTelcos")
    private String sectorTelcos;

    private String totalSectores;

    @XmlAttribute(name = "totalComoPrincipal")
    private String totalComoPrincipal;

    @XmlAttribute(name = "totalComoCodeudorYOtros")
    private String totalComoCodeudorYOtros;

    public Creditos() {
        this.setTotalSectores("");
    }

    public String getTotalSectores() {
        if(this.name.contains("Antigüedad desde")) {
            return "";
        }
        return String.valueOf((Integer.parseInt(this.sectorFinanciero) + Integer.parseInt(this.sectorTelcos) + Integer.parseInt(this.sectorReal) + Integer.parseInt(this.sectorCooperativo)));
    }

    // Getters y setters
}
