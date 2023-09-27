package com.mibanco.generarpdfriesgo.ms.dao.contract;

import com.mibanco.generarpdfriesgo.ms.dao.entity.GenerarPdfRiesgoConsultaDetalladaEntity;

public interface RiesgoConsultaDetalladaDao {

    GenerarPdfRiesgoConsultaDetalladaEntity generarRiesgoHistoricoEndeudamiento(String tipoDocumento, String numeroDocumento, String digitoVerificacion);
}
