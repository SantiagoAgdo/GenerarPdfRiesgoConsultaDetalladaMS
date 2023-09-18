package com.mibanco.generarpdfriesgo.ms.services.impl;

import com.mibanco.generarpdfriesgo.ms.dao.contract.impl.RiesgoConsultaDetalladaDaoImpl;
import com.mibanco.generarpdfriesgo.ms.dao.entity.GenerarPdfRiesgoConsultaDetalladaEntity;
import com.mibanco.generarpdfriesgo.ms.gen.type.TipoDocumentoEnum;
import com.mibanco.generarpdfriesgo.ms.services.contract.IGenerarPdfRiesgoConsultaDetallada;
import com.mibanco.generarpdfriesgo.ms.utils.mappers.RiesgoConsultaMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class GenerarPdfRiesgoConsultaDetalladaImpl implements IGenerarPdfRiesgoConsultaDetallada {

    public static final Logger LOG = LoggerFactory.getLogger(GenerarPdfRiesgoConsultaDetalladaImpl.class);


    @Inject
    RiesgoConsultaDetalladaDaoImpl riesgoConsultaDetalladaDao;

    @Override
    public boolean generarRiesgoHistoricoEndeudamiento(TipoDocumentoEnum tipoDocumento, String numeroDocumento, String digitoVerificacion) {
        LOG.info("Inicia consulta Detallada de riesgo ");
        GenerarPdfRiesgoConsultaDetalladaEntity dataRiesgoConsulta = riesgoConsultaDetalladaDao.generarRiesgoHistoricoEndeudamiento(tipoDocumento,numeroDocumento,digitoVerificacion);

        LOG.info("Termina consulta Detallada de riesgo");
        return dataRiesgoConsulta != null;
    }
}
