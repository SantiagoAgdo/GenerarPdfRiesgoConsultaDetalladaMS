package com.mibanco.generarpdfhistorialcrediticiodetallado.us.facade;

import com.mibanco.generarpdfhistorialcrediticiodetallado.us.dto.ArchivoResponseDto;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "IArchivoUS")
@Consumes(MediaType.APPLICATION_JSON)
//@Produces(MediaType.APPLICATION_JSON)
public interface IArchivoUS {

    @GET
    @Path("/archivo/ubicacion/{nombreContenedor}/{nombreArchivo}")
    ArchivoResponseDto consultarArchivoPorUbicacion(@PathParam("nombreContenedor") String nombreContenedor,
                                                    @PathParam("nombreArchivo") String nombreArchivo);
}
