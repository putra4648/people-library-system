package id.putra.peoplelibrarysystem.exception;

import java.util.HashMap;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;

@Provider
@Slf4j
public class UnauthorizedException implements ExceptionMapper<io.quarkus.security.UnauthorizedException> {

    @Override
    public Response toResponse(io.quarkus.security.UnauthorizedException exception) {
        log.error(exception.getMessage(), exception);

        var body = new HashMap<>();

        body.put("error", true);
        body.put("message", "Sorry you need to login again");

        return Response.seeOther(UriBuilder.fromUri("/auth/login").build()).entity(body).build();
    }

}
