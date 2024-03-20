package com.mibanco.generarpdfhistorialcrediticiodetallado.us.dao.entity;

import com.mibanco.generarpdfhistorialcrediticiodetallado.us.service.command.IParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArchivoEntity implements IParam {
    private String rutaXml;
    private String nombreArchivoXml;
}
