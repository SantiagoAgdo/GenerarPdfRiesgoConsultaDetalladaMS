package com.mibanco.generarpdfriesgo.ms.utils.mappers;

import com.mibanco.generarpdfriesgo.ms.gen.type.TipoDocumentoEnum;
import jakarta.enterprise.context.ApplicationScoped;
import org.modelmapper.ModelMapper;

@ApplicationScoped
public class RiesgoConsultaMapperGrpc {

    public TipoDocumentoEnum tipoDocumentoToEnum(String grpc) {
        return new ModelMapper().map(grpc, TipoDocumentoEnum.class);
    }

}
