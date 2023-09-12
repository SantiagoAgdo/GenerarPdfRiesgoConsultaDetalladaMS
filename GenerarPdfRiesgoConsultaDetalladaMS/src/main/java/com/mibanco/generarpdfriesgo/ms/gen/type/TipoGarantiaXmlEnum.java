package com.mibanco.generarpdfriesgo.ms.gen.type;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets TipoGarantiaXmlEnum
 */
public enum TipoGarantiaXmlEnum {
  
  SIN_GAR("SIN GAR"),
  
  ADMIS("ADMIS"),
  
  OTR_GAR("OTR GAR"),
  
  NO_IDON("NO IDON"),
  
  BIEN_RA_CES("BIEN RAÍCES"),
  
  PIGN_RENTA("PIGN RENTA"),
  
  GAR_SOBER_NACION("GAR. SOBER.NACION"),
  
  CONT_IRREV_FIDUC("CONT IRREV FIDUC"),
  
  FNG("FNG"),
  
  CARTA_CR_D("CARTA CRÉD"),
  
  FAG("FAG"),
  
  PERSONAL("PERSONAL"),
  
  BIEN_LEASI_NO_INMOB("BIEN LEASI NO INMOB"),
  
  BIEN_LEASI_INMOB("BIEN LEASI INMOB"),
  
  PRENDA_T_TULO("PRENDA TÍTULO"),
  
  DEPOSITOS("DEPOSITOS"),
  
  SEG_CREDITO("SEG CREDITO");

  private String value;

  TipoGarantiaXmlEnum(String value) {
    this.value = value;
  }

    /**
     * Convert a String into String, as specified in the
     * <a href="https://download.oracle.com/otndocs/jcp/jaxrs-2_0-fr-eval-spec/index.html">See JAX RS 2.0 Specification, section 3.2, p. 12</a>
     */
	public static TipoGarantiaXmlEnum fromString(String s) {
      for (TipoGarantiaXmlEnum b : TipoGarantiaXmlEnum.values()) {
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
  public static TipoGarantiaXmlEnum fromValue(String value) {
    for (TipoGarantiaXmlEnum b : TipoGarantiaXmlEnum.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}


