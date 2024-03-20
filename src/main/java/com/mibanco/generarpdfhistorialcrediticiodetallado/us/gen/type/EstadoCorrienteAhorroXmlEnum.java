package com.mibanco.generarpdfhistorialcrediticiodetallado.us.gen.type;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets EstadoCorrienteAhorroXmlEnum
 */
public enum EstadoCorrienteAhorroXmlEnum {
  
  _01("Activa"),
  
  _02("Cancelada por mal manejo"),
  
  _03("Desconocido"),
  
  _04("Desconocido"),
  
  _05("Saldada"),
  
  _06("Embargada"),
  
  _07("Embargada-Activa"),
  
  _09("Inactiva");

  private String value;

  EstadoCorrienteAhorroXmlEnum(String value) {
    this.value = value;
  }

    /**
     * Convert a String into String, as specified in the
     * <a href="https://download.oracle.com/otndocs/jcp/jaxrs-2_0-fr-eval-spec/index.html">See JAX RS 2.0 Specification, section 3.2, p. 12</a>
     */
	public static EstadoCorrienteAhorroXmlEnum fromString(String s) {
      for (EstadoCorrienteAhorroXmlEnum b : EstadoCorrienteAhorroXmlEnum.values()) {
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
  public static EstadoCorrienteAhorroXmlEnum fromValue(String value) {
    for (EstadoCorrienteAhorroXmlEnum b : EstadoCorrienteAhorroXmlEnum.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}


