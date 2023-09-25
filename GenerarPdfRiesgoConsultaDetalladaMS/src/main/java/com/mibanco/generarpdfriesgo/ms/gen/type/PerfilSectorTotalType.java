package com.mibanco.generarpdfriesgo.ms.gen.type;

import com.mibanco.generarpdfriesgo.ms.gen.type.TotalSectorXmlEnum;
import java.util.Date;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("PerfilSectorTotalType")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-09-25T09:27:07.966299400-05:00[America/Bogota]")
public class PerfilSectorTotalType   {
  private @Valid Date antiguedadDesde;
  private @Valid Integer consultaUltimos6Meses;
  private @Valid Integer creditosCerrados;
  private @Valid Integer creditosReestructurados;
  private @Valid Integer creditosRefinanciados;
  private @Valid Integer creditosVigentes;
  private @Valid Integer desacuerdosVigentesAFecha;
  private @Valid TotalSectorXmlEnum totalSector;

  /**
   **/
  public PerfilSectorTotalType antiguedadDesde(Date antiguedadDesde) {
    this.antiguedadDesde = antiguedadDesde;
    return this;
  }

  
  @JsonProperty("antiguedadDesde")
  public Date getAntiguedadDesde() {
    return antiguedadDesde;
  }

  @JsonProperty("antiguedadDesde")
  public void setAntiguedadDesde(Date antiguedadDesde) {
    this.antiguedadDesde = antiguedadDesde;
  }

  /**
   **/
  public PerfilSectorTotalType consultaUltimos6Meses(Integer consultaUltimos6Meses) {
    this.consultaUltimos6Meses = consultaUltimos6Meses;
    return this;
  }

  
  @JsonProperty("consultaUltimos6Meses")
  public Integer getConsultaUltimos6Meses() {
    return consultaUltimos6Meses;
  }

  @JsonProperty("consultaUltimos6Meses")
  public void setConsultaUltimos6Meses(Integer consultaUltimos6Meses) {
    this.consultaUltimos6Meses = consultaUltimos6Meses;
  }

  /**
   **/
  public PerfilSectorTotalType creditosCerrados(Integer creditosCerrados) {
    this.creditosCerrados = creditosCerrados;
    return this;
  }

  
  @JsonProperty("creditosCerrados")
  public Integer getCreditosCerrados() {
    return creditosCerrados;
  }

  @JsonProperty("creditosCerrados")
  public void setCreditosCerrados(Integer creditosCerrados) {
    this.creditosCerrados = creditosCerrados;
  }

  /**
   **/
  public PerfilSectorTotalType creditosReestructurados(Integer creditosReestructurados) {
    this.creditosReestructurados = creditosReestructurados;
    return this;
  }

  
  @JsonProperty("creditosReestructurados")
  public Integer getCreditosReestructurados() {
    return creditosReestructurados;
  }

  @JsonProperty("creditosReestructurados")
  public void setCreditosReestructurados(Integer creditosReestructurados) {
    this.creditosReestructurados = creditosReestructurados;
  }

  /**
   **/
  public PerfilSectorTotalType creditosRefinanciados(Integer creditosRefinanciados) {
    this.creditosRefinanciados = creditosRefinanciados;
    return this;
  }

  
  @JsonProperty("creditosRefinanciados")
  public Integer getCreditosRefinanciados() {
    return creditosRefinanciados;
  }

  @JsonProperty("creditosRefinanciados")
  public void setCreditosRefinanciados(Integer creditosRefinanciados) {
    this.creditosRefinanciados = creditosRefinanciados;
  }

  /**
   **/
  public PerfilSectorTotalType creditosVigentes(Integer creditosVigentes) {
    this.creditosVigentes = creditosVigentes;
    return this;
  }

  
  @JsonProperty("creditosVigentes")
  public Integer getCreditosVigentes() {
    return creditosVigentes;
  }

  @JsonProperty("creditosVigentes")
  public void setCreditosVigentes(Integer creditosVigentes) {
    this.creditosVigentes = creditosVigentes;
  }

  /**
   **/
  public PerfilSectorTotalType desacuerdosVigentesAFecha(Integer desacuerdosVigentesAFecha) {
    this.desacuerdosVigentesAFecha = desacuerdosVigentesAFecha;
    return this;
  }

  
  @JsonProperty("desacuerdosVigentesAFecha")
  public Integer getDesacuerdosVigentesAFecha() {
    return desacuerdosVigentesAFecha;
  }

  @JsonProperty("desacuerdosVigentesAFecha")
  public void setDesacuerdosVigentesAFecha(Integer desacuerdosVigentesAFecha) {
    this.desacuerdosVigentesAFecha = desacuerdosVigentesAFecha;
  }

  /**
   **/
  public PerfilSectorTotalType totalSector(TotalSectorXmlEnum totalSector) {
    this.totalSector = totalSector;
    return this;
  }

  
  @JsonProperty("totalSector")
  public TotalSectorXmlEnum getTotalSector() {
    return totalSector;
  }

  @JsonProperty("totalSector")
  public void setTotalSector(TotalSectorXmlEnum totalSector) {
    this.totalSector = totalSector;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PerfilSectorTotalType perfilSectorTotalType = (PerfilSectorTotalType) o;
    return Objects.equals(this.antiguedadDesde, perfilSectorTotalType.antiguedadDesde) &&
        Objects.equals(this.consultaUltimos6Meses, perfilSectorTotalType.consultaUltimos6Meses) &&
        Objects.equals(this.creditosCerrados, perfilSectorTotalType.creditosCerrados) &&
        Objects.equals(this.creditosReestructurados, perfilSectorTotalType.creditosReestructurados) &&
        Objects.equals(this.creditosRefinanciados, perfilSectorTotalType.creditosRefinanciados) &&
        Objects.equals(this.creditosVigentes, perfilSectorTotalType.creditosVigentes) &&
        Objects.equals(this.desacuerdosVigentesAFecha, perfilSectorTotalType.desacuerdosVigentesAFecha) &&
        Objects.equals(this.totalSector, perfilSectorTotalType.totalSector);
  }

  @Override
  public int hashCode() {
    return Objects.hash(antiguedadDesde, consultaUltimos6Meses, creditosCerrados, creditosReestructurados, creditosRefinanciados, creditosVigentes, desacuerdosVigentesAFecha, totalSector);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PerfilSectorTotalType {\n");
    
    sb.append("    antiguedadDesde: ").append(toIndentedString(antiguedadDesde)).append("\n");
    sb.append("    consultaUltimos6Meses: ").append(toIndentedString(consultaUltimos6Meses)).append("\n");
    sb.append("    creditosCerrados: ").append(toIndentedString(creditosCerrados)).append("\n");
    sb.append("    creditosReestructurados: ").append(toIndentedString(creditosReestructurados)).append("\n");
    sb.append("    creditosRefinanciados: ").append(toIndentedString(creditosRefinanciados)).append("\n");
    sb.append("    creditosVigentes: ").append(toIndentedString(creditosVigentes)).append("\n");
    sb.append("    desacuerdosVigentesAFecha: ").append(toIndentedString(desacuerdosVigentesAFecha)).append("\n");
    sb.append("    totalSector: ").append(toIndentedString(totalSector)).append("\n");
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

