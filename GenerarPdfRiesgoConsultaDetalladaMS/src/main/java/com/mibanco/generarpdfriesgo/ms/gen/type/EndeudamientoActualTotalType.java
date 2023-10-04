package com.mibanco.generarpdfriesgo.ms.gen.type;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("EndeudamientoActualTotalType")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-10-03T17:19:31.615516-05:00[America/Bogota]")
public class EndeudamientoActualTotalType   {
  private @Valid Float porcentajeDeuda;
  private @Valid Float porcentajePart;
  private @Valid Float saldoActual;
  private @Valid Float saldoEnMora;
  private @Valid Float valorCuota;
  private @Valid Float vlrOCupoInicial;

  /**
   **/
  public EndeudamientoActualTotalType porcentajeDeuda(Float porcentajeDeuda) {
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
  public EndeudamientoActualTotalType porcentajePart(Float porcentajePart) {
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
  public EndeudamientoActualTotalType saldoActual(Float saldoActual) {
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
  public EndeudamientoActualTotalType saldoEnMora(Float saldoEnMora) {
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
  public EndeudamientoActualTotalType valorCuota(Float valorCuota) {
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
  public EndeudamientoActualTotalType vlrOCupoInicial(Float vlrOCupoInicial) {
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
    EndeudamientoActualTotalType endeudamientoActualTotalType = (EndeudamientoActualTotalType) o;
    return Objects.equals(this.porcentajeDeuda, endeudamientoActualTotalType.porcentajeDeuda) &&
        Objects.equals(this.porcentajePart, endeudamientoActualTotalType.porcentajePart) &&
        Objects.equals(this.saldoActual, endeudamientoActualTotalType.saldoActual) &&
        Objects.equals(this.saldoEnMora, endeudamientoActualTotalType.saldoEnMora) &&
        Objects.equals(this.valorCuota, endeudamientoActualTotalType.valorCuota) &&
        Objects.equals(this.vlrOCupoInicial, endeudamientoActualTotalType.vlrOCupoInicial);
  }

  @Override
  public int hashCode() {
    return Objects.hash(porcentajeDeuda, porcentajePart, saldoActual, saldoEnMora, valorCuota, vlrOCupoInicial);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EndeudamientoActualTotalType {\n");
    
    sb.append("    porcentajeDeuda: ").append(toIndentedString(porcentajeDeuda)).append("\n");
    sb.append("    porcentajePart: ").append(toIndentedString(porcentajePart)).append("\n");
    sb.append("    saldoActual: ").append(toIndentedString(saldoActual)).append("\n");
    sb.append("    saldoEnMora: ").append(toIndentedString(saldoEnMora)).append("\n");
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

