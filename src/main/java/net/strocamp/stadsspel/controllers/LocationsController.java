package net.strocamp.stadsspel.controllers;


import net.strocamp.stadsspel.domain.Group;
import net.strocamp.stadsspel.domain.Location;
import net.strocamp.stadsspel.providers.GameDataProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class LocationsController {
    @Autowired
    private GameDataProvider gameDataProvider;

    @RequestMapping("/locations")
    ModelAndView index(@CookieValue(value = "team", defaultValue = "#{null}") String team) throws Exception {
        List<Location> locations = gameDataProvider.loadLocations();

        ModelAndView modelAndView = new ModelAndView("lokaties");
        modelAndView.addObject("locations", locations);
        if (team != null) {
            Group group = gameDataProvider.loadGroups().get(team);
            modelAndView.addObject("group", group);
        }
        return modelAndView;
    }

}
