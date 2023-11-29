package com.mibanco.generarpdfriesgo.ms.gen.type;

import com.mibanco.generarpdfriesgo.ms.gen.type.ConsultaDetalladaType;
import com.mibanco.generarpdfriesgo.ms.gen.type.HistoricoEndeudamientoType;
import com.mibanco.generarpdfriesgo.ms.gen.type.TipoDocumentoEnum;
import com.mibanco.generarpdfriesgo.ms.gen.type.TipoRelacionEnum;
import com.mibanco.generarpdfriesgo.ms.gen.type.TipoReporteXmlEnum;
import java.util.Date;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("ReporteCentralRiesgoType")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-11-22T11:43:13.018607800-05:00[America/Bogota]")
public class ReporteCentralRiesgoType   {
  private @Valid String fechaConsulta;
  private @Valid TipoDocumentoEnum tipoDocumento;
  private @Valid String numeroDocumento;
  private @Valid String estadoDocumento;
  private @Valid String lugarExpedicion;
  private @Valid Date fechaExpedicion;
  private @Valid String nombre;
  private @Valid String rangoEdad;
  private @Valid String genero;
  private @Valid Boolean tieneRUT;
  private @Valid String antiguedadUbicacion;
  private @Valid String digitoVerificacion;
  private @Valid TipoRelacionEnum tipoRelacion;
  private @Valid TipoReporteXmlEnum tipoReporte;
  private @Valid HistoricoEndeudamientoType historicoEndeudamiento;
  private @Valid ConsultaDetalladaType consultaDetallada;

  /**
   **/
  public ReporteCentralRiesgoType fechaConsulta(String fechaConsulta) {
    this.fechaConsulta = fechaConsulta;
    return this;
  }

  
  @JsonProperty("fechaConsulta")
  public String getFechaConsulta() {
    return fechaConsulta;
  }

  @JsonProperty("fechaConsulta")
  public void setFechaConsulta(String fechaConsulta) {
    this.fechaConsulta = fechaConsulta;
  }

  /**
   **/
  public ReporteCentralRiesgoType tipoDocumento(TipoDocumentoEnum tipoDocumento) {
    this.tipoDocumento = tipoDocumento;
    return this;
  }

  
  @JsonProperty("tipoDocumento")
  public TipoDocumentoEnum getTipoDocumento() {
    return tipoDocumento;
  }

  @JsonProperty("tipoDocumento")
  public void setTipoDocumento(TipoDocumentoEnum tipoDocumento) {
    this.tipoDocumento = tipoDocumento;
  }

  /**
   **/
  public ReporteCentralRiesgoType numeroDocumento(String numeroDocumento) {
    this.numeroDocumento = numeroDocumento;
    return this;
  }

  
  @JsonProperty("numeroDocumento")
  public String getNumeroDocumento() {
    return numeroDocumento;
  }

  @JsonProperty("numeroDocumento")
  public void setNumeroDocumento(String numeroDocumento) {
    this.numeroDocumento = numeroDocumento;
  }

  /**
   **/
  public ReporteCentralRiesgoType estadoDocumento(String estadoDocumento) {
    this.estadoDocumento = estadoDocumento;
    return this;
  }

  
  @JsonProperty("estadoDocumento")
  public String getEstadoDocumento() {
    return estadoDocumento;
  }

  @JsonProperty("estadoDocumento")
  public void setEstadoDocumento(String estadoDocumento) {
    this.estadoDocumento = estadoDocumento;
  }

  /**
   **/
  public ReporteCentralRiesgoType lugarExpedicion(String lugarExpedicion) {
    this.lugarExpedicion = lugarExpedicion;
    return this;
  }

  
  @JsonProperty("lugarExpedicion")
  public String getLugarExpedicion() {
    return lugarExpedicion;
  }

  @JsonProperty("lugarExpedicion")
  public void setLugarExpedicion(String lugarExpedicion) {
    this.lugarExpedicion = lugarExpedicion;
  }

  /**
   **/
  public ReporteCentralRiesgoType fechaExpedicion(Date fechaExpedicion) {
    this.fechaExpedicion = fechaExpedicion;
    return this;
  }

  
  @JsonProperty("fechaExpedicion")
  public Date getFechaExpedicion() {
    return fechaExpedicion;
  }

