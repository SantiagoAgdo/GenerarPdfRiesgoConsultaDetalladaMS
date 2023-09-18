package com.mibanco.generarpdfriesgo.ms.utils.mappers;

import com.mibanco.generarpdfriesgo.ms.dao.entity.GenerarPdfRiesgoConsultaDetalladaEntity;
import com.mibanco.generarpdfriesgo.ms.gen.type.GenerarPdfRiesgoConsultaDetalladaInput;
import jakarta.enterprise.context.ApplicationScoped;
import org.modelmapper.ModelMapper;

@ApplicationScoped
public class RiesgoConsultaMapper {

    public GenerarPdfRiesgoConsultaDetalladaInput consultaDetalladaEntityToType(GenerarPdfRiesgoConsultaDetalladaEntity entity) {
        return new ModelMapper().map(entity, GenerarPdfRiesgoConsultaDetalladaInput.class);
    }

}
