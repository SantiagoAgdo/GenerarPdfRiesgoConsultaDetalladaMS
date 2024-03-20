package com.mibanco.generarpdfhistorialcrediticiodetallado.us.gen.type;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets EstadoDeCuentaXmlEnum
 */
public enum EstadoDeCuentaXmlEnum {
  
  _00("Entidad no reporto"),
  
  _01("Al día"),
  
  _02("En Mora"),
  
  _03("Pago Total"),
  
  _04("Pago Judicial"),
  
  _05("Dudoso Recaudo"),
  
  _06("Castigada"),
  
  _07("Dación en Pago"),
  
  _08("Cancelada Voluntariamente"),
  
  _09("Cancelada por mal manejo"),
  
  _10("Prescripción"),
  
  _11("Cancelada por la entidad"),
  
  _12("Cancelada por reestructuración/refinanciación"),
  
  _13("Cancelada por venta"),
  
  _14("Insoluta"),
  
  _15("Cancelada por siniestro"),
  
  _16("Cancelada por Liquidación Patrimonial."),
  
  _17("Cancelada por subrogación");

  private String value;

  EstadoDeCuentaXmlEnum(String value) {
    this.value = value;
  }

    /**
     * Convert a String into String, as specified in the
     * <a href="https://download.oracle.com/otndocs/jcp/jaxrs-2_0-fr-eval-spec/index.html">See JAX RS 2.0 Specification, section 3.2, p. 12</a>
     */
	public static EstadoDeCuentaXmlEnum fromString(String s) {
      for (EstadoDeCuentaXmlEnum b : EstadoDeCuentaXmlEnum.values()) {
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
  public static EstadoDeCuentaXmlEnum fromValue(String value) {
    for (EstadoDeCuentaXmlEnum b : EstadoDeCuentaXmlEnum.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}


