package com.mibanco.generarpdfhistorialcrediticiodetallado.us.service.impl;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.mibanco.generarpdfhistorialcrediticiodetallado.us.dao.entity.ArchivoEntity;
import com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto.*;
import com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto.datasets.*;
import com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto.datasets.EndeudamientoActual;
import com.mibanco.generarpdfhistorialcrediticiodetallado.us.gen.type.HistorialCreditoBaseArchivoXmlInput;
import com.mibanco.generarpdfhistorialcrediticiodetallado.us.gen.type.HistorialCreditoBaseArchivoXmlOutput;
import com.mibanco.generarpdfhistorialcrediticiodetallado.us.service.command.consumer.ObtenerArchivoCmd;
import com.mibanco.generarpdfhistorialcrediticiodetallado.us.service.contract.IGenerarPdfHistorialCrediticioDetalladoMiBancoService;
import com.mibanco.generarpdfhistorialcrediticiodetallado.us.util.mappers.XMLMapper;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@ApplicationScoped
public class GenerarPdfHistorialCrediticioDetalladoMiBancoServiceImpl implements IGenerarPdfHistorialCrediticioDetalladoMiBancoService {
    private final Logger LOG = LoggerFactory.getLogger(GenerarPdfHistorialCrediticioDetalladoMiBancoServiceImpl.class);

    @Inject
    ObjectMapper objectMapper;
    @Inject
    ObtenerArchivoCmd obtenerArchivoCmd;

    @Inject
    XMLMapper mapper;

    @Override
    public HistorialCreditoBaseArchivoXmlOutput generarPDFHistorialCreditoBaseArchivoXml(HistorialCreditoBaseArchivoXmlInput input) throws IOException, JAXBException, JRException {

        Informe informes = tranformacionXmlToObj(input);

        //Control de Usuarios Rechazados
        if (informes.getScore() == null && informes.getCuentaAhorro() == null && informes.getTarjetaCredito() == null && informes.getCuentaCartera() == null && informes.getEndeudamientoGlobal() == null) {
            return usuarioRechazado(informes);
        }

        JasperPrint jasperPrint = generacionJasperPrint(informes);
        // Exportar el informe a PDF
        //JasperExportManager.exportReportToPdfFile(jasperPrint, "src/main/resources/output/xxxx2.pdf");
        //JasperExportManager.exportReportToHtmlFile(jasperPrint, "src/main/resources/output/reporte.html");


        HistorialCreditoBaseArchivoXmlOutput pdf = new HistorialCreditoBaseArchivoXmlOutput();
        pdf.setDatosBinarios(JasperExportManager.exportReportToPdf(jasperPrint));

        return pdf;
    }

    private HistorialCreditoBaseArchivoXmlOutput usuarioRechazado(Informe informes) throws JRException {
        InputStream inputStream2 = getClass().getResourceAsStream("/reports/usuario_rechazado.jrxml");
        JasperReport jasperReport2 = JasperCompileManager.compileReport(inputStream2);

        List<Map<String, Object>> data = prepararDatos(informes);
        JasperPrint jasperPrint2 = JasperFillManager.fillReport(jasperReport2, null, new JRBeanCollectionDataSource(data));

        HistorialCreditoBaseArchivoXmlOutput pdf = new HistorialCreditoBaseArchivoXmlOutput();
        pdf.setDatosBinarios(JasperExportManager.exportReportToPdf(jasperPrint2));
        return pdf;
    }

    private List<Map<String, Object>> prepararDatos(Informe informes) {

        List<Map<String, Object>> data = new ArrayList<>();

        SimpleDateFormat formatoSalida = new SimpleDateFormat("dd-MM-yyyy");
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String fechaFormateada = fechaActual.format(formateador);

        //Información básica
        Map<String, Object> datos = new HashMap<>();
        datos.put("vigencia", informes.getNaturalNacional().getIdentificacion().getEstado() == 0 ? "Vigente" : "");
        datos.put("fechaConsulta", fechaFormateada);
        datos.put("documento", String.valueOf(informes.getNaturalNacional().getIdentificacion().getNumero()));
        datos.put("tipo_documento", "C.C");
        datos.put("lugar_expedicion", String.valueOf(informes.getNaturalNacional().getIdentificacion().getCiudad()));
        datos.put("fecha_expedicion", formatoSalida.format(informes.getNaturalNacional().getIdentificacion().getFechaExpedicion()));
        datos.put("nombreCompleto", informes.getNaturalNacional().getNombreCompleto());
        datos.put("edad", informes.getNaturalNacional().getEdad().getMin() + "-" + informes.getNaturalNacional().getEdad().getMax());
        datos.put("genero", String.valueOf(generoToDescripcion(informes.getNaturalNacional().getIdentificacion().getGenero())));
        datos.put("rut", informes.getNaturalNacional().rut ? "Si" : "No");

        if (informes.getInfoAgregadaMicrocredito() != null){
            Map<String, List<String>> mesesVectores = mesesAnalisis(informes);
            //Rellena las cabeceras de la tabla saldos y moras
            List<String> mesesCabecera = mesesSaldos(informes);
            if (mesesCabecera.size() == 0){
                for (int i = 0; i < 12; i++) {
                    datos.put("sYm_mes" + (i + 1), "//");
                }
            }

            for (int i = 0; i < mesesCabecera.size(); i++) {
                datos.put("sYm_mes" + (i + 1), mesesCabecera.get(i));
            }

            Map<String, String> sectorToPrefixMap = new HashMap<>();
            sectorToPrefixMap.put("Sector Financiero", "avSectorFinanciero");
            sectorToPrefixMap.put("Sector Telcos", "avSectorTeleco");
            sectorToPrefixMap.put("Sector Cooperativo", "avSectorCooperativo");
            sectorToPrefixMap.put("Sector Real", "avSectorReal");

            for (Map.Entry<String, List<String>> entrada : mesesVectores.entrySet()) {
                int count = 1;
                String sector = entrada.getKey();
                List<String> datosSector = entrada.getValue();

                // Obtener el prefijo correspondiente al sector
                String prefijo = sectorToPrefixMap.getOrDefault(sector, "avSectorDesconocido");

                if (datosSector.size() != 0) {
                    // Agregar los datos al mapa con la clave adecuada
                    for (String z : datosSector) {
                        datos.put(prefijo + count, z);
                        count++;
                    }
                } else {
                    for (int i = 0; i < 23; i++) {
                        datos.put(prefijo + count, "/// //");
                        count++;
                    }
                }
            }
        }
        data.add(datos);
        return data;
    }

    public String generoToDescripcion(int params) {
        return switch (params) {
            case 1, 2, 3 -> "Femenino";
            case 4 -> "Masculino";
            default -> "";
        };
    }

    private List<String> mesesSaldos(Informe informes) {

        List<String> meses = new ArrayList<>();
        if (informes.getInfoAgregadaMicrocredito().getResumen().getVectorSaldosYMoras().getSaldosYMoras() == null){
            return meses;
        }
        for (VectorSaldosYMoras.SaldosYMoras saldos : informes.getInfoAgregadaMicrocredito().getResumen().getVectorSaldosYMoras().getSaldosYMoras()) {
            meses.add(numeroAMes(saldos.getFecha().substring(5, 7)) + " " + saldos.getFecha().substring(2, 4));
        }
        return meses;
    }

    private Map<String, List<String>> mesesAnalisis(Informe informes) {

        Map<String, List<String>> sectorToMesesMap = new HashMap<>();
        sectorToMesesMap.put("Sector Financiero", new ArrayList<>());
        sectorToMesesMap.put("Sector Telcos", new ArrayList<>());
        sectorToMesesMap.put("Sector Cooperativo", new ArrayList<>());
        sectorToMesesMap.put("Sector Real", new ArrayList<>());

        if (informes.getInfoAgregadaMicrocredito().getAnalisisVectores() == null){
            return sectorToMesesMap;
        }
        for (AnalisisVectores.SectorAnalisisVectores vectores : informes.getInfoAgregadaMicrocredito().getAnalisisVectores().getSector()) {
            List<String> meses = sectorToMesesMap.getOrDefault(vectores.getNombreSector(), new ArrayList<>());
            for (int i = 0; i < 24; i++) {
                meses.add(numeroAMes(vectores.getCuenta().get(0).getCaracterFechas().get(i).getFecha().substring(5, 7))
                        + "     " +
                        vectores.getCuenta().get(0).getCaracterFechas().get(i).getFecha().substring(2, 4));
            }
            sectorToMesesMap.put(vectores.getNombreSector(), meses);
        }

        return sectorToMesesMap;
    }

    //Data
    private Map<String, Object> rellenoDeDataSets(Informe informes) {

        Map<String, Object> parameter = new HashMap<>();

        //Perfil General - Sectores
        List<Creditos> creditos = mapeoCreditos(informes);
        // Perfil General - Saldos & Moras
        List<SaldosYMorasArray> saldosYMoras = mapeoSaldosYMoras(informes);
        //Datos de perfil endeudamiento
        List<com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto.datasets.EndeudamientoActual> endeudamientoActual = mapeoEndeudameintoActual(informes);
        //Habitos Abiertos/Vigentes
        List<List<AbiertosVigentesDataSet>> habitosAbiertosVigentes = mapeoHabitosAbiertosVigentes(informes);
        //Habitos Cerrados
        List<List<HabitObligaCerradas>> mapeoCerradas = mapeoHabitosObligacionesCerradas(informes.getCuentaCartera(), informes.getTarjetaCredito(), informes.getCuentaAhorro());
        //Analisis de Vectores
        List<List<AnalisisVectoresDataSet>> listas = mapeoAnalisisDeVectores(informes);
        // Evolucion de la deuda
        List<EvolucionDeudaTabla> evolucionDeuda = rellenoEvolucionDeuda(informes);
        //Historico De Consultas
        List<HistoricoConsultasDataSet> historicoConsultas = mapeoHistoricoConsultas(informes);
        //Endeudamiento Global Clasificado
        List<List<DeudaGlobal>> deudaGlobal = informes.getEndeudamientoGlobal() != null ? deudaGlobal(informes) : null;
        //Resumen Endeudamiento Global
        List<List<ResumenEndeudamientoGlobalDataSet>> resumenEndeudameintoGlobal = formatoResumenEndeudameinto(informes);

        //DataSets
        parameter.put("petsData", new JRBeanCollectionDataSource(creditos));
        parameter.put("petsDatatest1", new JRBeanCollectionDataSource(saldosYMoras));
        parameter.put("petsDatatest", new JRBeanCollectionDataSource(endeudamientoActual));
        parameter.put("petsDataSetAnalisisVectoresSectorFinanciero", new JRBeanCollectionDataSource(listas.get(0)));
        parameter.put("petsDataSetAnalisisVectoresSectorReal", new JRBeanCollectionDataSource(listas.get(1)));
        parameter.put("petsDataSetAnalisisVectoresSectorTelcos", new JRBeanCollectionDataSource(listas.get(2)));
        parameter.put("petsDataSetAnalisisVectoresSectorCooperativo", new JRBeanCollectionDataSource(listas.get(3)));
        parameter.put("petsDataSetEvolucionDeudaComutadores", new JRBeanCollectionDataSource(evolucionDeuda));
        parameter.put("petsDataHistoricoConsultas", new JRBeanCollectionDataSource(historicoConsultas));
        parameter.put("petsDataResumenEndeudamientoTrimestre03", new JRBeanCollectionDataSource(resumenEndeudameintoGlobal.get(0)));
        parameter.put("petsDataResumenEndeudamientoTrimestre06", new JRBeanCollectionDataSource(resumenEndeudameintoGlobal.get(1)));
        parameter.put("petsDataResumenEndeudamientoTrimestre09", new JRBeanCollectionDataSource(resumenEndeudameintoGlobal.get(2)));
        parameter.put("petsDataResumenEndeudamientoTrimestre12", new JRBeanCollectionDataSource(resumenEndeudameintoGlobal.get(3)));
        parameter.put("petsDataHabitoPago2SectorFinanciero", new JRBeanCollectionDataSource(mapeoCerradas.get(2)));
        parameter.put("petsDataSetHabitoPago2SectorReal", new JRBeanCollectionDataSource(mapeoCerradas.get(3)));
        parameter.put("petsDataSetHabitoPago2SectorTelecomunicaciones", new JRBeanCollectionDataSource(mapeoCerradas.get(0)));
        parameter.put("petsDataSetHabitoPago2SectorCooperativo", new JRBeanCollectionDataSource(mapeoCerradas.get(1)));
        parameter.put("petsDataSetHabitoPagoFinanciero", new JRBeanCollectionDataSource(habitosAbiertosVigentes.get(0)));
        parameter.put("petsDataSetHabitoPagoTeleco", new JRBeanCollectionDataSource(habitosAbiertosVigentes.get(1)));
        parameter.put("petsDataSetHabitoPagoCoopera", new JRBeanCollectionDataSource(habitosAbiertosVigentes.get(2)));
        parameter.put("petsDataSetHabitoPagoReal", new JRBeanCollectionDataSource(habitosAbiertosVigentes.get(3)));
        if(deudaGlobal != null){
            parameter.put("petsDataEndeudamientoTrimestre03SectorFiannciero", new JRBeanCollectionDataSource(deudaGlobal.get(0)));
            parameter.put("petsDataEndeudamientoTrimestre06SectorFiannciero", new JRBeanCollectionDataSource(deudaGlobal.get(1)));
            parameter.put("petsDataEndeudamientoTrimestre09SectorFiannciero", new JRBeanCollectionDataSource(deudaGlobal.get(2)));
            parameter.put("petsDataEndeudamientoTrimestre12SectorFiannciero", new JRBeanCollectionDataSource(deudaGlobal.get(3)));
        }
        return parameter;
    }

