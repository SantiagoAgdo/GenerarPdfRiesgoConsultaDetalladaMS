package com.mibanco.generarpdfriesgo.ms.dao.entity;

import com.mibanco.generarpdfriesgo.ms.gen.type.TipoDocumentoEnum;
import com.mibanco.generarpdfriesgo.ms.gen.type.TipoPersonaEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteBaseEntity {

    private Integer numeroCliente;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private TipoDocumentoEnum tipoDocumento;
    private String numeroDocumento;
    private Integer fechaExpedicionDocumento;
    private TipoPersonaEnum tipoPersona;
    private String correoElectronico;
    private Integer numeroCelular;

}
