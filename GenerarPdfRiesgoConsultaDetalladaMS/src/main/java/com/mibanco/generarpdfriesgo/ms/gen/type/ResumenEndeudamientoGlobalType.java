package com.mibanco.generarpdfriesgo.ms.gen.type;

import com.mibanco.generarpdfriesgo.ms.gen.type.DetalleResumenEndeudamientoGlobalType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("ResumenEndeudamientoGlobalType")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-09-18T15:36:44.386213-05:00[America/Bogota]")
public class ResumenEndeudamientoGlobalType   {
  private @Valid Date fechaCorte;
  private @Valid List<DetalleResumenEndeudamientoGlobalType> detalleResumenEndeudamientoGlobal;

  /**
   **/
  public ResumenEndeudamientoGlobalType fechaCorte(Date fechaCorte) {
    this.fechaCorte = fechaCorte;
    return this;
  }

  
  @JsonProperty("fechaCorte")
  public Date getFechaCorte() {
    return fechaCorte;
  }

  @JsonProperty("fechaCorte")
  public void setFechaCorte(Date fechaCorte) {
    this.fechaCorte = fechaCorte;
  }

  /**
   **/
  public ResumenEndeudamientoGlobalType detalleResumenEndeudamientoGlobal(List<DetalleResumenEndeudamientoGlobalType> detalleResumenEndeudamientoGlobal) {
    this.detalleResumenEndeudamientoGlobal = detalleResumenEndeudamientoGlobal;
    return this;
  }

  
  @JsonProperty("detalleResumenEndeudamientoGlobal")
  public List<DetalleResumenEndeudamientoGlobalType> getDetalleResumenEndeudamientoGlobal() {
    return detalleResumenEndeudamientoGlobal;
  }

  @JsonProperty("detalleResumenEndeudamientoGlobal")
  public void setDetalleResumenEndeudamientoGlobal(List<DetalleResumenEndeudamientoGlobalType> detalleResumenEndeudamientoGlobal) {
    this.detalleResumenEndeudamientoGlobal = detalleResumenEndeudamientoGlobal;
  }

  public ResumenEndeudamientoGlobalType addDetalleResumenEndeudamientoGlobalItem(DetalleResumenEndeudamientoGlobalType detalleResumenEndeudamientoGlobalItem) {
    if (this.detalleResumenEndeudamientoGlobal == null) {
      this.detalleResumenEndeudamientoGlobal = new ArrayList<>();
    }

    this.detalleResumenEndeudamientoGlobal.add(detalleResumenEndeudamientoGlobalItem);
    return this;
  }

  public ResumenEndeudamientoGlobalType removeDetalleResumenEndeudamientoGlobalItem(DetalleResumenEndeudamientoGlobalType detalleResumenEndeudamientoGlobalItem) {
    if (detalleResumenEndeudamientoGlobalItem != null && this.detalleResumenEndeudamientoGlobal != null) {
      this.detalleResumenEndeudamientoGlobal.remove(detalleResumenEndeudamientoGlobalItem);
    }

    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResumenEndeudamientoGlobalType resumenEndeudamientoGlobalType = (ResumenEndeudamientoGlobalType) o;
    return Objects.equals(this.fechaCorte, resumenEndeudamientoGlobalType.fechaCorte) &&
        Objects.equals(this.detalleResumenEndeudamientoGlobal, resumenEndeudamientoGlobalType.detalleResumenEndeudamientoGlobal);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fechaCorte, detalleResumenEndeudamientoGlobal);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResumenEndeudamientoGlobalType {\n");
    
    sb.append("    fechaCorte: ").append(toIndentedString(fechaCorte)).append("\n");
    sb.append("    detalleResumenEndeudamientoGlobal: ").append(toIndentedString(detalleResumenEndeudamientoGlobal)).append("\n");
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

