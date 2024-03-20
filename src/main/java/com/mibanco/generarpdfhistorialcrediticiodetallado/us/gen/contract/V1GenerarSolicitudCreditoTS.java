package com.mibanco.generarpdfhistorialcrediticiodetallado.us.gen.contract;

import com.mibanco.generarpdfhistorialcrediticiodetallado.us.gen.type.HistorialCreditoBaseArchivoXmlInput;
import com.mibanco.generarpdfhistorialcrediticiodetallado.us.gen.type.HistorialCreditoBaseArchivoXmlOutput;
import com.mibanco.generarpdfhistorialcrediticiodetallado.us.gen.type.HistorialCreditoBaseXmlInput;
import com.mibanco.generarpdfhistorialcrediticiodetallado.us.gen.type.HistorialCreditoBaseXmlOutput;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;



import java.io.InputStream;
import java.util.Map;
import java.util.List;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

@Path("/v1/us/historial-credito")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2024-03-01T11:27:00.249985-05:00[America/Bogota]")
public interface V1GenerarSolicitudCreditoTS {

    @POST
    @Path("/archivo/pdf")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response generarPDFHistorialCreditoBaseArchivoXml(@HeaderParam("jwt")   String jwt,@Valid HistorialCreditoBaseArchivoXmlInput historialCreditoBaseArchivoXmlInput);

    @POST
    @Path("/base-xml/pdf/{requestInput}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response generarPDFHistorialCreditoBaseXml(@PathParam("requestInput") String requestInput,@HeaderParam("jwt")   String jwt,@Valid HistorialCreditoBaseXmlInput historialCreditoBaseXmlInput);
}
