package id.putra.peoplelibrarysystem.resource.api.admin;

import io.quarkus.qute.TemplateInstance;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.SecurityContext;

@RolesAllowed("Admin")
@Path("admin")
public interface AdminRoute {
    @GET
    TemplateInstance admin(@Context SecurityContext sec);

}

