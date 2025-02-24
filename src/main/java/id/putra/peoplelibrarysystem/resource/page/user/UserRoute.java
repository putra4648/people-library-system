package id.putra.peoplelibrarysystem.resource.page.user;

import io.quarkus.qute.TemplateInstance;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.SecurityContext;

@RolesAllowed("User")
@Path("user")
public interface UserRoute {
    @GET
    TemplateInstance user(@Context SecurityContext sec);
}
