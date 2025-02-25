package id.putra.peoplelibrarysystem.resource.api.auth;

import id.putra.peoplelibrarysystem.dto.RoleDto;
import id.putra.peoplelibrarysystem.dto.UserDto;
import id.putra.peoplelibrarysystem.exception.UserException;
import id.putra.peoplelibrarysystem.service.RoleService;
import id.putra.peoplelibrarysystem.service.UserService;
import io.quarkus.panache.common.Sort;
import io.smallrye.jwt.build.Jwt;
import jakarta.annotation.security.PermitAll;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.NewCookie;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;
import jakarta.ws.rs.core.UriBuilder;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@PermitAll
public class ApiAuthResource implements ApiAuthRoute {
    @Inject
    UserService userService;

    @Inject
    RoleService roleService;

    @Override
    public Response apiLogin(LoginRequestBody loginRequest) throws UserException {
        var user = userService.findOne("username", Sort.ascending("username"), UserDto.builder().username(loginRequest.getUsername()).build());
        NewCookie cookie;
        if (user != null) {
            var token = Jwt.issuer("https://example.com/issuer").upn(user.getUsername())
                    .groups(new HashSet<>(List.of("User"))).expiresIn(Duration.ofDays(1)).sign();
            cookie = new NewCookie.Builder("jwt").path("/").value(token).build();
        } else {
            throw new UserException("Username not found");
        }
        return Response.seeOther(UriBuilder.fromUri("/api/login/redirect").build()).cookie(cookie).build();
    }

    @Override
    public Response apiRegister(RegisterRequestBody registerRequest) throws UserException {
        var user = UserDto
                .builder()
                .email(registerRequest.email)
                .username(registerRequest.username)
                .password(registerRequest.password)
                .role(RoleDto.builder().name("USER").build())
                .build();
        userService.save(user);
        return Response.seeOther(UriBuilder.fromUri("/auth/login").build()).build();
    }


    @Override
    public Response apiRedirectLogin(SecurityContext securityContext) {
        var isAdmin = securityContext.isUserInRole("Admin");
        if (isAdmin) {
            return Response.seeOther(UriBuilder.fromUri("/admin").build()).build();
        } else {
            return Response.seeOther(UriBuilder.fromUri("/user").build()).build();
        }
    }

    @Override
    public Response apiLogout(SecurityContext securityContext) {
        var cookie = new NewCookie.Builder("jwt").maxAge(0).expiry(Date.from(Instant.now())).path("/").build();
        return Response.seeOther(UriBuilder.fromUri("/auth/login").build()).cookie(cookie).build();
    }
}
