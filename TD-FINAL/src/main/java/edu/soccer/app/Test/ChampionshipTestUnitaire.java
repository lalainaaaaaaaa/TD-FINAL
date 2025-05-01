package edu.soccer.app.Test;

import edu.soccer.app.dao.entity.Championship;
import edu.soccer.app.dao.entity.Match;
import edu.soccer.app.dao.entity.Season;
import edu.soccer.app.dao.entity.Team;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ChampionshipTestUnitaire {
    public static void main(String[] args) {
        try {
            Championship championship = new Championship("Premier League", "England");

            Team team1 = new Team("Team 1");
            Team team2 = new Team("Team 2");
            Team team3 = new Team("Team 3");

            championship.addTeam(team1);
            championship.addTeam(team2);
            championship.addTeam(team3);

            Season season = new Season(2024);
            championship.setCurrentSeason(season);

            championship.generateMatches();

            List<Match> matches = championship.getMatches();
            assertEquals(6, matches.size(), "Match generation should create 6 matches.");

            for (Match match : matches) {
                assertNotNull(match.getHomeTeam(), "Home team should not be null.");
                assertNotNull(match.getAwayTeam(), "Away team should not be null.");
            }

            Season currentSeason = championship.getCurrentSeason();
            assertNotNull(currentSeason, "Current season should not be null.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}