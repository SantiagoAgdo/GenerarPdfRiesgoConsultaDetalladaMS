package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

public enum SectoresEnum {
    FINANCIERO(1),
    COOPERATIVO(2),
    REAL(3),
    TELECOMUNICACIONES(4);

    private final int valor;

    SectoresEnum(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public static SectoresEnum porValor(int valor) {
        for (SectoresEnum tipo : values()) {
            if (tipo.getValor() == valor) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Valor no soportado: " + valor);
    }

}

