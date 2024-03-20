package com.mibanco.generarpdfhistorialcrediticiodetallado.us.gen.type;

import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("historialCreditoBaseArchivoXmlInput")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2024-03-01T11:27:00.249985-05:00[America/Bogota]")
public class HistorialCreditoBaseArchivoXmlInput   {
  private @Valid String rutaXml;
  private @Valid String nombreArchivoXml;

  /**
   **/
  public HistorialCreditoBaseArchivoXmlInput rutaXml(String rutaXml) {
    this.rutaXml = rutaXml;
    return this;
  }

  
  @JsonProperty("rutaXml")
  public String getRutaXml() {
    return rutaXml;
  }

  @JsonProperty("rutaXml")
  public void setRutaXml(String rutaXml) {
    this.rutaXml = rutaXml;
  }

  /**
   **/
  public HistorialCreditoBaseArchivoXmlInput nombreArchivoXml(String nombreArchivoXml) {
    this.nombreArchivoXml = nombreArchivoXml;
    return this;
  }

  
  @JsonProperty("nombreArchivoXml")
  public String getNombreArchivoXml() {
    return nombreArchivoXml;
  }

  @JsonProperty("nombreArchivoXml")
  public void setNombreArchivoXml(String nombreArchivoXml) {
    this.nombreArchivoXml = nombreArchivoXml;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HistorialCreditoBaseArchivoXmlInput historialCreditoBaseArchivoXmlInput = (HistorialCreditoBaseArchivoXmlInput) o;
    return Objects.equals(this.rutaXml, historialCreditoBaseArchivoXmlInput.rutaXml) &&
        Objects.equals(this.nombreArchivoXml, historialCreditoBaseArchivoXmlInput.nombreArchivoXml);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rutaXml, nombreArchivoXml);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HistorialCreditoBaseArchivoXmlInput {\n");
    
    sb.append("    rutaXml: ").append(toIndentedString(rutaXml)).append("\n");
    sb.append("    nombreArchivoXml: ").append(toIndentedString(nombreArchivoXml)).append("\n");
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

