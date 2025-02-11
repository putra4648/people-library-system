package id.putra.peoplelibrarysystem.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Request;
import jakarta.ws.rs.core.Response;

@Path("success")
public class GlobalController {
    @GET()
    public void successHandler(Request request, Response response) {

    }

}
