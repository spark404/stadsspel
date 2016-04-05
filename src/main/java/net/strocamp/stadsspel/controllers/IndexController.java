package net.strocamp.stadsspel.controllers;

import net.strocamp.stadsspel.domain.Ranking;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    @RequestMapping("/")
    ModelAndView index() {
        List<Ranking> rankings = getRankings();

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("rankings", rankings);
        return modelAndView;
    }

    private List<Ranking> getRankings() {
        List<Ranking> rankings = new ArrayList<>();
        rankings.add(new Ranking(1, "de verzamelaars", 1000000));
        rankings.add(new Ranking(2, "de andere verzamelaars", 900000));
        rankings.add(new Ranking(3, "de andere verzamelaars", 800000));
        rankings.add(new Ranking(4, "de andere verzamelaars", 700000));
        rankings.add(new Ranking(5, "de andere verzamelaars", 600000));
        rankings.add(new Ranking(6, "de andere verzamelaars", 150000));
        return rankings;
    }
}
