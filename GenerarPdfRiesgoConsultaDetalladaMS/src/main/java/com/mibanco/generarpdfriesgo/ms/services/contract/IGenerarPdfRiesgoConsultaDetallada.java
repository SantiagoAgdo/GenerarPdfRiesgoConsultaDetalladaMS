package com.mibanco.generarpdfriesgo.ms.services.contract;

public interface IGenerarPdfRiesgoConsultaDetallada {
    boolean generarRiesgoHistoricoEndeudamiento(String tipoDocumento, String numeroDocumento, String digitoVerificacion);
}