    //Estructuras de Datos por Santi ;)
    //La documentación de cada metodo esta IMPLICITA en su logica, leer y comprender.
    private List<Creditos> mapeoCreditos(Informe informes) {
        List<Creditos> creditos = new ArrayList<>();

        //Cabezeras Laterales
        informes.getInfoAgregadaMicrocredito().getResumen().getPerfilGeneral().getCreditosVigentes().setName("Créditos vigentes");
        informes.getInfoAgregadaMicrocredito().getResumen().getPerfilGeneral().getCreditosVigentes().setTotalSectores(informes.getInfoAgregadaMicrocredito().getResumen().getPerfilGeneral().getCreditosVigentes().getTotalSectores());
        informes.getInfoAgregadaMicrocredito().getResumen().getPerfilGeneral().getCreditosCerrados().setName("Créditos cerrados");
        informes.getInfoAgregadaMicrocredito().getResumen().getPerfilGeneral().getCreditosCerrados().setTotalSectores(informes.getInfoAgregadaMicrocredito().getResumen().getPerfilGeneral().getCreditosCerrados().getTotalSectores());
        informes.getInfoAgregadaMicrocredito().getResumen().getPerfilGeneral().getCreditosReestructurados().setName("Créditos reestructurados");
        informes.getInfoAgregadaMicrocredito().getResumen().getPerfilGeneral().getCreditosReestructurados().setTotalSectores(informes.getInfoAgregadaMicrocredito().getResumen().getPerfilGeneral().getCreditosReestructurados().getTotalSectores());
        informes.getInfoAgregadaMicrocredito().getResumen().getPerfilGeneral().getCreditosRefinanciados().setName("Créditos refinanciados");
        informes.getInfoAgregadaMicrocredito().getResumen().getPerfilGeneral().getCreditosRefinanciados().setTotalSectores(informes.getInfoAgregadaMicrocredito().getResumen().getPerfilGeneral().getCreditosRefinanciados().getTotalSectores());
        informes.getInfoAgregadaMicrocredito().getResumen().getPerfilGeneral().getConsultaUlt6Meses().setName("Consulta en los últ. 6 meses");
        informes.getInfoAgregadaMicrocredito().getResumen().getPerfilGeneral().getConsultaUlt6Meses().setTotalSectores(informes.getInfoAgregadaMicrocredito().getResumen().getPerfilGeneral().getConsultaUlt6Meses().getTotalSectores());
        informes.getInfoAgregadaMicrocredito().getResumen().getPerfilGeneral().getDesacuerdos().setName("Desacuerdos Vigentes a la Fecha");
        informes.getInfoAgregadaMicrocredito().getResumen().getPerfilGeneral().getDesacuerdos().setTotalSectores(informes.getInfoAgregadaMicrocredito().getResumen().getPerfilGeneral().getDesacuerdos().getTotalSectores());
        informes.getInfoAgregadaMicrocredito().getResumen().getPerfilGeneral().getAntiguedadDesde().setName("Antiüedad desde");

        //Data
        creditos.add(informes.getInfoAgregadaMicrocredito().getResumen().getPerfilGeneral().getCreditosVigentes());
        creditos.add(informes.getInfoAgregadaMicrocredito().getResumen().getPerfilGeneral().getCreditosCerrados());
        creditos.add(informes.getInfoAgregadaMicrocredito().getResumen().getPerfilGeneral().getCreditosReestructurados());
        creditos.add(informes.getInfoAgregadaMicrocredito().getResumen().getPerfilGeneral().getCreditosRefinanciados());
        creditos.add(informes.getInfoAgregadaMicrocredito().getResumen().getPerfilGeneral().getConsultaUlt6Meses());
        creditos.add(informes.getInfoAgregadaMicrocredito().getResumen().getPerfilGeneral().getDesacuerdos());

        Creditos antiguedadDesde = new Creditos();
        antiguedadDesde.setName("Antigüedad desde");
        String sectorFinanciero = informes.getInfoAgregadaMicrocredito().getResumen().getPerfilGeneral().getAntiguedadDesde().getSectorFinanciero();
        antiguedadDesde.setSectorFinanciero(sectorFinanciero == null ? "" : sectorFinanciero);
        String sectorTelcos = informes.getInfoAgregadaMicrocredito().getResumen().getPerfilGeneral().getAntiguedadDesde().getSectorTelcos();
        antiguedadDesde.setSectorTelcos(sectorTelcos == null ? "" : sectorTelcos);
        String sectorReal = informes.getInfoAgregadaMicrocredito().getResumen().getPerfilGeneral().getAntiguedadDesde().getSectorReal();
        antiguedadDesde.setSectorReal(sectorReal == null ? "" : sectorReal);
        String sectorCooperativo = informes.getInfoAgregadaMicrocredito().getResumen().getPerfilGeneral().getAntiguedadDesde().getSectorCooperativo();
        antiguedadDesde.setSectorCooperativo(sectorCooperativo == null ? "" : sectorCooperativo);
        antiguedadDesde.setTotalComoCodeudorYOtros("");
        antiguedadDesde.setTotalComoPrincipal("");
        antiguedadDesde.setTotalComoCodeudorYOtros("");
        antiguedadDesde.setTotalSectores("");
        creditos.add(antiguedadDesde);

        return creditos;
    }

