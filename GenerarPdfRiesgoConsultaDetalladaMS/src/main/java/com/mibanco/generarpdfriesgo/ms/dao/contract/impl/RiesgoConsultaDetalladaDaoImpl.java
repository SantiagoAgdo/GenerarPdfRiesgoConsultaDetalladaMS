package com.mibanco.generarpdfriesgo.ms.dao.contract.impl;

import com.mibanco.generarpdfriesgo.ms.dao.contract.RiesgoConsultaDetalladaDao;
import com.mibanco.generarpdfriesgo.ms.dao.entity.*;
import com.mibanco.generarpdfriesgo.ms.gen.type.TipoDocumentoEnum;
import com.mibanco.generarpdfriesgo.ms.gen.type.TipoPersonaEnum;
import com.mibanco.generarpdfriesgo.ms.gen.type.TipoRelacionEnum;
import com.mibanco.generarpdfriesgo.ms.gen.type.TipoReporteXmlEnum;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ApplicationScoped
public class RiesgoConsultaDetalladaDaoImpl implements RiesgoConsultaDetalladaDao {
    @Override
    public GenerarPdfRiesgoConsultaDetalladaEntity generarRiesgoHistoricoEndeudamiento(String numeroCliente) {
        return createMockData(numeroCliente);
    }

    private GenerarPdfRiesgoConsultaDetalladaEntity createMockData(String numeroCliente) {
        List<AnalisisVectorEntity> analisisVectorList = new ArrayList<>();
        List<EndeudamientoActualEntity> endeudamientoActualList = new ArrayList<>();
        EndeudamientoActualTotalEntity endeudamientoActualTotal = new EndeudamientoActualTotalEntity();
        List<EndeudamientoGlobalEntity> endeudamientoGlobalList = new ArrayList<>();
        List<EvolucionDeudaEntity> evolucionDeudaList = new ArrayList<>();
        List<HabitoDePagoAbiertasEntity> habitoPagoAbiertasList = new ArrayList<>();
        List<HabitoDePagoCerradasEntity> habitoPagoCerradasList = new ArrayList<>();
        List<HistoricoConsultaEntity> historicoConsultaList = new ArrayList<>();
        List<PerfilSectorEntity> perfilSectorList = new ArrayList<>();
        List<PerfilSectorTotalEntity> perfilSectorTotalList = new ArrayList<>();
        List<ResumenEndeudamientoGlobalEntity> resumenEndeudamientoGlobalList = new ArrayList<>();
        List<SaldosYMorasEntity> saldosYMorasList = new ArrayList<>();

        ConsultaDetalladaEntity consultaDetallada = new ConsultaDetalladaEntity(
                analisisVectorList, endeudamientoActualList, endeudamientoActualTotal, endeudamientoGlobalList,
                evolucionDeudaList, habitoPagoAbiertasList, habitoPagoCerradasList, historicoConsultaList,
                perfilSectorList, perfilSectorTotalList, resumenEndeudamientoGlobalList, saldosYMorasList
        );

        ClienteBaseEntity clienteBaseEntity = new ClienteBaseEntity(
                12345, "John", "Doe", "Smith", "Johnson", TipoDocumentoEnum.CC, "AB123456",
                20220101, TipoPersonaEnum.JURIDICA, "john.doe@example.com", 5555555
        );

        CentralRiesgoEntity centralRiesgo = new CentralRiesgoEntity(
                "5 años", consultaDetallada, "Válido", new Date(), new Date(), "Masculino", "Bueno",
                "Ciudad", "123456789", "30-40", "Aprobado", true, TipoDocumentoEnum.CC,
                TipoRelacionEnum.CONYUGE, TipoReporteXmlEnum.CONSULTA_DETALLADA, true, "7"
        );

        return new GenerarPdfRiesgoConsultaDetalladaEntity(clienteBaseEntity, centralRiesgo);
    }


}
