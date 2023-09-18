package com.mibanco.generarpdfriesgo.ms.gen.type;

import com.mibanco.generarpdfriesgo.ms.gen.type.TIpoSectorXmlEnum;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("DetalleResumenEndeudamientoGlobalType")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-09-18T15:36:44.386213-05:00[America/Bogota]")
public class DetalleResumenEndeudamientoGlobalType   {
  private @Valid TIpoSectorXmlEnum sector;
  private @Valid Float comercialMiles;
  private @Valid Integer comercialNumero;
  private @Valid Float hipotecarioMiles;
  private @Valid Integer hipotecarioNumero;
  private @Valid Float consumoYTarjetaCreditoMiles;
  private @Valid Integer consumoYTarjetaCreditoNumero;
  private @Valid Float microcreditoMiles;
  private @Valid Integer microcreditoNumero;
  private @Valid Float porcentajeParticipacion;

  /**
   **/
  public DetalleResumenEndeudamientoGlobalType sector(TIpoSectorXmlEnum sector) {
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
  public DetalleResumenEndeudamientoGlobalType comercialMiles(Float comercialMiles) {
    this.comercialMiles = comercialMiles;
    return this;
  }

  
  @JsonProperty("comercialMiles")
  public Float getComercialMiles() {
    return comercialMiles;
  }

  @JsonProperty("comercialMiles")
  public void setComercialMiles(Float comercialMiles) {
    this.comercialMiles = comercialMiles;
  }

  /**
   **/
  public DetalleResumenEndeudamientoGlobalType comercialNumero(Integer comercialNumero) {
    this.comercialNumero = comercialNumero;
    return this;
  }

  
  @JsonProperty("comercialNumero")
  public Integer getComercialNumero() {
    return comercialNumero;
  }

  @JsonProperty("comercialNumero")
  public void setComercialNumero(Integer comercialNumero) {
    this.comercialNumero = comercialNumero;
  }

  /**
   **/
  public DetalleResumenEndeudamientoGlobalType hipotecarioMiles(Float hipotecarioMiles) {
    this.hipotecarioMiles = hipotecarioMiles;
    return this;
  }

  
  @JsonProperty("hipotecarioMiles")
  public Float getHipotecarioMiles() {
    return hipotecarioMiles;
  }

  @JsonProperty("hipotecarioMiles")
  public void setHipotecarioMiles(Float hipotecarioMiles) {
    this.hipotecarioMiles = hipotecarioMiles;
  }

  /**
   **/
  public DetalleResumenEndeudamientoGlobalType hipotecarioNumero(Integer hipotecarioNumero) {
    this.hipotecarioNumero = hipotecarioNumero;
    return this;
  }

  
  @JsonProperty("hipotecarioNumero")
  public Integer getHipotecarioNumero() {
    return hipotecarioNumero;
  }

  @JsonProperty("hipotecarioNumero")
  public void setHipotecarioNumero(Integer hipotecarioNumero) {
    this.hipotecarioNumero = hipotecarioNumero;
  }

  /**
   **/
  public DetalleResumenEndeudamientoGlobalType consumoYTarjetaCreditoMiles(Float consumoYTarjetaCreditoMiles) {
    this.consumoYTarjetaCreditoMiles = consumoYTarjetaCreditoMiles;
    return this;
  }

  
  @JsonProperty("consumoYTarjetaCreditoMiles")
  public Float getConsumoYTarjetaCreditoMiles() {
    return consumoYTarjetaCreditoMiles;
  }

  @JsonProperty("consumoYTarjetaCreditoMiles")
  public void setConsumoYTarjetaCreditoMiles(Float consumoYTarjetaCreditoMiles) {
    this.consumoYTarjetaCreditoMiles = consumoYTarjetaCreditoMiles;
  }

  /**
   **/
  public DetalleResumenEndeudamientoGlobalType consumoYTarjetaCreditoNumero(Integer consumoYTarjetaCreditoNumero) {
    this.consumoYTarjetaCreditoNumero = consumoYTarjetaCreditoNumero;
    return this;
  }

  
  @JsonProperty("consumoYTarjetaCreditoNumero")
  public Integer getConsumoYTarjetaCreditoNumero() {
    return consumoYTarjetaCreditoNumero;
  }

  @JsonProperty("consumoYTarjetaCreditoNumero")
  public void setConsumoYTarjetaCreditoNumero(Integer consumoYTarjetaCreditoNumero) {
    this.consumoYTarjetaCreditoNumero = consumoYTarjetaCreditoNumero;
  }

  /**
   **/
  public DetalleResumenEndeudamientoGlobalType microcreditoMiles(Float microcreditoMiles) {
    this.microcreditoMiles = microcreditoMiles;
    return this;
  }

  
  @JsonProperty("microcreditoMiles")
  public Float getMicrocreditoMiles() {
    return microcreditoMiles;
  }

  @JsonProperty("microcreditoMiles")
  public void setMicrocreditoMiles(Float microcreditoMiles) {
    this.microcreditoMiles = microcreditoMiles;
  }

  /**
   **/
  public DetalleResumenEndeudamientoGlobalType microcreditoNumero(Integer microcreditoNumero) {
    this.microcreditoNumero = microcreditoNumero;
    return this;
  }

  
  @JsonProperty("microcreditoNumero")
  public Integer getMicrocreditoNumero() {
    return microcreditoNumero;
  }

  @JsonProperty("microcreditoNumero")
  public void setMicrocreditoNumero(Integer microcreditoNumero) {
    this.microcreditoNumero = microcreditoNumero;
  }

  /**
   **/
  public DetalleResumenEndeudamientoGlobalType porcentajeParticipacion(Float porcentajeParticipacion) {
    this.porcentajeParticipacion = porcentajeParticipacion;
    return this;
  }

  
  @JsonProperty("porcentajeParticipacion")
  public Float getPorcentajeParticipacion() {
    return porcentajeParticipacion;
  }

  @JsonProperty("porcentajeParticipacion")
  public void setPorcentajeParticipacion(Float porcentajeParticipacion) {
    this.porcentajeParticipacion = porcentajeParticipacion;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DetalleResumenEndeudamientoGlobalType detalleResumenEndeudamientoGlobalType = (DetalleResumenEndeudamientoGlobalType) o;
    return Objects.equals(this.sector, detalleResumenEndeudamientoGlobalType.sector) &&
        Objects.equals(this.comercialMiles, detalleResumenEndeudamientoGlobalType.comercialMiles) &&
        Objects.equals(this.comercialNumero, detalleResumenEndeudamientoGlobalType.comercialNumero) &&
        Objects.equals(this.hipotecarioMiles, detalleResumenEndeudamientoGlobalType.hipotecarioMiles) &&
        Objects.equals(this.hipotecarioNumero, detalleResumenEndeudamientoGlobalType.hipotecarioNumero) &&
        Objects.equals(this.consumoYTarjetaCreditoMiles, detalleResumenEndeudamientoGlobalType.consumoYTarjetaCreditoMiles) &&
        Objects.equals(this.consumoYTarjetaCreditoNumero, detalleResumenEndeudamientoGlobalType.consumoYTarjetaCreditoNumero) &&
        Objects.equals(this.microcreditoMiles, detalleResumenEndeudamientoGlobalType.microcreditoMiles) &&
        Objects.equals(this.microcreditoNumero, detalleResumenEndeudamientoGlobalType.microcreditoNumero) &&
        Objects.equals(this.porcentajeParticipacion, detalleResumenEndeudamientoGlobalType.porcentajeParticipacion);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sector, comercialMiles, comercialNumero, hipotecarioMiles, hipotecarioNumero, consumoYTarjetaCreditoMiles, consumoYTarjetaCreditoNumero, microcreditoMiles, microcreditoNumero, porcentajeParticipacion);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DetalleResumenEndeudamientoGlobalType {\n");
    
    sb.append("    sector: ").append(toIndentedString(sector)).append("\n");
    sb.append("    comercialMiles: ").append(toIndentedString(comercialMiles)).append("\n");
    sb.append("    comercialNumero: ").append(toIndentedString(comercialNumero)).append("\n");
    sb.append("    hipotecarioMiles: ").append(toIndentedString(hipotecarioMiles)).append("\n");
    sb.append("    hipotecarioNumero: ").append(toIndentedString(hipotecarioNumero)).append("\n");
    sb.append("    consumoYTarjetaCreditoMiles: ").append(toIndentedString(consumoYTarjetaCreditoMiles)).append("\n");
    sb.append("    consumoYTarjetaCreditoNumero: ").append(toIndentedString(consumoYTarjetaCreditoNumero)).append("\n");
    sb.append("    microcreditoMiles: ").append(toIndentedString(microcreditoMiles)).append("\n");
    sb.append("    microcreditoNumero: ").append(toIndentedString(microcreditoNumero)).append("\n");
    sb.append("    porcentajeParticipacion: ").append(toIndentedString(porcentajeParticipacion)).append("\n");
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

