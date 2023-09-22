package com.mibanco.generarpdfriesgo.ms.gen.type;

import com.mibanco.generarpdfriesgo.ms.gen.type.EvolucionDetalleType;
import java.util.ArrayList;
import java.util.List;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("EvolucionDeudaType")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-09-22T09:11:08.374773-05:00[America/Bogota]")
public class EvolucionDeudaType   {
  private @Valid List<EvolucionDetalleType> evolucionDetalle;
  private @Valid String trimestre;

  /**
   **/
  public EvolucionDeudaType evolucionDetalle(List<EvolucionDetalleType> evolucionDetalle) {
    this.evolucionDetalle = evolucionDetalle;
    return this;
  }

  
  @JsonProperty("evolucionDetalle")
  public List<EvolucionDetalleType> getEvolucionDetalle() {
    return evolucionDetalle;
  }

  @JsonProperty("evolucionDetalle")
  public void setEvolucionDetalle(List<EvolucionDetalleType> evolucionDetalle) {
    this.evolucionDetalle = evolucionDetalle;
  }

  public EvolucionDeudaType addEvolucionDetalleItem(EvolucionDetalleType evolucionDetalleItem) {
    if (this.evolucionDetalle == null) {
      this.evolucionDetalle = new ArrayList<>();
    }

    this.evolucionDetalle.add(evolucionDetalleItem);
    return this;
  }

  public EvolucionDeudaType removeEvolucionDetalleItem(EvolucionDetalleType evolucionDetalleItem) {
    if (evolucionDetalleItem != null && this.evolucionDetalle != null) {
      this.evolucionDetalle.remove(evolucionDetalleItem);
    }

    return this;
  }
  /**
   **/
  public EvolucionDeudaType trimestre(String trimestre) {
    this.trimestre = trimestre;
    return this;
  }

  
  @JsonProperty("trimestre")
  public String getTrimestre() {
    return trimestre;
  }

  @JsonProperty("trimestre")
  public void setTrimestre(String trimestre) {
    this.trimestre = trimestre;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EvolucionDeudaType evolucionDeudaType = (EvolucionDeudaType) o;
    return Objects.equals(this.evolucionDetalle, evolucionDeudaType.evolucionDetalle) &&
        Objects.equals(this.trimestre, evolucionDeudaType.trimestre);
  }

  @Override
  public int hashCode() {
    return Objects.hash(evolucionDetalle, trimestre);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EvolucionDeudaType {\n");
    
    sb.append("    evolucionDetalle: ").append(toIndentedString(evolucionDetalle)).append("\n");
    sb.append("    trimestre: ").append(toIndentedString(trimestre)).append("\n");
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