  @JsonProperty("fechaExpedicion")
  public void setFechaExpedicion(Date fechaExpedicion) {
    this.fechaExpedicion = fechaExpedicion;
  }

  /**
   **/
  public ReporteCentralRiesgoType nombre(String nombre) {
    this.nombre = nombre;
    return this;
  }

  
  @JsonProperty("nombre")
  public String getNombre() {
    return nombre;
  }

  @JsonProperty("nombre")
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  /**
   **/
  public ReporteCentralRiesgoType rangoEdad(String rangoEdad) {
    this.rangoEdad = rangoEdad;
    return this;
  }

  
  @JsonProperty("rangoEdad")
  public String getRangoEdad() {
    return rangoEdad;
  }

  @JsonProperty("rangoEdad")
  public void setRangoEdad(String rangoEdad) {
    this.rangoEdad = rangoEdad;
  }

  /**
   **/
  public ReporteCentralRiesgoType genero(String genero) {
    this.genero = genero;
    return this;
  }

  
  @JsonProperty("genero")
  public String getGenero() {
    return genero;
  }

  @JsonProperty("genero")
  public void setGenero(String genero) {
    this.genero = genero;
  }

  /**
   **/
  public ReporteCentralRiesgoType tieneRUT(Boolean tieneRUT) {
    this.tieneRUT = tieneRUT;
    return this;
  }

  
  @JsonProperty("tieneRUT")
  public Boolean getTieneRUT() {
    return tieneRUT;
  }

  @JsonProperty("tieneRUT")
  public void setTieneRUT(Boolean tieneRUT) {
    this.tieneRUT = tieneRUT;
  }

  /**
   **/
  public ReporteCentralRiesgoType antiguedadUbicacion(String antiguedadUbicacion) {
    this.antiguedadUbicacion = antiguedadUbicacion;
    return this;
  }

  
  @JsonProperty("antiguedadUbicacion")
  public String getAntiguedadUbicacion() {
    return antiguedadUbicacion;
  }

  @JsonProperty("antiguedadUbicacion")
  public void setAntiguedadUbicacion(String antiguedadUbicacion) {
    this.antiguedadUbicacion = antiguedadUbicacion;
  }

  /**
   **/
  public ReporteCentralRiesgoType digitoVerificacion(String digitoVerificacion) {
    this.digitoVerificacion = digitoVerificacion;
    return this;
  }

  
  @JsonProperty("digitoVerificacion")
  public String getDigitoVerificacion() {
    return digitoVerificacion;
  }

  @JsonProperty("digitoVerificacion")
  public void setDigitoVerificacion(String digitoVerificacion) {
    this.digitoVerificacion = digitoVerificacion;
  }

  /**
   **/
  public ReporteCentralRiesgoType tipoRelacion(TipoRelacionEnum tipoRelacion) {
    this.tipoRelacion = tipoRelacion;
    return this;
  }

  
  @JsonProperty("tipoRelacion")
  public TipoRelacionEnum getTipoRelacion() {
    return tipoRelacion;
  }

  @JsonProperty("tipoRelacion")
  public void setTipoRelacion(TipoRelacionEnum tipoRelacion) {
    this.tipoRelacion = tipoRelacion;
  }

  /**
   **/
  public ReporteCentralRiesgoType tipoReporte(TipoReporteXmlEnum tipoReporte) {
    this.tipoReporte = tipoReporte;
    return this;
  }

  
  @JsonProperty("tipoReporte")
  public TipoReporteXmlEnum getTipoReporte() {
    return tipoReporte;
  }

  @JsonProperty("tipoReporte")
  public void setTipoReporte(TipoReporteXmlEnum tipoReporte) {
    this.tipoReporte = tipoReporte;
  }

  /**
   **/
  public ReporteCentralRiesgoType historicoEndeudamiento(HistoricoEndeudamientoType historicoEndeudamiento) {
    this.historicoEndeudamiento = historicoEndeudamiento;
    return this;
  }

  
  @JsonProperty("historicoEndeudamiento")
  public HistoricoEndeudamientoType getHistoricoEndeudamiento() {
    return historicoEndeudamiento;
  }

  @JsonProperty("historicoEndeudamiento")
  public void setHistoricoEndeudamiento(HistoricoEndeudamientoType historicoEndeudamiento) {
    this.historicoEndeudamiento = historicoEndeudamiento;
  }

