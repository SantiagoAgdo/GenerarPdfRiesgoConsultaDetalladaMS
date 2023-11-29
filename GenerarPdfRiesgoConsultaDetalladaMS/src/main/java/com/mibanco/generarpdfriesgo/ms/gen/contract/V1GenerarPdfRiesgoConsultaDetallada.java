package com.mibanco.generarpdfriesgo.ms.gen.contract;

import com.mibanco.generarpdfriesgo.ms.gen.type.Error;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;



import java.io.InputStream;
import java.util.Map;
import java.util.List;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

@Path("/v1/ms/central-riesgo/detallada/pdf/{numeroCliente}")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-11-22T11:43:13.018607800-05:00[America/Bogota]")
public interface V1GenerarPdfRiesgoConsultaDetallada {

    @POST
    @Produces({ "application/json" })
    Response generaRiesgoHistorial(@PathParam("numeroCliente") String numeroCliente);
}
