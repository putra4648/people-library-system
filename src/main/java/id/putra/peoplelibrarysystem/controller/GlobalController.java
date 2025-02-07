package id.putra.peoplelibrarysystem.controller;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class GlobalController {
    @RequestMapping("/success")
    public void successHandler(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException {
        String roles = authentication.getAuthorities().toString();
        System.out.println(roles);

        if (roles.contains("ROLE_ADMIN")) {
            response.sendRedirect("admin");
        }

        if (roles.contains("ROLE_USER")) {
            response.sendRedirect("user");
        }

    }

}
