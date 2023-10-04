package com.mibanco.generarpdfriesgo.ms.gen.type;

import com.mibanco.generarpdfriesgo.ms.gen.type.EstadoEndeudamientoActualXmlEnum;
import com.mibanco.generarpdfriesgo.ms.gen.type.TIpoSectorXmlEnum;
import com.mibanco.generarpdfriesgo.ms.gen.type.TipoCarteraXmlEnum;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("EndeudamientoActualType")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-10-03T17:19:31.615516-05:00[America/Bogota]")
public class EndeudamientoActualType   {
  private @Valid String calidad;
  private @Valid String calificacion;
  private @Valid TipoCarteraXmlEnum cartera;
  private @Valid EstadoEndeudamientoActualXmlEnum estadoEndeudamientoActual;
  private @Valid Float porcentajeDeuda;
  private @Valid Float porcentajePart;
  private @Valid Float saldoActual;
  private @Valid Float saldoEnMora;
  private @Valid TIpoSectorXmlEnum sector;
  private @Valid Float valorCuota;
  private @Valid Float vlrOCupoInicial;

  /**
   **/
  public EndeudamientoActualType calidad(String calidad) {
    this.calidad = calidad;
    return this;
  }

  
  @JsonProperty("calidad")
  public String getCalidad() {
    return calidad;
  }

  @JsonProperty("calidad")
  public void setCalidad(String calidad) {
    this.calidad = calidad;
  }

  /**
   **/
  public EndeudamientoActualType calificacion(String calificacion) {
    this.calificacion = calificacion;
    return this;
  }

  
  @JsonProperty("calificacion")
  public String getCalificacion() {
    return calificacion;
  }

  @JsonProperty("calificacion")
  public void setCalificacion(String calificacion) {
    this.calificacion = calificacion;
  }

  /**
   **/
  public EndeudamientoActualType cartera(TipoCarteraXmlEnum cartera) {
    this.cartera = cartera;
    return this;
  }

  
  @JsonProperty("cartera")
  public TipoCarteraXmlEnum getCartera() {
    return cartera;
  }

  @JsonProperty("cartera")
  public void setCartera(TipoCarteraXmlEnum cartera) {
    this.cartera = cartera;
  }

  /**
   **/
  public EndeudamientoActualType estadoEndeudamientoActual(EstadoEndeudamientoActualXmlEnum estadoEndeudamientoActual) {
    this.estadoEndeudamientoActual = estadoEndeudamientoActual;
    return this;
  }

  
  @JsonProperty("estadoEndeudamientoActual")
  public EstadoEndeudamientoActualXmlEnum getEstadoEndeudamientoActual() {
    return estadoEndeudamientoActual;
  }

  @JsonProperty("estadoEndeudamientoActual")
  public void setEstadoEndeudamientoActual(EstadoEndeudamientoActualXmlEnum estadoEndeudamientoActual) {
    this.estadoEndeudamientoActual = estadoEndeudamientoActual;
  }

  /**
   **/
  public EndeudamientoActualType porcentajeDeuda(Float porcentajeDeuda) {
    this.porcentajeDeuda = porcentajeDeuda;
    return this;
  }

  
  @JsonProperty("porcentajeDeuda")
  public Float getPorcentajeDeuda() {
    return porcentajeDeuda;
  }

  @JsonProperty("porcentajeDeuda")
  public void setPorcentajeDeuda(Float porcentajeDeuda) {
    this.porcentajeDeuda = porcentajeDeuda;
  }

  /**
   **/
  public EndeudamientoActualType porcentajePart(Float porcentajePart) {
    this.porcentajePart = porcentajePart;
    return this;
  }

  
  @JsonProperty("porcentajePart")
  public Float getPorcentajePart() {
    return porcentajePart;
  }

  @JsonProperty("porcentajePart")
  public void setPorcentajePart(Float porcentajePart) {
    this.porcentajePart = porcentajePart;
  }

  /**
   **/
  public EndeudamientoActualType saldoActual(Float saldoActual) {
    this.saldoActual = saldoActual;
    return this;
  }

  
  @JsonProperty("saldoActual")
  public Float getSaldoActual() {
    return saldoActual;
  }

  @JsonProperty("saldoActual")
  public void setSaldoActual(Float saldoActual) {
    this.saldoActual = saldoActual;
  }

