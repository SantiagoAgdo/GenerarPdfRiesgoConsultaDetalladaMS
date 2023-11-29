package com.mibanco.generarpdfriesgo.ms.gen.type;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets TipoCarteraXmlEnum
 */
public enum TipoCarteraXmlEnum {
  
  AGR("AGR"),
  
  AHO("AHO"),
  
  ALI("ALI"),
  
  APD("APD"),
  
  CAB("CAB"),
  
  CAC("CAC"),
  
  CAU("CAU"),
  
  CAV("CAV"),
  
  CBM("CBM"),
  
  CBR("CBR"),
  
  CCB("CCB"),
  
  CCC("CCC"),
  
  CCF("CCF"),
  
  COF("COF"),
  
  COM("COM"),
  
  CON("CON"),
  
  CSA("CSA"),
  
  CSP("CSP"),
  
  CTC("CTC"),
  
  CTU("CTU"),
  
  CVE("CVE"),
  
  DIC("DIC"),
  
  EDU("EDU"),
  
  EST("EST"),
  
  FER("FER"),
  
  FUN("FUN"),
  
  CCL("CCL"),
  
  CCS("CCS"),
  
  CDB("CDB"),
  
  CDC("CDC"),
  
  CEL("CEL"),
  
  CFE("CFE"),
  
  CFR("CFR"),
  
  CLB("CLB"),
  
  CMU("CMU"),
  
  CMZ("CMZ"),
  
  COC("COC"),
  
  GRM("GRM"),
  
  IND("IND"),
  
  LAB("LAB"),
  
  LBZ("LBZ"),
  
  MCR("MCR"),
  
  SBG("SBG"),
  
  SEG("SEG"),
  
  SFI("SFI"),
  
  TDC("TDC"),
  
  TRT("TRT");

  private String value;

  TipoCarteraXmlEnum(String value) {
    this.value = value;
  }

    /**
     * Convert a String into String, as specified in the
     * <a href="https://download.oracle.com/otndocs/jcp/jaxrs-2_0-fr-eval-spec/index.html">See JAX RS 2.0 Specification, section 3.2, p. 12</a>
     */
	public static TipoCarteraXmlEnum fromString(String s) {
      for (TipoCarteraXmlEnum b : TipoCarteraXmlEnum.values()) {
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
  public static TipoCarteraXmlEnum fromValue(String value) {
    for (TipoCarteraXmlEnum b : TipoCarteraXmlEnum.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}


