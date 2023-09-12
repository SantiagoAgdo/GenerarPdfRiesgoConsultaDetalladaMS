package com.mibanco.generarpdfriesgo.ms.gen.type;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets EstadoObligacionXmlEnum
 */
public enum EstadoObligacionXmlEnum {
  
  ACTIVA("ACTIVA"),
  
  EMBARGADA("EMBARGADA"),
  
  EMBARGADA_ACTIVA("EMBARGADA-ACTIVA"),
  
  AL_D_A("AL DÍA"),
  
  AL_D_A_MXX("AL DÍA MXX"),
  
  EST_EN_MORA_XX("ESTÁ EN MORA XX"),
  
  EST_EN_MORA_XX_RM_XX("ESTÁ EN MORA XX RM XX"),
  
  DUDOSO_RECAUDO("DUDOSO RECAUDO"),
  
  CART_CASTIGADA("CART.CASTIGADA"),
  
  REESTRUCTURADA("REESTRUCTURADA"),
  
  REFINANCIADA("REFINANCIADA"),
  
  TRANS_PRODUCTO("TRANS.PRODUCTO"),
  
  NORMAL("NORMAL"),
  
  COMPRADA("COMPRADA"),
  
  NORMAL_REESTRUCTURADA("NORMAL REESTRUCTURADA"),
  
  NORMAL_REFINANCIADA("NORMAL REFINANCIADA");

  private String value;

  EstadoObligacionXmlEnum(String value) {
    this.value = value;
  }

    /**
     * Convert a String into String, as specified in the
     * <a href="https://download.oracle.com/otndocs/jcp/jaxrs-2_0-fr-eval-spec/index.html">See JAX RS 2.0 Specification, section 3.2, p. 12</a>
     */
	public static EstadoObligacionXmlEnum fromString(String s) {
      for (EstadoObligacionXmlEnum b : EstadoObligacionXmlEnum.values()) {
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
  public static EstadoObligacionXmlEnum fromValue(String value) {
    for (EstadoObligacionXmlEnum b : EstadoObligacionXmlEnum.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}