  /**
   **/
  public ReporteCentralRiesgoType consultaDetallada(ConsultaDetalladaType consultaDetallada) {
    this.consultaDetallada = consultaDetallada;
    return this;
  }

  
  @JsonProperty("consultaDetallada")
  public ConsultaDetalladaType getConsultaDetallada() {
    return consultaDetallada;
  }

  @JsonProperty("consultaDetallada")
  public void setConsultaDetallada(ConsultaDetalladaType consultaDetallada) {
    this.consultaDetallada = consultaDetallada;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReporteCentralRiesgoType reporteCentralRiesgoType = (ReporteCentralRiesgoType) o;
    return Objects.equals(this.fechaConsulta, reporteCentralRiesgoType.fechaConsulta) &&
        Objects.equals(this.tipoDocumento, reporteCentralRiesgoType.tipoDocumento) &&
        Objects.equals(this.numeroDocumento, reporteCentralRiesgoType.numeroDocumento) &&
        Objects.equals(this.estadoDocumento, reporteCentralRiesgoType.estadoDocumento) &&
        Objects.equals(this.lugarExpedicion, reporteCentralRiesgoType.lugarExpedicion) &&
        Objects.equals(this.fechaExpedicion, reporteCentralRiesgoType.fechaExpedicion) &&
        Objects.equals(this.nombre, reporteCentralRiesgoType.nombre) &&
        Objects.equals(this.rangoEdad, reporteCentralRiesgoType.rangoEdad) &&
        Objects.equals(this.genero, reporteCentralRiesgoType.genero) &&
        Objects.equals(this.tieneRUT, reporteCentralRiesgoType.tieneRUT) &&
        Objects.equals(this.antiguedadUbicacion, reporteCentralRiesgoType.antiguedadUbicacion) &&
        Objects.equals(this.digitoVerificacion, reporteCentralRiesgoType.digitoVerificacion) &&
        Objects.equals(this.tipoRelacion, reporteCentralRiesgoType.tipoRelacion) &&
        Objects.equals(this.tipoReporte, reporteCentralRiesgoType.tipoReporte) &&
        Objects.equals(this.historicoEndeudamiento, reporteCentralRiesgoType.historicoEndeudamiento) &&
        Objects.equals(this.consultaDetallada, reporteCentralRiesgoType.consultaDetallada);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fechaConsulta, tipoDocumento, numeroDocumento, estadoDocumento, lugarExpedicion, fechaExpedicion, nombre, rangoEdad, genero, tieneRUT, antiguedadUbicacion, digitoVerificacion, tipoRelacion, tipoReporte, historicoEndeudamiento, consultaDetallada);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReporteCentralRiesgoType {\n");
    
    sb.append("    fechaConsulta: ").append(toIndentedString(fechaConsulta)).append("\n");
    sb.append("    tipoDocumento: ").append(toIndentedString(tipoDocumento)).append("\n");
    sb.append("    numeroDocumento: ").append(toIndentedString(numeroDocumento)).append("\n");
    sb.append("    estadoDocumento: ").append(toIndentedString(estadoDocumento)).append("\n");
    sb.append("    lugarExpedicion: ").append(toIndentedString(lugarExpedicion)).append("\n");
    sb.append("    fechaExpedicion: ").append(toIndentedString(fechaExpedicion)).append("\n");
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
    sb.append("    rangoEdad: ").append(toIndentedString(rangoEdad)).append("\n");
    sb.append("    genero: ").append(toIndentedString(genero)).append("\n");
    sb.append("    tieneRUT: ").append(toIndentedString(tieneRUT)).append("\n");
    sb.append("    antiguedadUbicacion: ").append(toIndentedString(antiguedadUbicacion)).append("\n");
    sb.append("    digitoVerificacion: ").append(toIndentedString(digitoVerificacion)).append("\n");
    sb.append("    tipoRelacion: ").append(toIndentedString(tipoRelacion)).append("\n");
    sb.append("    tipoReporte: ").append(toIndentedString(tipoReporte)).append("\n");
    sb.append("    historicoEndeudamiento: ").append(toIndentedString(historicoEndeudamiento)).append("\n");
    sb.append("    consultaDetallada: ").append(toIndentedString(consultaDetallada)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


}

