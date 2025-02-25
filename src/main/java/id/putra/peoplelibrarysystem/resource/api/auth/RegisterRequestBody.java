package id.putra.peoplelibrarysystem.resource.api.auth;

import jakarta.ws.rs.FormParam;

/// IDK why this is work
/// when using access modifier it doesn't work
public class RegisterRequestBody {
    @FormParam("username")
    String username;
    @FormParam("password")
    String password;
    @FormParam("email")
    String email;
}
