package id.putra.peoplelibrarysystem.resource.api.auth;

import jakarta.ws.rs.FormParam;

public class RegisterRequestBody {
    @FormParam("username") final String username;
    @FormParam("password") final String password;
    @FormParam("email") final String email;


    public RegisterRequestBody(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
