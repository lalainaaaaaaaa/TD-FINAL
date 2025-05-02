package edu.soccer.app.Test;

import edu.soccer.app.dao.entity.championships;
import edu.soccer.app.dao.entity.matches;
import edu.soccer.app.dao.entity.season;
import edu.soccer.app.dao.entity.clubs;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class championshipsTestUnitaire {
    public static void main(String[] args) {
        try {
            championships championship = new championships("Premier League", "England");

            clubs team1 = new clubs("Team 1");
            clubs team2 = new clubs("Team 2");
            clubs team3 = new clubs("Team 3");

            championship.addTeam(team1);
            championship.addTeam(team2);
            championship.addTeam(team3);

            season season = new season(2024);
            championship.setCurrentSeason(season);

            championship.generateMatches();

            List<matches> matches = championship.getMatches();
            assertEquals(6, matches.size(), "Match generation should create 6 matches.");

            for (edu.soccer.app.dao.entity.matches match : matches) {
                assertNotNull(match.getHomeTeam(), "Home team should not be null.");
                assertNotNull(match.getAwayTeam(), "Away team should not be null.");
            }

            edu.soccer.app.dao.entity.season currentSeason = championship.getCurrentSeason();
            assertNotNull(currentSeason, "Current season should not be null.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}