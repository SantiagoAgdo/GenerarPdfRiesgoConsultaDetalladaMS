package com.mibanco.generarpdfriesgo.ms.dao.entity;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RegisterForReflection(targets = {
        AnalisisVectorEntity.class,
        EndeudamientoActualEntity.class,
        EndeudamientoGlobalEntity.class,
        EvolucionDeudaEntity.class,
        HabitoDePagoAbiertasEntity.class,
        HabitoDePagoCerradasEntity.class,
        HistoricoConsultaEntity.class,
        PerfilSectorEntity.class,
        PerfilSectorTotalEntity.class,
        ResumenEndeudamientoGlobalEntity.class,
        SaldosYMorasEntity.class}
)
public class ConsultaDetalladaEntity {

    private List<AnalisisVectorEntity> analisisVector;
    private List<EndeudamientoActualEntity> endeudamientoActual;
    private EndeudamientoActualTotalEntity endeudamientoActualTotal;
    private List<EndeudamientoGlobalEntity> endeudamientoGlobal;
    private List<EvolucionDeudaEntity> evolucionDeuda;
    private List<HabitoDePagoAbiertasEntity> habitoDePagoAbiertas;
    private List<HabitoDePagoCerradasEntity> habitoDePagoCerradas;
    private List<HistoricoConsultaEntity> historicoConsulta;
    private List<PerfilSectorEntity> perfilSector;
    private List<PerfilSectorTotalEntity> perfilSectorTotal;
    private List<ResumenEndeudamientoGlobalEntity> resumenEndeudamientoGlobal;
    private List<SaldosYMorasEntity> saldosYMoras;

}
