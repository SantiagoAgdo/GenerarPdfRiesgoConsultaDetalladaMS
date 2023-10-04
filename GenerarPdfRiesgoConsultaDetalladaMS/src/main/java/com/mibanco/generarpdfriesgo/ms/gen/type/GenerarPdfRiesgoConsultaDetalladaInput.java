package com.mibanco.generarpdfriesgo.ms.gen.type;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.mibanco.generarpdfriesgo.ms.gen.type.CentralRiesgoType;
import com.mibanco.generarpdfriesgo.ms.gen.type.ClienteBaseType;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("generarPdfRiesgoConsultaDetalladaInput")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-10-03T17:19:31.615516-05:00[America/Bogota]")
public class GenerarPdfRiesgoConsultaDetalladaInput   {
  private @Valid ClienteBaseType cliente;
  private @Valid CentralRiesgoType centralRiesgo;

  /**
   **/
  public GenerarPdfRiesgoConsultaDetalladaInput cliente(ClienteBaseType cliente) {
    this.cliente = cliente;
    return this;
  }

  
  @JsonProperty("cliente")
  public ClienteBaseType getCliente() {
    return cliente;
  }

  @JsonProperty("cliente")
  public void setCliente(ClienteBaseType cliente) {
    this.cliente = cliente;
  }

  /**
   **/
  public GenerarPdfRiesgoConsultaDetalladaInput centralRiesgo(CentralRiesgoType centralRiesgo) {
    this.centralRiesgo = centralRiesgo;
    return this;
  }

  
  @JsonProperty("centralRiesgo")
  public CentralRiesgoType getCentralRiesgo() {
    return centralRiesgo;
  }

  @JsonProperty("centralRiesgo")
  public void setCentralRiesgo(CentralRiesgoType centralRiesgo) {
    this.centralRiesgo = centralRiesgo;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GenerarPdfRiesgoConsultaDetalladaInput generarPdfRiesgoConsultaDetalladaInput = (GenerarPdfRiesgoConsultaDetalladaInput) o;
    return Objects.equals(this.cliente, generarPdfRiesgoConsultaDetalladaInput.cliente) &&
        Objects.equals(this.centralRiesgo, generarPdfRiesgoConsultaDetalladaInput.centralRiesgo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cliente, centralRiesgo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GenerarPdfRiesgoConsultaDetalladaInput {\n");
    
    sb.append("    cliente: ").append(toIndentedString(cliente)).append("\n");
    sb.append("    centralRiesgo: ").append(toIndentedString(centralRiesgo)).append("\n");
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

