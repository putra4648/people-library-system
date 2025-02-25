package id.putra.peoplelibrarysystem.exception.mapper;

import id.putra.peoplelibrarysystem.exception.UserException;
import id.putra.peoplelibrarysystem.response.AppGeneralResponse;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;

@Provider
@Slf4j
public class UsernameExceptionMapper implements ExceptionMapper<UserException> {

    @Override
    public Response toResponse(UserException exception) {
        log.error(exception.getMessage(), exception);
        var body = new AppGeneralResponse(true, exception.getMessage());
        return Response.status(Response.Status.OK).entity(body).type(MediaType.APPLICATION_JSON).build();
    }
}
