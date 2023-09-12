package com.mibanco.generarpdfriesgo.ms.gen.type;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets TIpoSectorXmlEnum
 */
public enum TIpoSectorXmlEnum {
  
  FINANCIERO("SECTOR FINANCIERO"),
  
  COOPERATIVO("SECTOR COOPERATIVO"),
  
  REAL("SECTOR REAL"),
  
  TELECOMUNICACIONES_TELCOS_("SECTOR TELECOMUNICACIONES (TELCOS)");

  private String value;

  TIpoSectorXmlEnum(String value) {
    this.value = value;
  }

    /**
     * Convert a String into String, as specified in the
     * <a href="https://download.oracle.com/otndocs/jcp/jaxrs-2_0-fr-eval-spec/index.html">See JAX RS 2.0 Specification, section 3.2, p. 12</a>
     */
	public static TIpoSectorXmlEnum fromString(String s) {
      for (TIpoSectorXmlEnum b : TIpoSectorXmlEnum.values()) {
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
  public static TIpoSectorXmlEnum fromValue(String value) {
    for (TIpoSectorXmlEnum b : TIpoSectorXmlEnum.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}


