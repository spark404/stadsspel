package net.strocamp.stadsspel.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MiscInfoController {
    @RequestMapping("/overig")
    ModelAndView overig() throws Exception {
        ModelAndView modelAndView = new ModelAndView("overig");
        return modelAndView;
    }
}
