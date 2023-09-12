package com.mibanco.generarpdfriesgo.ms.gen.type;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets TotalSectorXmlEnum
 */
public enum TotalSectorXmlEnum {
  
  SECTORES("TOTAL SECTORES"),
  
  COMO_PRINCIPAL("TOTAL COMO PRINCIPAL"),
  
  COMO_CODEUDOR_Y_OTROS("TOTAL COMO CODEUDOR Y OTROS");

  private String value;

  TotalSectorXmlEnum(String value) {
    this.value = value;
  }

    /**
     * Convert a String into String, as specified in the
     * <a href="https://download.oracle.com/otndocs/jcp/jaxrs-2_0-fr-eval-spec/index.html">See JAX RS 2.0 Specification, section 3.2, p. 12</a>
     */
	public static TotalSectorXmlEnum fromString(String s) {
      for (TotalSectorXmlEnum b : TotalSectorXmlEnum.values()) {
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
  public static TotalSectorXmlEnum fromValue(String value) {
    for (TotalSectorXmlEnum b : TotalSectorXmlEnum.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}


