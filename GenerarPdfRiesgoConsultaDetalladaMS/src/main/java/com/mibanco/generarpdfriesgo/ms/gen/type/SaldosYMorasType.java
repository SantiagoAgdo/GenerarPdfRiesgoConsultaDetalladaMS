package com.mibanco.generarpdfriesgo.ms.gen.type;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("SaldosYMorasType")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-11-22T11:43:13.018607800-05:00[America/Bogota]")
public class SaldosYMorasType   {
  private @Valid String morasMaxSectorReal;
  private @Valid String morasMaxSectorTelcos;
  private @Valid Float numCreditosConMoraIgual30Dias;
  private @Valid Float numCreditosConMoraIMayorOIgual60Dias;
  private @Valid String periodoSaldoYMoras;
  private @Valid Float saldoDeudaTotal;
  private @Valid Float saldoDeudaTotalEnMora;
  private @Valid String totalMorasMaximas;

  /**
   **/
  public SaldosYMorasType morasMaxSectorReal(String morasMaxSectorReal) {
    this.morasMaxSectorReal = morasMaxSectorReal;
    return this;
  }

  
  @JsonProperty("morasMaxSectorReal")
  public String getMorasMaxSectorReal() {
    return morasMaxSectorReal;
  }

  @JsonProperty("morasMaxSectorReal")
  public void setMorasMaxSectorReal(String morasMaxSectorReal) {
    this.morasMaxSectorReal = morasMaxSectorReal;
  }

  /**
   **/
  public SaldosYMorasType morasMaxSectorTelcos(String morasMaxSectorTelcos) {
    this.morasMaxSectorTelcos = morasMaxSectorTelcos;
    return this;
  }

  
  @JsonProperty("morasMaxSectorTelcos")
  public String getMorasMaxSectorTelcos() {
    return morasMaxSectorTelcos;
  }

  @JsonProperty("morasMaxSectorTelcos")
  public void setMorasMaxSectorTelcos(String morasMaxSectorTelcos) {
    this.morasMaxSectorTelcos = morasMaxSectorTelcos;
  }

  /**
   **/
  public SaldosYMorasType numCreditosConMoraIgual30Dias(Float numCreditosConMoraIgual30Dias) {
    this.numCreditosConMoraIgual30Dias = numCreditosConMoraIgual30Dias;
    return this;
  }

  
  @JsonProperty("numCreditosConMoraIgual30Dias")
  public Float getNumCreditosConMoraIgual30Dias() {
    return numCreditosConMoraIgual30Dias;
  }

  @JsonProperty("numCreditosConMoraIgual30Dias")
  public void setNumCreditosConMoraIgual30Dias(Float numCreditosConMoraIgual30Dias) {
    this.numCreditosConMoraIgual30Dias = numCreditosConMoraIgual30Dias;
  }

  /**
   **/
  public SaldosYMorasType numCreditosConMoraIMayorOIgual60Dias(Float numCreditosConMoraIMayorOIgual60Dias) {
    this.numCreditosConMoraIMayorOIgual60Dias = numCreditosConMoraIMayorOIgual60Dias;
    return this;
  }

  
  @JsonProperty("numCreditosConMoraIMayorOIgual60Dias")
  public Float getNumCreditosConMoraIMayorOIgual60Dias() {
    return numCreditosConMoraIMayorOIgual60Dias;
  }

  @JsonProperty("numCreditosConMoraIMayorOIgual60Dias")
  public void setNumCreditosConMoraIMayorOIgual60Dias(Float numCreditosConMoraIMayorOIgual60Dias) {
    this.numCreditosConMoraIMayorOIgual60Dias = numCreditosConMoraIMayorOIgual60Dias;
  }

  /**
   **/
  public SaldosYMorasType periodoSaldoYMoras(String periodoSaldoYMoras) {
    this.periodoSaldoYMoras = periodoSaldoYMoras;
    return this;
  }

  
  @JsonProperty("periodoSaldoYMoras")
  public String getPeriodoSaldoYMoras() {
    return periodoSaldoYMoras;
  }

  @JsonProperty("periodoSaldoYMoras")
  public void setPeriodoSaldoYMoras(String periodoSaldoYMoras) {
    this.periodoSaldoYMoras = periodoSaldoYMoras;
  }

