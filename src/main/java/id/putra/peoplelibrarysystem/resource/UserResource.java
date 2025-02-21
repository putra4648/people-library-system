package id.putra.peoplelibrarysystem.resource;

import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("user")
@RolesAllowed("User")
public class UserResource {

    @GET
    public Response user() {
        return Response.ok("User").build();
    }
}
