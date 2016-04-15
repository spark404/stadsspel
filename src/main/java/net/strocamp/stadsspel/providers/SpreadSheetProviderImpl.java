package net.strocamp.stadsspel.providers;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.gdata.client.spreadsheet.SpreadsheetService;
import com.google.gdata.data.spreadsheet.*;
import com.google.gdata.util.ServiceException;
import net.strocamp.stadsspel.domain.Event;
import net.strocamp.stadsspel.domain.Group;
import net.strocamp.stadsspel.domain.Location;
import net.strocamp.stadsspel.domain.Ranking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.*;

@Component
public class SpreadSheetProviderImpl implements GameDataProvider {
    private static final Logger LOG = LoggerFactory.getLogger(SpreadSheetProviderImpl.class);

    private static final String STADSSPEL_SHEET =
            "https://spreadsheets.google.com/feeds/spreadsheets/1YBWQfmIn0DVqLHuXdKsPRwc31wtUXdbdC8gE3xutQqA";

    public static final String RANKING_WORKSHEET = "Ranking";
    public static final String GROUPS_WORKSHEET = "Groepen";
    public static final String EVENTS_WORKSHEET = "Extrapunten";
    public static final String LOCATIONS_WORKSHEET = "Locaties";

    private SpreadsheetService service;

    @Autowired
    public SpreadSheetProviderImpl(@Value("${google.keyfile}") String keyfile) throws IOException {
        service = new SpreadsheetService("google-spreadsheet");

        File file = new File(keyfile);
        InputStream is = new FileInputStream(file);

        GoogleCredential credential = GoogleCredential
                .fromStream(is)
                .createScoped(Arrays.asList("https://spreadsheets.google.com/feeds"));

        credential.refreshToken();
        service.setOAuth2Credentials(credential);
    }

    @Override
    public List<Ranking> loadRanking() throws Exception {
        SpreadsheetEntry rankingSheet = getSpreadsheetEntry();

        String worksheetName = RANKING_WORKSHEET;
        WorksheetEntry rankingEntry = getWorksheetEntry(rankingSheet, worksheetName);

        URL rankingList = new URI(rankingEntry.getListFeedUrl().toString() + "?reverse=true&orderby=column:stand").toURL();
        ListFeed listFeed = service.getFeed(rankingList, ListFeed.class);

        List<Ranking> rankings  = new ArrayList<>();
        int i = 1;
        for (ListEntry listEntry: listFeed.getEntries()) {
            rankings.add(new Ranking(i++, listEntry.getTitle().getPlainText(), Integer.parseInt(listEntry.getCustomElements().getValue("stand"))));

        }
        return rankings;
    }

    @Override
    public Map<String, Group> loadGroups() throws Exception {
        SpreadsheetEntry spreadsheetEntry = getSpreadsheetEntry();
        WorksheetEntry worksheetEntry = getWorksheetEntry(spreadsheetEntry, GROUPS_WORKSHEET);

        URL rankingList = worksheetEntry.getListFeedUrl();
        ListFeed listFeed = service.getFeed(rankingList, ListFeed.class);

        Map<String, Group> groups  = new HashMap<>();
        for (ListEntry listEntry: listFeed.getEntries()) {
            String teamcode = listEntry.getCustomElements().getValue("teamcode");
            groups.put(teamcode, new Group(listEntry.getTitle().getPlainText(), teamcode));
        }
        return groups;
    }

    @Override
    public List<Event> loadEvents() throws Exception {
        SpreadsheetEntry spreadsheetEntry = getSpreadsheetEntry();
        WorksheetEntry worksheetEntry = getWorksheetEntry(spreadsheetEntry, EVENTS_WORKSHEET);

        URL eventList = new URI(worksheetEntry.getListFeedUrl().toString() + "?reverse=false").toURL();
        ListFeed listFeed = service.getFeed(eventList, ListFeed.class);

        List<Event> events = new ArrayList<>();
        for (ListEntry listEntry: listFeed.getEntries()) {
            Event event = new Event();
            event.setEvent(listEntry.getCustomElements().getValue("waarom"));
            event.setGroupName(listEntry.getCustomElements().getValue("wie"));
            event.setAmount(listEntry.getCustomElements().getValue("hoeveel"));
            event.setOtherGroupName(listEntry.getCustomElements().getValue("vanwie"));
            event.setLocationCode(listEntry.getCustomElements().getValue("waar"));
            events.add(event);
        }
        return events;
    }

    @Override
    public List<Location> loadLocations() throws Exception {
        SpreadsheetEntry spreadsheetEntry = getSpreadsheetEntry();
        WorksheetEntry worksheetEntry = getWorksheetEntry(spreadsheetEntry, LOCATIONS_WORKSHEET);

        URL eventList = worksheetEntry.getListFeedUrl();
        ListFeed listFeed = service.getFeed(eventList, ListFeed.class);

        List<Location> locations = new ArrayList<>();
        for (ListEntry listEntry: listFeed.getEntries()) {
            Location location = new Location();
            location.setCode(listEntry.getCustomElements().getValue("locatiecode"));
            location.setReference(listEntry.getCustomElements().getValue("referentie"));
            String naam = listEntry.getCustomElements().getValue("naam");
            location.setName((naam == null || naam.isEmpty()) ? location.getCode() : naam);
            location.setValue(Integer.parseInt(listEntry.getCustomElements().getValue("waarde")));
            location.setOwnerGroupName(listEntry.getCustomElements().getValue("eigenaar"));
            location.setRentValue(Integer.parseInt(listEntry.getCustomElements().getValue("huurprijs")));
            locations.add(location);
        }

        return locations;
    }

    private SpreadsheetEntry getSpreadsheetEntry() throws IOException, ServiceException {
        SpreadsheetEntry rankingSheet = service.getEntry(new URL(STADSSPEL_SHEET), SpreadsheetEntry.class);

        if (rankingSheet == null) {
            throw new IOException("Failed to find the Ranking spreadsheet");
        }
        return rankingSheet;
    }


    private WorksheetEntry getWorksheetEntry(SpreadsheetEntry rankingSheet, String worksheetName) throws IOException, ServiceException {
        WorksheetFeed worksheetFeed = service.getFeed(rankingSheet.getWorksheetFeedUrl(), WorksheetFeed.class);
        WorksheetEntry worksheetEntry = null;
        for (WorksheetEntry entry : worksheetFeed.getEntries()) {
            if (worksheetName.equals(entry.getTitle().getPlainText())) {
                worksheetEntry = entry;
            }
        }

        if (worksheetEntry == null) {
            throw new IOException("Failed to find the " + worksheetName + " worksheet");
        }

        return worksheetEntry;
    }


}
