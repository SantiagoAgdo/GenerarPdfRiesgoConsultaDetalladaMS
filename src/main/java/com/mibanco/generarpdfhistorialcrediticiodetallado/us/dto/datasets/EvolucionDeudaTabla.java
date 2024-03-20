package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto.datasets;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EvolucionDeudaTabla {

    private String tipoDeuda;
    private String num;
    private String cupoinicial;
    private String saldo;
    private String mora;
    private String cuota;
    private String deuda;
    private String calificacion;
}


