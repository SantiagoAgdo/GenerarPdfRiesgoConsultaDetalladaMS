package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import lombok.Data;

@Data
public class EndeudamientoGlobalDTO {
    private String endeudamientoGlobalTrimestreC1;
    private String endeudamientoGlobalTrimestreC2;
    private String endeudamientoGlobalTrimestreC3;
    private String endeudamientoGlobalTrimestreC4;
    private EndeudamientoNroMilesDTO endeudamientoGlobalTrimestreC5;
    private EndeudamientoNroMilesDTO hipotecario;
    private EndeudamientoNroMilesDTO consumoTarjetaCredito;
    private EndeudamientoNroMilesDTO microcredito;
    private EndeudamientoGarantiaDTO garantias;
    private String moneda;
    private String fuente;

}