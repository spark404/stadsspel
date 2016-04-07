package net.strocamp.stadsspel.controllers;

import net.strocamp.stadsspel.domain.Ranking;
import net.strocamp.stadsspel.providers.SpreadSheetProvider;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private SpreadSheetProvider spreadSheetProvider;

    @RequestMapping("/")
    ModelAndView index() throws Exception {
        List<Ranking> rankings = getRankings();

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("rankings", rankings);
        return modelAndView;
    }

    @RequestMapping("/events")
    ModelAndView events(@CookieValue(value = "team", defaultValue = "#{null}") String team) throws Exception {
        if (team == null) {
            ModelAndView modelAndView = new ModelAndView("teamsetter");
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("events");
        return modelAndView;
    }

    @RequestMapping("/overig")
    ModelAndView overig() throws Exception {
        ModelAndView modelAndView = new ModelAndView("overig");
        return modelAndView;
    }

    @RequestMapping("/teamconfig")
    ModelAndView teamconfig(ModelAndView teamform, HttpServletResponse response) throws Exception {
        response.addCookie(new Cookie("team","test"));

        ModelAndView modelAndView = new ModelAndView("events");
        return modelAndView;
    }

    @RequestMapping("/reset")
    ModelAndView reset(HttpServletResponse response) throws Exception {
        response.addCookie(new Cookie("team",null));

        ModelAndView modelAndView = new ModelAndView("redirect:/");
        return modelAndView;
    }

    private List<Ranking> getRankings() throws Exception {
        return spreadSheetProvider.loadRanking();
    }
}
