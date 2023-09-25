package com.mibanco.generarpdfriesgo.ms.gen.type;

import com.mibanco.generarpdfriesgo.ms.gen.type.TIpoSectorXmlEnum;
import java.util.Date;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("EndeudamientoGlobalType")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-09-25T09:27:07.966299400-05:00[America/Bogota]")
public class EndeudamientoGlobalType   {
  private @Valid TIpoSectorXmlEnum sector;
  private @Valid Float comercialMiles;
  private @Valid Integer comercialNumero;
  private @Valid String entidadInformante;
  private @Valid String calificacion;
  private @Valid Float hipotecarioMiles;
  private @Valid Integer hipotecarioNumero;
  private @Valid Integer numero;
  private @Valid Float consumoYTarjetaCreditoMiles;
  private @Valid Float saldoTotal;
  private @Valid Integer consumoYTarjetaCreditoNumero;
  private @Valid Float microcreditoMiles;
  private @Valid Integer microcreditoNumero;
  private @Valid String garantiaTipo;
  private @Valid Date garantiafechaAvaluo;
  private @Valid Float garantiaValor;
  private @Valid String moneda;
  private @Valid String fuente;

  /**
   **/
  public EndeudamientoGlobalType sector(TIpoSectorXmlEnum sector) {
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
  public EndeudamientoGlobalType comercialMiles(Float comercialMiles) {
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
  public EndeudamientoGlobalType comercialNumero(Integer comercialNumero) {
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
  public EndeudamientoGlobalType entidadInformante(String entidadInformante) {
    this.entidadInformante = entidadInformante;
    return this;
  }

  
  @JsonProperty("entidadInformante")
  public String getEntidadInformante() {
    return entidadInformante;
  }

  @JsonProperty("entidadInformante")
  public void setEntidadInformante(String entidadInformante) {
    this.entidadInformante = entidadInformante;
  }

  /**
   **/
  public EndeudamientoGlobalType calificacion(String calificacion) {
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
  public EndeudamientoGlobalType hipotecarioMiles(Float hipotecarioMiles) {
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
  public EndeudamientoGlobalType hipotecarioNumero(Integer hipotecarioNumero) {
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
  public EndeudamientoGlobalType numero(Integer numero) {
    this.numero = numero;
    return this;
  }

  
  @JsonProperty("numero")
  public Integer getNumero() {
    return numero;
  }

  @JsonProperty("numero")
  public void setNumero(Integer numero) {
    this.numero = numero;
  }

  /**
   **/
  public EndeudamientoGlobalType consumoYTarjetaCreditoMiles(Float consumoYTarjetaCreditoMiles) {
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
  public EndeudamientoGlobalType saldoTotal(Float saldoTotal) {
    this.saldoTotal = saldoTotal;
    return this;
  }

  
  @JsonProperty("saldoTotal")
  public Float getSaldoTotal() {
    return saldoTotal;
  }

  @JsonProperty("saldoTotal")
  public void setSaldoTotal(Float saldoTotal) {
    this.saldoTotal = saldoTotal;
  }

  /**
   **/
  public EndeudamientoGlobalType consumoYTarjetaCreditoNumero(Integer consumoYTarjetaCreditoNumero) {
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
  public EndeudamientoGlobalType microcreditoMiles(Float microcreditoMiles) {
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
  public EndeudamientoGlobalType microcreditoNumero(Integer microcreditoNumero) {
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
  public EndeudamientoGlobalType garantiaTipo(String garantiaTipo) {
    this.garantiaTipo = garantiaTipo;
    return this;
  }

  
  @JsonProperty("garantiaTipo")
  public String getGarantiaTipo() {
    return garantiaTipo;
  }

  @JsonProperty("garantiaTipo")
  public void setGarantiaTipo(String garantiaTipo) {
    this.garantiaTipo = garantiaTipo;
  }

  /**
   **/
  public EndeudamientoGlobalType garantiafechaAvaluo(Date garantiafechaAvaluo) {
    this.garantiafechaAvaluo = garantiafechaAvaluo;
    return this;
  }

  
  @JsonProperty("garantiafechaAvaluo")
  public Date getGarantiafechaAvaluo() {
    return garantiafechaAvaluo;
  }

  @JsonProperty("garantiafechaAvaluo")
  public void setGarantiafechaAvaluo(Date garantiafechaAvaluo) {
    this.garantiafechaAvaluo = garantiafechaAvaluo;
  }

  /**
   **/
  public EndeudamientoGlobalType garantiaValor(Float garantiaValor) {
    this.garantiaValor = garantiaValor;
    return this;
  }

  
  @JsonProperty("garantiaValor")
  public Float getGarantiaValor() {
    return garantiaValor;
  }

  @JsonProperty("garantiaValor")
  public void setGarantiaValor(Float garantiaValor) {
    this.garantiaValor = garantiaValor;
  }

  /**
   **/
  public EndeudamientoGlobalType moneda(String moneda) {
    this.moneda = moneda;
    return this;
  }

  
  @JsonProperty("moneda")
  public String getMoneda() {
    return moneda;
  }

  @JsonProperty("moneda")
  public void setMoneda(String moneda) {
    this.moneda = moneda;
  }

  /**
   **/
  public EndeudamientoGlobalType fuente(String fuente) {
    this.fuente = fuente;
    return this;
  }

  
  @JsonProperty("fuente")
  public String getFuente() {
    return fuente;
  }

  @JsonProperty("fuente")
  public void setFuente(String fuente) {
    this.fuente = fuente;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EndeudamientoGlobalType endeudamientoGlobalType = (EndeudamientoGlobalType) o;
    return Objects.equals(this.sector, endeudamientoGlobalType.sector) &&
        Objects.equals(this.comercialMiles, endeudamientoGlobalType.comercialMiles) &&
        Objects.equals(this.comercialNumero, endeudamientoGlobalType.comercialNumero) &&
        Objects.equals(this.entidadInformante, endeudamientoGlobalType.entidadInformante) &&
        Objects.equals(this.calificacion, endeudamientoGlobalType.calificacion) &&
        Objects.equals(this.hipotecarioMiles, endeudamientoGlobalType.hipotecarioMiles) &&
        Objects.equals(this.hipotecarioNumero, endeudamientoGlobalType.hipotecarioNumero) &&
        Objects.equals(this.numero, endeudamientoGlobalType.numero) &&
        Objects.equals(this.consumoYTarjetaCreditoMiles, endeudamientoGlobalType.consumoYTarjetaCreditoMiles) &&
        Objects.equals(this.saldoTotal, endeudamientoGlobalType.saldoTotal) &&
        Objects.equals(this.consumoYTarjetaCreditoNumero, endeudamientoGlobalType.consumoYTarjetaCreditoNumero) &&
        Objects.equals(this.microcreditoMiles, endeudamientoGlobalType.microcreditoMiles) &&
        Objects.equals(this.microcreditoNumero, endeudamientoGlobalType.microcreditoNumero) &&
        Objects.equals(this.garantiaTipo, endeudamientoGlobalType.garantiaTipo) &&
        Objects.equals(this.garantiafechaAvaluo, endeudamientoGlobalType.garantiafechaAvaluo) &&
        Objects.equals(this.garantiaValor, endeudamientoGlobalType.garantiaValor) &&
        Objects.equals(this.moneda, endeudamientoGlobalType.moneda) &&
        Objects.equals(this.fuente, endeudamientoGlobalType.fuente);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sector, comercialMiles, comercialNumero, entidadInformante, calificacion, hipotecarioMiles, hipotecarioNumero, numero, consumoYTarjetaCreditoMiles, saldoTotal, consumoYTarjetaCreditoNumero, microcreditoMiles, microcreditoNumero, garantiaTipo, garantiafechaAvaluo, garantiaValor, moneda, fuente);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EndeudamientoGlobalType {\n");
    
    sb.append("    sector: ").append(toIndentedString(sector)).append("\n");
    sb.append("    comercialMiles: ").append(toIndentedString(comercialMiles)).append("\n");
    sb.append("    comercialNumero: ").append(toIndentedString(comercialNumero)).append("\n");
    sb.append("    entidadInformante: ").append(toIndentedString(entidadInformante)).append("\n");
    sb.append("    calificacion: ").append(toIndentedString(calificacion)).append("\n");
    sb.append("    hipotecarioMiles: ").append(toIndentedString(hipotecarioMiles)).append("\n");
    sb.append("    hipotecarioNumero: ").append(toIndentedString(hipotecarioNumero)).append("\n");
    sb.append("    numero: ").append(toIndentedString(numero)).append("\n");
    sb.append("    consumoYTarjetaCreditoMiles: ").append(toIndentedString(consumoYTarjetaCreditoMiles)).append("\n");
    sb.append("    saldoTotal: ").append(toIndentedString(saldoTotal)).append("\n");
    sb.append("    consumoYTarjetaCreditoNumero: ").append(toIndentedString(consumoYTarjetaCreditoNumero)).append("\n");
    sb.append("    microcreditoMiles: ").append(toIndentedString(microcreditoMiles)).append("\n");
    sb.append("    microcreditoNumero: ").append(toIndentedString(microcreditoNumero)).append("\n");
    sb.append("    garantiaTipo: ").append(toIndentedString(garantiaTipo)).append("\n");
    sb.append("    garantiafechaAvaluo: ").append(toIndentedString(garantiafechaAvaluo)).append("\n");
    sb.append("    garantiaValor: ").append(toIndentedString(garantiaValor)).append("\n");
    sb.append("    moneda: ").append(toIndentedString(moneda)).append("\n");
    sb.append("    fuente: ").append(toIndentedString(fuente)).append("\n");
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

