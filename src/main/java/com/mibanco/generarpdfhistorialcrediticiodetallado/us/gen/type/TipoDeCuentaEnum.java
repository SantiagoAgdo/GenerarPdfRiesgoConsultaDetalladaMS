package com.mibanco.generarpdfhistorialcrediticiodetallado.us.gen.type;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets TipoDeCuentaEnum
 */
public enum TipoDeCuentaEnum {
  
  CCB("CUENTA CORRIENTE BANCARIA"),
  
  CCD("CUENTA CORRIENTE DIGITAL"),
  
  TDC("TARJETAS DE CRÉDITO"),
  
  TDD("TARJETAS DE CRÉDITO DIGITAL"),
  
  CBR("CARTERA BANCARIA ROTATIVA"),
  
  CRD("CARTERA BANCARIA ROTATIVA DIGITAL"),
  
  CAM("MANTENIMIENTO  Y  REPARACIÓN  DE  VEHÍCULOS AUTOMOTORES"),
  
  CAP("COMERCIO DE PARTES, PIEZAS (AUTOPARTES) Y ACCESORIOS (LUJOS) PARA VEHÍCULOS AUTOMOTORES"),
  
  CMO("COMERCIO DE MOTOCICLETAS Y DE SUS PARTES, PIEZAS Y ACCESORIOS"),
  
  CAL("COMPAÑIAS LLANTERAS"),
  
  CAB("CARTERA BANCARIA"),
  
  CBD("CARTERA BANCARIA DIGITAL"),
  
  FIT("FINTECH"),
  
  CBC("COLECTIVA"),
  
  CBF("FIDUCIARIA"),
  
  CLV("LINEA VERDE - SOSTENIBLE"),
  
  CFI("FIDEICOMISO"),
  
  CME("FINANCIACION MONEDA EXTRANJERA"),
  
  CBO("OFICIAL"),
  
  CAC("CART. COOP DE AHORRO Y CREDITO"),
  
  COF("CARTERA CORPORAC. FINANCIERAS"),
  
  CFM("FOMENTO MUNICIPAL"),
  
  CFD("FOMENTO DEPARTAMENTAL"),
  
  CFF("FINAGRO"),
  
  CFE("CARTERA FONDOS DE EMPLEADOS"),
  
  CVE("CARTERA VESTUARIO"),
  
  CLB("CARTERA EDITORIAL"),
  
  CPE("PAGO EN ESPECIE"),
  
  CPG("PIGNORACION"),
  
  CVB("VENTA DE BIENES"),
  
  CMS("CORREO Y SERVICIOS DE MENSAJERÍA"),
  
  CSM("SERVICIOS MEDICOS"),
  
  CVT("ACTIVIDADES VETERINARIAS"),
  
  CAA("ALQUILER Y ARRENDAMIENTO DE OTROS TIPOS DE MAQUINARIA, EQUIPO Y BIENES TANGIBLES N.C.P."),
  
  CFU("SERVICIOS FÚNEBRES Y ACTIVIDADES RELACIONADAS"),
  
  CAS("ASESORIAS"),
  
  CTU("CARTERA TURISMO"),
  
  CTR("RECREACIÓN"),
  
  CAV("CARTERA AHORRO Y VIVIENDA"),
  
  CVN("VIVIENDA NO VIS"),
  
  CVP("VIVIENDA PRIORITARIA"),
  
  CVV("VIVIENDA VIS"),
  
  CCL("CARTERA COMPANIAS DE LEASING"),
  
  LNV("LEASING HABITACIONAL NO  VIS"),
  
  LHV("LEASING HABITACIONAL VIS"),
  
  LAP("LEASING APALANCADO"),
  
  LFI("LEASING FINANCIERO"),
  
  LIN("LEASING INMOBILIARIO"),
  
  LVE("LEASING VEHICULAR"),
  
  LOP("LEASING OPERATIVO"),
  
  LOT("LEASING OTROS"),
  
  LBK("LEASE BACK"),
  
  CCC("CARTERA CRED. DE CONSTRUCCION"),
  
  CFR("CARTERA FINCA RAIZ"),
  
  CFA("ARRENDAMIENTO"),
  
  CIN("INVERSION NO VIS"),
  
  CIV("INVERSION VIS"),
  
  EST("ESTATAL"),
  
  CCF("CARTERA C/IAS. FINANC. CIAL."),
  
  CRE("REDESCUENTO"),
  
  CFT("FACTORING"),
  
  COR("ORDINARIO"),
  
