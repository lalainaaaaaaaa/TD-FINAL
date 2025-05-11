package edu.soccer.app.TestCentral;

import edu.soccer.app.dao.EntityCentral.Championship;

public class ChampionshipTest {

    public static void main(String[] args) {
        Championship ligue1 = new Championship(1, "Ligue 1", "France");
        Championship serieA = new Championship(2, "Serie A", "Italy");
        Championship bundesliga = new Championship(3, "Bundesliga", "Germany");
        Championship liga = new Championship(4, "La Liga", "Spain");
        Championship premierLeague = new Championship(5, "Premier League", "England");


        System.out.println("Championship's list for 2024 :");
        printChampionship(ligue1);
        printChampionship(serieA);
        printChampionship(bundesliga);
        printChampionship(liga);
        printChampionship(premierLeague);
    }

    private static void printChampionship(Championship c) {
        System.out.println("ID: " + c.getId() + ", Name: " + c.getName() + ", Country: " + c.getCountry());
    }
}
