package com.mibanco.generarpdfriesgo.ms.gen.type;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("HistoricoEndeudamientoType")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-11-22T11:43:13.018607800-05:00[America/Bogota]")
public class HistoricoEndeudamientoType   {
  private @Valid String resumenGeneral;
  private @Valid String bancoConDeuda;
  private @Valid String cuotasPorSector;

  /**
   **/
  public HistoricoEndeudamientoType resumenGeneral(String resumenGeneral) {
    this.resumenGeneral = resumenGeneral;
    return this;
  }

  
  @JsonProperty("resumenGeneral")
  public String getResumenGeneral() {
    return resumenGeneral;
  }

  @JsonProperty("resumenGeneral")
  public void setResumenGeneral(String resumenGeneral) {
    this.resumenGeneral = resumenGeneral;
  }

  /**
   **/
  public HistoricoEndeudamientoType bancoConDeuda(String bancoConDeuda) {
    this.bancoConDeuda = bancoConDeuda;
    return this;
  }

  
  @JsonProperty("bancoConDeuda")
  public String getBancoConDeuda() {
    return bancoConDeuda;
  }

  @JsonProperty("bancoConDeuda")
  public void setBancoConDeuda(String bancoConDeuda) {
    this.bancoConDeuda = bancoConDeuda;
  }

  /**
   **/
  public HistoricoEndeudamientoType cuotasPorSector(String cuotasPorSector) {
    this.cuotasPorSector = cuotasPorSector;
    return this;
  }

  
  @JsonProperty("cuotasPorSector")
  public String getCuotasPorSector() {
    return cuotasPorSector;
  }

  @JsonProperty("cuotasPorSector")
  public void setCuotasPorSector(String cuotasPorSector) {
    this.cuotasPorSector = cuotasPorSector;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HistoricoEndeudamientoType historicoEndeudamientoType = (HistoricoEndeudamientoType) o;
    return Objects.equals(this.resumenGeneral, historicoEndeudamientoType.resumenGeneral) &&
        Objects.equals(this.bancoConDeuda, historicoEndeudamientoType.bancoConDeuda) &&
        Objects.equals(this.cuotasPorSector, historicoEndeudamientoType.cuotasPorSector);
  }

  @Override
  public int hashCode() {
    return Objects.hash(resumenGeneral, bancoConDeuda, cuotasPorSector);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HistoricoEndeudamientoType {\n");
    
    sb.append("    resumenGeneral: ").append(toIndentedString(resumenGeneral)).append("\n");
    sb.append("    bancoConDeuda: ").append(toIndentedString(bancoConDeuda)).append("\n");
    sb.append("    cuotasPorSector: ").append(toIndentedString(cuotasPorSector)).append("\n");
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

