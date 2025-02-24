package id.putra.peoplelibrarysystem.exception.mapper;

import id.putra.peoplelibrarysystem.response.AppGeneralResponse;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;

@Provider
@Slf4j
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {

    @Override
    public Response toResponse(NotFoundException exception) {
        log.error(exception.getMessage(), exception);
        var body = new AppGeneralResponse(true, exception.getMessage());
        return Response.ok(body).build();
    }

}
