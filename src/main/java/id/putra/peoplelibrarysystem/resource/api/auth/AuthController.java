package id.putra.peoplelibrarysystem.resource.api.auth;

import io.smallrye.jwt.build.Jwt;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.core.*;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;

public class AuthController implements ApiAuthRoute {


    @Override
    public Response apiLogin(@FormParam("username") String username, @FormParam("password") String password) {
        String token = Jwt.issuer("https://example.com/issuer").upn(username)
                .groups(new HashSet<>(List.of("Admin"))).expiresIn(Duration.ofDays(1)).sign();
        NewCookie cookie = new NewCookie.Builder("jwt").path("/").value(token).build();
        return Response.seeOther(UriBuilder.fromUri("/api/login/redirect").build()).cookie(cookie).build();
    }


    @Override
    public Response apiRedirectLogin(@Context SecurityContext securityContext) {
        boolean isAdmin = securityContext.isUserInRole("Admin");
        if (isAdmin) {
            return Response.seeOther(UriBuilder.fromUri("/admin").build()).build();
        } else {
            return Response.seeOther(UriBuilder.fromUri("/user").build()).build();
        }
    }
}
