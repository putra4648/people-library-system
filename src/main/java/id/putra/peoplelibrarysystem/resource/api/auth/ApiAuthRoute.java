package id.putra.peoplelibrarysystem.resource.api.auth;

import id.putra.peoplelibrarysystem.exception.UserException;
import jakarta.annotation.security.PermitAll;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;

@Path("api")
public interface ApiAuthRoute {
    @POST
    @Path("login")
    @PermitAll
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    Response apiLogin(@BeanParam LoginRequestBody loginRequest) throws UserException;

    @POST
    @Path("register")
    @PermitAll
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    Response apiRegister(@BeanParam RegisterRequestBody registerRequest) throws UserException;

    @GET
    @Path("login/redirect")
    Response apiRedirectLogin(@Context SecurityContext securityContext);

    @GET
    @Path("logout")
    Response apiLogout(@Context SecurityContext securityContext);
}
