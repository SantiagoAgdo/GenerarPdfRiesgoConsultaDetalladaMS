package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Data
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class EndeudamientoActual {

    @XmlElement(name = "Sector")
    private List<Sector> sectores;

    public EndeudamientoActual(String s, String tipoUsuario, String estadoActual, String calificacion, String s1, String s2, String s3, String s4, String s5, String s6) {
    }
}

/*@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipoCuenta", namespace = "http://www.mibanco.com/TipoCuenta")
public class TipoCuenta {

    @XmlAttribute(name = "tipoCuenta")
    private String tipoCuenta;

    @XmlElement(name = "Usuario")
    private List<Usuario> usuarios;

    @Data
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Usuario {

        @XmlAttribute(name = "tipoUsuario")
        private String tipoUsuario;

        @XmlElement(name = "CuentaUsuario")
        private List<Cuenta> cuentas;

        // Constructor, getters y setters

        @XmlAccessorType(XmlAccessType.FIELD)
        public static class Cuenta {

            @XmlAttribute(name = "estadoActual")
            private String estadoActual;

            @XmlAttribute(name = "calificacion")
            private String calificacion;
            @XmlAttribute(name = "valorInicial")
            private String valorInicial;
            @XmlAttribute(name = "saldoActual")
            private String saldoActual;
            @XmlAttribute(name = "saldoMora")
            private String saldoMora;
            @XmlAttribute(name = "cuotaMes")
            private String cuotaMes;
            @XmlAttribute(name = "comportamientoNegativo")
            private String comportamientoNegativo;
            @XmlAttribute(name = "totalDeudaCarteras")
            private String totalDeudaCarteras;

        }
    }
}*/

