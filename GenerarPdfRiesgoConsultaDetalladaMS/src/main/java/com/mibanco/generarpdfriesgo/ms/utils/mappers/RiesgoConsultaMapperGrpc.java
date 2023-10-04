package com.mibanco.generarpdfriesgo.ms.utils.mappers;


import com.google.gson.Gson;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import com.mibanco.generarpdfriesgo.ms.GenerarRiesgoConsultaDetalladaInput;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class RiesgoConsultaMapperGrpc {

    private Gson obj = new Gson();

    public GenerarRiesgoConsultaDetalladaInput consultaToGRPC(com.mibanco.generarpdfriesgo.ms.gen.type.GenerarRiesgoConsultaDetalladaInput data) throws InvalidProtocolBufferException {
        GenerarRiesgoConsultaDetalladaInput.Builder structBuilder = GenerarRiesgoConsultaDetalladaInput.newBuilder();
        JsonFormat.parser().ignoringUnknownFields().merge(this.obj.toJson(data), structBuilder);
        return structBuilder.build();
    }
}
