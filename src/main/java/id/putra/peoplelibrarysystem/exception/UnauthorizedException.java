package id.putra.peoplelibrarysystem.exception;

import java.util.HashMap;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class UnauthorizedException implements ExceptionMapper<io.quarkus.security.UnauthorizedException> {

    @Override
    public Response toResponse(io.quarkus.security.UnauthorizedException exception) {
        var body = new HashMap<>();

        body.put("error", true);
        body.put("message", "Sorry you need to login again");

        return Response.status(Response.Status.UNAUTHORIZED).entity(body).build();
    }

}