  CCM("CARTERA MOTOS"),
  
  CMD("CARTERA MOTOR DIGITAL"),
  
  CVH("CARTERA VEHICULO"),
  
  CVD("CARTERA VEHICULO DIGITAL"),
  
  CMU("CARTERA MUEBLES"),
  
  CCS("CARTERA COMPANIAS DE SEGUROS"),
  
  SAC("SEGUROS ACCIDENTES"),
  
  SGE("SEGUROS GENERALES"),
  
  SHO("SEGUROS HOGAR"),
  
  SVE("SEGUROS VEHICULO"),
  
  SVI("SEGUROS VIDA"),
  
  CBM("CREDITOS DE BAJO MONTO"),
  
  CEL("CARTERA ELECTRODOMESTICOS"),
  
  CTC("CARTERA TELEFONIA CELULAR"),
  
  CSB("SPLIT BILLING - CORPORATIVA"),
  
  CDC("CARTERA DE COMUNICACIONES"),
  
  CCH("HOGARES (TV, BANDA ANCHA, FIJO)"),
  
  CCO("CORPORATIVO (TV, BANDA ANCHA, FIJO)"),
  
  CPY("PYME (TV, BANDA ANCHA, FIJO)"),
  
  DIC("DEPARTAMENTO INFORM. COMERCIAL"),
  
  CDB("CARTERA COMISIONISTAS DE BOLSA"),
  
  COC("CARTERA OTROS CREDITOS"),
  
  CSP("CARTERA SERVICIOS PUBLICOS"),
  
  CSU("SERVICIO AGUA"),
  
  CSL("SERVICIO LUZ"),
  
  CSG("SERVICIO GAS"),
  
  AGR("CARTERA AGROINDUSTRIA"),
  
  RUR("RURAL"),
  
  ALI("CARTERA DE ALIMENTOS"),
  
  CMZ("CARTERA COMERCIALIZADORAS"),
  
  CSA("CARTERA CAJAS COMPENS. Y SALUD"),
  
  COM("CARTERA DE EQUIPOS"),
  
  FER("CARTERA FERRETERIAS"),
  
  FUN("CARTERA FUNDACIONES"),
  
  GRM("CARTERA GREMIOS"),
  
  IND("CARTERA INDUSTRIAL"),
  
  LAB("CARTERA LABORATORIOS"),
  
  CDI("VENTA DIRECTA"),
  
  LBZ("CARTERA LIBRANZA"),
  
  LBD("CARTERA LIBRANZA DIGITAL"),
  
  LBE("LIBRANZA EMPLEADOS"),
  
  LBP("LIBRANZA PENSIONADOS"),
  
  LBR("LIBRANZA ROTATIVA"),
  
  LBC("LIBRANZA COMPRA CARTERA"),
  
  SEG("CARTERA SEGURIDAD"),
  
  TRT("CARTERA TRANSPORTE"),
  
  EDU("CARTERA EDUCACION"),
  
  SFI("SERVICIOS FINANCIEROS"),
  
  SCC("CASAS DE COBRANZA"),
  
  CAU("CARTERA AUTOMOTRIZ"),
  
  CON("CREDITOS DE CONSUMO"),
  
  APD("ALMACEN POR DEPARTAMENTOS"),
  
  SBG("CARTERA SOBREGIRO"),
  
  MCR("CARTERA MICROCREDITO"),
  
  CUENTAS_DE_AHORRO_BANCARIA("CUENTAS DE AHORRO BANCARIA"),
  
  CUENTAS_DE_AHORRO_BANCARIA_DIGITAL("CUENTAS DE AHORRO BANCARIA DIGITAL"),
  
  CDT("CDT");

  private String value;

  TipoDeCuentaEnum(String value) {
    this.value = value;
  }

    /**
     * Convert a String into String, as specified in the
     * <a href="https://download.oracle.com/otndocs/jcp/jaxrs-2_0-fr-eval-spec/index.html">See JAX RS 2.0 Specification, section 3.2, p. 12</a>
     */
	public static TipoDeCuentaEnum fromString(String s) {
      for (TipoDeCuentaEnum b : TipoDeCuentaEnum.values()) {
        // using Objects.toString() to be safe if value type non-object type
        // because types like 'int' etc. will be auto-boxed
        if (java.util.Objects.toString(b.value).equals(s)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected string value '" + s + "'");
	}
	
  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static TipoDeCuentaEnum fromValue(String value) {
    for (TipoDeCuentaEnum b : TipoDeCuentaEnum.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}


