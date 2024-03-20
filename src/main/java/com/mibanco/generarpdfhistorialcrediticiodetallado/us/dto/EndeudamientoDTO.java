package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import lombok.Data;

import java.util.List;

@Data
public class EndeudamientoDTO {

    private List<EndeudamientoPeriodoDTO> endeudamientoPeriodo;

}