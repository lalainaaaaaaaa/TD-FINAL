package edu.soccer.app.Test;

import edu.soccer.app.dao.entity.Match;
import edu.soccer.app.dao.entity.Season;
import edu.soccer.app.dao.entity.Team;
import edu.soccer.app.dao.operations.BestMatchCrudOperations;
import edu.soccer.app.dao.operations.BestMatchCrudOperationsImpl;

import java.util.List;

public class BestMatchTestUnitaire {

    public static void main(String[] args) {
        Team team1 = new Team("Real Madrid FC");
        Team team2 = new Team("FC Barcelona");
        Team team3 = new Team("Paris Saint Germain");
        Team team4 = new Team("Olympique de Marseille");

        Season season = new Season(2025);

        Match m1 = new Match(team1, team2, season);
        m1.play(2, 3);
        Match m2 = new Match(team2, team1, season);
        m2.play(4, 4);
        Match m3 = new Match(team3, team4, season);
        m3.play(3, 0);

        // Créer une instance de l'implémentation
        BestMatchCrudOperations bestMatchService = new BestMatchCrudOperationsImpl();

        bestMatchService.addMatch(m1);
        bestMatchService.addMatch(m2);
        bestMatchService.addMatch(m3);

        Match found = bestMatchService.getMatchByTeams("Real Madrid FC", "FC Barcelona");
        System.out.println("Found match: " + found);
        if (found != null && found.equals(m1)) {
            System.out.println("Match retrieval: OK");
        } else {
            System.out.println("Match retrieval: FAILED");
        }

        bestMatchService.updateMatchScore("Paris Saint Germain", "Olympique de Marseille", 2, 2);
        Match updated = bestMatchService.getMatchByTeams("Paris Saint Germain", "Olympique de Marseille");
        System.out.println("Updated match: " + updated);
        if (updated != null && updated.getHomeScore() == 2 && updated.getAwayScore() == 2) {
            System.out.println("Score update: OK");
        } else {
            System.out.println("Score update: FAILED");
        }

        bestMatchService.deleteMatch("FC Barcelona", "Real Madrid FC");
        List<Match> matches = bestMatchService.findAll();
        boolean deleted = true;
        for (Match m : matches) {
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

        Match best = bestMatchService.getBestMatch();
        System.out.println("Best match: " + best);
        if (best != null && best.equals(m2)) {
            System.out.println("Best match check: OK");
        } else {
            System.out.println("Best match check: FAILED");
        }
    }
}
