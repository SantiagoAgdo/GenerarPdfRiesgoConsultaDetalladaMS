package com.mibanco.generarpdfriesgo.ms.dao.contract;

import com.mibanco.generarpdfriesgo.ms.dao.entity.GenerarPdfRiesgoConsultaDetalladaEntity;
import com.mibanco.generarpdfriesgo.ms.gen.type.GenerarPdfRiesgoConsultaDetalladaInput;
import com.mibanco.generarpdfriesgo.ms.gen.type.TipoDocumentoEnum;

public interface RiesgoConsultaDetalladaDao {

    GenerarPdfRiesgoConsultaDetalladaEntity generarRiesgoHistoricoEndeudamiento(String tipoDocumento, String numeroDocumento, String digitoVerificacion);
}
