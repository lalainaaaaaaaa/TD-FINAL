package edu.soccer.app.Test;

import edu.soccer.app.dao.entity.clubs;
import edu.soccer.app.dao.entity.CollectiveStatistics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class clubsTest {

    public static void main(String[] args) {
        clubs club1 = new clubs(1, "Club 1", "C1", 1902, "Stadium 1", "Coach 1", "French");
        clubs club2 = new clubs(2, "Club 2", "C2", 1905, "Stadium 2", "Coach 2", "Italian");
        clubs club3 = new clubs(3, "Club 3", "C3", 1910, "Stadium 3", "Coach 3", "German");
        clubs club4 = new clubs(4, "Club 4", "C4", 1902, "Stadium 4", "Coach 4", "Malagasy");
        clubs club5 = new clubs(5, "Club 5", "C5", 1905, "Stadium 5", "Coach 5", "Ivorian");
        clubs club6 = new clubs(6, "Club 6", "C6", 1910, "Stadium 6", "Coach 6", "Spanish");

        List<clubs> clubsList = new ArrayList<>();
        clubsList.add(club1);
        clubsList.add(club2);
        clubsList.add(club3);
        clubsList.add(club4);
        clubsList.add(club5);
        clubsList.add(club6);


        updateStats(club1.getStatistics(), 7, 2);
        updateStats(club2.getStatistics(), 4, 5);
        updateStats(club3.getStatistics(), 1, 4);
        updateStats(club4.getStatistics(), 6, 2);
        updateStats(club5.getStatistics(), 5, 4);
        updateStats(club6.getStatistics(), 5, 5);

        System.out.println("Club standings at the end of the 2024 season:");

        clubsList.sort(Comparator.comparingInt((clubs c) -> c.getStatistics().getPoints()).reversed()
                .thenComparingInt(c -> c.getStatistics().getGoalsFor() - c.getStatistics().getGoalsAgainst()).reversed());

        int rank = 1;
        for (clubs c : clubsList) {
            CollectiveStatistics stats = c.getStatistics();
            int diff = stats.getGoalsFor() - stats.getGoalsAgainst();
            System.out.println(rank + ": " + c.getName() + ", Points: " + stats.getPoints() +
                    ", Goals For: " + stats.getGoalsFor() +
                    ", Goals Against: " + stats.getGoalsAgainst() +
                    ", Goal Difference: " + diff);
            rank++;
        }
    }

    private static void updateStats(CollectiveStatistics stats, int goalsFor, int goalsAgainst) {
        stats.update(goalsFor, goalsAgainst);
    }
}