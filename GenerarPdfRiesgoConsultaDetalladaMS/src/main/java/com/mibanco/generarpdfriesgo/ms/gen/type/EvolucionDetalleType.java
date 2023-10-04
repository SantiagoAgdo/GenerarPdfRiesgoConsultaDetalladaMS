package com.mibanco.generarpdfriesgo.ms.gen.type;

import com.mibanco.generarpdfriesgo.ms.gen.type.TIpoSectorXmlEnum;
import com.mibanco.generarpdfriesgo.ms.gen.type.TipoCarteraXmlEnum;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("EvolucionDetalleType")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-10-03T17:19:31.615516-05:00[America/Bogota]")
public class EvolucionDetalleType   {
  private @Valid TIpoSectorXmlEnum sector;
  private @Valid TipoCarteraXmlEnum cartera;
  private @Valid Float cupoInicial;
  private @Valid Float saldo;
  private @Valid Float saldoEnMora;
  private @Valid Float valorCuota;
  private @Valid Float porcentajeDeuda;
  private @Valid String menorCalificacion;

  /**
   **/
  public EvolucionDetalleType sector(TIpoSectorXmlEnum sector) {
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
  public EvolucionDetalleType cartera(TipoCarteraXmlEnum cartera) {
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
  public EvolucionDetalleType cupoInicial(Float cupoInicial) {
    this.cupoInicial = cupoInicial;
    return this;
  }

  
  @JsonProperty("cupoInicial")
  public Float getCupoInicial() {
    return cupoInicial;
  }

  @JsonProperty("cupoInicial")
  public void setCupoInicial(Float cupoInicial) {
    this.cupoInicial = cupoInicial;
  }

  /**
   **/
  public EvolucionDetalleType saldo(Float saldo) {
    this.saldo = saldo;
    return this;
  }

  
  @JsonProperty("saldo")
  public Float getSaldo() {
    return saldo;
  }

  @JsonProperty("saldo")
  public void setSaldo(Float saldo) {
    this.saldo = saldo;
  }

  /**
   **/
  public EvolucionDetalleType saldoEnMora(Float saldoEnMora) {
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
  public EvolucionDetalleType valorCuota(Float valorCuota) {
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
  public EvolucionDetalleType porcentajeDeuda(Float porcentajeDeuda) {
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
  public EvolucionDetalleType menorCalificacion(String menorCalificacion) {
    this.menorCalificacion = menorCalificacion;
    return this;
  }

  
  @JsonProperty("menorCalificacion")
  public String getMenorCalificacion() {
    return menorCalificacion;
  }

  @JsonProperty("menorCalificacion")
  public void setMenorCalificacion(String menorCalificacion) {
    this.menorCalificacion = menorCalificacion;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EvolucionDetalleType evolucionDetalleType = (EvolucionDetalleType) o;
    return Objects.equals(this.sector, evolucionDetalleType.sector) &&
        Objects.equals(this.cartera, evolucionDetalleType.cartera) &&
        Objects.equals(this.cupoInicial, evolucionDetalleType.cupoInicial) &&
        Objects.equals(this.saldo, evolucionDetalleType.saldo) &&
        Objects.equals(this.saldoEnMora, evolucionDetalleType.saldoEnMora) &&
        Objects.equals(this.valorCuota, evolucionDetalleType.valorCuota) &&
        Objects.equals(this.porcentajeDeuda, evolucionDetalleType.porcentajeDeuda) &&
        Objects.equals(this.menorCalificacion, evolucionDetalleType.menorCalificacion);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sector, cartera, cupoInicial, saldo, saldoEnMora, valorCuota, porcentajeDeuda, menorCalificacion);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EvolucionDetalleType {\n");
    
    sb.append("    sector: ").append(toIndentedString(sector)).append("\n");
    sb.append("    cartera: ").append(toIndentedString(cartera)).append("\n");
    sb.append("    cupoInicial: ").append(toIndentedString(cupoInicial)).append("\n");
    sb.append("    saldo: ").append(toIndentedString(saldo)).append("\n");
    sb.append("    saldoEnMora: ").append(toIndentedString(saldoEnMora)).append("\n");
    sb.append("    valorCuota: ").append(toIndentedString(valorCuota)).append("\n");
    sb.append("    porcentajeDeuda: ").append(toIndentedString(porcentajeDeuda)).append("\n");
    sb.append("    menorCalificacion: ").append(toIndentedString(menorCalificacion)).append("\n");
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

