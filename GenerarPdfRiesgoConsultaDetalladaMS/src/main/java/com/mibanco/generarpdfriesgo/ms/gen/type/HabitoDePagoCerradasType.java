package com.mibanco.generarpdfriesgo.ms.gen.type;

import com.mibanco.generarpdfriesgo.ms.gen.type.EstadoObligacionXmlEnum;
import com.mibanco.generarpdfriesgo.ms.gen.type.TIpoSectorXmlEnum;
import com.mibanco.generarpdfriesgo.ms.gen.type.TipoCuentaXmlEnum;
import java.util.Date;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("HabitoDePagoCerradasType")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-09-25T09:27:07.966299400-05:00[America/Bogota]")
public class HabitoDePagoCerradasType   {
  private @Valid String _47meses;
  private @Valid Date adjetivoFecha;
  private @Valid String calificacion;
  private @Valid String ciudadFechaVencimiento;
  private @Valid String desacuerdoInformacion;
  private @Valid String entidadInformante;
  private @Valid EstadoObligacionXmlEnum estadoObligacion;
  private @Valid Date fechaApertura;
  private @Valid Date fechaCierre;
  private @Valid Integer numeroCuenta;
  private @Valid String oficinaDeudor;
  private @Valid TIpoSectorXmlEnum sector;
  private @Valid TipoCuentaXmlEnum tipoCuenta;
  private @Valid Float vrlOCupoInicial;

  /**
   **/
  public HabitoDePagoCerradasType _47meses(String _47meses) {
    this._47meses = _47meses;
    return this;
  }

  
  @JsonProperty("47meses")
  public String get47meses() {
    return _47meses;
  }

  @JsonProperty("47meses")
  public void set47meses(String _47meses) {
    this._47meses = _47meses;
  }

  /**
   **/
  public HabitoDePagoCerradasType adjetivoFecha(Date adjetivoFecha) {
    this.adjetivoFecha = adjetivoFecha;
    return this;
  }

  
  @JsonProperty("adjetivoFecha")
  public Date getAdjetivoFecha() {
    return adjetivoFecha;
  }

  @JsonProperty("adjetivoFecha")
  public void setAdjetivoFecha(Date adjetivoFecha) {
    this.adjetivoFecha = adjetivoFecha;
  }

  /**
   **/
  public HabitoDePagoCerradasType calificacion(String calificacion) {
    this.calificacion = calificacion;
    return this;
  }

  
  @JsonProperty("calificacion")
  public String getCalificacion() {
    return calificacion;
  }

  @JsonProperty("calificacion")
  public void setCalificacion(String calificacion) {
    this.calificacion = calificacion;
  }

  /**
   **/
  public HabitoDePagoCerradasType ciudadFechaVencimiento(String ciudadFechaVencimiento) {
    this.ciudadFechaVencimiento = ciudadFechaVencimiento;
    return this;
  }

  
  @JsonProperty("ciudadFechaVencimiento")
  public String getCiudadFechaVencimiento() {
    return ciudadFechaVencimiento;
  }

  @JsonProperty("ciudadFechaVencimiento")
  public void setCiudadFechaVencimiento(String ciudadFechaVencimiento) {
    this.ciudadFechaVencimiento = ciudadFechaVencimiento;
  }

  /**
   **/
  public HabitoDePagoCerradasType desacuerdoInformacion(String desacuerdoInformacion) {
    this.desacuerdoInformacion = desacuerdoInformacion;
    return this;
  }

  
  @JsonProperty("desacuerdoInformacion")
  public String getDesacuerdoInformacion() {
    return desacuerdoInformacion;
  }

  @JsonProperty("desacuerdoInformacion")
  public void setDesacuerdoInformacion(String desacuerdoInformacion) {
    this.desacuerdoInformacion = desacuerdoInformacion;
  }

  /**
   **/
  public HabitoDePagoCerradasType entidadInformante(String entidadInformante) {
    this.entidadInformante = entidadInformante;
    return this;
  }

  
  @JsonProperty("entidadInformante")
  public String getEntidadInformante() {
    return entidadInformante;
  }

  @JsonProperty("entidadInformante")
  public void setEntidadInformante(String entidadInformante) {
    this.entidadInformante = entidadInformante;
  }

  /**
   **/
  public HabitoDePagoCerradasType estadoObligacion(EstadoObligacionXmlEnum estadoObligacion) {
    this.estadoObligacion = estadoObligacion;
    return this;
  }

  
  @JsonProperty("estadoObligacion")
  public EstadoObligacionXmlEnum getEstadoObligacion() {
    return estadoObligacion;
  }

  @JsonProperty("estadoObligacion")
  public void setEstadoObligacion(EstadoObligacionXmlEnum estadoObligacion) {
    this.estadoObligacion = estadoObligacion;
  }

  /**
   **/
  public HabitoDePagoCerradasType fechaApertura(Date fechaApertura) {
    this.fechaApertura = fechaApertura;
    return this;
  }

  
  @JsonProperty("fechaApertura")
  public Date getFechaApertura() {
    return fechaApertura;
  }

  @JsonProperty("fechaApertura")
  public void setFechaApertura(Date fechaApertura) {
    this.fechaApertura = fechaApertura;
  }

  /**
   **/
  public HabitoDePagoCerradasType fechaCierre(Date fechaCierre) {
    this.fechaCierre = fechaCierre;
    return this;
  }

  
  @JsonProperty("fechaCierre")
  public Date getFechaCierre() {
    return fechaCierre;
  }