    private List<SaldosYMorasArray> mapeoSaldosYMoras(Informe informes) {
        List<SaldosYMorasArray> saldosYMoras = new ArrayList<>();
        String[] nameColumnSaldos = {"Saldo deuda total en mora (en miles)",
                "Saldo deuda total (en miles)",
                "Moras max Sector Financiero",
                "Moras max Sector Cooperativo",
                "Moras max Sector Telcos",
                "Moras max Sector Real",
                "Total Moras Máximas",
                "Núm créditos con mora = 30",
                "Núm créditos con mora >= 60 "};
        List<List<String>> dataLists = new ArrayList<>(Arrays.asList(
                new ArrayList<>(), // saldoTotalMora
                new ArrayList<>(), // saldoDeudaTotal
                new ArrayList<>(), // Financiero
                new ArrayList<>(), // Cooperativo
                new ArrayList<>(), // Telcos
                new ArrayList<>(), // Real
                new ArrayList<>(), // totalMorasMax
                new ArrayList<>(), // mora30
                new ArrayList<>()  // mora60
        ));

        if (informes.getInfoAgregadaMicrocredito().getResumen().getVectorSaldosYMoras().getSaldosYMoras() != null){
            for (VectorSaldosYMoras.SaldosYMoras saldos : informes.getInfoAgregadaMicrocredito().getResumen().getVectorSaldosYMoras().getSaldosYMoras()) {
                dataLists.get(0).add(miles(String.valueOf(saldos.getSaldoDeudaTotalMora())));
                dataLists.get(1).add(miles(String.valueOf(saldos.getSaldoDeudaTotal())));
                dataLists.get(2).add(saldos.getMorasMaxSectorFinanciero() == null ? "-" : saldos.getMorasMaxSectorFinanciero());
                dataLists.get(3).add(saldos.getMorasMaxSectorCooperativo() == null ? "-" : saldos.getMorasMaxSectorCooperativo());
                dataLists.get(4).add(saldos.getMorasMaxSectorTelcos() == null ? "-" : saldos.getMorasMaxSectorTelcos());
                dataLists.get(5).add(saldos.getMorasMaxSectorReal() == null ? "-" : saldos.getMorasMaxSectorReal());
                dataLists.get(6).add(saldos.getMorasMaximas() == null ? "-" : saldos.getMorasMaximas());
                dataLists.get(7).add(String.valueOf(saldos.getNumCreditos30()));
                dataLists.get(8).add(String.valueOf(saldos.getNumCreditosMayorIgual60()));
            }
        }

        for (int i = 0; i < nameColumnSaldos.length; i++) {
            List<String> dataList = dataLists.get(i);
            if (dataList.size() >= 8) {
                saldosYMoras.add(new SaldosYMorasArray(nameColumnSaldos[i], dataList.get(0), dataList.get(1), dataList.get(2), dataList.get(3), dataList.get(4), dataList.get(5), dataList.get(6), dataList.get(7), dataList.get(8), dataList.get(9), dataList.get(10), dataList.get(11)));
            } else {
                saldosYMoras.add(new SaldosYMorasArray("Sin Saldos", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"));
            }
        }
        return saldosYMoras;
    }

    private List<com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto.datasets.EndeudamientoActual> llenarData(Sector sector, String nombreSector) {

        List<com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto.datasets.EndeudamientoActual> endeudamientoActual = new ArrayList<>();
        DecimalFormat formato = new DecimalFormat("#.#");
        double totalCupoInicial = 0, totalSaldoActual = 0, totalSaldoMora = 0, totalCuota = 0, totalParticipacion = 0;
        boolean status = true;
        for (int i = 0; i < sector.getTipoCuenta().size(); i++) {
            for (int k = 0; k < sector.getTipoCuenta().get(i).getUsuario().size(); k++) {
                for (int j = 0; j < sector.getTipoCuenta().get(i).getUsuario().get(k).getCuenta().size(); j++) {
                    EndeudamientoActual newEndeudamientoActual = new EndeudamientoActual();
                    newEndeudamientoActual.setNameColmun(convertirAMinusculasCamelCase(mapper.codToTipoCuenta(sector.getTipoCuenta().get(i).getTipoCuenta()).toString()) + " / " + nombreSector);
                    newEndeudamientoActual.setEndeudamientoC2(sector.getTipoCuenta().get(i).getUsuario().get(k).getTipoUsuario());
                    newEndeudamientoActual.setEndeudamientoC3(sector.getTipoCuenta().get(i).getUsuario().get(k).getCuenta().get(j).getEstadoActual());
                    newEndeudamientoActual.setEndeudamientoC4(sector.getTipoCuenta().get(i).getUsuario().get(k).getCuenta().get(j).getCalificacion());
                    newEndeudamientoActual.setEndeudamientoC5(miles(String.valueOf(sector.getTipoCuenta().get(i).getUsuario().get(k).getCuenta().get(j).getValorInicial())));
                    totalCupoInicial += sector.getTipoCuenta().get(i).getUsuario().get(k).getCuenta().get(j).getValorInicial();
                    newEndeudamientoActual.setEndeudamientoC6(miles(String.valueOf(sector.getTipoCuenta().get(i).getUsuario().get(k).getCuenta().get(j).getSaldoActual())));
                    totalSaldoActual += sector.getTipoCuenta().get(i).getUsuario().get(k).getCuenta().get(j).getSaldoActual();
                    newEndeudamientoActual.setEndeudamientoC7(miles(String.valueOf(sector.getTipoCuenta().get(i).getUsuario().get(k).getCuenta().get(j).getSaldoMora())));
                    totalSaldoMora += sector.getTipoCuenta().get(i).getUsuario().get(k).getCuenta().get(j).getSaldoMora();
                    newEndeudamientoActual.setEndeudamientoC8(miles(String.valueOf(sector.getTipoCuenta().get(i).getUsuario().get(k).getCuenta().get(j).getCuotaMes())));
                    totalCuota += sector.getTipoCuenta().get(i).getUsuario().get(k).getCuenta().get(j).getCuotaMes();
                    newEndeudamientoActual.setEndeudamientoC9(formato.format(sector.getTipoCuenta().get(i).getUsuario().get(k).getCuenta().get(j).getSaldoActual() / sector.getTipoCuenta().get(i).getUsuario().get(k).getCuenta().get(j).getTotalDeudaCarteras() * 100) + "%");
                    totalParticipacion += sector.getTipoCuenta().get(i).getUsuario().get(k).getCuenta().get(j).getSaldoActual() / sector.getTipoCuenta().get(i).getUsuario().get(k).getCuenta().get(j).getTotalDeudaCarteras() * 100;
                    newEndeudamientoActual.setEndeudamientoC10(sector.getTipoCuenta().get(i).getUsuario().get(k).getCuenta().get(j).getValorInicial() == 0 ? "0%" : formato.format(sector.getTipoCuenta().get(i).getUsuario().get(k).getCuenta().get(j).getSaldoActual() / sector.getTipoCuenta().get(i).getUsuario().get(k).getCuenta().get(j).getValorInicial() * 100) + "%");
                    endeudamientoActual.add(newEndeudamientoActual);
                }
            }
        }

        if (status) {
            EndeudamientoActual newEndeudamientoActual = new EndeudamientoActual();
            newEndeudamientoActual.setNameColmun("Total " + nombreSector);
            newEndeudamientoActual.setEndeudamientoC2("");
            newEndeudamientoActual.setEndeudamientoC3("");
            newEndeudamientoActual.setEndeudamientoC4("");
            newEndeudamientoActual.setEndeudamientoC5(miles("" + totalCupoInicial));
            newEndeudamientoActual.setEndeudamientoC6(miles("" + totalSaldoActual));
            newEndeudamientoActual.setEndeudamientoC7(miles("" + totalSaldoMora));
            newEndeudamientoActual.setEndeudamientoC8(miles("" + totalCuota));
            newEndeudamientoActual.setEndeudamientoC9(formato.format(totalParticipacion) + "%");
            newEndeudamientoActual.setEndeudamientoC10(totalCupoInicial == 0 ? "0%" : formato.format((totalSaldoActual / totalCupoInicial) * 100) + "%");
            endeudamientoActual.add(newEndeudamientoActual);
            status = false;
        }

        return endeudamientoActual;
    }

    private List<com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto.datasets.EndeudamientoActual> mapeoEndeudameintoActual(Informe informes) {
        List<com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto.datasets.EndeudamientoActual> endeudamientoActual = new ArrayList<>();

        double totalCupoInicial = 0, totalSaldoActual = 0, totalSaldoMora = 0, totalCuota = 0;
        DecimalFormat formato = new DecimalFormat("#.#");

        if (informes.getInfoAgregadaMicrocredito().getResumen().getEndeudamientoActual().getSectores() != null){
            for (Sector s : informes.getInfoAgregadaMicrocredito().getResumen().getEndeudamientoActual().getSectores()) {

                if (s.getCodSector() == 1 && !s.getTipoCuenta().isEmpty()) {
                    endeudamientoActual.addAll(this.llenarData(s, "Financiero"));
                }

                if (s.getCodSector() == 2 && !s.getTipoCuenta().isEmpty()) {
                    endeudamientoActual.addAll(this.llenarData(s, "Cooperativo"));
                }

                if (s.getCodSector() == 3 && !s.getTipoCuenta().isEmpty()) {
                    endeudamientoActual.addAll(this.llenarData(s, "Real"));
                }

                if (s.getCodSector() == 4 && !s.getTipoCuenta().isEmpty()) {
                    endeudamientoActual.addAll(this.llenarData(s, "Telecomunicaciones"));
                }
            }
        }

        for (int i = 0; i < endeudamientoActual.size(); i++) {
            if (endeudamientoActual.get(i).getNameColmun().contains("Total")) {
                if(!endeudamientoActual.get(i).getEndeudamientoC5().isEmpty()) {
                    totalCupoInicial += Double.parseDouble(endeudamientoActual.get(i).getEndeudamientoC5().replace(",", ""));
                }
                if(!endeudamientoActual.get(i).getEndeudamientoC6().isEmpty()) {
                    totalSaldoActual += Double.parseDouble(endeudamientoActual.get(i).getEndeudamientoC6().replace(",", ""));
                }
                if(!endeudamientoActual.get(i).getEndeudamientoC7().isEmpty()) {
                    totalSaldoMora += Double.parseDouble(endeudamientoActual.get(i).getEndeudamientoC7().replace(",", ""));
                }
                if(!endeudamientoActual.get(i).getEndeudamientoC8().isEmpty()) {
                    totalCuota += Double.parseDouble(endeudamientoActual.get(i).getEndeudamientoC8().replace(",", ""));
                }
            }
        }

        EndeudamientoActual newEndeudamientoActual = new EndeudamientoActual();
        newEndeudamientoActual.setNameColmun("TOTAL");
        newEndeudamientoActual.setEndeudamientoC2("");
        newEndeudamientoActual.setEndeudamientoC3("");
        newEndeudamientoActual.setEndeudamientoC4("");
        newEndeudamientoActual.setEndeudamientoC5(miles(String.valueOf(totalCupoInicial)));
        newEndeudamientoActual.setEndeudamientoC6(miles(String.valueOf(totalSaldoActual)));
        newEndeudamientoActual.setEndeudamientoC7(miles(String.valueOf(totalSaldoMora)));
        newEndeudamientoActual.setEndeudamientoC8(miles(String.valueOf(totalCuota)));
        newEndeudamientoActual.setEndeudamientoC9("100%");
        newEndeudamientoActual.setEndeudamientoC10(totalCupoInicial == 0 ? "0%" : formato.format((totalSaldoActual / totalCupoInicial) * 100) + "%");
        endeudamientoActual.add(newEndeudamientoActual);

        return endeudamientoActual;
    }

    private List<List<AbiertosVigentesDataSet>> mapeoHabitosAbiertosVigentes(Informe informes) {

        List<List<AbiertosVigentesDataSet>> separacionSectores = new ArrayList<>();
        cleanData();

        // Cuenta Cartera
        if (informes.getCuentaCartera() != null) {
            for (CuentaCartera c : informes.getCuentaCartera()) {
                if (estaAbiertaVigente(c.getEstados().getEstadoCuenta().getCodigo())) {
                    separacionSectores = separacionSectores(retornoCuentasCarterasAbiertasVigente(c), String.valueOf(c.getSector()));
                }
            }
        }

        //Tarjetas De Credito
        if (informes.getTarjetaCredito() != null) {
            for (TarjetaCredito c : informes.getTarjetaCredito()) {
                if (estaAbiertaVigente(c.getEstados().getEstadoCuenta().getCodigo())) {
                    double porcentaje = 0;
                    if (c.getValores() != null) {
                        if (c.getValores().getValores() != null){
                            porcentaje = 100 * ((c.getValores().getValores().get(0).getSaldoActual()) / (c.getValores() != null ? c.getValores().getValores().get(0).getCupoTotal() : 0));
                        }
                    }
                    AbiertosVigentesDataSet abiertosVigentesDataSet = new AbiertosVigentesDataSet(
                            c.getEntidad(),
                            "TARJETA DE CRÉDITO",
                            c.getNumero(),
                            mapper.numToCalificacion("_" + c.getCalificacion()).toString(),
                            mapper.codToEstadoCuentaTarjetaOCartera("_" + c.getEstados().getEstadoCuenta().getCodigo()).toString(),
                            c.getValores() != null && c.getValores().getValores() != null ? c.getValores().getValores().get(0).getFecha() : "",
                            "-",
                            c.getFechaApertura(),
                            c.getFechaVencimiento(),
                            "Mora Max",
                            String.format("%.1f", porcentaje) + "%",
                            !c.getComportamiento().isEmpty() ? "[" + dividirYAgregarSeparadores(c.getComportamiento()) + "]" : "-",
                            "-", //desacuerdo con la info
                            "Normal", // estado titular
                            mapper.codToFranquicia("_" + c.getCaracteristicas().getFranquicia()).toString() + " / " + mapper.codToClaseTC("_" + c.getCaracteristicas().getClase()).toString(), //solo TDC (marca)
                            mapper.codToGarantia("_" + c.getCaracteristicas().getGarantia()).toString(),
                            "$"+ (miles(String.valueOf(c.getValores() != null && c.getValores().getValores() != null ? c.getValores().getValores().get(0).getValorInicial() : 0))),
                            "$"+ (miles(String.valueOf(c.getValores() != null && c.getValores().getValores() != null ? c.getValores().getValores().get(0).getSaldoActual() : 0))),
                            "$"+ (c.getValores() != null ? miles(String.valueOf(c.getValores().getValores() != null ? c.getValores().getValores().get(0).getSaldoMora() : "")) : "Mora Max"),
                            "$"+ (miles(String.valueOf(c.getValores() != null && c.getValores().getValores() != null ? c.getValores().getValores().get(0).getCuota() : 0))),
                            c.getValores() != null && c.getValores().getValores() != null ? c.getValores().getValores().get(0).getFechaLimitePago() == null ? "" : c.getValores().getValores().get(0).getFechaLimitePago() : "",
                            c.getValores() != null && c.getValores().getValores() != null ? c.getValores().getValores().get(0).getFechaPagoCuota() == null ? "" : c.getValores().getValores().get(0).getFechaPagoCuota() : "",
                            "-", //Permanencia solo cuenta cartera
                            "-", //cheques devueltos?
                            c.getValores() != null  && c.getValores().getValores() != null ? c.getValores().getValores().get(0).getCuotasCanceladas() + " de " + c.getValores() != null && c.getValores().getValores() != null ? String.valueOf(c.getValores().getValores().get(0).getTotalCuotas()) : "" + " / "
                                    + mapper.codToPeriodicidad( c.getValores() != null && c.getValores().getValores() != null ? "_" +c.getValores().getValores().get(0).getPeriodicidad() : "" ) + " / " +
                                    "-" : "",
                            c.getOficina() + " / " + mapper.codToGarante("_" + c.getCaracteristicas().getCodigoAmparada()).toString()
                    );
                    separacionSectores = separacionSectores(abiertosVigentesDataSet, String.valueOf(c.getSector()));
                }
            }
        }

        //Cuentas De Ahorro
        if (informes.getCuentaAhorro() != null) {
            for (CuentaAhorro c : informes.getCuentaAhorro()) {
                if (estaAbiertaVigenteCuentaAhorro(c.getEstado().getCodigo())) {
                    AbiertosVigentesDataSet abiertosVigentesDataSet = new AbiertosVigentesDataSet(
                            c.getEntidad(),
                            "AHO",
                            c.getNumero(),
                            mapper.numToCalificacion("_" + c.getCalificacion()).toString(),
                            mapper.codToEstadoCuenta("_" + c.getEstado().getCodigo()).toString(),
                            c.getEstado() != null ? c.getEstado().getFecha() : "",
                            "-",
                            c.getFechaApertura(),
                            "-",
                            "",
                            "-",
                            "-",
                            "-",
                            String.valueOf(mapper.codToEstadoTitular("_" + c.getSituacionTitular())),
                            String.valueOf(mapper.codToTipoCuentaAhorro("_" + c.getCaracteristicas().getClase())),
                            "-",
                            "-",
                            "-",
                            "-",
                            "",
                            "-",
                            "-",
                            "-",
                            "-",
                            "-",
                            c.getOficina()
                    );
                    separacionSectores = separacionSectores(abiertosVigentesDataSet, String.valueOf(c.getSector()));
                }
            }
        }

        return rellenoVacioAbiertosVigente(separacionSectores);
    }

    private  AbiertosVigentesDataSet retornoCuentasCarterasAbiertasVigente(CuentaCartera c){
        boolean valoresIsEmpty = true;
        double porcentaje = 0;

        if (c.getValores() != null){
            if (c.getValores().getValores() != null){
                porcentaje = 100 * ((c.getValores().getValores().get(0).getSaldoActual()) / (c.getValores() != null ? c.getValores().getValores().get(0).getValorInicial() : 0));
                return new AbiertosVigentesDataSet(
                        c.getEntidad(),
                        String.valueOf(mapper.codToTipoCuenta(c.getCaracteristicas().getTipoCuenta())),
                        c.getNumero(),
                        mapper.numToCalificacion("_" + c.getCalificacion()).toString(),
                        mapper.codToEstadoCuentaTarjetaOCartera("_" + c.getEstados().getEstadoCuenta().getCodigo()).toString(),
                        c.getEstados() != null ? c.getEstados().getEstadoPago().getFecha() : "",
                        c.getAdjetivo() == null  ? "-" : mapper.codToAdjetivo("_" + c.getAdjetivo().getCodigo()) + " / " +  c.getAdjetivo().getFecha(),
                        c.getFechaApertura(),
                        c.getFechaVencimiento(),
                        "Mora Max",
                        String.format("%.1f", porcentaje) + "%",
                        !c.getComportamiento().isEmpty() ? "[" + dividirYAgregarSeparadores(c.getComportamiento()) + "]" : "-",
                        "-", //desacuerdo con la info
                        "Normal", // estado titular
                        "-", //solo TDC (marca)
                        mapper.codToGarantia("_" + c.getCaracteristicas().getGarantia()).toString(),
                        "$"+ (miles(String.valueOf(c.getValores().getValores().get(0).getValorInicial()))),
                        "$"+ (miles(String.valueOf(c.getValores().getValores().get(0).getSaldoActual() ))),
                        "$"+ (miles(String.valueOf(c.getValores().getValores().get(0).getSaldoMora()))),
                        "$"+ (miles(String.valueOf(c.getValores().getValores().get(0).getCuota()))),
                        c.getValores().getValores().get(0).getFechaLimitePago() == null ? "" : c.getValores().getValores().get(0).getFechaLimitePago(),
                        c.getValores().getValores().get(0).getFechaPagoCuota() == null ? "" : c.getValores().getValores().get(0).getFechaPagoCuota(),
                        String.valueOf(c.getCaracteristicas().getMesesPermanencia()), //Permanencia solo cuenta cartera
                        "-", //cheques devueltos?
                        c.getValores().getValores().get(0).getCuotasCanceladas() + " de " + c.getValores().getValores().get(0).getTotalCuotas() + " / " +
                        mapper.codToPeriodicidad("_" + c.getValores().getValores().get(0).getPeriodicidad()) + " / " +
                        mapper.codToContrato("_" + c.getCaracteristicas().getTipoContrato()),
                        c.getOficina() + " / " + mapper.codToGarante("_" + c.getCaracteristicas().getCalidadDeudor()).toString()
                );
            }else{
                valoresIsEmpty = false;
            }
        }else{
            valoresIsEmpty = false;
        }

        if (!valoresIsEmpty){
            return new AbiertosVigentesDataSet(
                    c.getEntidad(),
                    String.valueOf(mapper.codToTipoCuenta(c.getCaracteristicas().getTipoCuenta())),
                    c.getNumero(),
                    mapper.numToCalificacion("_" + c.getCalificacion()).toString(),
                    mapper.codToEstadoCuentaTarjetaOCartera("_" + c.getEstados().getEstadoCuenta().getCodigo()).toString(),
                    c.getEstados() != null ? c.getEstados().getEstadoPago().getFecha() : "",
                    c.getAdjetivo() == null  ? "-" : mapper.codToAdjetivo("_" + c.getAdjetivo().getCodigo()) + " / " +  c.getAdjetivo().getFecha(),
                    c.getFechaApertura(),
                    c.getFechaVencimiento(),
                    "Mora Max",
                    String.format("%.1f", porcentaje) + "%",
                    !c.getComportamiento().isEmpty() ? "[" + dividirYAgregarSeparadores(c.getComportamiento()) + "]" : "-",
                    "-", //desacuerdo con la info
                    "Normal", // estado titular
                    "-", //solo TDC (marca)
                    mapper.codToGarantia("_" + c.getCaracteristicas().getGarantia()).toString(),
                    "$0",
                    "$0",
                    "$0",
                    "$0",
                    "",
                    "",
                    String.valueOf(c.getCaracteristicas().getMesesPermanencia()), //Permanencia solo cuenta cartera
                    "-", //cheques devueltos?
                    "" + " / " + "" + " / " +  mapper.codToContrato("_" + c.getCaracteristicas().getTipoContrato()),
                    c.getOficina() + " / " + mapper.codToGarante("_" + c.getCaracteristicas().getCalidadDeudor()).toString()
            );
        }
        return new AbiertosVigentesDataSet();
    }

    private boolean estaAbiertaVigente(String codigo) {
        return codigo.equals("00") ||
                codigo.equals("01") ||
                codigo.equals("02") ||
                codigo.equals("04") ||
                codigo.equals("05") ||
                codigo.equals("06") ||
                codigo.equals("07") ||
                codigo.equals("10") ||
                codigo.equals("14");
    }

    private boolean estaCerradas(String codigo) {
        return codigo.equals("03") ||
                codigo.equals("08") ||
                codigo.equals("09") ||
                codigo.equals("11") ||
                codigo.equals("12") ||
                codigo.equals("13") ||
                codigo.equals("15") ||
                codigo.equals("16") ||
                codigo.equals("17");
    }

    private boolean estaCerradasCuentaAhorro(String codigo) {
        return codigo.equals("02") ||
                codigo.equals("05") ||
                codigo.equals("09");
    }

    private boolean estaAbiertaVigenteCuentaAhorro(String codigo) {
        return
                codigo.equals("01") ||
                        codigo.equals("06") ||
                        codigo.equals("07");
    }

    protected List<AbiertosVigentesDataSet> abiertosVigentesFinanciero = new ArrayList<>();
    protected List<AbiertosVigentesDataSet> abiertosVigentesTeleco = new ArrayList<>();
    protected List<AbiertosVigentesDataSet> abiertosVigentesCoopera = new ArrayList<>();
    protected List<AbiertosVigentesDataSet> abiertosVigentesReal = new ArrayList<>();

    private List<List<AbiertosVigentesDataSet>> separacionSectores(AbiertosVigentesDataSet data, String sector) {

        switch (sector) {
            case "1" -> abiertosVigentesFinanciero.add(data);
            case "2" -> abiertosVigentesCoopera.add(data);
            case "3" -> abiertosVigentesReal.add(data);
            case "4" -> abiertosVigentesTeleco.add(data);
            default -> Log.info("Sector Desconocido");
        }

        return Arrays.asList(
                abiertosVigentesFinanciero,
                abiertosVigentesTeleco,
                abiertosVigentesCoopera,
                abiertosVigentesReal
        );
    }

    private void cleanData() {
        abiertosVigentesFinanciero = new ArrayList<>();
        abiertosVigentesTeleco = new ArrayList<>();
        abiertosVigentesCoopera = new ArrayList<>();
        abiertosVigentesReal = new ArrayList<>();
    }

    private List<List<AbiertosVigentesDataSet>> rellenoVacioAbiertosVigente(List<List<AbiertosVigentesDataSet>> listas) {
        List<List<AbiertosVigentesDataSet>> listasRellenadas = new ArrayList<>();

        for (List<AbiertosVigentesDataSet> l : listas) {
            if (l == null || l.isEmpty()) {
                List<AbiertosVigentesDataSet> newList = new ArrayList<>();
                newList.add(new AbiertosVigentesDataSet("Sector sin Habitos", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"));
                listasRellenadas.add(newList);
            } else {
                listasRellenadas.add(l);
            }
        }

        return listasRellenadas;
    }

    private List<List<AnalisisVectoresDataSet>> mapeoAnalisisDeVectores(Informe informes) {
        List<AnalisisVectoresDataSet> analisisVectoresDataSetsFinanciero = new ArrayList<>();
        List<AnalisisVectoresDataSet> analisisVectoresDataSetsReal = new ArrayList<>();
        List<AnalisisVectoresDataSet> analisisVectoresDataSetsTelco = new ArrayList<>();
        List<AnalisisVectoresDataSet> analisisVectoresDataSetsCooperativo = new ArrayList<>();

        Map<String, List<AnalisisVectoresDataSet>> sectorToDataSetMap = new HashMap<>();
        sectorToDataSetMap.put("Sector Financiero", analisisVectoresDataSetsFinanciero);
        sectorToDataSetMap.put("Sector Real", analisisVectoresDataSetsReal);
        sectorToDataSetMap.put("Sector Telcos", analisisVectoresDataSetsTelco);
        sectorToDataSetMap.put("Sector Cooperativo", analisisVectoresDataSetsCooperativo);
        if (informes.getInfoAgregadaMicrocredito().getAnalisisVectores() != null) {
            List<AnalisisVectores.SectorAnalisisVectores> vectorSector = informes.getInfoAgregadaMicrocredito().getAnalisisVectores().getSector();
            vectorSector.forEach(s -> {
                List<AnalisisVectoresDataSet> dataSet = sectorToDataSetMap.get(s.getNombreSector());
                if (dataSet != null) {
                    s.getCuenta().stream()
                            .map(this::saldos)
                            .forEach(dataSet::add);
                }
            });


            for (AnalisisVectores.SectorAnalisisVectores x : informes.getInfoAgregadaMicrocredito().getAnalisisVectores().getSector()) {
                switch (x.getNombreSector()) {
                    case "Sector Financiero":
                        if (!analisisVectoresDataSetsFinanciero.isEmpty()) {
                            analisisVectoresDataSetsFinanciero.add(morasMaximas(x.getMorasMaximas(), "Sector Financiero"));
                        }
                        break;
                    case "Sector Real":
                        if (!analisisVectoresDataSetsReal.isEmpty()) {
                            analisisVectoresDataSetsReal.add(morasMaximas(x.getMorasMaximas(), "Sector Real"));
                        }
                        break;
                    case "Sector Telcos":
                        if (!analisisVectoresDataSetsTelco.isEmpty()) {
                            analisisVectoresDataSetsTelco.add(morasMaximas(x.getMorasMaximas(), "Sector Telcos"));
                        }
                        break;
                    case "Sector Cooperativo":
                        if (!analisisVectoresDataSetsCooperativo.isEmpty()) {
                            analisisVectoresDataSetsCooperativo.add(morasMaximas(x.getMorasMaximas(), "Sector Cooperativo"));
                        }
                        break;
                }
            }
        }

        List<List<AnalisisVectoresDataSet>> listas = Arrays.asList(
                analisisVectoresDataSetsFinanciero,
                analisisVectoresDataSetsReal,
                analisisVectoresDataSetsTelco,
                analisisVectoresDataSetsCooperativo
        );

        for (List<AnalisisVectoresDataSet> lista : listas) {
            if (lista.isEmpty()) {
                lista.addAll(rellenoVacioAnalisisDeVectores());
            }
        }

        return listas;
    }


    private AnalisisVectoresDataSet morasMaximas(AnalisisVectores.SectorAnalisisVectores.MorasMaximas morasMaximas, String sector) {
        return new AnalisisVectoresDataSet(
                "Moras Máxima " + sector,
                "",
                "",
                "",
                morasMaximas.getCaracterFechas().get(23).getSaldoDeudaTotalMora() == null ? "-" : morasMaximas.getCaracterFechas().get(23).getSaldoDeudaTotalMora(),
                morasMaximas.getCaracterFechas().get(22).getSaldoDeudaTotalMora() == null ? "-" : morasMaximas.getCaracterFechas().get(22).getSaldoDeudaTotalMora(),
                morasMaximas.getCaracterFechas().get(21).getSaldoDeudaTotalMora() == null ? "-" : morasMaximas.getCaracterFechas().get(21).getSaldoDeudaTotalMora(),
                morasMaximas.getCaracterFechas().get(20).getSaldoDeudaTotalMora() == null ? "-" : morasMaximas.getCaracterFechas().get(20).getSaldoDeudaTotalMora(),
                morasMaximas.getCaracterFechas().get(19).getSaldoDeudaTotalMora() == null ? "-" : morasMaximas.getCaracterFechas().get(19).getSaldoDeudaTotalMora(),
                morasMaximas.getCaracterFechas().get(18).getSaldoDeudaTotalMora() == null ? "-" : morasMaximas.getCaracterFechas().get(18).getSaldoDeudaTotalMora(),
                morasMaximas.getCaracterFechas().get(17).getSaldoDeudaTotalMora() == null ? "-" : morasMaximas.getCaracterFechas().get(17).getSaldoDeudaTotalMora(),
                morasMaximas.getCaracterFechas().get(16).getSaldoDeudaTotalMora() == null ? "-" : morasMaximas.getCaracterFechas().get(16).getSaldoDeudaTotalMora(),
                morasMaximas.getCaracterFechas().get(15).getSaldoDeudaTotalMora() == null ? "-" : morasMaximas.getCaracterFechas().get(15).getSaldoDeudaTotalMora(),
                morasMaximas.getCaracterFechas().get(14).getSaldoDeudaTotalMora() == null ? "-" : morasMaximas.getCaracterFechas().get(14).getSaldoDeudaTotalMora(),
                morasMaximas.getCaracterFechas().get(13).getSaldoDeudaTotalMora() == null ? "-" : morasMaximas.getCaracterFechas().get(13).getSaldoDeudaTotalMora(),
                morasMaximas.getCaracterFechas().get(12).getSaldoDeudaTotalMora() == null ? "-" : morasMaximas.getCaracterFechas().get(12).getSaldoDeudaTotalMora(),
                morasMaximas.getCaracterFechas().get(11).getSaldoDeudaTotalMora() == null ? "-" : morasMaximas.getCaracterFechas().get(11).getSaldoDeudaTotalMora(),
                morasMaximas.getCaracterFechas().get(10).getSaldoDeudaTotalMora() == null ? "-" : morasMaximas.getCaracterFechas().get(10).getSaldoDeudaTotalMora(),
                morasMaximas.getCaracterFechas().get(9).getSaldoDeudaTotalMora() == null ? "-" : morasMaximas.getCaracterFechas().get(9).getSaldoDeudaTotalMora(),
                morasMaximas.getCaracterFechas().get(8).getSaldoDeudaTotalMora() == null ? "-" : morasMaximas.getCaracterFechas().get(8).getSaldoDeudaTotalMora(),
                morasMaximas.getCaracterFechas().get(7).getSaldoDeudaTotalMora() == null ? "-" : morasMaximas.getCaracterFechas().get(7).getSaldoDeudaTotalMora(),
                morasMaximas.getCaracterFechas().get(6).getSaldoDeudaTotalMora() == null ? "-" : morasMaximas.getCaracterFechas().get(6).getSaldoDeudaTotalMora(),
                morasMaximas.getCaracterFechas().get(5).getSaldoDeudaTotalMora() == null ? "-" : morasMaximas.getCaracterFechas().get(5).getSaldoDeudaTotalMora(),
                morasMaximas.getCaracterFechas().get(4).getSaldoDeudaTotalMora() == null ? "-" : morasMaximas.getCaracterFechas().get(4).getSaldoDeudaTotalMora(),
                morasMaximas.getCaracterFechas().get(3).getSaldoDeudaTotalMora() == null ? "-" : morasMaximas.getCaracterFechas().get(3).getSaldoDeudaTotalMora(),
                morasMaximas.getCaracterFechas().get(2).getSaldoDeudaTotalMora() == null ? "-" : morasMaximas.getCaracterFechas().get(2).getSaldoDeudaTotalMora(),
                morasMaximas.getCaracterFechas().get(1).getSaldoDeudaTotalMora() == null ? "-" : morasMaximas.getCaracterFechas().get(1).getSaldoDeudaTotalMora()
        );
    }

    private AnalisisVectoresDataSet saldos(AnalisisVectores.SectorAnalisisVectores.Cuenta c) {
        return new AnalisisVectoresDataSet(
                c.getEntidad() == null ? "-" : c.getEntidad(),
                c.getNumeroCuenta() == null ? "-" : c.getNumeroCuenta(),
                c.getTipoCuenta() == null ? "-" : c.getTipoCuenta(),
                c.getEstado() == null ? "-" : c.getEstado(),
                obtenerSaldoDeudaTotalMora(c, 0),
                obtenerSaldoDeudaTotalMora(c, 1),
                obtenerSaldoDeudaTotalMora(c, 2),
                obtenerSaldoDeudaTotalMora(c, 3),
                obtenerSaldoDeudaTotalMora(c, 4),
                obtenerSaldoDeudaTotalMora(c, 5),
                obtenerSaldoDeudaTotalMora(c, 6),
                obtenerSaldoDeudaTotalMora(c, 7),
                obtenerSaldoDeudaTotalMora(c, 8),
                obtenerSaldoDeudaTotalMora(c, 9),
                obtenerSaldoDeudaTotalMora(c, 10),
                obtenerSaldoDeudaTotalMora(c, 11),
                obtenerSaldoDeudaTotalMora(c, 12),
                obtenerSaldoDeudaTotalMora(c, 13),
                obtenerSaldoDeudaTotalMora(c, 14),
                obtenerSaldoDeudaTotalMora(c, 15),
                obtenerSaldoDeudaTotalMora(c, 16),
                obtenerSaldoDeudaTotalMora(c, 17),
                obtenerSaldoDeudaTotalMora(c, 18),
                obtenerSaldoDeudaTotalMora(c, 19),
                obtenerSaldoDeudaTotalMora(c, 20),
                obtenerSaldoDeudaTotalMora(c, 21),
                obtenerSaldoDeudaTotalMora(c, 22)

        );
    }

    private String obtenerSaldoDeudaTotalMora(AnalisisVectores.SectorAnalisisVectores.Cuenta c, int indice) {
        try {
            return c.getCaracterFechas().get(indice).getSaldoDeudaTotalMora() == null ? "-" : c.getCaracterFechas().get(indice).getSaldoDeudaTotalMora();
        } catch (IndexOutOfBoundsException e) {
            return "-";
        }
    }


    private ResumenEndeudamientoGlobalDataSet carteras(SectorTrimestreResumenEndeudamiento sector) {
        return new ResumenEndeudamientoGlobalDataSet(
                String.valueOf(sector.getCarteras().get(0).getNumeroCuentas()),
                String.valueOf(sector.getCarteras().get(0).getValor()),
                String.valueOf(sector.getCarteras().get(1).getNumeroCuentas()),
                String.valueOf(sector.getCarteras().get(1).getValor()),
                String.valueOf(sector.getCarteras().get(2).getNumeroCuentas() + sector.getCarteras().get(3).getNumeroCuentas()),
                String.valueOf(sector.getCarteras().get(2).getValor() + sector.getCarteras().get(3).getValor()),
                String.valueOf(sector.getCarteras().get(4).getNumeroCuentas()),
                String.valueOf(sector.getCarteras().get(4).getValor()),
                "0.0"
        );
    }

    private List<AnalisisVectoresDataSet> rellenoVacioAnalisisDeVectores() {
        List<AnalisisVectoresDataSet> analisisVectoresDataSets = new ArrayList<>();
        analisisVectoresDataSets.add(new AnalisisVectoresDataSet("Sector Vacio", "-", "-", "-",
                "-",
                "-",
                "-",
                "-",
                "-",
                "-",
                "-",
                "-",
                "-",
                "-",
                "-",
                "-",
                "-",
                "-",
                "-",
                "-",
                "-",
                "-",
                "-",
                "-",
                "-",
                "-",
                "-"
        ));
        return analisisVectoresDataSets;
    }

    private List<ResumenEndeudamientoGlobalDataSet> rellenoVacioResumenGlobal() {
        List<ResumenEndeudamientoGlobalDataSet> resumenEndeudamientoGlobalDataSets = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            resumenEndeudamientoGlobalDataSets.add(new ResumenEndeudamientoGlobalDataSet(
                    "0",
                    "0",
                    "0",
                    "0",
                    "0",
                    "0",
                    "0",
                    "0",
                    "0"
            ));
        }
        return resumenEndeudamientoGlobalDataSets;
    }

    private List<EvolucionDeudaTabla> rellenoEvolucionDeuda(Informe informes) {
        List<EvolucionDeudaTabla> evolucionDeudaTablas = new ArrayList<>();
        List<EvolucionDeudaTabla[]> evolucionDeuda = separacionDatosEvolucionDeuda(informes.getInfoAgregadaMicrocredito().getEvolucionDeuda());
        for (EvolucionDeudaTabla[] deudaTablas : evolucionDeuda) {
            for (int i = 0; i < deudaTablas.length; i++) {
                evolucionDeudaTablas.add(deudaTablas[i]);
            }
        }
        return evolucionDeudaTablas;
    }

    private List<EvolucionDeudaTabla[]> separacionDatosEvolucionDeuda(EvolucionDeudaInfoAgregadaMicrocredito datos) {
        List<EvolucionDeudaTabla[]> tabla = new ArrayList<>();
        if (datos.getEvolucionDeudaSectores() == null){
            return tabla;
        }
        for (EvolucionDeudaInfoAgregadaMicrocredito.EvolucionDeudaSector sector : datos.getEvolucionDeudaSectores()) {
            for (EvolucionDeudaInfoAgregadaMicrocredito.EvolucionDeudaSector.EvolucionDeudaTipoCuenta tipoCuenta : sector.getEvolucionDeudaTipoCuentas()) {
                for (EvolucionDeudaInfoAgregadaMicrocredito.EvolucionDeudaSector.EvolucionDeudaTipoCuenta.EvolucionDeudaValorTrimestre valorTrimestre : tipoCuenta.getEvolucionDeudaValorTrimestres()) {
                    String sectorNombre = String.valueOf(mapper.codToTipoCuenta(tipoCuenta.getTipoCuenta())).toLowerCase();
                    tabla.add(new EvolucionDeudaTabla[]{
                            new EvolucionDeudaTabla(
                                    sector.getNombreSector() + " / " + sectorNombre + "  -  " + valorTrimestre.getTrimestre(), //parsear tipo de cuenta a descripcion
                                    String.valueOf(valorTrimestre.getNum()),
                                    "$" + miles(String.valueOf(valorTrimestre.getCupoInicial())),
                                    "$" + miles(String.valueOf(valorTrimestre.getSaldo())),
                                    "$" + miles(String.valueOf(valorTrimestre.getSaldoMora())),
                                    "$" + miles(String.valueOf(valorTrimestre.getCuota())),
                                    String.valueOf(valorTrimestre.getPorcentajeDeuda() + "%"),
                                    valorTrimestre.getTextoMenorCalificacion()
                            )
                    });
                }
            }
        }

        return tabla;
    }

    private List<HistoricoConsultasDataSet> mapeoHistoricoConsultas(Informe informes) {

        List<HistoricoConsultasDataSet> consultasList = new ArrayList<>();
        for (Consulta c : informes.getConsulta()) {
            consultasList.add(
                    new HistoricoConsultasDataSet(c.getFecha(), c.getTipoCuenta(), c.getEntidad(), c.getOficina(), c.getCiudad(), c.getCantidad()
                    )
            );
        }
        return consultasList;
    }

    private List<List<ResumenEndeudamientoGlobalDataSet>> mapeoResumenEndeudamientoGlobal(Informe informes) {

        List<ResumenEndeudamientoGlobalDataSet> endeudamientoGlobalsT03 = new ArrayList<>();
        List<ResumenEndeudamientoGlobalDataSet> endeudamientoGlobalsT06 = new ArrayList<>();
        List<ResumenEndeudamientoGlobalDataSet> endeudamientoGlobalsT09 = new ArrayList<>();
        List<ResumenEndeudamientoGlobalDataSet> endeudamientoGlobalsT12 = new ArrayList<>();

        Map<String, List<ResumenEndeudamientoGlobalDataSet>> endeudamientoMap = new HashMap<>();
        endeudamientoMap.put("Trimestre 03", endeudamientoGlobalsT03);
        endeudamientoMap.put("Trimestre 06", endeudamientoGlobalsT06);
        endeudamientoMap.put("Trimestre 09", endeudamientoGlobalsT09);
        endeudamientoMap.put("Trimestre 12", endeudamientoGlobalsT12);

        List<TrimestreResumenEndeudamiento> trimestreResumen = informes.getInfoAgregada().getResumenEndeudamiento().getTrimestres();

        if (trimestreResumen != null) {
            trimestreResumen.forEach(sector -> {
                        List<ResumenEndeudamientoGlobalDataSet> dataSet = endeudamientoMap.get("Trimestre " + sector.getFecha().substring(5, 7));
                        if (dataSet != null) {
                            sector.getSectores().stream()
                                    .map(this::carteras)
                                    .forEach(dataSet::add);
                        }
                    }
            );
        }

        List<List<ResumenEndeudamientoGlobalDataSet>> listas = Arrays.asList(
                endeudamientoGlobalsT03,
                endeudamientoGlobalsT06,
                endeudamientoGlobalsT09,
                endeudamientoGlobalsT12
        );

        for (List<ResumenEndeudamientoGlobalDataSet> lista : calcularTotales(listas)) {

        }

        return calculoParticipacion(listas);
    }

    private double[] totales = new double[4];
    private int contadorParticipacion = 0;

    private List<List<ResumenEndeudamientoGlobalDataSet>> calculoParticipacion(List<List<ResumenEndeudamientoGlobalDataSet>> listas) {
        int i = 0;

        List<List<ResumenEndeudamientoGlobalDataSet>> listaNueva = listas;

        for (List<ResumenEndeudamientoGlobalDataSet> x : listas) {
            int y = 0;
            for (ResumenEndeudamientoGlobalDataSet sectoresPorTrimestre : x) {
                if (x.size() != 0) {
                    double total = (Double.parseDouble(sectoresPorTrimestre.getResumenEndeudaC2())
                            + Double.parseDouble(sectoresPorTrimestre.getResumenEndeudaC4())
                            + Double.parseDouble(sectoresPorTrimestre.getResumenEndeudaC6())
                            + Double.parseDouble(sectoresPorTrimestre.getResumenEndeudaC8()));
                    double participacion = 0.0;
                    if (totales[i] != 0.0){
                        if (total != 0.0){
                            participacion = (total / totales[i] ) * 100;
                        }
                    }
                    listaNueva.get(i).get(y).setResumenEndeudaC9(( String.format("%.2f", participacion) + "%" ).equals("100,00%") ? "100%" : String.format("%.2f", participacion) + "%");
                    y++;
                } else {
                    listaNueva.get(i).get(y).setResumenEndeudaC9("0.0%");
                    y++;
                }
            }
            i++;
        }

        return listaNueva;
    }

    private List<List<ResumenEndeudamientoGlobalDataSet>> formatoResumenEndeudameinto(Informe informe) {

        int i = 0;
        List<List<ResumenEndeudamientoGlobalDataSet>> resumenEndeudamientoGlobal = mapeoResumenEndeudamientoGlobal(informe);
        List<List<ResumenEndeudamientoGlobalDataSet>> listaNueva = resumenEndeudamientoGlobal;
        try {
            for (List<ResumenEndeudamientoGlobalDataSet> resumenEndeudamientoGlobalDataSets : resumenEndeudamientoGlobal) {
                int y = 0;
                for (ResumenEndeudamientoGlobalDataSet z : resumenEndeudamientoGlobalDataSets) {
                    if (resumenEndeudamientoGlobalDataSets.size() != 1) {
                        listaNueva.get(i).get(y).setResumenEndeudaC2(miles(listaNueva.get(i).get(y).getResumenEndeudaC2()));
                        listaNueva.get(i).get(y).setResumenEndeudaC4(miles(listaNueva.get(i).get(y).getResumenEndeudaC4()));
                        String f = miles(listaNueva.get(i).get(y).getResumenEndeudaC6());
                        listaNueva.get(i).get(y).setResumenEndeudaC6(f);
                        listaNueva.get(i).get(y).setResumenEndeudaC8(miles(listaNueva.get(i).get(y).getResumenEndeudaC8()));
                    }
                    y++;
                }
                i++;
            }
        }catch (Exception e){
            System.out.println(e);
        }

            return listaNueva;
        }

    private List<List<ResumenEndeudamientoGlobalDataSet>> calcularTotales(List<List<ResumenEndeudamientoGlobalDataSet>> listas) {

        List<List<ResumenEndeudamientoGlobalDataSet>> listaOriginal = listas;
        int i = 0;
        for (List<ResumenEndeudamientoGlobalDataSet> l : listas) {
            if (l.isEmpty()) {
                l.addAll(rellenoVacioResumenGlobal());
            }
            double sumaC1 = 0;
            double sumaC2 = 0;
            double sumaC3 = 0;
            double sumaC4 = 0;
            double sumaC5 = 0;
            double sumaC6 = 0;
            double sumaC7 = 0;
            double sumaC8 = 0;
            double sumaC9 = 0;
            for (ResumenEndeudamientoGlobalDataSet r : l) {
                sumaC1 += Double.parseDouble(r.getResumenEndeudaC1());
                sumaC2 += Double.parseDouble(r.getResumenEndeudaC2());
                sumaC3 += Double.parseDouble(r.getResumenEndeudaC3());
                sumaC4 += Double.parseDouble(r.getResumenEndeudaC4());
                sumaC5 += Double.parseDouble(r.getResumenEndeudaC5());
                sumaC6 += Double.parseDouble(r.getResumenEndeudaC6());
                sumaC7 += Double.parseDouble(r.getResumenEndeudaC7());
                sumaC8 += Double.parseDouble(r.getResumenEndeudaC8());
                sumaC9 += Double.parseDouble(r.getResumenEndeudaC9());
            }
            listaOriginal.get(i).add(new ResumenEndeudamientoGlobalDataSet(String.valueOf(sumaC1), String.valueOf(sumaC2), String.valueOf(sumaC3), String.valueOf(sumaC4), String.valueOf(sumaC5), String.valueOf(sumaC6), String.valueOf(sumaC7), String.valueOf(sumaC8), "100.0%"));
            i++;
            sumaTotalParaParticipacion(sumaC2, sumaC4, sumaC6, sumaC8);
        }
        contadorParticipacion = 0;
        return listaOriginal;
    }

    private void sumaTotalParaParticipacion(double sumaComercial, double sumaHipotecario, double sumaConsumo, double sumaMicrocredito) {
        if (contadorParticipacion < totales.length) {
            totales[contadorParticipacion] = sumaComercial + sumaHipotecario + sumaConsumo + sumaMicrocredito;
            contadorParticipacion++;
        }
    }

    private static final int NUM_TRIMESTRES = 4;
    private static final int NUM_SECTORES = 4;

    private List<List<DeudaGlobal>> deudaGlobal(Informe informe) {
        List<List<List<DeudaGlobal>>> deudasPorTrimestreYSector = new ArrayList<>(NUM_TRIMESTRES);
        inicializarListasDeDeudas(deudasPorTrimestreYSector);

        // Inicializa DeudaGlobal para cada sector
        for (int i = 0; i < NUM_SECTORES; i++) {
            DeudaGlobal deudaInicial = new DeudaGlobal();
            deudaInicial.setEndeudamientoGlobalTrimestreC10(getNombreSector(i));
            agregarDeudaInicialATodosLosTrimestres(deudasPorTrimestreYSector, deudaInicial, i);
        }

        // Asigna DeudaGlobal segun la fecha y el sector
        for (EndeudamientoGlobal endeudamiento : informe.getEndeudamientoGlobal()) {
            int trimestre = obtenerTrimestre(endeudamiento.getFechaReporte());
            int sector = endeudamiento.getEntidad().getSector() - 1;
            deudasPorTrimestreYSector.get(trimestre).get(sector).add(getDeudaGlobal(endeudamiento));
        }

        return procesarYOrdenarDeudas(deudasPorTrimestreYSector);
    }


    private void inicializarListasDeDeudas(List<List<List<DeudaGlobal>>> deudasPorTrimestreYSector) {
        for (int i = 0; i < NUM_TRIMESTRES; i++) {
            List<List<DeudaGlobal>> deudasPorSector = new ArrayList<>(NUM_SECTORES);
            for (int j = 0; j < NUM_SECTORES; j++) {
                deudasPorSector.add(new ArrayList<>());
            }
            deudasPorTrimestreYSector.add(deudasPorSector);
        }
    }

    private void agregarDeudaInicialATodosLosTrimestres(List<List<List<DeudaGlobal>>> deudasPorTrimestreYSector, DeudaGlobal deudaInicial, int sector) {
        for (List<List<DeudaGlobal>> deudasPorSector : deudasPorTrimestreYSector) {
            deudasPorSector.get(sector).add(deudaInicial);
        }
    }

    private DeudaGlobal getDeudaGlobal(EndeudamientoGlobal endeudamientoGlobal) {
        DeudaGlobal deudaGlobal = new DeudaGlobal();
        deudaGlobal.setEndeudamientoGlobalTrimestreC1(endeudamientoGlobal.getEntidad().getNombre().replace("0", "").trim());
        deudaGlobal.setEndeudamientoGlobalTrimestreC2(endeudamientoGlobal.getCalificacion());
        deudaGlobal.setEndeudamientoGlobalTrimestreC3(String.valueOf(endeudamientoGlobal.getNumeroCreditos()));
        deudaGlobal.setEndeudamientoGlobalTrimestreC4(miles(String.valueOf(endeudamientoGlobal.getSaldoPendiente())));
        deudaGlobal.setEndeudamientoGlobalTrimestreC15(endeudamientoGlobal.getGarantia() == null ? "-" : String.valueOf(endeudamientoGlobal.getGarantia().getValor()).equals("-1.0") ? "-" : String.valueOf(endeudamientoGlobal.getGarantia().getValor()));
        deudaGlobal.setEndeudamientoGlobalTrimestreC16(endeudamientoGlobal.getMoneda());
        deudaGlobal.setEndeudamientoGlobalTrimestreC17(endeudamientoGlobal.getFuente());
        deudaGlobal.setEndeudamientoGlobalTrimestreC13(endeudamientoGlobal.getGarantia() == null ? "-" : String.valueOf(mapper.codToGarantiaGlobal("_" + endeudamientoGlobal.getGarantia().getTipo())));
        deudaGlobal.setEndeudamientoGlobalTrimestreC14(endeudamientoGlobal.getGarantia() == null ? "" : endeudamientoGlobal.getGarantia().getFecha() == null ? "" : endeudamientoGlobal.getGarantia().getFecha());
        if (endeudamientoGlobal.getTipoCredito().equals("CMR")) {
            deudaGlobal.setEndeudamientoGlobalTrimestreC5(String.valueOf(endeudamientoGlobal.getNumeroCreditos()));
            deudaGlobal.setEndeudamientoGlobalTrimestreC6(miles(String.valueOf(endeudamientoGlobal.getSaldoPendiente())));
            deudaGlobal.setEndeudamientoGlobalTrimestreC7("0");
            deudaGlobal.setEndeudamientoGlobalTrimestreC8("0");
            deudaGlobal.setEndeudamientoGlobalTrimestreC9("0");
            deudaGlobal.setEndeudamientoGlobalTrimestreC10("0");
            deudaGlobal.setEndeudamientoGlobalTrimestreC11("0");
            deudaGlobal.setEndeudamientoGlobalTrimestreC12("0");
        } else if (endeudamientoGlobal.getTipoCredito().equals("HIP")) {
            deudaGlobal.setEndeudamientoGlobalTrimestreC5("0");
            deudaGlobal.setEndeudamientoGlobalTrimestreC6("0");
            deudaGlobal.setEndeudamientoGlobalTrimestreC7(String.valueOf(endeudamientoGlobal.getNumeroCreditos()));
            deudaGlobal.setEndeudamientoGlobalTrimestreC8(miles(String.valueOf(endeudamientoGlobal.getSaldoPendiente())));
            deudaGlobal.setEndeudamientoGlobalTrimestreC9("0");
            deudaGlobal.setEndeudamientoGlobalTrimestreC10("0");
            deudaGlobal.setEndeudamientoGlobalTrimestreC11("0");
            deudaGlobal.setEndeudamientoGlobalTrimestreC12("0");
        } else if (endeudamientoGlobal.getTipoCredito().equals("MIC")) {
            deudaGlobal.setEndeudamientoGlobalTrimestreC5("0");
            deudaGlobal.setEndeudamientoGlobalTrimestreC6("0");
            deudaGlobal.setEndeudamientoGlobalTrimestreC7("0");
            deudaGlobal.setEndeudamientoGlobalTrimestreC8("0");
            deudaGlobal.setEndeudamientoGlobalTrimestreC9("0");
            deudaGlobal.setEndeudamientoGlobalTrimestreC10("0");
            deudaGlobal.setEndeudamientoGlobalTrimestreC11(String.valueOf(endeudamientoGlobal.getNumeroCreditos()));
            deudaGlobal.setEndeudamientoGlobalTrimestreC12(miles(String.valueOf(endeudamientoGlobal.getSaldoPendiente())));
        } else if (endeudamientoGlobal.getTipoCredito().equals("CNS")) {
            deudaGlobal.setEndeudamientoGlobalTrimestreC5("0");
            deudaGlobal.setEndeudamientoGlobalTrimestreC6("0");
            deudaGlobal.setEndeudamientoGlobalTrimestreC7("0");
            deudaGlobal.setEndeudamientoGlobalTrimestreC8("0");
            deudaGlobal.setEndeudamientoGlobalTrimestreC9(String.valueOf(endeudamientoGlobal.getNumeroCreditos()));
            deudaGlobal.setEndeudamientoGlobalTrimestreC10((miles(String.valueOf(endeudamientoGlobal.getSaldoPendiente()))));
            deudaGlobal.setEndeudamientoGlobalTrimestreC11("0");
            deudaGlobal.setEndeudamientoGlobalTrimestreC12("0");
        }

        return deudaGlobal;
    }

    private int obtenerTrimestre(String fechaReporte) {
        String mes = fechaReporte.substring(5, 7);
        return switch (mes) {
            case "03" -> 0;
            case "06" -> 1;
            case "09" -> 2;
            case "12" -> 3;
            default -> -1;
        };
    }

    private String getNombreSector(int sector) {
        String[] nombresSectores = {
                "Sector Financiero",
                "Sector Cooperativo",
                "Sector Real",
                "Sector Telecomunicaciones"
        };

        if (sector >= 0 && sector < nombresSectores.length) {
            return nombresSectores[sector];
        } else {
            return "Sector desconocido";
        }
    }


    private List<List<DeudaGlobal>> procesarYOrdenarDeudas(List<List<List<DeudaGlobal>>> deudasPorTrimestreYSector) {
        List<List<DeudaGlobal>> deudasOrdenadas = new ArrayList<>(NUM_TRIMESTRES);
        for (List<List<DeudaGlobal>> deudasPorSector : deudasPorTrimestreYSector) {
            List<DeudaGlobal> deudasTrimestrales = new ArrayList<>();
            for (List<DeudaGlobal> deudas : deudasPorSector) {
                deudas.add(sumasTotalesTipo(deudas));
                deudasTrimestrales.addAll(deudas);
            }
            deudasOrdenadas.add(deudasTrimestrales);
        }
        return deudasOrdenadas;
    }

    private DeudaGlobal sumasTotalesTipo(List<DeudaGlobal> lista) {
        DeudaGlobal sumaDeudaGlobal = new DeudaGlobal();
        sumaDeudaGlobal.setEndeudamientoGlobalTrimestreC1("TOTAL");
        sumaDeudaGlobal.setEndeudamientoGlobalTrimestreC2("");
        sumaDeudaGlobal.setEndeudamientoGlobalTrimestreC3("0");
        sumaDeudaGlobal.setEndeudamientoGlobalTrimestreC4("0");
        sumaDeudaGlobal.setEndeudamientoGlobalTrimestreC5("0");
        sumaDeudaGlobal.setEndeudamientoGlobalTrimestreC6("0");
        sumaDeudaGlobal.setEndeudamientoGlobalTrimestreC7("0");
        sumaDeudaGlobal.setEndeudamientoGlobalTrimestreC8("0");
        sumaDeudaGlobal.setEndeudamientoGlobalTrimestreC9("0");
        sumaDeudaGlobal.setEndeudamientoGlobalTrimestreC10("0");
        sumaDeudaGlobal.setEndeudamientoGlobalTrimestreC11("0");
        sumaDeudaGlobal.setEndeudamientoGlobalTrimestreC12("0");
        sumaDeudaGlobal.setEndeudamientoGlobalTrimestreC13("");
        sumaDeudaGlobal.setEndeudamientoGlobalTrimestreC14("");
        sumaDeudaGlobal.setEndeudamientoGlobalTrimestreC15("");
        sumaDeudaGlobal.setEndeudamientoGlobalTrimestreC16("");
        sumaDeudaGlobal.setEndeudamientoGlobalTrimestreC17("");
        if (lista.size() == 1) {
            return sumaDeudaGlobal;
        }
        double trimestreC3 = 0, trimestreC4 = 0, trimestreC5 = 0, trimestreC6 = 0, trimestreC7 = 0, trimestreC8 = 0, trimestreC9 = 0, trimestreC10 = 0, trimestreC11 = 0, trimestreC12 = 0;
        for(DeudaGlobal data: lista) {
            trimestreC3 += data.getEndeudamientoGlobalTrimestreC3().equals("") ? 0 : Double.parseDouble(data.getEndeudamientoGlobalTrimestreC3().replace(",", ""));
            trimestreC4 += data.getEndeudamientoGlobalTrimestreC4().equals("") ? 0 : Double.parseDouble(data.getEndeudamientoGlobalTrimestreC4().replace(",", ""));
            trimestreC5 += data.getEndeudamientoGlobalTrimestreC5().equals("") ? 0 : Double.parseDouble(data.getEndeudamientoGlobalTrimestreC5().replace(",", ""));
            trimestreC6 += data.getEndeudamientoGlobalTrimestreC6().equals("") ? 0 : Double.parseDouble(data.getEndeudamientoGlobalTrimestreC6().replace(",", ""));
            trimestreC7 += data.getEndeudamientoGlobalTrimestreC7().equals("") ? 0 : Double.parseDouble(data.getEndeudamientoGlobalTrimestreC7().replace(",", ""));
            trimestreC8 += data.getEndeudamientoGlobalTrimestreC8().equals("") ? 0 : Double.parseDouble(data.getEndeudamientoGlobalTrimestreC8().replace(",", ""));
            trimestreC9 += data.getEndeudamientoGlobalTrimestreC9().equals("") ? 0 : Double.parseDouble(data.getEndeudamientoGlobalTrimestreC9().replace(",", ""));
            trimestreC10 += data.getEndeudamientoGlobalTrimestreC10().equals("") || data.getEndeudamientoGlobalTrimestreC10().equals("Sector Financiero") || data.getEndeudamientoGlobalTrimestreC10().equals("Sector Cooperativo") || data.getEndeudamientoGlobalTrimestreC10().equals("Sector Real")
                    || data.getEndeudamientoGlobalTrimestreC10().equals("Sector Telecomunicaciones") ? 0 : Double.parseDouble(data.getEndeudamientoGlobalTrimestreC10().replace(",", ""));
            trimestreC11 += data.getEndeudamientoGlobalTrimestreC11().equals("") ? 0 : Double.parseDouble(data.getEndeudamientoGlobalTrimestreC11().replace(",", ""));
            trimestreC12 += data.getEndeudamientoGlobalTrimestreC12().equals("") ? 0 : Double.parseDouble(data.getEndeudamientoGlobalTrimestreC12().replace(",", ""));
        }
        sumaDeudaGlobal.setEndeudamientoGlobalTrimestreC3(miles(String.valueOf(trimestreC3)));
        sumaDeudaGlobal.setEndeudamientoGlobalTrimestreC4(miles(String.format("%.0f", trimestreC4)));
        sumaDeudaGlobal.setEndeudamientoGlobalTrimestreC5(miles(String.format("%.0f", trimestreC5)));
        sumaDeudaGlobal.setEndeudamientoGlobalTrimestreC6(miles(String.format("%.0f", trimestreC6)));
        sumaDeudaGlobal.setEndeudamientoGlobalTrimestreC7(miles(String.format("%.0f", trimestreC7)));
        sumaDeudaGlobal.setEndeudamientoGlobalTrimestreC8(miles(String.format("%.0f", trimestreC8)));
        sumaDeudaGlobal.setEndeudamientoGlobalTrimestreC9(miles(String.format("%.0f", trimestreC9)));
        sumaDeudaGlobal.setEndeudamientoGlobalTrimestreC10(miles(String.format("%.0f", trimestreC10)));
        sumaDeudaGlobal.setEndeudamientoGlobalTrimestreC11(miles(String.format("%.0f", trimestreC11)));
        sumaDeudaGlobal.setEndeudamientoGlobalTrimestreC12(miles(String.format("%.0f", trimestreC12)));
        return sumaDeudaGlobal;
    }

    private TotalesDataset sumasTotales(List<DeudaGlobal> trimestre) {
        int[] sumaNum = new int[4];
        int[] sumaSaldoTotal = new int[4];
        for (DeudaGlobal deudaGlobalTrimestre : trimestre) {
            String endeudamiento = deudaGlobalTrimestre.getEndeudamientoGlobalTrimestreC1();
            if (!endeudamiento.isEmpty()) {
                int index = endeudamiento.charAt(endeudamiento.length() - 1) - '1';
                if (index >= 0 && index < 4) {
                    try {
                        sumaNum[index] += Integer.parseInt(deudaGlobalTrimestre.getEndeudamientoGlobalTrimestreC3());
                        sumaSaldoTotal[index] += Integer.parseInt(deudaGlobalTrimestre.getEndeudamientoGlobalTrimestreC4());
                    } catch (NumberFormatException e) {
                        Log.info("Error en suma totales - endeudamiento clasificado");
                    }
                }
            }
        }
        return new TotalesDataset(sumaNum, sumaSaldoTotal);
    }

    /*
     * Mapeo de mapeoHabitosObligacionesCerradas y funciones necesarias - Murcia
     */

    private List<List<HabitObligaCerradas>> mapeoHabitosObligacionesCerradas(List<CuentaCartera> cuentaCartera, List<TarjetaCredito> tarjetaCredito, List<CuentaAhorro> cuentaAhorro) {
        List<HabitObligaCerradas> dataSetsFinanciero = new ArrayList<>();
        List<HabitObligaCerradas> dataSetsReal = new ArrayList<>();
        List<HabitObligaCerradas> dataSetsTelco = new ArrayList<>();
        List<HabitObligaCerradas> dataSetsCooperativo = new ArrayList<>();

        Map<String, List<HabitObligaCerradas>> sectorToDataSetMap = new HashMap<>();
        sectorToDataSetMap.put("Sector Financiero", dataSetsFinanciero);
        sectorToDataSetMap.put("Sector Real", dataSetsReal);
        sectorToDataSetMap.put("Sector Telecomunicaciones", dataSetsTelco);
        sectorToDataSetMap.put("Sector Cooperativo", dataSetsCooperativo);

        // Iterar sobre las listas
        if (cuentaAhorro != null) {
            for (CuentaAhorro cuentaAh : cuentaAhorro) {
                HabitObligaCerradas habitObligaCerradas = rellenarCerradas("cuentaAhorro", cuentaAh);
                List<HabitObligaCerradas> dataSet = sectorToDataSetMap.get("Sector " + getSectorName(cuentaAh.getSector()));
                if (habitObligaCerradas.getHabitoPagoC1() != null) {
                    dataSet.add(habitObligaCerradas);
                }
            }
        }

        if (cuentaCartera != null) {
            for (CuentaCartera cuentaCar : cuentaCartera) {
                HabitObligaCerradas habitObligaCerradas = rellenarCerradas("cuentaCartera", cuentaCar);
                List<HabitObligaCerradas> dataSet = sectorToDataSetMap.get("Sector " + getSectorName(cuentaCar.getSector()));
                if (habitObligaCerradas.getHabitoPagoC1() != null) {
                    dataSet.add(habitObligaCerradas);
                }
            }
        }
        if (tarjetaCredito != null) {
            for (TarjetaCredito tarjetaCred : tarjetaCredito) {
                tarjetaCred.setCalificacion(tarjetaCred.getCalificacion() > 0 ? tarjetaCred.getCalificacion() : 0);
                HabitObligaCerradas habitObligaCerradas = rellenarCerradas("tarjetaCredito", tarjetaCred);
                List<HabitObligaCerradas> dataSet = sectorToDataSetMap.get("Sector " + getSectorName(tarjetaCred.getSector()));
                if (habitObligaCerradas.getHabitoPagoC1() != null) {
                    dataSet.add(habitObligaCerradas);
                }
            }
        }


        if (dataSetsFinanciero.size() == 0){
            dataSetsFinanciero.add(new HabitObligaCerradas("Sector Vacio", "-","-","-", "-","-","-", "-","-","-", "-","-","-"));
        }
        if (dataSetsReal.size() == 0){
            dataSetsReal.add(new HabitObligaCerradas("Sector Vacio", "-","-","-", "-","-","-", "-","-","-", "-","-","-"));
        }
        if (dataSetsTelco.size() == 0){
            dataSetsTelco.add(new HabitObligaCerradas("Sector Vacio", "-","-","-", "-","-","-", "-","-","-", "-","-","-"));
        }
        if (dataSetsCooperativo.size() == 0){
            dataSetsCooperativo.add(new HabitObligaCerradas("Sector Vacio", "-","-","-", "-","-","-", "-","-","-", "-","-","-"));
        }

        return new ArrayList<>(sectorToDataSetMap.values());
    }

    private String dividirYAgregarSeparadores(String caden) {
        StringBuilder resultado = new StringBuilder();
        String cadena = caden.trim();
        int length = cadena.length();

        for (int i = 0; i < length; i += 12) {
            String part = cadena.substring(i, Math.min(i + 12, length));
            resultado.append(part);
            if (i + 12 < length) {
                resultado.append("][");
            }
        }
        return resultado.toString() ;
    }

    private HabitObligaCerradas rellenarCerradas(String type, Object obj) {
        HabitObligaCerradas habitObligaCerradas = new HabitObligaCerradas();
        if (type.contains("cuentaCartera")) {
            CuentaCartera cuentaCartera = (CuentaCartera) obj;
            if (estaCerradas(cuentaCartera.getEstados().getEstadoCuenta().getCodigo())) {
                habitObligaCerradas.setHabitoPagoC1(cuentaCartera.getEntidad());
                if (cuentaCartera.getCaracteristicas() != null) {
                    habitObligaCerradas.setHabitoPagoC2(cuentaCartera.getCaracteristicas().getTipoCuenta() == null ? "-" : cuentaCartera.getCaracteristicas().getTipoCuenta());
                }
                habitObligaCerradas.setHabitoPagoC3(obtenerCalificacion(cuentaCartera.getCalificacion()).equals("") ? "-" : obtenerCalificacion(cuentaCartera.getCalificacion()));
                habitObligaCerradas.setHabitoPagoC4(obtenerEstadoPago(cuentaCartera.getEstados().getEstadoCuenta().getCodigo().equals("08") ? "08" : "00"));
                habitObligaCerradas.setHabitoPagoC5(cuentaCartera.getAdjetivo() == null  ? "-" : String.valueOf(mapper.codToAdjetivo("_" + cuentaCartera.getAdjetivo().getCodigo() + " / " +  cuentaCartera.getAdjetivo().getFecha())));
                habitObligaCerradas.setHabitoPagoC6(cuentaCartera.getNumero());
                habitObligaCerradas.setHabitoPagoC7(cuentaCartera.getFechaApertura());
                if (cuentaCartera.getEstados() != null) {
                    habitObligaCerradas.setHabitoPagoC8(cuentaCartera.getEstados().getEstadoCuenta().getFecha());
                } else if (cuentaCartera.getValores().getValores() == null) {
                    if (cuentaCartera.getEstados() != null) {
                        habitObligaCerradas.setHabitoPagoC8(cuentaCartera.getEstados().getEstadoCuenta().getFecha());
                    }
                } else {
                    habitObligaCerradas.setHabitoPagoC8(cuentaCartera.getValores().getValores().get(0).getFecha());
                }

                if (cuentaCartera.getValores() != null && cuentaCartera.getValores().getValores() != null && !cuentaCartera.getValores().getValores().isEmpty()) {
                    habitObligaCerradas.setHabitoPagoC9("$" + miles(String.valueOf(cuentaCartera.getValores().getValores().get(0).getValorInicial())));
                } else {
                    habitObligaCerradas.setHabitoPagoC9("-");
                }
                habitObligaCerradas.setHabitoPagoC10(cuentaCartera.getCiudad() == null ? "-" : cuentaCartera.getCiudad() + " / " + cuentaCartera.getFechaVencimiento());
                habitObligaCerradas.setHabitoPagoC11(cuentaCartera.getOficina() + " / " + mapper.codToGarante(cuentaCartera.getCaracteristicas().getCalidadDeudor() == null ? "_00" : "_" + cuentaCartera.getCaracteristicas().getCalidadDeudor()).toString());
                habitObligaCerradas.setHabitoPagoC12("-");
                habitObligaCerradas.setHabitoPagoC13(cuentaCartera.getComportamiento() != null && !cuentaCartera.getComportamiento().isEmpty() ? "[" + dividirYAgregarSeparadores(cuentaCartera.getComportamiento()) + "]" : "-");
            }
        }
        if (type.contains("tarjetaCredito")) {
            TarjetaCredito tarjetaCredito = (TarjetaCredito) obj;
            if (estaCerradas(tarjetaCredito.getEstados().getEstadoCuenta().getCodigo())) {
                habitObligaCerradas.setHabitoPagoC1(tarjetaCredito.getEntidad());
                habitObligaCerradas.setHabitoPagoC2("TDC");
                habitObligaCerradas.setHabitoPagoC3(obtenerCalificacion(tarjetaCredito.getCalificacion()).equals("") ? "-" : obtenerCalificacion(tarjetaCredito.getCalificacion()));
                habitObligaCerradas.setHabitoPagoC4(obtenerEstadoPago(tarjetaCredito.getEstados().getEstadoCuenta().getCodigo().equals("08") ? "08" : "00"));
                habitObligaCerradas.setHabitoPagoC5("-");
                habitObligaCerradas.setHabitoPagoC6(tarjetaCredito.getNumero());
                habitObligaCerradas.setHabitoPagoC7(tarjetaCredito.getFechaApertura());
                if (tarjetaCredito.getValores().getValores() == null) {
                    if (tarjetaCredito.getEstados() != null) {
                        habitObligaCerradas.setHabitoPagoC8(tarjetaCredito.getEstados().getEstadoCuenta().getFecha());
                    }
                } else {
                    habitObligaCerradas.setHabitoPagoC8(tarjetaCredito.getValores().getValores().get(0).getFecha());
                }
                habitObligaCerradas.setHabitoPagoC9(tarjetaCredito.getValores().getValores() == null ? "-" : "$" + miles(String.valueOf(tarjetaCredito.getValores().getValores().get(0).getDisponible())));
                habitObligaCerradas.setHabitoPagoC9("$" + (tarjetaCredito.getValores().getValores() == null ? "-" : miles(String.valueOf(tarjetaCredito.getValores().getValores().get(0).getDisponible()))));
                habitObligaCerradas.setHabitoPagoC10(tarjetaCredito.getCiudad() + " / " + tarjetaCredito.getFechaVencimiento());
                habitObligaCerradas.setHabitoPagoC11(tarjetaCredito.getOficina() + " / " + mapper.codToGarante(tarjetaCredito.getCaracteristicas().getCalidadDeudor() == null ? "_00" : "_" + tarjetaCredito.getCaracteristicas().getCalidadDeudor()).toString());
                habitObligaCerradas.setHabitoPagoC12("-");
                habitObligaCerradas.setHabitoPagoC13(tarjetaCredito.getComportamiento() != null && !tarjetaCredito.getComportamiento().isEmpty() ? "[" + dividirYAgregarSeparadores(tarjetaCredito.getComportamiento()) + "]" : "-");
            }
        }
        if (type.contains("cuentaAhorro")) {
            CuentaAhorro cuentaAhorro = (CuentaAhorro) obj;
            if (estaCerradasCuentaAhorro(cuentaAhorro.getEstado().getCodigo())){
                habitObligaCerradas.setHabitoPagoC1(cuentaAhorro.getEntidad());
                habitObligaCerradas.setHabitoPagoC2("AHO");
                habitObligaCerradas.setHabitoPagoC3(obtenerCalificacion(cuentaAhorro.getCalificacion()).equals("") ? "-" : obtenerCalificacion(cuentaAhorro.getCalificacion()));
                //estado de la obligacion duda
                habitObligaCerradas.setHabitoPagoC4(obtenerEstadoPago(cuentaAhorro.getEstado() != null && !cuentaAhorro.getEstado().getCodigo().isEmpty() ? cuentaAhorro.getEstado().getCodigo() : "00"));
                habitObligaCerradas.setHabitoPagoC5("-");
                habitObligaCerradas.setHabitoPagoC6(String.valueOf(cuentaAhorro.getNumero()));
                habitObligaCerradas.setHabitoPagoC7(cuentaAhorro.getFechaApertura());
                habitObligaCerradas.setHabitoPagoC8(cuentaAhorro.getEstado() != null && !cuentaAhorro.getEstado().getFecha().isEmpty() ? cuentaAhorro.getEstado().getFecha() : "-");
                habitObligaCerradas.setHabitoPagoC9("-");
                habitObligaCerradas.setHabitoPagoC10(cuentaAhorro.getCiudad());
                habitObligaCerradas.setHabitoPagoC11(cuentaAhorro.getOficina());
                habitObligaCerradas.setHabitoPagoC12("-");
                habitObligaCerradas.setHabitoPagoC13("-");
            }
        }
        return habitObligaCerradas;
    }


    private boolean estaCerrada(String codigo) {
        return codigo.equals("02") ||
                codigo.equals("03") ||
                codigo.equals("05") ||
                codigo.equals("08") ||
                codigo.equals("09") ||
                codigo.equals("11");
    }

    private String getSectorName(int sector) {
        try {
            Map<Integer, String> sectores = new HashMap<>();
            sectores.put(1, "Financiero");
            sectores.put(2, "Cooperativo");
            sectores.put(3, "Real");
            sectores.put(4, "Telecomunicaciones");
            return sectores.getOrDefault(sector, "");
        } catch (Exception e) {
            System.out.println("efecas");
        }
        return "xxx";

    }

    private String obtenerCalificacion(int valor) {
        Map<Integer, String> calificaciones = new HashMap<>();
        calificaciones.put(1, "A");
        calificaciones.put(2, "B");
        calificaciones.put(3, "C");
        calificaciones.put(4, "D");
        calificaciones.put(5, "E");
        calificaciones.put(6, "AA");
        calificaciones.put(7, "BB");
        calificaciones.put(8, "CC");
        calificaciones.put(9, "K");

        return calificaciones.getOrDefault(valor, "");
    }

    private String obtenerEstadoPago(String  estadoPago) {
        final Map<String, String> ESTADOS_PAGO = new HashMap<>();

        ESTADOS_PAGO.put("01", "Activa");
        ESTADOS_PAGO.put("02", "Cancelada por mal manejo");
        ESTADOS_PAGO.put("05", "Saldada");
        ESTADOS_PAGO.put("06", "Embargada");
        ESTADOS_PAGO.put("07", "Embargada-Activa");
        ESTADOS_PAGO.put("08", "CANCELADA VOL Orig: Normal Plástico Devuelto");
        ESTADOS_PAGO.put("09", "Inactiva");
        ESTADOS_PAGO.put("00", "PAGO VOL Orig: Normal");

        return ESTADOS_PAGO.getOrDefault(estadoPago,"Desconocido");

    }

    public String sectorToDescripcion(int params) {
        return switch (params) {
            case 0 -> "Financiero";
            case 1 -> "Cooperativo";
            case 2 -> "Real";
            case 3 -> "Telecomunicaciones";
            default -> null;
        };
    }

    //Extracion XML
    private JasperPrint generacionJasperPrint(Informe informes) throws JRException {

        InputStream inputStream = getClass().getResourceAsStream("/reports/sample_report.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);

        List<Map<String, Object>> data = prepararDatos(informes);
        Map<String, Object> parameter = new HashMap<>();
        if (informes.getInfoAgregadaMicrocredito() != null){
            parameter = rellenoDeDataSets(informes);
        }

        return JasperFillManager.fillReport(jasperReport, parameter, new JRBeanCollectionDataSource(data));

    }

    private Informe tranformacionXmlToObj(HistorialCreditoBaseArchivoXmlInput input) throws IOException, JAXBException {

        ArchivoEntity archivoEntity = new ArchivoEntity();
        archivoEntity.setNombreArchivoXml(input.getNombreArchivoXml());
        archivoEntity.setRutaXml("XML CENTRALES RIESGOS");
        ArchivoResponseDto archivoResponse = (ArchivoResponseDto) obtenerArchivoCmd.execute(archivoEntity);

        // Decodificar la cadena Base64 a una cadena de texto
        String decodedXmlString = decodeBase64ToString(archivoResponse.getArchivo());

        JAXBContext context = JAXBContext.newInstance(Informes.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        StringReader reader = new StringReader(decodedXmlString);
        ArrayList<Object> informacion = new ArrayList<>();

        informacion.add(unmarshaller.unmarshal(reader));

        return ((Informes) informacion.get(0)).getInforme().get(0);
    }

    private static String decodeBase64ToString(String base64String) {
        byte[] decodedBytes = Base64.getDecoder().decode(base64String);
        return new String(decodedBytes, StandardCharsets.UTF_8);
    }

    private static String miles(String numberStr) {
        try {
            //String a double y luego a long para eliminar decimales
            double numeroDouble = Double.parseDouble(numberStr);
            long numeroRedondeado = (long) numeroDouble;
            NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
            return numberFormat.format(numeroRedondeado);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return "0";
    }

    private static final String[] MESES = {
            "Ene", "Feb", "Mar", "Abr", "May", "Jun",
            "Jul", "Ago", "Sep", "Oct", "Nov", "Dic"
    };

    public static String numeroAMes(String numero) {
        try {
            int indiceMes = Integer.parseInt(numero) - 1;
            if (indiceMes >= 0 && indiceMes < 12) {
                return MESES[indiceMes];
            } else {
                return "Número de mes inválido";
            }
        } catch (NumberFormatException e) {
            return "Entrada no es un número";
        }
    }

    public static String convertirAMinusculasCamelCase(String texto) {
        if (texto == null || texto.isEmpty()) {
            return texto;
        }

        StringBuilder resultado = new StringBuilder(texto.length());
        boolean esPrimeraLetra = true;

        for (char ch : texto.toCharArray()) {
            if (esPrimeraLetra && Character.isLetter(ch)) {
                resultado.append(Character.toUpperCase(ch));
                esPrimeraLetra = false;
            } else {
                resultado.append(Character.toLowerCase(ch));
            }

            if (Character.isWhitespace(ch)) {
                esPrimeraLetra = true;
            }
        }

        return resultado.toString();
    }

}
