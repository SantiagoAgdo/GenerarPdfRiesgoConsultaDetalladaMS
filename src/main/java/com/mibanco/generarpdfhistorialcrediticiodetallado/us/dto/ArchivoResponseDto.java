package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RegisterForReflection
public class ArchivoResponseDto {
    private String archivo;
}
