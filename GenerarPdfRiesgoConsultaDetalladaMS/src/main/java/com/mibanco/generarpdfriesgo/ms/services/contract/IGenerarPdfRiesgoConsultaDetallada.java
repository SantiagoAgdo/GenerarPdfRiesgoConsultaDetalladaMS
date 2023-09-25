package com.mibanco.generarpdfriesgo.ms.services.contract;

import com.mibanco.generarpdfriesgo.ms.gen.type.TipoDocumentoEnum;
import jakarta.ws.rs.PathParam;

public interface IGenerarPdfRiesgoConsultaDetallada {

    boolean generarRiesgoHistoricoEndeudamiento(String tipoDocumento, String numeroDocumento, String digitoVerificacion);
}
