package id.putra.peoplelibrarysystem.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("hello")
public class GlobalController {
    @GET
    public Response response() {
        return Response.ok("Hello").build();
    }

}
