package com.mibanco.generarpdfhistorialcrediticiodetallado.us.gen.type;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets GarantiaDeudaGlobalXmlEnum
 */
public enum GarantiaDeudaGlobalXmlEnum {
  
  _0("SIN GAR"),
  
  _1("NO IDON"),
  
  _2("BIEN RAICES"),
  
  _3("OTR PREND"),
  
  _4("PIGN RENTA"),
  
  _5("GAR SOBER NACION"),
  
  _6("CONT IRREV FIDUC"),
  
  _7("FNG"),
  
  _8("CARTA CRÉD"),
  
  _9("OTR GAR"),
  
  _10("FAG"),
  
  _11("PERSONAL"),
  
  _12("BIEN LEASI NO INMOB"),
  
  _13("BIEN LEASI INMOB"),
  
  _14("PRENDA TITULO"),
  
  _15("DEPOSITOS"),
  
  _16("SEG CREDITO");

  private String value;

  GarantiaDeudaGlobalXmlEnum(String value) {
    this.value = value;
  }

    /**
     * Convert a String into String, as specified in the
     * <a href="https://download.oracle.com/otndocs/jcp/jaxrs-2_0-fr-eval-spec/index.html">See JAX RS 2.0 Specification, section 3.2, p. 12</a>
     */
	public static GarantiaDeudaGlobalXmlEnum fromString(String s) {
      for (GarantiaDeudaGlobalXmlEnum b : GarantiaDeudaGlobalXmlEnum.values()) {
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
  public static GarantiaDeudaGlobalXmlEnum fromValue(String value) {
    for (GarantiaDeudaGlobalXmlEnum b : GarantiaDeudaGlobalXmlEnum.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}


