package id.putra.peoplelibrarysystem.resource.api.auth;

import jakarta.ws.rs.FormParam;

public class LoginRequestBody {
    @FormParam("username")
    private String username;

    @FormParam("password")
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
