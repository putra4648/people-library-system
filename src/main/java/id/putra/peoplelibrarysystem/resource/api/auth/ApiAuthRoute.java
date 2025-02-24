package id.putra.peoplelibrarysystem.resource.api.auth;

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
    Response apiLogin(@FormParam("username") String username, @FormParam("password") String password);

    @GET
    @Path("login/redirect")
    Response apiRedirectLogin(@Context SecurityContext securityContext);
}
