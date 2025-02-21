package id.putra.peoplelibrarysystem.exception;

import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

public class NotFoundExceptionMapper {
    @ServerExceptionMapper
    public Response handleExceptions(WebApplicationException exception) {
        return exception.getResponse();
    }
}
