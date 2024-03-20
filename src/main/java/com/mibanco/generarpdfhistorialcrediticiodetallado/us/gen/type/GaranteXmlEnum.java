package com.mibanco.generarpdfhistorialcrediticiodetallado.us.gen.type;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets GaranteXmlEnum
 */
public enum GaranteXmlEnum {
  
  _00("Deudor Principal"),
  
  _01("Codeudor"),
  
  _04("Avalista"),
  
  _05("Deudor solidario"),
  
  _06("Coarrendatario"),
  
  _07("Otros Garantes"),
  
  _08("Fiador"),
  
  _09("No Aplica"),
  
  _96("Cotitular"),
  
  _97("Comunal"),
  
  _98("No Aplica");

  private String value;

  GaranteXmlEnum(String value) {
    this.value = value;
  }

    /**
     * Convert a String into String, as specified in the
     * <a href="https://download.oracle.com/otndocs/jcp/jaxrs-2_0-fr-eval-spec/index.html">See JAX RS 2.0 Specification, section 3.2, p. 12</a>
     */
	public static GaranteXmlEnum fromString(String s) {
      for (GaranteXmlEnum b : GaranteXmlEnum.values()) {
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
  public static GaranteXmlEnum fromValue(String value) {
    for (GaranteXmlEnum b : GaranteXmlEnum.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}


