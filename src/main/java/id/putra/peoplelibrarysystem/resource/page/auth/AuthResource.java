package id.putra.peoplelibrarysystem.resource.page.auth;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import io.smallrye.jwt.auth.principal.JWTParser;
import io.smallrye.jwt.auth.principal.ParseException;
import jakarta.annotation.security.PermitAll;
import jakarta.inject.Inject;
import jakarta.ws.rs.CookieParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;

@PermitAll
@Path("auth")
public class AuthResource {

    @Inject
    JWTParser jwtParser;

    @GET
    public Response redirectTo(@CookieParam("jwt") String token) {
        if (token != null && isTokenValid(token)) {
            return Response.seeOther(UriBuilder.fromUri("/api/login/redirect").build()).build();
        }
        return Response.seeOther(UriBuilder.fromUri("/auth/login").build()).build();
    }

    @GET
    @Path("login")
    @Produces(MediaType.TEXT_HTML)
    public Response login(@CookieParam("jwt") String token) {
        if (token != null && isTokenValid(token)) {
            return Response.seeOther(UriBuilder.fromUri("/api/login/redirect").build()).build();
        }
        return Response.ok(AuthTemplates.login()).build();
    }

    private boolean isTokenValid(String token) {
        try {
            jwtParser.parseOnly(token);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    @CheckedTemplate
    public static class AuthTemplates {
        public static native TemplateInstance login();
    }

}
