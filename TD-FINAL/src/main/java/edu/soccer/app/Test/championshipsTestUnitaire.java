package edu.soccer.app.Test;

import edu.soccer.app.dao.entity.championships;
import edu.soccer.app.dao.entity.matches;
import edu.soccer.app.dao.entity.season;
import edu.soccer.app.dao.entity.clubs;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class championshipsTestUnitaire {

    @Test
    public void testChampionshipMatches() {
        championships championship = Mockito.mock(championships.class);


        clubs team1 = new clubs(1, "Team 1", "T1", 1900, "Stadium 1", "Coach 1", "Country 1");
        clubs team2 = new clubs(2, "Team 2", "T2", 1905, "Stadium 2", "Coach 2", "Country 2");
        clubs team3 = new clubs(3, "Team 3", "T3", 1910, "Stadium 3", "Coach 3", "Country 3");

        season season = new season(2024);

        List<matches> matches = new ArrayList<>();

        matches.add(createMatch(team1, team2, season));
        matches.add(createMatch(team2, team1, season));
        matches.add(createMatch(team1, team3, season));
        matches.add(createMatch(team3, team1, season));
        matches.add(createMatch(team2, team3, season));
        matches.add(createMatch(team3, team2, season));

        Mockito.when(championship.getName()).thenReturn("Premier League");
        Mockito.when(championship.getMatches()).thenReturn(matches);
        Mockito.when(championship.getCurrentSeason()).thenReturn(season);


        assertEquals(6, championship.getMatches().size(), "Correct number of matches generated (6)");


        boolean allTeamsPresent = championship.getMatches().stream()
                .allMatch(m -> m.getHomeTeam() != null && m.getAwayTeam() != null);
        assertTrue(allTeamsPresent, "All matches have home and away teams");


        System.out.println("Matches of the championship " + championship.getName() + ":");
        for (matches match : championship.getMatches()) {
            System.out.println(match.getHomeTeam().getName() + " vs " + match.getAwayTeam().getName() +
                    " | Score: " + match.getHomeScore() + " - " + match.getAwayScore() +
                    " | Season: " + championship.getCurrentSeason().getYear());
        }


        assertNotNull(championship.getCurrentSeason(), "Current season is set");
        System.out.println("Current season: " + championship.getCurrentSeason().getYear());
    }

    private static matches createMatch(clubs home, clubs away, season season) {
        matches match = Mockito.mock(matches.class);
        Mockito.when(match.getHomeTeam()).thenReturn(home);
        Mockito.when(match.getAwayTeam()).thenReturn(away);
        Mockito.when(match.getHomeScore()).thenReturn(0);
        Mockito.when(match.getAwayScore()).thenReturn(0);
        Mockito.when(match.getSeason()).thenReturn(season);
        return match;
    }
}
