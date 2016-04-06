package net.strocamp.stadsspel.controllers;

import net.strocamp.stadsspel.domain.Ranking;
import net.strocamp.stadsspel.providers.SpreadSheetProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

    private List<Ranking> getRankings() throws Exception {
        return spreadSheetProvider.loadRanking();
    }
}
