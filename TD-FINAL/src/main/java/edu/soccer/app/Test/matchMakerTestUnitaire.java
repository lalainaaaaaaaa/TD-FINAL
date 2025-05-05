package edu.soccer.app.Test;

import edu.soccer.app.dao.entity.matches;
import edu.soccer.app.dao.entity.season;
import edu.soccer.app.dao.entity.clubs;
import edu.soccer.app.dao.operations.matchMakerCrudOperations;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class matchMakerTestUnitaire {

    public static void main(String[] args) {
        clubs team1 = new clubs("Real Madrid FC");
        clubs team2 = new clubs("FC Barcelona");
        clubs team3 = new clubs("Paris Saint Germain");
        clubs team4 = new clubs("Olympique de Marseille");
        season season = new season(2025);


        matches m1 = new matches(team1, team2, season);
        m1.play(2, 3);
        matches m2 = new matches(team2, team1, season);
        m2.play(4, 4);
        matches m3 = new matches(team3, team4, season);
        m3.play(3, 0);


        matchMakerCrudOperations matchService = Mockito.mock(matchMakerCrudOperations.class);


        Mockito.when(matchService.findAll()).thenReturn(Arrays.asList(m1, m2, m3));
        Mockito.when(matchService.getMatchByTeams("Real Madrid FC", "FC Barcelona")).thenReturn(m1);
        Mockito.when(matchService.getMatchByTeams("Paris Saint Germain", "Olympique de Marseille")).thenReturn(m3);
        Mockito.when(matchService.getBestMatch()).thenReturn(m2);


        matches updatedM3 = new matches(team3, team4, season);
        updatedM3.play(2, 2);
        Mockito.when(matchService.getMatchByTeams("Paris Saint Germain", "Olympique de Marseille")).thenReturn(updatedM3);


        Mockito.when(matchService.findAll()).thenReturn(Arrays.asList(m1, updatedM3));



        matches found = matchService.getMatchByTeams("Real Madrid FC", "FC Barcelona");
        System.out.println("Found match: " + found);
        if (found != null && found.equals(m1)) {
            System.out.println("Match retrieval: OK");
        } else {
            System.out.println("Match retrieval: FAILED");
        }

        matches updated = matchService.getMatchByTeams("Paris Saint Germain", "Olympique de Marseille");
        System.out.println("Updated match: " + updated);
        if (updated != null && updated.getHomeScore() == 2 && updated.getAwayScore() == 2) {
            System.out.println("Score update: OK");
        } else {
            System.out.println("Score update: FAILED");
        }

        List<matches> matchesList = matchService.findAll();
        boolean deleted = true;
        for (matches m : matchesList) {
            if (m.getHomeTeam().getName().equals("FC Barcelona") && m.getAwayTeam().getName().equals("Real Madrid FC")) {
                deleted = false;
                break;
            }
        }
        System.out.println("Matches after delete:");
        for (matches m : matchesList) {
            System.out.println(m);
        }
        if (deleted) {
            System.out.println("Delete match: OK");
        } else {
            System.out.println("Delete match: FAILED");
        }

        matches best = matchService.getBestMatch();
        System.out.println("Best match: " + best);
        if (best != null && best.equals(m2)) {
            System.out.println("Best match check: OK");
        } else {
            System.out.println("Best match check: FAILED");
        }
    }
}
