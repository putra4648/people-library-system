package id.putra.peoplelibrarysystem.resource;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.SecurityContext;

@Path("admin")
interface AdminRouteController {

    @GET
    TemplateInstance admin(@Context SecurityContext sec);

}

class AdminData {
    public final String name;

    public AdminData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

@RolesAllowed("Admin")
public class AdminResource implements AdminRouteController {
    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance index(AdminData data);
    }

    @Override
    public TemplateInstance admin(@Context SecurityContext sec) {
        AdminData data = new AdminData(sec.getUserPrincipal().getName());
        return Templates.index(data);
    }

}
