package id.putra.peoplelibrarysystem.resource.page.auth;

import io.quarkus.qute.TemplateInstance;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

public interface AuthRoute {
    @GET
    @Path("login")
    TemplateInstance login();

    @GET
    @Path("register")
    TemplateInstance register();
}
