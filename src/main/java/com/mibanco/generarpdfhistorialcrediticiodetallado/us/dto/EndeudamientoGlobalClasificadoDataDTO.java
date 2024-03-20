package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import lombok.Data;

@Data
public class EndeudamientoGlobalClasificadoDataDTO {

    private String periodicidad;
    private String sector;
    private EndeudamientosGeneralDTO dataSector;
}
