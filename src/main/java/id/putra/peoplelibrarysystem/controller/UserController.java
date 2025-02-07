package id.putra.peoplelibrarysystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("user")
public class UserController {
    @GetMapping("")
    public ModelAndView user(ModelMap model) {
        model.put("message", "Hello User");
        return new ModelAndView("user/index", model);
    }

}
