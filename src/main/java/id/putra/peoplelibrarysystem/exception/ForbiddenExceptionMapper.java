package id.putra.peoplelibrarysystem.exception;

import io.quarkus.security.ForbiddenException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

@Provider
@Slf4j
public class ForbiddenExceptionMapper implements ExceptionMapper<ForbiddenException> {

    @Override
    public Response toResponse(ForbiddenException exception) {
        log.error(exception.getMessage(), exception);

        var body = new HashMap<>();

        body.put("error", true);
        body.put("message", "Sorry you are not allowed to see this");

        return Response.status(Response.Status.FORBIDDEN).entity(body).build();
    }

}
