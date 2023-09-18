package com.mibanco.generarpdfriesgo.ms.dao.entity;

import com.mibanco.generarpdfriesgo.ms.gen.type.TipoDocumentoEnum;
import com.mibanco.generarpdfriesgo.ms.gen.type.TipoRelacionEnum;
import com.mibanco.generarpdfriesgo.ms.gen.type.TipoReporteXmlEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CentralRiesgoEntity {

    private String antiguedadUbicacion;
    private ConsultaDetalladaEntity consultaDetallada;
    private String estadoDocumento;
    private Date fechaConsultaMasReciente;
    private Date fechaExpedicion;
    private String genero;
    private String historicoEndeudamiento;
    private String lugarExpedicion;
    private String numeroDocumento;
    private String rangoEdad;
    private String resultadoConsultaMasReciente;
    private Boolean tieneRUT;
    private TipoDocumentoEnum tipoDocumento;
    private TipoRelacionEnum tipoRelacion;
    private TipoReporteXmlEnum tipoReporte;
    private Boolean vbVigenteParaSerConsultado;
    private String digitoVerificacion;
}
