package com.mibanco.generarpdfriesgo.ms.dao.contract.impl;

import com.mibanco.generarpdfriesgo.ms.dao.contract.RiesgoConsultaDetalladaDao;
import com.mibanco.generarpdfriesgo.ms.dao.entity.*;
import com.mibanco.generarpdfriesgo.ms.gen.type.*;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ApplicationScoped
public class RiesgoConsultaDetalladaDaoImpl implements RiesgoConsultaDetalladaDao {
    @Override
    public GenerarPdfRiesgoConsultaDetalladaEntity generarRiesgoHistoricoEndeudamiento(String tipoDocumento, String numeroDocumento, String digitoVerificacion) {
        return mockData(tipoDocumento,numeroDocumento,digitoVerificacion);
    }

    private GenerarPdfRiesgoConsultaDetalladaEntity mockData(String tipoDocumento, String numeroDocumento, String digitoVerificacion){

        List<AnalisisVectorEntity> crearListaAnalisisVector = new ArrayList<>();
        List<EndeudamientoActualEntity> crearListaEndeudamientoActual = new ArrayList<>();
        EndeudamientoActualTotalEntity endeudamientoActualTotal = new EndeudamientoActualTotalEntity();
        List<EndeudamientoGlobalEntity> crearListaEndeudamientoGlobal = new ArrayList<>();
        List<EvolucionDeudaEntity> crearListaEvolucionDeuda = new ArrayList<>();
        List<HabitoDePagoAbiertasEntity> crearListaHabitoPagoAbiertas = new ArrayList<>();
        List<HabitoDePagoCerradasEntity> crearListaHabitoPagoCerradas = new ArrayList<>();
        List<HistoricoConsultaEntity> crearListaHistoricoConsulta = new ArrayList<>();
        List<PerfilSectorEntity> crearListaPerfilSector = new ArrayList<>();
        List<PerfilSectorTotalEntity> crearListaPerfilSectorTotal = new ArrayList<>();
        List<ResumenEndeudamientoGlobalEntity> crearListaResumenEndeudamientoGlobal = new ArrayList<>();
        List<SaldosYMorasEntity> crearListaSaldosYMoras = new ArrayList<>();

        ConsultaDetalladaEntity consultaDetallada = new ConsultaDetalladaEntity(crearListaAnalisisVector, crearListaEndeudamientoActual, endeudamientoActualTotal, crearListaEndeudamientoGlobal, crearListaEvolucionDeuda, crearListaHabitoPagoAbiertas, crearListaHabitoPagoCerradas, crearListaHistoricoConsulta, crearListaPerfilSector, crearListaPerfilSectorTotal, crearListaResumenEndeudamientoGlobal, crearListaSaldosYMoras);

        ClienteBaseEntity  clienteBaseEntity = new ClienteBaseEntity(12345, "John", "Doe", "Smith", "Johnson", TipoDocumentoEnum.CC, "AB123456", 20220101, TipoPersonaEnum.JURIDICA, "john.doe@example.com", 5555555);
        CentralRiesgoEntity centralRiesgo = new CentralRiesgoEntity("5 años", consultaDetallada, "Válido", new Date(), new Date(), "Masculino", "Bueno", "Ciudad", "123456789", "30-40", "Aprobado", true, TipoDocumentoEnum.CC, TipoRelacionEnum.CONYUGE, TipoReporteXmlEnum.CONSULTA_DETALLADA, true, "7");

        return new GenerarPdfRiesgoConsultaDetalladaEntity(clienteBaseEntity, centralRiesgo);
    }

}
