package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import lombok.Data;

import java.math.BigInteger;
import java.util.List;

@Data
public class EndeudamientosGeneralDTO {
    private List<EndeudamientoGlobalDTO> endeudamiento;
    private BigInteger total;
}
