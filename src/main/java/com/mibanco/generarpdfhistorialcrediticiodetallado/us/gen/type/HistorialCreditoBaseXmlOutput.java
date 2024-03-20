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



@JsonTypeName("historialCreditoBaseXmlOutput")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2024-03-01T11:27:00.249985-05:00[America/Bogota]")
public class HistorialCreditoBaseXmlOutput   {
  private @Valid byte[] informePDF;

  /**
   **/
  public HistorialCreditoBaseXmlOutput informePDF(byte[] informePDF) {
    this.informePDF = informePDF;
    return this;
  }

  
  @JsonProperty("informePDF")
  public byte[] getInformePDF() {
    return informePDF;
  }

  @JsonProperty("informePDF")
  public void setInformePDF(byte[] informePDF) {
    this.informePDF = informePDF;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HistorialCreditoBaseXmlOutput historialCreditoBaseXmlOutput = (HistorialCreditoBaseXmlOutput) o;
    return Arrays.equals(this.informePDF, historialCreditoBaseXmlOutput.informePDF);
  }

  @Override
  public int hashCode() {
    return Objects.hash(Arrays.hashCode(informePDF));
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HistorialCreditoBaseXmlOutput {\n");
    
    sb.append("    informePDF: ").append(toIndentedString(informePDF)).append("\n");
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

