package com.mibanco.generarpdfhistorialcrediticiodetallado.us.gen.type;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets GatantiaXmlEnum
 */
public enum GatantiaXmlEnum {
  
  _0("SIN GAR"),
  
  _1("ADMIS"),
  
  _2("OTR GAR"),
  
  _A("NO IDON"),
  
  _B("BIEN RAICES"),
  
  _C("OTR PREND"),
  
  _D("PIGN RENTA"),
  
  _E("GAR SOBER NACION"),
  
  _F("CONT IRREV FIDUC"),
  
  _G("FNG"),
  
  _H("CARTA CRÉD"),
  
  _I("FAG"),
  
  _J("PERSONAL"),
  
  _K("BIEN LEASI NO INMOB"),
  
  _L("BIEN LEASI INMOB"),
  
  _M("PRENDA TITULO"),
  
  _N("DEPOSITOS"),
  
  _O("SEG CREDITO"),
  
  _P("OTRAS GARANTÍAS IDÓNEAS"),
  
  _Q("NO IDÓNEA");

  private String value;

  GatantiaXmlEnum(String value) {
    this.value = value;
  }

    /**
     * Convert a String into String, as specified in the
     * <a href="https://download.oracle.com/otndocs/jcp/jaxrs-2_0-fr-eval-spec/index.html">See JAX RS 2.0 Specification, section 3.2, p. 12</a>
     */
	public static GatantiaXmlEnum fromString(String s) {
      for (GatantiaXmlEnum b : GatantiaXmlEnum.values()) {
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
  public static GatantiaXmlEnum fromValue(String value) {
    for (GatantiaXmlEnum b : GatantiaXmlEnum.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}


