package com.mibanco.generarpdfriesgo.ms.gen.type;

import com.mibanco.generarpdfriesgo.ms.gen.type.EstadoObligacionXmlEnum;
import com.mibanco.generarpdfriesgo.ms.gen.type.TIpoSectorXmlEnum;
import com.mibanco.generarpdfriesgo.ms.gen.type.TipoCuentaXmlEnum;
import com.mibanco.generarpdfriesgo.ms.gen.type.TipoGarantiaXmlEnum;
import com.mibanco.generarpdfriesgo.ms.gen.type.TipoMarcaClaseXmlEnum;
import java.util.Date;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("HabitoDePagoAbiertasType")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-09-25T09:27:07.966299400-05:00[America/Bogota]")
public class HabitoDePagoAbiertasType   {
  private @Valid String _47meses;
  private @Valid Date adjetivoFecha;
  private @Valid String calificacion;
  private @Valid String cuotasMVigencia;
  private @Valid String desacuerdoInformacion;
  private @Valid String entidadInformante;
  private @Valid EstadoObligacionXmlEnum estadoObligacion;
  private @Valid String estadoTitular;
  private @Valid Date fechaActualizacion;
  private @Valid Date fechaApertura;
  private @Valid Date fechaLimitePago;
  private @Valid Date fechaPago;
  private @Valid Date fechaVencimiento;
  private @Valid TipoMarcaClaseXmlEnum marcaClase;
  private @Valid String moraMaxima;
  private @Valid Integer numeroCuenta;
  private @Valid Integer numeroChequeDevueltos;
  private @Valid String oficinaDeudor;
  private @Valid Integer perm;
  private @Valid Float porcentajeDeuda;
  private @Valid Float saldoActual;
  private @Valid Float saldoMora;
  private @Valid TIpoSectorXmlEnum sector;
  private @Valid TipoCuentaXmlEnum tipoCuenta;
  private @Valid TipoGarantiaXmlEnum tipoGarantia;
  private @Valid Float valorCuota;
  private @Valid Float vrlOcupoInicial;

