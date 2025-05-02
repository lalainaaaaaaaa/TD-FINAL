package edu.soccer.app.Test;

import edu.soccer.app.dao.entity.matches;
import edu.soccer.app.dao.entity.season;
import edu.soccer.app.dao.entity.clubs;
import edu.soccer.app.dao.operations.matchMakerCrudOperations;
import edu.soccer.app.dao.operations.matchMakerCrudOperattionsImpl;

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

        // Créer une instance de l'implémentation
        matchMakerCrudOperations bestMatchService = new matchMakerCrudOperattionsImpl();

        bestMatchService.addMatch(m1);
        bestMatchService.addMatch(m2);
        bestMatchService.addMatch(m3);

        matches found = bestMatchService.getMatchByTeams("Real Madrid FC", "FC Barcelona");
        System.out.println("Found match: " + found);
        if (found != null && found.equals(m1)) {
            System.out.println("Match retrieval: OK");
        } else {
            System.out.println("Match retrieval: FAILED");
        }

        bestMatchService.updateMatchScore("Paris Saint Germain", "Olympique de Marseille", 2, 2);
        matches updated = bestMatchService.getMatchByTeams("Paris Saint Germain", "Olympique de Marseille");
        System.out.println("Updated match: " + updated);
        if (updated != null && updated.getHomeScore() == 2 && updated.getAwayScore() == 2) {
            System.out.println("Score update: OK");
        } else {
            System.out.println("Score update: FAILED");
        }

        bestMatchService.deleteMatch("FC Barcelona", "Real Madrid FC");
        List<matches> matches = bestMatchService.findAll();
        boolean deleted = true;
        for (edu.soccer.app.dao.entity.matches m : matches) {
            if (m.getHomeTeam().getName().equals("FC Barcelona") && m.getAwayTeam().getName().equals("Real Madrid FC")) {
                deleted = false;
                break;
            }
        }
        System.out.println("Matches after delete:");
        matches.forEach(System.out::println);
        if (deleted) {
            System.out.println("Delete match: OK");
        } else {
            System.out.println("Delete match: FAILED");
        }

        edu.soccer.app.dao.entity.matches best = bestMatchService.getBestMatch();
        System.out.println("Best match: " + best);
        if (best != null && best.equals(m2)) {
            System.out.println("Best match check: OK");
        } else {
            System.out.println("Best match check: FAILED");
        }
    }
}
