package com.mibanco.generarpdfhistorialcrediticiodetallado.us.gen.type;

import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.Arrays;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("historialCreditoBaseArchivoXmlOutput")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2024-03-01T11:27:00.249985-05:00[America/Bogota]")
public class HistorialCreditoBaseArchivoXmlOutput   {
  private @Valid byte[] datosBinarios;

  /**
   **/
  public HistorialCreditoBaseArchivoXmlOutput datosBinarios(byte[] datosBinarios) {
    this.datosBinarios = datosBinarios;
    return this;
  }

  
  @JsonProperty("datosBinarios")
  public byte[] getDatosBinarios() {
    return datosBinarios;
  }

  @JsonProperty("datosBinarios")
  public void setDatosBinarios(byte[] datosBinarios) {
    this.datosBinarios = datosBinarios;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HistorialCreditoBaseArchivoXmlOutput historialCreditoBaseArchivoXmlOutput = (HistorialCreditoBaseArchivoXmlOutput) o;
    return Arrays.equals(this.datosBinarios, historialCreditoBaseArchivoXmlOutput.datosBinarios);
  }

  @Override
  public int hashCode() {
    return Objects.hash(Arrays.hashCode(datosBinarios));
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HistorialCreditoBaseArchivoXmlOutput {\n");
    
    sb.append("    datosBinarios: ").append(toIndentedString(datosBinarios)).append("\n");
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

