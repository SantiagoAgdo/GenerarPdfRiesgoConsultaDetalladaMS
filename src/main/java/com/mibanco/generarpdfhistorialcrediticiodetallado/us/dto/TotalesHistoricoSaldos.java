package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)

public class TotalesHistoricoSaldos {

    @XmlAttribute(name = "fecha")
    private String fecha;
    @XmlAttribute(name = "totalCuentas")
    private String totalCuentas;
    @XmlAttribute(name = "cuentasConsideradas")
    private String cuentasConsideradas;
    @XmlAttribute(name = "saldo")
    private String saldo;

}
