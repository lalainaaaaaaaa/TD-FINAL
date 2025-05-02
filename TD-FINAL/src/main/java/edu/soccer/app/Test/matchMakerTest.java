package edu.soccer.app.Test;

import edu.soccer.app.dao.entity.matches;
import edu.soccer.app.dao.entity.season;
import edu.soccer.app.dao.entity.clubs;
import edu.soccer.app.dao.operations.matchMakerCrudOperations;
import edu.soccer.app.dao.operations.matchMakerCrudOperattionsImpl;

import java.util.List;

public class matchMakerTest {
    public static void main(String[] args) {
        clubs realMadrid = new clubs("Real Madrid FC");
        clubs barcelona = new clubs("FC Barcelona");
        clubs psg = new clubs("Paris Saint Germain");
        clubs marseille = new clubs("Olympique de Marseille");

        season season2025 = new season(2025);

        matches match1 = new matches(realMadrid, barcelona, season2025);
        match1.play(2, 3);

        matches match2 = new matches(barcelona, realMadrid, season2025);
        match2.play(4, 4);

        matches match3 = new matches(psg, marseille, season2025);
        match3.play(3, 0);

        matchMakerCrudOperations bestMatchService = new matchMakerCrudOperattionsImpl();

        bestMatchService.addMatch(match1);
        bestMatchService.addMatch(match2);
        bestMatchService.addMatch(match3);

        System.out.println("Searching for a match:");
        matches retrievedMatch = bestMatchService.getMatchByTeams("Real Madrid FC", "FC Barcelona");
        if (retrievedMatch != null) {
            System.out.println("Match found: " + retrievedMatch.getHomeTeam().getName() + " vs " +
                    retrievedMatch.getAwayTeam().getName() + " | Score: " +
                    retrievedMatch.getHomeScore() + " - " + retrievedMatch.getAwayScore() +
                    " | Season: " + retrievedMatch.getSeason().getYear());
        } else {
            System.out.println("No match found.");
        }

        System.out.println();

        bestMatchService.updateMatchScore("Paris Saint Germain", "Olympique de Marseille", 2, 2);
        matches updatedMatch = bestMatchService.getMatchByTeams("Paris Saint Germain", "Olympique de Marseille");
        System.out.println("After update:");
        if (updatedMatch != null) {
            System.out.println("Updated match: " + updatedMatch.getHomeTeam().getName() + " vs " +
                    updatedMatch.getAwayTeam().getName() + " | Score: " +
                    updatedMatch.getHomeScore() + " - " + updatedMatch.getAwayScore());
        } else {
            System.out.println("No match to update.");
        }

        System.out.println();

        bestMatchService.deleteMatch("FC Barcelona", "Real Madrid FC");
        System.out.println("List of matches after deletion:");
        List<matches> matches = bestMatchService.findAll();
        for (edu.soccer.app.dao.entity.matches m : matches) {
            System.out.println(m.getHomeTeam().getName() + " vs " + m.getAwayTeam().getName() +
                    " | Season: " + m.getSeason().getYear() +
                    " | Score: " + m.getHomeScore() + " - " + m.getAwayScore());
        }

        System.out.println();

        edu.soccer.app.dao.entity.matches bestMatch = bestMatchService.getBestMatch();
        System.out.println("Best match (largest goal difference):");
        if (bestMatch != null) {
            int diff = Math.abs(bestMatch.getHomeScore() - bestMatch.getAwayScore());
            System.out.println(bestMatch.getHomeTeam().getName() + " vs " + bestMatch.getAwayTeam().getName() +
                    " | Score: " + bestMatch.getHomeScore() + " - " + bestMatch.getAwayScore() +
                    " | Difference: " + diff);
        } else {
            System.out.println("No match available.");
        }
    }
}
