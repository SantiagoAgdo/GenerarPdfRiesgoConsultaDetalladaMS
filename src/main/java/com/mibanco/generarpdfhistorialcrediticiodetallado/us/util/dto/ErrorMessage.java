package com.mibanco.generarpdfhistorialcrediticiodetallado.us.util.dto;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.Data;

@Data
@ApplicationScoped
public class ErrorMessage {
    private int status;
    private String message;
}
