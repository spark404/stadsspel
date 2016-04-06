package net.strocamp.stadsspel.controllers;

import net.strocamp.stadsspel.domain.Ranking;
import net.strocamp.stadsspel.providers.SpreadSheetProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ranking")
public class RankingController {

    @Autowired
    private SpreadSheetProvider spreadSheetProvider;

    @RequestMapping(method = RequestMethod.GET)
    public List<Ranking> ranking() throws Exception {
        List<Ranking> rankings = spreadSheetProvider.loadRanking();
        return rankings;
    }

}