  /**
   **/
  public HabitoDePagoAbiertasType _47meses(String _47meses) {
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
  public HabitoDePagoAbiertasType adjetivoFecha(Date adjetivoFecha) {
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
  public HabitoDePagoAbiertasType calificacion(String calificacion) {
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
  public HabitoDePagoAbiertasType cuotasMVigencia(String cuotasMVigencia) {
    this.cuotasMVigencia = cuotasMVigencia;
    return this;
  }

  
  @JsonProperty("cuotasMVigencia")
  public String getCuotasMVigencia() {
    return cuotasMVigencia;
  }

  @JsonProperty("cuotasMVigencia")
  public void setCuotasMVigencia(String cuotasMVigencia) {
    this.cuotasMVigencia = cuotasMVigencia;
  }

  /**
   **/
  public HabitoDePagoAbiertasType desacuerdoInformacion(String desacuerdoInformacion) {
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
  public HabitoDePagoAbiertasType entidadInformante(String entidadInformante) {
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
  public HabitoDePagoAbiertasType estadoObligacion(EstadoObligacionXmlEnum estadoObligacion) {
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
  public HabitoDePagoAbiertasType estadoTitular(String estadoTitular) {
    this.estadoTitular = estadoTitular;
    return this;
  }

  
  @JsonProperty("estadoTitular")
  public String getEstadoTitular() {
    return estadoTitular;
  }

  @JsonProperty("estadoTitular")
  public void setEstadoTitular(String estadoTitular) {
    this.estadoTitular = estadoTitular;
  }

  /**
   **/
  public HabitoDePagoAbiertasType fechaActualizacion(Date fechaActualizacion) {
    this.fechaActualizacion = fechaActualizacion;
    return this;
  }

  
  @JsonProperty("fechaActualizacion")
  public Date getFechaActualizacion() {
    return fechaActualizacion;
  }

  @JsonProperty("fechaActualizacion")
  public void setFechaActualizacion(Date fechaActualizacion) {
    this.fechaActualizacion = fechaActualizacion;
  }

  /**
   **/
  public HabitoDePagoAbiertasType fechaApertura(Date fechaApertura) {
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
  public HabitoDePagoAbiertasType fechaLimitePago(Date fechaLimitePago) {
    this.fechaLimitePago = fechaLimitePago;
    return this;
  }

  
  @JsonProperty("fechaLimitePago")
  public Date getFechaLimitePago() {
    return fechaLimitePago;
  }

  @JsonProperty("fechaLimitePago")
  public void setFechaLimitePago(Date fechaLimitePago) {
    this.fechaLimitePago = fechaLimitePago;
  }

  /**
   **/
  public HabitoDePagoAbiertasType fechaPago(Date fechaPago) {
    this.fechaPago = fechaPago;
    return this;
  }

  
  @JsonProperty("fechaPago")
  public Date getFechaPago() {
    return fechaPago;
  }

  @JsonProperty("fechaPago")
  public void setFechaPago(Date fechaPago) {
    this.fechaPago = fechaPago;
  }

  /**
   **/
  public HabitoDePagoAbiertasType fechaVencimiento(Date fechaVencimiento) {
    this.fechaVencimiento = fechaVencimiento;
    return this;
  }

  
  @JsonProperty("fechaVencimiento")
  public Date getFechaVencimiento() {
    return fechaVencimiento;
  }

  @JsonProperty("fechaVencimiento")
  public void setFechaVencimiento(Date fechaVencimiento) {
    this.fechaVencimiento = fechaVencimiento;
  }

  /**
   **/
  public HabitoDePagoAbiertasType marcaClase(TipoMarcaClaseXmlEnum marcaClase) {
    this.marcaClase = marcaClase;
    return this;
  }

  
  @JsonProperty("marcaClase")
  public TipoMarcaClaseXmlEnum getMarcaClase() {
    return marcaClase;
  }

  @JsonProperty("marcaClase")
  public void setMarcaClase(TipoMarcaClaseXmlEnum marcaClase) {
    this.marcaClase = marcaClase;
  }

  /**
   **/
  public HabitoDePagoAbiertasType moraMaxima(String moraMaxima) {
    this.moraMaxima = moraMaxima;
    return this;
  }

  
  @JsonProperty("moraMaxima")
  public String getMoraMaxima() {
    return moraMaxima;
  }

  @JsonProperty("moraMaxima")
  public void setMoraMaxima(String moraMaxima) {
    this.moraMaxima = moraMaxima;
  }

  /**
   **/
  public HabitoDePagoAbiertasType numeroCuenta(Integer numeroCuenta) {
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
  public HabitoDePagoAbiertasType numeroChequeDevueltos(Integer numeroChequeDevueltos) {
    this.numeroChequeDevueltos = numeroChequeDevueltos;
    return this;
  }

  
  @JsonProperty("numeroChequeDevueltos")
  public Integer getNumeroChequeDevueltos() {
    return numeroChequeDevueltos;
  }

  @JsonProperty("numeroChequeDevueltos")
  public void setNumeroChequeDevueltos(Integer numeroChequeDevueltos) {
    this.numeroChequeDevueltos = numeroChequeDevueltos;
  }

  /**
   **/
  public HabitoDePagoAbiertasType oficinaDeudor(String oficinaDeudor) {
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
  public HabitoDePagoAbiertasType perm(Integer perm) {
    this.perm = perm;
    return this;
  }

  
  @JsonProperty("perm")
  public Integer getPerm() {
    return perm;
  }

  @JsonProperty("perm")
  public void setPerm(Integer perm) {
    this.perm = perm;
  }

  /**
   **/
  public HabitoDePagoAbiertasType porcentajeDeuda(Float porcentajeDeuda) {
    this.porcentajeDeuda = porcentajeDeuda;
    return this;
  }

  
  @JsonProperty("porcentajeDeuda")
  public Float getPorcentajeDeuda() {
    return porcentajeDeuda;
  }

  @JsonProperty("porcentajeDeuda")
  public void setPorcentajeDeuda(Float porcentajeDeuda) {
    this.porcentajeDeuda = porcentajeDeuda;
  }

  /**
   **/
  public HabitoDePagoAbiertasType saldoActual(Float saldoActual) {
    this.saldoActual = saldoActual;
    return this;
  }

  
  @JsonProperty("saldoActual")
  public Float getSaldoActual() {
    return saldoActual;
  }

  @JsonProperty("saldoActual")
  public void setSaldoActual(Float saldoActual) {
    this.saldoActual = saldoActual;
  }

  /**
   **/
  public HabitoDePagoAbiertasType saldoMora(Float saldoMora) {
    this.saldoMora = saldoMora;
    return this;
  }

  
  @JsonProperty("saldoMora")
  public Float getSaldoMora() {
    return saldoMora;
  }

  @JsonProperty("saldoMora")
  public void setSaldoMora(Float saldoMora) {
    this.saldoMora = saldoMora;
  }

  /**
   **/
  public HabitoDePagoAbiertasType sector(TIpoSectorXmlEnum sector) {
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
  public HabitoDePagoAbiertasType tipoCuenta(TipoCuentaXmlEnum tipoCuenta) {
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
  public HabitoDePagoAbiertasType tipoGarantia(TipoGarantiaXmlEnum tipoGarantia) {
    this.tipoGarantia = tipoGarantia;
    return this;
  }

  
  @JsonProperty("tipoGarantia")
  public TipoGarantiaXmlEnum getTipoGarantia() {
    return tipoGarantia;
  }

  @JsonProperty("tipoGarantia")
  public void setTipoGarantia(TipoGarantiaXmlEnum tipoGarantia) {
    this.tipoGarantia = tipoGarantia;
  }

  /**
   **/
  public HabitoDePagoAbiertasType valorCuota(Float valorCuota) {
    this.valorCuota = valorCuota;
    return this;
  }

  
  @JsonProperty("valorCuota")
  public Float getValorCuota() {
    return valorCuota;
  }

  @JsonProperty("valorCuota")
  public void setValorCuota(Float valorCuota) {
    this.valorCuota = valorCuota;
  }

  /**
   **/
  public HabitoDePagoAbiertasType vrlOcupoInicial(Float vrlOcupoInicial) {
    this.vrlOcupoInicial = vrlOcupoInicial;
    return this;
  }

  
  @JsonProperty("vrlOcupoInicial")
  public Float getVrlOcupoInicial() {
    return vrlOcupoInicial;
  }

  @JsonProperty("vrlOcupoInicial")
  public void setVrlOcupoInicial(Float vrlOcupoInicial) {
    this.vrlOcupoInicial = vrlOcupoInicial;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HabitoDePagoAbiertasType habitoDePagoAbiertasType = (HabitoDePagoAbiertasType) o;
    return Objects.equals(this._47meses, habitoDePagoAbiertasType._47meses) &&
        Objects.equals(this.adjetivoFecha, habitoDePagoAbiertasType.adjetivoFecha) &&
        Objects.equals(this.calificacion, habitoDePagoAbiertasType.calificacion) &&
        Objects.equals(this.cuotasMVigencia, habitoDePagoAbiertasType.cuotasMVigencia) &&
        Objects.equals(this.desacuerdoInformacion, habitoDePagoAbiertasType.desacuerdoInformacion) &&
        Objects.equals(this.entidadInformante, habitoDePagoAbiertasType.entidadInformante) &&
        Objects.equals(this.estadoObligacion, habitoDePagoAbiertasType.estadoObligacion) &&
        Objects.equals(this.estadoTitular, habitoDePagoAbiertasType.estadoTitular) &&
        Objects.equals(this.fechaActualizacion, habitoDePagoAbiertasType.fechaActualizacion) &&
        Objects.equals(this.fechaApertura, habitoDePagoAbiertasType.fechaApertura) &&
        Objects.equals(this.fechaLimitePago, habitoDePagoAbiertasType.fechaLimitePago) &&
        Objects.equals(this.fechaPago, habitoDePagoAbiertasType.fechaPago) &&
        Objects.equals(this.fechaVencimiento, habitoDePagoAbiertasType.fechaVencimiento) &&
        Objects.equals(this.marcaClase, habitoDePagoAbiertasType.marcaClase) &&
        Objects.equals(this.moraMaxima, habitoDePagoAbiertasType.moraMaxima) &&
        Objects.equals(this.numeroCuenta, habitoDePagoAbiertasType.numeroCuenta) &&
        Objects.equals(this.numeroChequeDevueltos, habitoDePagoAbiertasType.numeroChequeDevueltos) &&
        Objects.equals(this.oficinaDeudor, habitoDePagoAbiertasType.oficinaDeudor) &&
        Objects.equals(this.perm, habitoDePagoAbiertasType.perm) &&
        Objects.equals(this.porcentajeDeuda, habitoDePagoAbiertasType.porcentajeDeuda) &&
        Objects.equals(this.saldoActual, habitoDePagoAbiertasType.saldoActual) &&
        Objects.equals(this.saldoMora, habitoDePagoAbiertasType.saldoMora) &&
        Objects.equals(this.sector, habitoDePagoAbiertasType.sector) &&
        Objects.equals(this.tipoCuenta, habitoDePagoAbiertasType.tipoCuenta) &&
        Objects.equals(this.tipoGarantia, habitoDePagoAbiertasType.tipoGarantia) &&
        Objects.equals(this.valorCuota, habitoDePagoAbiertasType.valorCuota) &&
        Objects.equals(this.vrlOcupoInicial, habitoDePagoAbiertasType.vrlOcupoInicial);
  }

  @Override
  public int hashCode() {
    return Objects.hash(_47meses, adjetivoFecha, calificacion, cuotasMVigencia, desacuerdoInformacion, entidadInformante, estadoObligacion, estadoTitular, fechaActualizacion, fechaApertura, fechaLimitePago, fechaPago, fechaVencimiento, marcaClase, moraMaxima, numeroCuenta, numeroChequeDevueltos, oficinaDeudor, perm, porcentajeDeuda, saldoActual, saldoMora, sector, tipoCuenta, tipoGarantia, valorCuota, vrlOcupoInicial);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HabitoDePagoAbiertasType {\n");
    
    sb.append("    _47meses: ").append(toIndentedString(_47meses)).append("\n");
    sb.append("    adjetivoFecha: ").append(toIndentedString(adjetivoFecha)).append("\n");
    sb.append("    calificacion: ").append(toIndentedString(calificacion)).append("\n");
    sb.append("    cuotasMVigencia: ").append(toIndentedString(cuotasMVigencia)).append("\n");
    sb.append("    desacuerdoInformacion: ").append(toIndentedString(desacuerdoInformacion)).append("\n");
    sb.append("    entidadInformante: ").append(toIndentedString(entidadInformante)).append("\n");
    sb.append("    estadoObligacion: ").append(toIndentedString(estadoObligacion)).append("\n");
    sb.append("    estadoTitular: ").append(toIndentedString(estadoTitular)).append("\n");
    sb.append("    fechaActualizacion: ").append(toIndentedString(fechaActualizacion)).append("\n");
    sb.append("    fechaApertura: ").append(toIndentedString(fechaApertura)).append("\n");
    sb.append("    fechaLimitePago: ").append(toIndentedString(fechaLimitePago)).append("\n");
    sb.append("    fechaPago: ").append(toIndentedString(fechaPago)).append("\n");
    sb.append("    fechaVencimiento: ").append(toIndentedString(fechaVencimiento)).append("\n");
    sb.append("    marcaClase: ").append(toIndentedString(marcaClase)).append("\n");
    sb.append("    moraMaxima: ").append(toIndentedString(moraMaxima)).append("\n");
    sb.append("    numeroCuenta: ").append(toIndentedString(numeroCuenta)).append("\n");
    sb.append("    numeroChequeDevueltos: ").append(toIndentedString(numeroChequeDevueltos)).append("\n");
    sb.append("    oficinaDeudor: ").append(toIndentedString(oficinaDeudor)).append("\n");
    sb.append("    perm: ").append(toIndentedString(perm)).append("\n");
    sb.append("    porcentajeDeuda: ").append(toIndentedString(porcentajeDeuda)).append("\n");
    sb.append("    saldoActual: ").append(toIndentedString(saldoActual)).append("\n");
    sb.append("    saldoMora: ").append(toIndentedString(saldoMora)).append("\n");
    sb.append("    sector: ").append(toIndentedString(sector)).append("\n");
    sb.append("    tipoCuenta: ").append(toIndentedString(tipoCuenta)).append("\n");
    sb.append("    tipoGarantia: ").append(toIndentedString(tipoGarantia)).append("\n");
    sb.append("    valorCuota: ").append(toIndentedString(valorCuota)).append("\n");
    sb.append("    vrlOcupoInicial: ").append(toIndentedString(vrlOcupoInicial)).append("\n");
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

