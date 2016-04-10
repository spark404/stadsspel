package net.strocamp.stadsspel.controllers;

import net.strocamp.stadsspel.domain.Group;
import net.strocamp.stadsspel.domain.Ranking;
import net.strocamp.stadsspel.providers.GameDataProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class IndexController {
    private static final Logger LOG = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private GameDataProvider gameDataProvider;

    @RequestMapping("/")
    ModelAndView index(@CookieValue(value = "team", defaultValue = "#{null}") String team) throws Exception {
        List<Ranking> rankings = getRankings();

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("rankings", rankings);
        if (team != null) {
            Group group = gameDataProvider.loadGroups().get(team);
            modelAndView.addObject("group", group);
        }
        return modelAndView;
    }


    private List<Ranking> getRankings() throws Exception {
        return gameDataProvider.loadRanking();
    }
}
