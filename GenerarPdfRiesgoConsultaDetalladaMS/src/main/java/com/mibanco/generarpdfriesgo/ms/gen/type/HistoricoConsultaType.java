package com.mibanco.generarpdfriesgo.ms.gen.type;

import com.mibanco.generarpdfriesgo.ms.gen.type.TipoCuentaXmlEnum;
import java.util.Date;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("HistoricoConsultaType")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-10-03T17:19:31.615516-05:00[America/Bogota]")
public class HistoricoConsultaType   {
  private @Valid String ciudad;
  private @Valid String consultanteMotivoConsulta;
  private @Valid Date fecha;
  private @Valid Integer numeroConsultas;
  private @Valid String oficina;
  private @Valid TipoCuentaXmlEnum tipoCuenta;

  /**
   **/
  public HistoricoConsultaType ciudad(String ciudad) {
    this.ciudad = ciudad;
    return this;
  }

  
  @JsonProperty("ciudad")
  public String getCiudad() {
    return ciudad;
  }

  @JsonProperty("ciudad")
  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }

  /**
   **/
  public HistoricoConsultaType consultanteMotivoConsulta(String consultanteMotivoConsulta) {
    this.consultanteMotivoConsulta = consultanteMotivoConsulta;
    return this;
  }

  
  @JsonProperty("consultanteMotivoConsulta")
  public String getConsultanteMotivoConsulta() {
    return consultanteMotivoConsulta;
  }

  @JsonProperty("consultanteMotivoConsulta")
  public void setConsultanteMotivoConsulta(String consultanteMotivoConsulta) {
    this.consultanteMotivoConsulta = consultanteMotivoConsulta;
  }

  /**
   **/
  public HistoricoConsultaType fecha(Date fecha) {
    this.fecha = fecha;
    return this;
  }

  
  @JsonProperty("fecha")
  public Date getFecha() {
    return fecha;
  }

  @JsonProperty("fecha")
  public void setFecha(Date fecha) {
    this.fecha = fecha;
  }

  /**
   **/
  public HistoricoConsultaType numeroConsultas(Integer numeroConsultas) {
    this.numeroConsultas = numeroConsultas;
    return this;
  }

  
  @JsonProperty("numeroConsultas")
  public Integer getNumeroConsultas() {
    return numeroConsultas;
  }

  @JsonProperty("numeroConsultas")
  public void setNumeroConsultas(Integer numeroConsultas) {
    this.numeroConsultas = numeroConsultas;
  }

  /**
   **/
  public HistoricoConsultaType oficina(String oficina) {
    this.oficina = oficina;
    return this;
  }

  
  @JsonProperty("oficina")
  public String getOficina() {
    return oficina;
  }

  @JsonProperty("oficina")
  public void setOficina(String oficina) {
    this.oficina = oficina;
  }

  /**
   **/
  public HistoricoConsultaType tipoCuenta(TipoCuentaXmlEnum tipoCuenta) {
    this.tipoCuenta = tipoCuenta;
    return this;
  }

  
  @JsonProperty("tipoCuenta")
  public TipoCuentaXmlEnum getTipoCuenta() {
    return tipoCuenta;
  }

  @JsonProperty("tipoCuenta")
  public void setTipoCuenta(TipoCuentaXmlEnum tipoCuenta) {
    this.tipoCuenta = tipoCuenta;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HistoricoConsultaType historicoConsultaType = (HistoricoConsultaType) o;
    return Objects.equals(this.ciudad, historicoConsultaType.ciudad) &&
        Objects.equals(this.consultanteMotivoConsulta, historicoConsultaType.consultanteMotivoConsulta) &&
        Objects.equals(this.fecha, historicoConsultaType.fecha) &&
        Objects.equals(this.numeroConsultas, historicoConsultaType.numeroConsultas) &&
        Objects.equals(this.oficina, historicoConsultaType.oficina) &&
        Objects.equals(this.tipoCuenta, historicoConsultaType.tipoCuenta);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ciudad, consultanteMotivoConsulta, fecha, numeroConsultas, oficina, tipoCuenta);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HistoricoConsultaType {\n");
    
    sb.append("    ciudad: ").append(toIndentedString(ciudad)).append("\n");
    sb.append("    consultanteMotivoConsulta: ").append(toIndentedString(consultanteMotivoConsulta)).append("\n");
    sb.append("    fecha: ").append(toIndentedString(fecha)).append("\n");
    sb.append("    numeroConsultas: ").append(toIndentedString(numeroConsultas)).append("\n");
    sb.append("    oficina: ").append(toIndentedString(oficina)).append("\n");
    sb.append("    tipoCuenta: ").append(toIndentedString(tipoCuenta)).append("\n");
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

