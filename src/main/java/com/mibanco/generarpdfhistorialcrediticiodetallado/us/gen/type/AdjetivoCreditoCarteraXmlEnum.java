package com.mibanco.generarpdfhistorialcrediticiodetallado.us.gen.type;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets AdjetivoCreditoCarteraXmlEnum
 */
public enum AdjetivoCreditoCarteraXmlEnum {
  
  _0("No hay adjetivo"),
  
  _1("Fallecido"),
  
  _2("Cuenta en cobrador"),
  
  _3("Deudor no localizado"),
  
  _4("Línea suspendida"),
  
  _5("Incapacidad total o permanente"),
  
  _6("Cobro pre-jurídico"),
  
  _7("Cobro jurídico");

  private String value;

  AdjetivoCreditoCarteraXmlEnum(String value) {
    this.value = value;
  }

    /**
     * Convert a String into String, as specified in the
     * <a href="https://download.oracle.com/otndocs/jcp/jaxrs-2_0-fr-eval-spec/index.html">See JAX RS 2.0 Specification, section 3.2, p. 12</a>
     */
	public static AdjetivoCreditoCarteraXmlEnum fromString(String s) {
      for (AdjetivoCreditoCarteraXmlEnum b : AdjetivoCreditoCarteraXmlEnum.values()) {
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
  public static AdjetivoCreditoCarteraXmlEnum fromValue(String value) {
    for (AdjetivoCreditoCarteraXmlEnum b : AdjetivoCreditoCarteraXmlEnum.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}


