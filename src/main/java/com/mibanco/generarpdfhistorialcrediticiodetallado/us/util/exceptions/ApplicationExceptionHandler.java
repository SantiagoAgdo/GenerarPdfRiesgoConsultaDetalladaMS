package com.mibanco.generarpdfhistorialcrediticiodetallado.us.util.exceptions;

import com.mibanco.generarpdfhistorialcrediticiodetallado.us.util.dto.ErrorMessage;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
public class ApplicationExceptionHandler implements ExceptionMapper<ApplicationException> {

    private static final Logger LOG = LoggerFactory.getLogger(ApplicationExceptionHandler.class);

    @Inject
    ErrorMessage errorMessage;

    @Override
    public Response toResponse(ApplicationException e) {
        LOG.error(e.getMessage());
        errorMessage.setMessage(e.getMessage());
        return Response.status(Response.Status.BAD_REQUEST).entity(errorMessage).type(MediaType.APPLICATION_JSON).build();
    }

}