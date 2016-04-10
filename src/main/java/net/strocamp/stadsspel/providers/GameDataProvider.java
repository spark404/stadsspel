package net.strocamp.stadsspel.providers;

import net.strocamp.stadsspel.domain.Event;
import net.strocamp.stadsspel.domain.Group;
import net.strocamp.stadsspel.domain.Ranking;

import java.util.List;
import java.util.Map;

public interface GameDataProvider {
    List<Ranking> loadRanking() throws Exception;

    Map<String, Group> loadGroups() throws Exception;

    List<Event> loadEvents() throws Exception;
}
