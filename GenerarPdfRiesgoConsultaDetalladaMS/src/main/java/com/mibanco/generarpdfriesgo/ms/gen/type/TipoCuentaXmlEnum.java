package com.mibanco.generarpdfriesgo.ms.gen.type;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets TipoCuentaXmlEnum
 */
public enum TipoCuentaXmlEnum {
  
  COC("COC"),
  
  COF("COF"),
  
  COM("COM"),
  
  CON("CON"),
  
  COR("COR"),
  
  CPE("CPE"),
  
  CPG("CPG"),
  
  CPY("CPY"),
  
  CRD("CRD"),
  
  CRE("CRE"),
  
  CSA("CSA"),
  
  CSB("CSB"),
  
  CSG("CSG"),
  
  CSL("CSL"),
  
  CSM("CSM"),
  
  CSP("CSP"),
  
  CSU("CSU"),
  
  CTC("CTC"),
  
  CTR("CTR"),
  
  CTU("CTU"),
  
  CVB("CVB"),
  
  CVD("CVD"),
  
  CVE("CVE"),
  
  CVH("CVH"),
  
  CVN("CVN"),
  
  CVP("CVP"),
  
  CVT("CVT"),
  
  CVV("CVV"),
  
  DIC("DIC"),
  
  EDU("EDU"),
  
  EST("EST"),
  
  FER("FER"),
  
  FIT("FIT"),
  
  FUN("FUN"),
  
  GRM("GRM"),
  
  IND("IND"),
  
  LAB("LAB"),
  
  LAP("LAP"),
  
  LBC("LBC"),
  
  LBD("LBD"),
  
  LBE("LBE"),
  
  LBK("LBK"),
  
  LBP("LBP"),
  
  LBR("LBR"),
  
  LBZ("LBZ"),
  
  LFI("LFI"),
  
  LHV("LHV"),
  
  LIN("LIN"),
  
  LNV("LNV"),
  
  LOP("LOP"),
  
  LOT("LOT"),
  
  LVE("LVE"),
  
  MCR("MCR"),
  
  RUR("RUR"),
  
  SAC("SAC"),
  
  SBG("SBG"),
  
  SCC("SCC"),
  
  SEG("SEG"),
  
  SFI("SFI"),
  
  SGE("SGE"),
  
  SHO("SHO"),
  
  SVE("SVE"),
  
  SVI("SVI"),
  
  TDC("TDC"),
  
  TDD("TDD"),
  
  TRT("TRT");

  private String value;

  TipoCuentaXmlEnum(String value) {
    this.value = value;
  }

    /**
     * Convert a String into String, as specified in the
     * <a href="https://download.oracle.com/otndocs/jcp/jaxrs-2_0-fr-eval-spec/index.html">See JAX RS 2.0 Specification, section 3.2, p. 12</a>
     */
	public static TipoCuentaXmlEnum fromString(String s) {
      for (TipoCuentaXmlEnum b : TipoCuentaXmlEnum.values()) {
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
  public static TipoCuentaXmlEnum fromValue(String value) {
    for (TipoCuentaXmlEnum b : TipoCuentaXmlEnum.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}


