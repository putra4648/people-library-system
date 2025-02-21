package id.putra.peoplelibrarysystem.exception;

import java.util.HashMap;

import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {

    @Override
    public Response toResponse(NotFoundException exception) {
        var body = new HashMap<>();

        body.put("error", true);
        body.put("message", exception.getMessage());

        return Response.ok(body).build();
    }

}
