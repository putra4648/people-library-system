package id.putra.peoplelibrarysystem.resource.api.auth;

import id.putra.peoplelibrarysystem.entity.User;
import id.putra.peoplelibrarysystem.exception.UsernameException;
import id.putra.peoplelibrarysystem.repository.UserRepository;
import id.putra.peoplelibrarysystem.response.AppGeneralResponse;
import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.smallrye.jwt.build.Jwt;
import jakarta.annotation.security.PermitAll;
import jakarta.inject.Inject;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.core.*;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;

@PermitAll
public class ApiAuthResource implements ApiAuthRoute {
    @Inject
    UserRepository userRepository;

    @Override
    public Response apiLogin(@BeanParam LoginRequestBody loginRequest) throws UsernameException {
        PanacheQuery<User> user = userRepository.find("username", loginRequest.getUsername());
        NewCookie cookie;
        if (user.count() == 1) {
            String token = Jwt.issuer("https://example.com/issuer").upn(loginRequest.getUsername())
                    .groups(new HashSet<>(List.of("User"))).expiresIn(Duration.ofDays(1)).sign();
            cookie = new NewCookie.Builder("jwt").path("/").value(token).build();
        } else {
            throw new UsernameException("Username not found");
        }

        return Response.seeOther(UriBuilder.fromUri("/api/login/redirect").build()).cookie(cookie).build();
    }

    @Override
    public Response apiRegister(@BeanParam RegisterRequestBody registerRequest) {
        User user = User
                .builder()
                .username(registerRequest.username)
                .password(BcryptUtil.bcryptHash(registerRequest.password, 10))
                .build();
        userRepository.persist(user);
        AppGeneralResponse body = new AppGeneralResponse(false, "User registered successfully");
        return Response.ok(body).build();
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
