package net.strocamp.stadsspel.controllers;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ResetController {
    @RequestMapping("/reset")
    ModelAndView reset(HttpServletResponse response) throws Exception {
        response.addCookie(new Cookie("team",null));

        ModelAndView modelAndView = new ModelAndView("redirect:/");
        return modelAndView;
    }


}
