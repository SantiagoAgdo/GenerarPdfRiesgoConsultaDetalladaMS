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

@Path("/v1/ms/centralRiesgo/generaRiesgoHistorial/pdf/{tipoDocumento}/{numeroDocumento}/{digitoVerificacion}")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-09-25T09:27:07.966299400-05:00[America/Bogota]")
public interface V1GenerarPdfRiesgoConsultaDetallada {

    @POST
    @Produces({ "application/json" })
    Response generaRiesgoHistorial(@PathParam("tipoDocumento") TipoDocumentoEnum tipoDocumento,@PathParam("numeroDocumento") String numeroDocumento,@PathParam("digitoVerificacion") String digitoVerificacion);
}
