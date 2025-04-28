//Pour gérer les données de match de football

package edu.soccer.app.dao.management;

import edu.soccer.app.dao.entity.Match;

import java.util.List;

public class FIFAManagement {
    private APIManagement apiManagement;

    public FIFAManagement(APIManagement apiManagement) {
        this.apiManagement = apiManagement;
    }

    public void collectData() {
        System.out.println("Collecting data from championships...");
        List<Match> allMatches = apiManagement.retrieveMatchStatistics();
        for (Match match : allMatches) {
            System.out.println("Match: " + match.getHomeTeam().getName() + " vs " + match.getAwayTeam().getName());
        }
    }

    public void analyzeStatistics() {
        System.out.println("Analyzing statistics...");
    }
}



//Constructeur : prend un objet APIManagement en paramètre pour accéder aux statistiques des matchs.
//Collecte des données : collectData imprime un message indiquant qu'elle collecte des données. Ensuite, elle récupère tous les matchs enregistrés et affiche le nom des équipes qui jouent.
//Analyse des statistiques :  analyzeStatistics imprime un message pour dire qu'elle commence à analyser les statistiques, mais elle n'effectue pas encore d'analyse.
