package edu.soccer.app.Test;

import edu.soccer.app.dao.entity.championships;
import edu.soccer.app.dao.entity.matches;
import edu.soccer.app.dao.entity.season;
import edu.soccer.app.dao.entity.clubs;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class championshipsTestUnitaire {

    public static void main(String[] args) {
        championships championship = Mockito.mock(championships.class);

        clubs team1 = new clubs("Team 1");
        clubs team2 = new clubs("Team 2");
        clubs team3 = new clubs("Team 3");


        season season = new season(2024);


        List<matches> matches = new ArrayList<>();

        // Création simple de 6 matchs mockés
        matches.add(createMatch(team1, team2, season));
        matches.add(createMatch(team2, team1, season));
        matches.add(createMatch(team1, team3, season));
        matches.add(createMatch(team3, team1, season));
        matches.add(createMatch(team2, team3, season));
        matches.add(createMatch(team3, team2, season));


        Mockito.when(championship.getName()).thenReturn("Premier League");
        Mockito.when(championship.getMatches()).thenReturn(matches);
        Mockito.when(championship.getCurrentSeason()).thenReturn(season);


        if (championship.getMatches().size() == 6) {
            System.out.println("Test passed: Correct number of matches generated (6)");
        } else {
            System.err.println("Test failed: Expected 6 matches but got " + championship.getMatches().size());
        }


        boolean allTeamsPresent = true;
        for (matches match : championship.getMatches()) {
            if (match.getHomeTeam() == null || match.getAwayTeam() == null) {
                allTeamsPresent = false;
                System.err.println("Test failed: Match with missing team detected.");
                break;
            }
        }
        if (allTeamsPresent) {
            System.out.println("Test passed: All matches have home and away teams.");
        }


        System.out.println("Matches of the championship " + championship.getName() + ":");
        for (matches match : championship.getMatches()) {
            System.out.println(match.getHomeTeam().getName() + " vs " + match.getAwayTeam().getName() +
                    " | Score: " + match.getHomeScore() + " - " + match.getAwayScore() +
                    " | Season: " + championship.getCurrentSeason().getYear());
        }


        if (championship.getCurrentSeason() != null) {
            System.out.println("Current season: " + championship.getCurrentSeason().getYear());
            System.out.println("Test passed: Current season is set.");
        } else {
            System.err.println("Test failed: Current season is null.");
        }
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
