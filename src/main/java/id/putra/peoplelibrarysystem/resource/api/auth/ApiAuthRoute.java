package id.putra.peoplelibrarysystem.resource.api.auth;

import id.putra.peoplelibrarysystem.exception.UsernameException;
import jakarta.annotation.security.PermitAll;
import jakarta.ws.rs.*;
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
    Response apiLogin(LoginRequestBody loginRequest) throws UsernameException;

    @POST
    @Path("register")
    @PermitAll
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    Response apiRegister(RegisterRequestBody registerRequest);

    @GET
    @Path("login/redirect")
    Response apiRedirectLogin(SecurityContext securityContext);
}
