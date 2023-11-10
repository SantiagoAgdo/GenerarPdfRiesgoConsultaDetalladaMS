package com.mibanco.generarpdfriesgo.ms.dao.entity;

import com.mibanco.generarpdfriesgo.ms.gen.type.TIpoSectorXmlEnum;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RegisterForReflection
public class AnalisisVectorEntity {

    private TIpoSectorXmlEnum sector;
    private String entidad;
    private Integer numCuenta;
    private String tipoCuenta;
    private String estado;
    private String periodo;
}
