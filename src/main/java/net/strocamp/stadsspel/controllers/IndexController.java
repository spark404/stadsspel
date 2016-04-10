package net.strocamp.stadsspel.controllers;

import net.strocamp.stadsspel.domain.Event;
import net.strocamp.stadsspel.domain.Group;
import net.strocamp.stadsspel.domain.Ranking;
import net.strocamp.stadsspel.domain.TeamInput;
import net.strocamp.stadsspel.providers.SpreadSheetProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {
    private static final Logger LOG = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private SpreadSheetProvider spreadSheetProvider;

    @RequestMapping("/")
    ModelAndView index(@CookieValue(value = "team", defaultValue = "#{null}") String team) throws Exception {
        List<Ranking> rankings = getRankings();

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("rankings", rankings);
        if (team != null) {
            Group group = spreadSheetProvider.loadGroups().get(team);
            modelAndView.addObject("group", group);
        }
        return modelAndView;
    }

    @RequestMapping("/events")
    ModelAndView events(@CookieValue(value = "team", defaultValue = "#{null}") String team) throws Exception {
        if (team == null) {
            ModelAndView modelAndView = new ModelAndView("teamsetter");
            modelAndView.addObject(new TeamInput());
            return modelAndView;
        }

        Map<String,Group> groups = spreadSheetProvider.loadGroups();
        if (!groups.containsKey(team)) {
            ModelAndView modelAndView = new ModelAndView("teamsetter");
            modelAndView.addObject(new TeamInput());
            return modelAndView;
        }

        Group group = groups.get(team);
        List<Event> events = spreadSheetProvider.loadEvents();
        List<Event> filteredEvents = new ArrayList<>();
        for (Event event : events) {
            if (group.getGroupname().equals(event.getGroupName())) {
                filteredEvents.add(event);
            }
            if (event.getOtherGroupName() != null && group.getGroupname().equals(event.getOtherGroupName())) {
                filteredEvents.add(event);
            }
        }

        ModelAndView modelAndView = new ModelAndView("events");
        modelAndView.addObject("group", groups.get(team));
        modelAndView.addObject("events", filteredEvents);
        return modelAndView;
    }

    @RequestMapping("/overig")
    ModelAndView overig() throws Exception {
        ModelAndView modelAndView = new ModelAndView("overig");
        return modelAndView;
    }

    @RequestMapping(value = "/teamconfig", method = RequestMethod.POST)
    ModelAndView teamconfig(@ModelAttribute TeamInput teamInput, HttpServletResponse response) throws Exception {
        String teamCode = teamInput.getTeamCode();

        LOG.debug("Received team {}", teamCode);
        Map<String,Group> groups = spreadSheetProvider.loadGroups();
        if (!groups.containsKey(teamCode)) {
            ModelAndView modelAndView = new ModelAndView("teamsetter");
            modelAndView.addObject("teamInput", teamInput);
            modelAndView.addObject("error", "Teamcode " + teamCode + " is niet geldig!");
            return modelAndView;
        }

        response.addCookie(new Cookie("team", teamCode));

        ModelAndView modelAndView = new ModelAndView("redirect:events");
        modelAndView.addObject("group", groups.get(teamCode));
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
