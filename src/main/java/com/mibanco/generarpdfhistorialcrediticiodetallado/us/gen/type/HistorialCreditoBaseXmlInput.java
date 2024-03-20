package com.mibanco.generarpdfhistorialcrediticiodetallado.us.gen.type;

import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("historialCreditoBaseXmlInput")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2024-03-01T11:27:00.249985-05:00[America/Bogota]")
public class HistorialCreditoBaseXmlInput   {
  private @Valid String consecutivo;
  private @Valid String xmlHistorial;

  /**
   **/
  public HistorialCreditoBaseXmlInput consecutivo(String consecutivo) {
    this.consecutivo = consecutivo;
    return this;
  }

  
  @JsonProperty("consecutivo")
  public String getConsecutivo() {
    return consecutivo;
  }

  @JsonProperty("consecutivo")
  public void setConsecutivo(String consecutivo) {
    this.consecutivo = consecutivo;
  }

  /**
   **/
  public HistorialCreditoBaseXmlInput xmlHistorial(String xmlHistorial) {
    this.xmlHistorial = xmlHistorial;
    return this;
  }

  
  @JsonProperty("xmlHistorial")
  public String getXmlHistorial() {
    return xmlHistorial;
  }

  @JsonProperty("xmlHistorial")
  public void setXmlHistorial(String xmlHistorial) {
    this.xmlHistorial = xmlHistorial;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HistorialCreditoBaseXmlInput historialCreditoBaseXmlInput = (HistorialCreditoBaseXmlInput) o;
    return Objects.equals(this.consecutivo, historialCreditoBaseXmlInput.consecutivo) &&
        Objects.equals(this.xmlHistorial, historialCreditoBaseXmlInput.xmlHistorial);
  }

  @Override
  public int hashCode() {
    return Objects.hash(consecutivo, xmlHistorial);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HistorialCreditoBaseXmlInput {\n");
    
    sb.append("    consecutivo: ").append(toIndentedString(consecutivo)).append("\n");
    sb.append("    xmlHistorial: ").append(toIndentedString(xmlHistorial)).append("\n");
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