  /**
   **/
  public SaldosYMorasType saldoDeudaTotal(Float saldoDeudaTotal) {
    this.saldoDeudaTotal = saldoDeudaTotal;
    return this;
  }

  
  @JsonProperty("saldoDeudaTotal")
  public Float getSaldoDeudaTotal() {
    return saldoDeudaTotal;
  }

  @JsonProperty("saldoDeudaTotal")
  public void setSaldoDeudaTotal(Float saldoDeudaTotal) {
    this.saldoDeudaTotal = saldoDeudaTotal;
  }

  /**
   **/
  public SaldosYMorasType saldoDeudaTotalEnMora(Float saldoDeudaTotalEnMora) {
    this.saldoDeudaTotalEnMora = saldoDeudaTotalEnMora;
    return this;
  }

  
  @JsonProperty("saldoDeudaTotalEnMora")
  public Float getSaldoDeudaTotalEnMora() {
    return saldoDeudaTotalEnMora;
  }

  @JsonProperty("saldoDeudaTotalEnMora")
  public void setSaldoDeudaTotalEnMora(Float saldoDeudaTotalEnMora) {
    this.saldoDeudaTotalEnMora = saldoDeudaTotalEnMora;
  }

  /**
   **/
  public SaldosYMorasType totalMorasMaximas(String totalMorasMaximas) {
    this.totalMorasMaximas = totalMorasMaximas;
    return this;
  }

  
  @JsonProperty("totalMorasMaximas")
  public String getTotalMorasMaximas() {
    return totalMorasMaximas;
  }

  @JsonProperty("totalMorasMaximas")
  public void setTotalMorasMaximas(String totalMorasMaximas) {
    this.totalMorasMaximas = totalMorasMaximas;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SaldosYMorasType saldosYMorasType = (SaldosYMorasType) o;
    return Objects.equals(this.morasMaxSectorReal, saldosYMorasType.morasMaxSectorReal) &&
        Objects.equals(this.morasMaxSectorTelcos, saldosYMorasType.morasMaxSectorTelcos) &&
        Objects.equals(this.numCreditosConMoraIgual30Dias, saldosYMorasType.numCreditosConMoraIgual30Dias) &&
        Objects.equals(this.numCreditosConMoraIMayorOIgual60Dias, saldosYMorasType.numCreditosConMoraIMayorOIgual60Dias) &&
        Objects.equals(this.periodoSaldoYMoras, saldosYMorasType.periodoSaldoYMoras) &&
        Objects.equals(this.saldoDeudaTotal, saldosYMorasType.saldoDeudaTotal) &&
        Objects.equals(this.saldoDeudaTotalEnMora, saldosYMorasType.saldoDeudaTotalEnMora) &&
        Objects.equals(this.totalMorasMaximas, saldosYMorasType.totalMorasMaximas);
  }

  @Override
  public int hashCode() {
    return Objects.hash(morasMaxSectorReal, morasMaxSectorTelcos, numCreditosConMoraIgual30Dias, numCreditosConMoraIMayorOIgual60Dias, periodoSaldoYMoras, saldoDeudaTotal, saldoDeudaTotalEnMora, totalMorasMaximas);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SaldosYMorasType {\n");
    
    sb.append("    morasMaxSectorReal: ").append(toIndentedString(morasMaxSectorReal)).append("\n");
    sb.append("    morasMaxSectorTelcos: ").append(toIndentedString(morasMaxSectorTelcos)).append("\n");
    sb.append("    numCreditosConMoraIgual30Dias: ").append(toIndentedString(numCreditosConMoraIgual30Dias)).append("\n");
    sb.append("    numCreditosConMoraIMayorOIgual60Dias: ").append(toIndentedString(numCreditosConMoraIMayorOIgual60Dias)).append("\n");
    sb.append("    periodoSaldoYMoras: ").append(toIndentedString(periodoSaldoYMoras)).append("\n");
    sb.append("    saldoDeudaTotal: ").append(toIndentedString(saldoDeudaTotal)).append("\n");
    sb.append("    saldoDeudaTotalEnMora: ").append(toIndentedString(saldoDeudaTotalEnMora)).append("\n");
    sb.append("    totalMorasMaximas: ").append(toIndentedString(totalMorasMaximas)).append("\n");
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

