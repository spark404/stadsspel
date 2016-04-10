package net.strocamp.stadsspel.controllers;

import net.strocamp.stadsspel.domain.Event;
import net.strocamp.stadsspel.domain.Group;
import net.strocamp.stadsspel.domain.TeamInput;
import net.strocamp.stadsspel.providers.GameDataProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class EventsController {
    private static final Logger LOG = LoggerFactory.getLogger(EventsController.class);

    private GameDataProvider gameDataProvider;

    @Autowired
    public EventsController(GameDataProvider gameDataProvider) {
        this.gameDataProvider = gameDataProvider;
    }

    @RequestMapping("/events")
    ModelAndView events(@CookieValue(value = "team", defaultValue = "#{null}") String team) throws Exception {
        if (team == null) {
            ModelAndView modelAndView = new ModelAndView("teamsetter");
            modelAndView.addObject(new TeamInput());
            return modelAndView;
        }

        Map<String,Group> groups = gameDataProvider.loadGroups();
        if (!groups.containsKey(team)) {
            ModelAndView modelAndView = new ModelAndView("teamsetter");
            modelAndView.addObject(new TeamInput());
            return modelAndView;
        }

        Group group = groups.get(team);
        List<Event> events = gameDataProvider.loadEvents();
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

}
