package id.putra.peoplelibrarysystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
    @GetMapping("")
    public ModelAndView index(ModelMap model) {
        model.put("message", "People Library System");
        return new ModelAndView("index", model);
    }
}
