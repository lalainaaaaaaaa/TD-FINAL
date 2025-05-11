package edu.soccer.app.Test;

import edu.soccer.app.dao.entity.championships;
import edu.soccer.app.dao.entity.clubs;
import edu.soccer.app.dao.entity.matches;
import edu.soccer.app.dao.entity.season;

import java.util.List;

public class championshipsTest {

    public static void main(String[] args) {
        championships championship = new championships("Championnat National", "France");


        clubs club1 = new clubs(1, "Club 1", "C1", 1902, "Stade 1", "Coach 1", "Français");
        clubs club2 = new clubs(2, "Club 2", "C2", 1905, "Stade 2", "Coach 2", "Italien");
        clubs club3 = new clubs(3, "Club 3", "C3", 1910, "Stade 3", "Coach 3", "Allemand");
        clubs club4 = new clubs(4, "Club 4", "C4", 1920, "Stade 4", "Coach 4", "Espagnol");
        clubs club5 = new clubs(5, "Club 5", "C5", 1925, "Stade 5", "Coach 5", "Portugais");
        clubs club6 = new clubs(6, "Club 6", "C6", 1930, "Stade 6", "Coach 6", "Belge");

        championship.addTeam(club1);
        championship.addTeam(club2);
        championship.addTeam(club3);
        championship.addTeam(club4);
        championship.addTeam(club5);
        championship.addTeam(club6);


        season season2024 = new season(2024);
        championship.setCurrentSeason(season2024);


        championship.generateMatches();


        System.out.println("Équipes du championnat :");
        for (clubs c : championship.getTeams()) {
            System.out.println("- " + c.getName() + " (" + c.getAcronym() + ")");
        }


        System.out.println("Matchs générés pour la saison " + season2024.getYear() + " :");
        List<matches> matches = championship.getMatches();
        for (matches m : matches) {
            System.out.println(m.getHomeTeam().getName() + " vs " +
                    m.getAwayTeam().getName() + " Stade : " +
                    m.getHomeTeam().getStadium());
        }


        championship.endSeason();


        System.out.println("Nombre total de matchs générés : " + matches.size());
        System.out.println("Nombre théorique pour 6 clubs : " + (6 * 5 * 2) + " matchs");
    }
}
