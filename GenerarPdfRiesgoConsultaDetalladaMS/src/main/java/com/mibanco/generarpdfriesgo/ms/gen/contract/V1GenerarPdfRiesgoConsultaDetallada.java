package com.mibanco.generarpdfriesgo.ms.gen.contract;

import com.mibanco.generarpdfriesgo.ms.gen.type.Error;
import com.mibanco.generarpdfriesgo.ms.gen.type.TipoDocumentoEnum;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;



import java.io.InputStream;
import java.util.Map;
import java.util.List;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

@Path("/v1/ms/central-riesgo/detallada/pdf/{tipoDocumento}/{numeroDocumento}/{digitoVerificacion}")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-10-03T17:19:31.615516-05:00[America/Bogota]")
public interface V1GenerarPdfRiesgoConsultaDetallada {

    @POST
    @Produces({ "application/json" })
    Response generaRiesgoHistorial(@PathParam("tipoDocumento") TipoDocumentoEnum tipoDocumento,@PathParam("numeroDocumento") String numeroDocumento,@PathParam("digitoVerificacion") String digitoVerificacion);
}
