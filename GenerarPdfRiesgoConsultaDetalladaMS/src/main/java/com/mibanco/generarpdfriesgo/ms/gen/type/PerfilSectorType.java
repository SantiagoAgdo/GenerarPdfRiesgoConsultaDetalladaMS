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



@JsonTypeName("PerfilSectorType")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-09-22T09:11:08.374773-05:00[America/Bogota]")
public class PerfilSectorType   {
  private @Valid Date antiguedadDesde;
  private @Valid Integer consultaUltimos6Meses;
  private @Valid Integer creditosCerrados;
  private @Valid Integer creditosReestructurados;
  private @Valid Integer creditosRefinanciados;
  private @Valid Integer creditosVigentes;
  private @Valid Integer desacuerdosVigentesAFecha;
  private @Valid TIpoSectorXmlEnum sector;

  /**
   **/
  public PerfilSectorType antiguedadDesde(Date antiguedadDesde) {
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
  public PerfilSectorType consultaUltimos6Meses(Integer consultaUltimos6Meses) {
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
  public PerfilSectorType creditosCerrados(Integer creditosCerrados) {
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
  public PerfilSectorType creditosReestructurados(Integer creditosReestructurados) {
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
  public PerfilSectorType creditosRefinanciados(Integer creditosRefinanciados) {
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
  public PerfilSectorType creditosVigentes(Integer creditosVigentes) {
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
  public PerfilSectorType desacuerdosVigentesAFecha(Integer desacuerdosVigentesAFecha) {
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
  public PerfilSectorType sector(TIpoSectorXmlEnum sector) {
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PerfilSectorType perfilSectorType = (PerfilSectorType) o;
    return Objects.equals(this.antiguedadDesde, perfilSectorType.antiguedadDesde) &&
        Objects.equals(this.consultaUltimos6Meses, perfilSectorType.consultaUltimos6Meses) &&
        Objects.equals(this.creditosCerrados, perfilSectorType.creditosCerrados) &&
        Objects.equals(this.creditosReestructurados, perfilSectorType.creditosReestructurados) &&
        Objects.equals(this.creditosRefinanciados, perfilSectorType.creditosRefinanciados) &&
        Objects.equals(this.creditosVigentes, perfilSectorType.creditosVigentes) &&
        Objects.equals(this.desacuerdosVigentesAFecha, perfilSectorType.desacuerdosVigentesAFecha) &&
        Objects.equals(this.sector, perfilSectorType.sector);
  }

  @Override
  public int hashCode() {
    return Objects.hash(antiguedadDesde, consultaUltimos6Meses, creditosCerrados, creditosReestructurados, creditosRefinanciados, creditosVigentes, desacuerdosVigentesAFecha, sector);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PerfilSectorType {\n");
    
    sb.append("    antiguedadDesde: ").append(toIndentedString(antiguedadDesde)).append("\n");
    sb.append("    consultaUltimos6Meses: ").append(toIndentedString(consultaUltimos6Meses)).append("\n");
    sb.append("    creditosCerrados: ").append(toIndentedString(creditosCerrados)).append("\n");
    sb.append("    creditosReestructurados: ").append(toIndentedString(creditosReestructurados)).append("\n");
    sb.append("    creditosRefinanciados: ").append(toIndentedString(creditosRefinanciados)).append("\n");
    sb.append("    creditosVigentes: ").append(toIndentedString(creditosVigentes)).append("\n");
    sb.append("    desacuerdosVigentesAFecha: ").append(toIndentedString(desacuerdosVigentesAFecha)).append("\n");
    sb.append("    sector: ").append(toIndentedString(sector)).append("\n");
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

