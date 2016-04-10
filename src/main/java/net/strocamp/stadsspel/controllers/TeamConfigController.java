package net.strocamp.stadsspel.controllers;

import net.strocamp.stadsspel.domain.Group;
import net.strocamp.stadsspel.domain.TeamInput;
import net.strocamp.stadsspel.providers.GameDataProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class TeamConfigController {
    private static final Logger LOG = LoggerFactory.getLogger(TeamConfigController.class);

    @Autowired
    private GameDataProvider gameDataProvider;

    @RequestMapping(value = "/teamconfig", method = RequestMethod.POST)
    ModelAndView teamconfig(@ModelAttribute TeamInput teamInput, HttpServletResponse response) throws Exception {
        String teamCode = teamInput.getTeamCode();

        LOG.debug("Received team {}", teamCode);
        Map<String,Group> groups = gameDataProvider.loadGroups();
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


}
