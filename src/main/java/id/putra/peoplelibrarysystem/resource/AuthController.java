package id.putra.peoplelibrarysystem.resource;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.eclipse.microprofile.jwt.JsonWebToken;

import io.smallrye.jwt.build.Jwt;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.NewCookie;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;

@Path("/auth")
public class AuthController {

    @Inject
    JsonWebToken jwt;

    @GET
    @Path("profile")
    @RolesAllowed({ "Admin", "User" })
    public Response getProfile(@Context SecurityContext securityContext) {
        Map<String, Object> data = new HashMap<>();

        data.put("name", securityContext.getUserPrincipal().getName());
        return Response.ok(data).build();
    }

    @GET
    @Path("login")
    @PermitAll
    public Response login() {
        String token = Jwt.issuer("https://example.com/issuer").upn("admin@admin.com")
                .groups(new HashSet<>(Arrays.asList("Admin"))).expiresIn(Duration.ofDays(1)).sign();
        NewCookie cookie = new NewCookie.Builder("jwt").path("/").value(token).build();
        return Response.ok("Login success").cookie(cookie).build();
    }

}
