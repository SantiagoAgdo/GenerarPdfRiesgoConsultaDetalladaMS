package com.mibanco.generarpdfriesgo.ms.gen.type;

import com.mibanco.generarpdfriesgo.ms.gen.type.TIpoSectorXmlEnum;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("AnalisisVectorType")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-10-06T11:07:21.204427-05:00[America/Bogota]")
public class AnalisisVectorType   {
  private @Valid TIpoSectorXmlEnum sector;
  private @Valid String entidad;
  private @Valid Integer numCuenta;
  private @Valid String tipoCuenta;
  private @Valid String estado;
  private @Valid String periodo;

  /**
   **/
  public AnalisisVectorType sector(TIpoSectorXmlEnum sector) {
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
  public AnalisisVectorType entidad(String entidad) {
    this.entidad = entidad;
    return this;
  }

  
  @JsonProperty("entidad")
  public String getEntidad() {
    return entidad;
  }

  @JsonProperty("entidad")
  public void setEntidad(String entidad) {
    this.entidad = entidad;
  }

  /**
   **/
  public AnalisisVectorType numCuenta(Integer numCuenta) {
    this.numCuenta = numCuenta;
    return this;
  }

  
  @JsonProperty("numCuenta")
  public Integer getNumCuenta() {
    return numCuenta;
  }

  @JsonProperty("numCuenta")
  public void setNumCuenta(Integer numCuenta) {
    this.numCuenta = numCuenta;
  }

  /**
   **/
  public AnalisisVectorType tipoCuenta(String tipoCuenta) {
    this.tipoCuenta = tipoCuenta;
    return this;
  }

  
  @JsonProperty("tipoCuenta")
  public String getTipoCuenta() {
    return tipoCuenta;
  }

  @JsonProperty("tipoCuenta")
  public void setTipoCuenta(String tipoCuenta) {
    this.tipoCuenta = tipoCuenta;
  }

  /**
   **/
  public AnalisisVectorType estado(String estado) {
    this.estado = estado;
    return this;
  }

  
  @JsonProperty("estado")
  public String getEstado() {
    return estado;
  }

  @JsonProperty("estado")
  public void setEstado(String estado) {
    this.estado = estado;
  }

  /**
   **/
  public AnalisisVectorType periodo(String periodo) {
    this.periodo = periodo;
    return this;
  }

  
  @JsonProperty("periodo")
  public String getPeriodo() {
    return periodo;
  }

  @JsonProperty("periodo")
  public void setPeriodo(String periodo) {
    this.periodo = periodo;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AnalisisVectorType analisisVectorType = (AnalisisVectorType) o;
    return Objects.equals(this.sector, analisisVectorType.sector) &&
        Objects.equals(this.entidad, analisisVectorType.entidad) &&
        Objects.equals(this.numCuenta, analisisVectorType.numCuenta) &&
        Objects.equals(this.tipoCuenta, analisisVectorType.tipoCuenta) &&
        Objects.equals(this.estado, analisisVectorType.estado) &&
        Objects.equals(this.periodo, analisisVectorType.periodo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sector, entidad, numCuenta, tipoCuenta, estado, periodo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AnalisisVectorType {\n");
    
    sb.append("    sector: ").append(toIndentedString(sector)).append("\n");
    sb.append("    entidad: ").append(toIndentedString(entidad)).append("\n");
    sb.append("    numCuenta: ").append(toIndentedString(numCuenta)).append("\n");
    sb.append("    tipoCuenta: ").append(toIndentedString(tipoCuenta)).append("\n");
    sb.append("    estado: ").append(toIndentedString(estado)).append("\n");
    sb.append("    periodo: ").append(toIndentedString(periodo)).append("\n");
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