  /**
   **/
  public EndeudamientoActualType saldoEnMora(Float saldoEnMora) {
    this.saldoEnMora = saldoEnMora;
    return this;
  }

  
  @JsonProperty("saldoEnMora")
  public Float getSaldoEnMora() {
    return saldoEnMora;
  }

  @JsonProperty("saldoEnMora")
  public void setSaldoEnMora(Float saldoEnMora) {
    this.saldoEnMora = saldoEnMora;
  }

  /**
   **/
  public EndeudamientoActualType sector(TIpoSectorXmlEnum sector) {
    this.sector = sector;
    return this;
  }

  
  @JsonProperty("sector")
  public TIpoSectorXmlEnum getSector() {
    return sector;
  }

  @JsonProperty("sector")
  public void setSector(TIpoSectorXmlEnum sector) {
    this.sector = sector;
  }

  /**
   **/
  public EndeudamientoActualType valorCuota(Float valorCuota) {
    this.valorCuota = valorCuota;
    return this;
  }

  
  @JsonProperty("valorCuota")
  public Float getValorCuota() {
    return valorCuota;
  }

  @JsonProperty("valorCuota")
  public void setValorCuota(Float valorCuota) {
    this.valorCuota = valorCuota;
  }

  /**
   **/
  public EndeudamientoActualType vlrOCupoInicial(Float vlrOCupoInicial) {
    this.vlrOCupoInicial = vlrOCupoInicial;
    return this;
  }

  
  @JsonProperty("vlrOCupoInicial")
  public Float getVlrOCupoInicial() {
    return vlrOCupoInicial;
  }

  @JsonProperty("vlrOCupoInicial")
  public void setVlrOCupoInicial(Float vlrOCupoInicial) {
    this.vlrOCupoInicial = vlrOCupoInicial;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EndeudamientoActualType endeudamientoActualType = (EndeudamientoActualType) o;
    return Objects.equals(this.calidad, endeudamientoActualType.calidad) &&
        Objects.equals(this.calificacion, endeudamientoActualType.calificacion) &&
        Objects.equals(this.cartera, endeudamientoActualType.cartera) &&
        Objects.equals(this.estadoEndeudamientoActual, endeudamientoActualType.estadoEndeudamientoActual) &&
        Objects.equals(this.porcentajeDeuda, endeudamientoActualType.porcentajeDeuda) &&
        Objects.equals(this.porcentajePart, endeudamientoActualType.porcentajePart) &&
        Objects.equals(this.saldoActual, endeudamientoActualType.saldoActual) &&
        Objects.equals(this.saldoEnMora, endeudamientoActualType.saldoEnMora) &&
        Objects.equals(this.sector, endeudamientoActualType.sector) &&
        Objects.equals(this.valorCuota, endeudamientoActualType.valorCuota) &&
        Objects.equals(this.vlrOCupoInicial, endeudamientoActualType.vlrOCupoInicial);
  }

  @Override
  public int hashCode() {
    return Objects.hash(calidad, calificacion, cartera, estadoEndeudamientoActual, porcentajeDeuda, porcentajePart, saldoActual, saldoEnMora, sector, valorCuota, vlrOCupoInicial);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EndeudamientoActualType {\n");
    
    sb.append("    calidad: ").append(toIndentedString(calidad)).append("\n");
    sb.append("    calificacion: ").append(toIndentedString(calificacion)).append("\n");
    sb.append("    cartera: ").append(toIndentedString(cartera)).append("\n");
    sb.append("    estadoEndeudamientoActual: ").append(toIndentedString(estadoEndeudamientoActual)).append("\n");
    sb.append("    porcentajeDeuda: ").append(toIndentedString(porcentajeDeuda)).append("\n");
    sb.append("    porcentajePart: ").append(toIndentedString(porcentajePart)).append("\n");
    sb.append("    saldoActual: ").append(toIndentedString(saldoActual)).append("\n");
    sb.append("    saldoEnMora: ").append(toIndentedString(saldoEnMora)).append("\n");
    sb.append("    sector: ").append(toIndentedString(sector)).append("\n");
    sb.append("    valorCuota: ").append(toIndentedString(valorCuota)).append("\n");
    sb.append("    vlrOCupoInicial: ").append(toIndentedString(vlrOCupoInicial)).append("\n");
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

