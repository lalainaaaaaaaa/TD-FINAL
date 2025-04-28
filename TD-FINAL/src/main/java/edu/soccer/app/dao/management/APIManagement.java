//Pour gérer la gestion de statistiques du match


package edu.soccer.app.dao.management;

import edu.soccer.app.dao.entity.Match;
import edu.soccer.app.dao.entity.Championship;

import java.util.ArrayList;
import java.util.List;

public class APIManagement {
    private List<Match> matchStatistics;

    public APIManagement() {
        this.matchStatistics = new ArrayList<>();
    }

    public void recordMatchStatistics(Match match) {
        matchStatistics.add(match);
        System.out.println("Match statistics recorded: " + match.getHomeTeam().getName() + " vs " + match.getAwayTeam().getName());
    }

    public List<Match> retrieveMatchStatistics() {
        return matchStatistics;
    }

    public void retrieveChampionshipStatistics(Championship championship) {
        System.out.println("Retrieving statistics for championship: " + championship.getName());
        for (var team : championship.getTeams()) {
            var stats = team.getCollectiveStatistics();
            System.out.println("Team: " + team.getName() + ", Points: " + stats.getPoints());
        }
    }
}




//Stockage des matchs : Elle a une liste où elle garde tous les matchs enregistrés.
//Enregistrement des matchs : Quand un match se termine, on peut l'ajouter à cette liste avec la méthode recordMatchStatistics.
//Récupération des matchs : On peut voir tous les matchs enregistrés en utilisant retrieveMatchStatistics.
//Statistiques des championnats : On peut aussi obtenir des informations sur les équipes d'un championnat, comme leur nom et le nombre de points, grâce à la méthode retrieveChampionshipStatistics.
