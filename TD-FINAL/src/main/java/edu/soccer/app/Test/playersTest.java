package edu.soccer.app.Test;

import edu.soccer.app.dao.entity.players;
import edu.soccer.app.dao.entity.clubs;
import edu.soccer.app.dao.entity.IndividualStatistics;

import java.util.ArrayList;
import java.util.List;

public class playersTest {

    public static void main(String[] args) {
        clubs club1 = new clubs(1, "FC Barcelona", "FCB", 1899, "Camp Nou", "Xavi", "Spain");
        clubs club2 = new clubs(2, "Real Madrid", "RM", 1902, "Santiago Bernabeu", "Ancelotti", "Spain");

        players player1 = new players("p01", "Lionel Messi", 10, 35, "Forward", "Argentinian", 32000, club1);
        players player2 = new players("p02", "Karim Benzema", 9, 34, "Forward", "French", 31000, club2);

        IndividualStatistics stats1 = player1.getIndividualStatistics();
        stats1.setGoals(30);
        stats1.setAssists(12);
        stats1.setYellowCards(3);

        IndividualStatistics stats2 = player2.getIndividualStatistics();
        stats2.setGoals(25);
        stats2.setAssists(10);
        stats2.setYellowCards(2);

        List<players> playersList = new ArrayList<>();
        playersList.add(player1);
        playersList.add(player2);

        for (players p : playersList) {
            System.out.println("Player: " + p.getName());
            System.out.println("Number: " + p.getNumber());
            System.out.println("Age: " + p.getAge());
            System.out.println("Position: " + p.getPosition());
            System.out.println("Nationality: " + p.getNationality());
            System.out.println("Club: " + p.getClub().getName());
            System.out.println("Playing Time (s): " + p.getPlayingTimeSeconds());
            System.out.println("Individual Statistics:");
            System.out.println("  Goals: " + p.getIndividualStatistics().getGoals());
            System.out.println("  Assists: " + p.getIndividualStatistics().getAssists());
            System.out.println("  Yellow Cards: " + p.getIndividualStatistics().getYellowCards());
        }
    }
}