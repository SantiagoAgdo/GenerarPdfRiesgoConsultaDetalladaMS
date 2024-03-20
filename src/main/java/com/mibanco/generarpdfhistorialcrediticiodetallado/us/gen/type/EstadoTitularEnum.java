package com.mibanco.generarpdfhistorialcrediticiodetallado.us.gen.type;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets EstadoTitularEnum
 */
public enum EstadoTitularEnum {
  
  _0("Normal"),
  
  _1("Concordato"),
  
  _2("Liquidación Forzosa"),
  
  _3("Liquidación Voluntaria"),
  
  _4("Proceso de Reorganización"),
  
  _5("Ley 550"),
  
  _6("Ley 1116"),
  
  _7("Otra"),
  
  _8("Liquidación Patrimonial");

  private String value;

  EstadoTitularEnum(String value) {
    this.value = value;
  }

    /**
     * Convert a String into String, as specified in the
     * <a href="https://download.oracle.com/otndocs/jcp/jaxrs-2_0-fr-eval-spec/index.html">See JAX RS 2.0 Specification, section 3.2, p. 12</a>
     */
	public static EstadoTitularEnum fromString(String s) {
      for (EstadoTitularEnum b : EstadoTitularEnum.values()) {
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
  public static EstadoTitularEnum fromValue(String value) {
    for (EstadoTitularEnum b : EstadoTitularEnum.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}


