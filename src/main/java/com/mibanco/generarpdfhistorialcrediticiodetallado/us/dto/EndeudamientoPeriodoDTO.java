package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import lombok.Data;

import java.util.List;

@Data
public class EndeudamientoPeriodoDTO {

    private String periodicidad;
    private List<EndeudamientoGlobalDTO> endeudamientoGlobal;

}
