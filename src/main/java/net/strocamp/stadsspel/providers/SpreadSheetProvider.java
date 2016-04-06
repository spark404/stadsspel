package net.strocamp.stadsspel.providers;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.gdata.client.spreadsheet.SpreadsheetService;
import com.google.gdata.data.spreadsheet.ListEntry;
import com.google.gdata.data.spreadsheet.ListFeed;
import com.google.gdata.data.spreadsheet.SpreadsheetEntry;
import com.google.gdata.data.spreadsheet.SpreadsheetFeed;
import com.google.gdata.data.spreadsheet.WorksheetEntry;
import com.google.gdata.data.spreadsheet.WorksheetFeed;
import com.google.gdata.util.ServiceException;
import net.strocamp.stadsspel.domain.Ranking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SpreadSheetProvider {
    private static final Logger LOG = LoggerFactory.getLogger(SpreadSheetProvider.class);

    private static final String STADSSPEL_SHEET =
            "https://spreadsheets.google.com/feeds/spreadsheets/1YBWQfmIn0DVqLHuXdKsPRwc31wtUXdbdC8gE3xutQqA";

    private SpreadsheetService service;

    public SpreadSheetProvider() throws IOException {
        service = new SpreadsheetService("google-spreadsheet");

        File file = new File("/Users/htrippaers/IdeaProjects/stadsspel/google-servicekey.json");
        InputStream is = new FileInputStream(file);

        GoogleCredential credential = GoogleCredential
                .fromStream(is)
                .createScoped(Arrays.asList("https://spreadsheets.google.com/feeds"));

        credential.refreshToken();
        service.setOAuth2Credentials(credential);
    }

    public List<Ranking> loadRanking() throws Exception {
        SpreadsheetEntry rankingSheet = service.getEntry(new URL(STADSSPEL_SHEET), SpreadsheetEntry.class);

        if (rankingSheet == null) {
            throw new IOException("Failed to find the Ranking spreadsheet");
        }

        WorksheetFeed worksheetFeed = service.getFeed(rankingSheet.getWorksheetFeedUrl(), WorksheetFeed.class);
        WorksheetEntry rankingEntry = null;
        for (WorksheetEntry entry : worksheetFeed.getEntries()) {
            LOG.debug(entry.getTitle().getPlainText());
            if ("Ranking".equals(entry.getTitle().getPlainText())) {
                rankingEntry = entry;
            }
        }

        if (rankingEntry == null) {
            throw new Exception("No ranking sheet");
        }

        URL rankingList = new URI(rankingEntry.getListFeedUrl().toString() + "?reverse=true&orderby=column:stand").toURL();
        ListFeed listFeed = service.getFeed(rankingList, ListFeed.class);

        List<Ranking> rankings  = new ArrayList<>();
        int i = 1;
        for (ListEntry listEntry: listFeed.getEntries()) {
            LOG.debug("ListEntry: {} -> {}", listEntry.getTitle().getPlainText(), listEntry.getCustomElements().getValue("stand"));
            rankings.add(new Ranking(i++, listEntry.getTitle().getPlainText(), Integer.parseInt(listEntry.getCustomElements().getValue("stand"))));

        }
        return rankings;
    }
}
