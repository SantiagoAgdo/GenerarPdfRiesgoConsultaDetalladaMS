package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class HistoricoSaldos {

    @XmlElement(name = "TipoCuentaHistoricoSaldos")
    private List<TipoCuentaHistorico> tipoCuentas;

    @XmlElement(name = "Totales")
    private List<TotalesHistoricoSaldos> totales;

    // Getters y setters
    public List<TipoCuentaHistorico> getTipoCuentas() {
        return tipoCuentas;
    }

    public void setTipoCuentas(List<TipoCuentaHistorico> tipoCuentas) {
        this.tipoCuentas = tipoCuentas;
    }
}
