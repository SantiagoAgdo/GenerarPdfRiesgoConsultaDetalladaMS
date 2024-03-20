package com.mibanco.generarpdfhistorialcrediticiodetallado.us.gen.type;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets ModalidadPagoXmlEnum
 */
public enum ModalidadPagoXmlEnum {
  
  _0("No informó"),
  
  _1("Mensual"),
  
  _2("Bimensual"),
  
  _3("Trimestral"),
  
  _4("Semestral"),
  
  _5("Anual"),
  
  _6("Al vencimiento"),
  
  _9("Otro");

  private String value;

  ModalidadPagoXmlEnum(String value) {
    this.value = value;
  }

    /**
     * Convert a String into String, as specified in the
     * <a href="https://download.oracle.com/otndocs/jcp/jaxrs-2_0-fr-eval-spec/index.html">See JAX RS 2.0 Specification, section 3.2, p. 12</a>
     */
	public static ModalidadPagoXmlEnum fromString(String s) {
      for (ModalidadPagoXmlEnum b : ModalidadPagoXmlEnum.values()) {
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
  public static ModalidadPagoXmlEnum fromValue(String value) {
    for (ModalidadPagoXmlEnum b : ModalidadPagoXmlEnum.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}


