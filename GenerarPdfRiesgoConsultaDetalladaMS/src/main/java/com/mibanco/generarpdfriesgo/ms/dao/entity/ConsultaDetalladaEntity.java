package com.mibanco.generarpdfriesgo.ms.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
