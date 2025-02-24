package id.putra.peoplelibrarysystem.exception.mapper;

import id.putra.peoplelibrarysystem.response.AppGeneralResponse;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;

@Provider
@Slf4j
public class UnauthorizedExceptionMapper implements ExceptionMapper<io.quarkus.security.UnauthorizedException> {

    @Override
    public Response toResponse(io.quarkus.security.UnauthorizedException exception) {
        log.error(exception.getMessage(), exception);
        var body = new AppGeneralResponse(true, exception.getMessage());
        return Response.seeOther(UriBuilder.fromUri("/auth/login").build()).entity(body).build();
    }

}
