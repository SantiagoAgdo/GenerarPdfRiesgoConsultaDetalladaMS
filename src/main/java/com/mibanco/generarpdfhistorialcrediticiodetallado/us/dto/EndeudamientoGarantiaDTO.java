package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EndeudamientoGarantiaDTO {
    private String tipo;
    private String fechaAvaluo;
    private Double valor;
}
