package edu.soccer.app.Test;

import edu.soccer.app.dao.entity.Match;
import edu.soccer.app.dao.entity.Season;
import edu.soccer.app.dao.entity.Team;
import edu.soccer.app.dao.operations.BestMatchCrudOperations;
import edu.soccer.app.dao.operations.BestMatchCrudOperationsImpl;

import java.util.List;

public class BestMatchTest {
    public static void main(String[] args) {
        Team realMadrid = new Team("Real Madrid FC");
        Team barcelona = new Team("FC Barcelona");
        Team psg = new Team("Paris Saint Germain");
        Team marseille = new Team("Olympique de Marseille");

        Season season2025 = new Season(2025);

        Match match1 = new Match(realMadrid, barcelona, season2025);
        match1.play(2, 3);

        Match match2 = new Match(barcelona, realMadrid, season2025);
        match2.play(4, 4);

        Match match3 = new Match(psg, marseille, season2025);
        match3.play(3, 0);

        BestMatchCrudOperations bestMatchService = new BestMatchCrudOperationsImpl();

        bestMatchService.addMatch(match1);
        bestMatchService.addMatch(match2);
        bestMatchService.addMatch(match3);

        System.out.println("Searching for a match:");
        Match retrievedMatch = bestMatchService.getMatchByTeams("Real Madrid FC", "FC Barcelona");
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
        Match updatedMatch = bestMatchService.getMatchByTeams("Paris Saint Germain", "Olympique de Marseille");
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
        List<Match> matches = bestMatchService.findAll();
        for (Match m : matches) {
            System.out.println(m.getHomeTeam().getName() + " vs " + m.getAwayTeam().getName() +
                    " | Season: " + m.getSeason().getYear() +
                    " | Score: " + m.getHomeScore() + " - " + m.getAwayScore());
        }

        System.out.println();

        Match bestMatch = bestMatchService.getBestMatch();
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
