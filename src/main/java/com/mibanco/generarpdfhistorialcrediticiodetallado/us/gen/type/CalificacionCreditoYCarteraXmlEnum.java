package com.mibanco.generarpdfhistorialcrediticiodetallado.us.gen.type;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets CalificacionCreditoYCarteraXmlEnum
 */
public enum CalificacionCreditoYCarteraXmlEnum {
  
  _1("A"),
  
  _2("B"),
  
  _3("C"),
  
  _4("D"),
  
  _5("E"),
  
  _6("AA"),
  
  _7("BB"),
  
  _8("CC"),
  
  _9("K"),
  
  _10("--");

  private String value;

  CalificacionCreditoYCarteraXmlEnum(String value) {
    this.value = value;
  }

    /**
     * Convert a String into String, as specified in the
     * <a href="https://download.oracle.com/otndocs/jcp/jaxrs-2_0-fr-eval-spec/index.html">See JAX RS 2.0 Specification, section 3.2, p. 12</a>
     */
	public static CalificacionCreditoYCarteraXmlEnum fromString(String s) {
      for (CalificacionCreditoYCarteraXmlEnum b : CalificacionCreditoYCarteraXmlEnum.values()) {
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
  public static CalificacionCreditoYCarteraXmlEnum fromValue(String value) {
    for (CalificacionCreditoYCarteraXmlEnum b : CalificacionCreditoYCarteraXmlEnum.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}


