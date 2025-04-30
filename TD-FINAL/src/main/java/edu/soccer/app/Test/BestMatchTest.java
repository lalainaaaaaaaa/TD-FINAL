package edu.soccer.app.Test;

import edu.soccer.app.dao.entity.Match;
import edu.soccer.app.dao.entity.Season;
import edu.soccer.app.dao.entity.Team;
import edu.soccer.app.dao.operations.BestMatchCrudOperations;

public class BestMatchTest {
    public static void main(String[] args) {
        Team realMadrid = new Team("Real Madrid FC", "Santiago Bernabeu", "RMA", null);
        Team barcelona = new Team("FC Barcelona", "Lluís Companys", "FCB", null);
        Team psg = new Team("Paris Saint Germain", "Parc des Princes", "PSG", null);
        Team marseille = new Team("Olympique de Marseille", "Orange Vélodrome", "OM", null);

        Season season2025 = new Season(2025);

        Match match1 = new Match(realMadrid, barcelona, season2025);
        match1.play(2, 3); // Score: Real Madrid 2 - 3 FC Barcelona
        Match match2 = new Match(barcelona, realMadrid, season2025);
        match2.play(4, 4); // Score: FC Barcelona 4 - 4 Real Madrid
        Match match3 = new Match(psg, marseille, season2025);
        match3.play(3, 0); // Score: PSG 3 - Marseille 0

        BestMatchCrudOperations.addMatch(match1);
        BestMatchCrudOperations.addMatch(match2);
        BestMatchCrudOperations.addMatch(match3);

        Match retrievedMatch = BestMatchCrudOperations.getMatchByTeams("Real Madrid FC", "FC Barcelona");
        System.out.println("Retrieved match: " + retrievedMatch);

        BestMatchCrudOperations.updateMatchScore("Paris Saint Germain", "Olympique de Marseille", 2, 2);
        Match updatedMatch = BestMatchCrudOperations.getMatchByTeams("Paris Saint Germain", "Olympique de Marseille");
        System.out.println("Match after update: " + updatedMatch);

        BestMatchCrudOperations.deleteMatch("FC Barcelona", "Real Madrid FC");
        System.out.println("List after deletion:");
        for (Match m : BestMatchCrudOperations.findAll()) {
            System.out.println(m);
        }

        Match bestMatch = BestMatchCrudOperations.getBestMatch();
        System.out.println("Best match (largest score difference): " + bestMatch);
    }
}
