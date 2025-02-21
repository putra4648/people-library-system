package id.putra.peoplelibrarysystem.exception;

import java.util.HashMap;

import io.quarkus.security.ForbiddenException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ForbiddenExceptionMapper implements ExceptionMapper<ForbiddenException> {

    @Override
    public Response toResponse(ForbiddenException exception) {
        exception.printStackTrace();

        var body = new HashMap<>();

        body.put("error", true);
        body.put("message", "Sorry you are not allowed to see this");

        return Response.status(Response.Status.FORBIDDEN).entity(body).build();
    }

}