  @JsonProperty("fechaCierre")
  public void setFechaCierre(Date fechaCierre) {
    this.fechaCierre = fechaCierre;
  }

  /**
   **/
  public HabitoDePagoCerradasType numeroCuenta(Integer numeroCuenta) {
    this.numeroCuenta = numeroCuenta;
    return this;
  }

  
  @JsonProperty("numeroCuenta")
  public Integer getNumeroCuenta() {
    return numeroCuenta;
  }

  @JsonProperty("numeroCuenta")
  public void setNumeroCuenta(Integer numeroCuenta) {
    this.numeroCuenta = numeroCuenta;
  }

  /**
   **/
  public HabitoDePagoCerradasType oficinaDeudor(String oficinaDeudor) {
    this.oficinaDeudor = oficinaDeudor;
    return this;
  }

  
  @JsonProperty("oficinaDeudor")
  public String getOficinaDeudor() {
    return oficinaDeudor;
  }

  @JsonProperty("oficinaDeudor")
  public void setOficinaDeudor(String oficinaDeudor) {
    this.oficinaDeudor = oficinaDeudor;
  }

  /**
   **/
  public HabitoDePagoCerradasType sector(TIpoSectorXmlEnum sector) {
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
  public HabitoDePagoCerradasType tipoCuenta(TipoCuentaXmlEnum tipoCuenta) {
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

  /**
   **/
  public HabitoDePagoCerradasType vrlOCupoInicial(Float vrlOCupoInicial) {
    this.vrlOCupoInicial = vrlOCupoInicial;
    return this;
  }

  
  @JsonProperty("vrlOCupoInicial")
  public Float getVrlOCupoInicial() {
    return vrlOCupoInicial;
  }

  @JsonProperty("vrlOCupoInicial")
  public void setVrlOCupoInicial(Float vrlOCupoInicial) {
    this.vrlOCupoInicial = vrlOCupoInicial;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HabitoDePagoCerradasType habitoDePagoCerradasType = (HabitoDePagoCerradasType) o;
    return Objects.equals(this._47meses, habitoDePagoCerradasType._47meses) &&
        Objects.equals(this.adjetivoFecha, habitoDePagoCerradasType.adjetivoFecha) &&
        Objects.equals(this.calificacion, habitoDePagoCerradasType.calificacion) &&
        Objects.equals(this.ciudadFechaVencimiento, habitoDePagoCerradasType.ciudadFechaVencimiento) &&
        Objects.equals(this.desacuerdoInformacion, habitoDePagoCerradasType.desacuerdoInformacion) &&
        Objects.equals(this.entidadInformante, habitoDePagoCerradasType.entidadInformante) &&
        Objects.equals(this.estadoObligacion, habitoDePagoCerradasType.estadoObligacion) &&
        Objects.equals(this.fechaApertura, habitoDePagoCerradasType.fechaApertura) &&
        Objects.equals(this.fechaCierre, habitoDePagoCerradasType.fechaCierre) &&
        Objects.equals(this.numeroCuenta, habitoDePagoCerradasType.numeroCuenta) &&
        Objects.equals(this.oficinaDeudor, habitoDePagoCerradasType.oficinaDeudor) &&
        Objects.equals(this.sector, habitoDePagoCerradasType.sector) &&
        Objects.equals(this.tipoCuenta, habitoDePagoCerradasType.tipoCuenta) &&
        Objects.equals(this.vrlOCupoInicial, habitoDePagoCerradasType.vrlOCupoInicial);
  }

  @Override
  public int hashCode() {
    return Objects.hash(_47meses, adjetivoFecha, calificacion, ciudadFechaVencimiento, desacuerdoInformacion, entidadInformante, estadoObligacion, fechaApertura, fechaCierre, numeroCuenta, oficinaDeudor, sector, tipoCuenta, vrlOCupoInicial);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HabitoDePagoCerradasType {\n");
    
    sb.append("    _47meses: ").append(toIndentedString(_47meses)).append("\n");
    sb.append("    adjetivoFecha: ").append(toIndentedString(adjetivoFecha)).append("\n");
    sb.append("    calificacion: ").append(toIndentedString(calificacion)).append("\n");
    sb.append("    ciudadFechaVencimiento: ").append(toIndentedString(ciudadFechaVencimiento)).append("\n");
    sb.append("    desacuerdoInformacion: ").append(toIndentedString(desacuerdoInformacion)).append("\n");
    sb.append("    entidadInformante: ").append(toIndentedString(entidadInformante)).append("\n");
    sb.append("    estadoObligacion: ").append(toIndentedString(estadoObligacion)).append("\n");
    sb.append("    fechaApertura: ").append(toIndentedString(fechaApertura)).append("\n");
    sb.append("    fechaCierre: ").append(toIndentedString(fechaCierre)).append("\n");
    sb.append("    numeroCuenta: ").append(toIndentedString(numeroCuenta)).append("\n");
    sb.append("    oficinaDeudor: ").append(toIndentedString(oficinaDeudor)).append("\n");
    sb.append("    sector: ").append(toIndentedString(sector)).append("\n");
    sb.append("    tipoCuenta: ").append(toIndentedString(tipoCuenta)).append("\n");
    sb.append("    vrlOCupoInicial: ").append(toIndentedString(vrlOCupoInicial)).append("\n");
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

