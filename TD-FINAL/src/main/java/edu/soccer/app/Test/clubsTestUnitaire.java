package edu.soccer.app.Test;

import edu.soccer.app.dao.entity.clubs;
import edu.soccer.app.dao.entity.CollectiveStatistics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class clubsTestUnitaire {

    private List<clubs> clubsList;

    @BeforeEach
    void setUp() {
        clubs club1 = new clubs(1, "Club 1", "C1", 1902, "Stade 1", "Entraîneur 1", "Français");
        clubs club2 = new clubs(2, "Club 2", "C2", 1905, "Stade 2", "Entraîneur 2", "Italien");
        clubs club3 = new clubs(3, "Club 3", "C3", 1910, "Stade 3", "Entraîneur 3", "Allemand");
        clubs club4 = new clubs(4, "Club 4", "C4", 1902, "Stade 4", "Entraîneur 4", "Malgache");
        clubs club5 = new clubs(5, "Club 5", "C5", 1905, "Stade 5", "Entraîneur 5", "Ivorien");
        clubs club6 = new clubs(6, "Club 6", "C6", 1910, "Stade 6", "Entraîneur 6", "Espagnol");

        clubsList = new ArrayList<>();
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
    }

    @Test
    void testStatisticsUpdate() {
        assertEquals(7, clubsList.get(0).getStatistics().getGoalsFor());
        assertEquals(2, clubsList.get(0).getStatistics().getGoalsAgainst());

        assertEquals(4, clubsList.get(1).getStatistics().getGoalsFor());
        assertEquals(5, clubsList.get(1).getStatistics().getGoalsAgainst());
    }

    @Test
    void testRankingOrder() {
        clubsList.sort(Comparator.comparingInt((clubs c) -> c.getStatistics().getPoints()).reversed()
                .thenComparingInt(c -> c.getStatistics().getGoalsFor() - c.getStatistics().getGoalsAgainst()).reversed());


        assertTrue(clubsList.get(0).getStatistics().getPoints() >= clubsList.get(1).getStatistics().getPoints());
        assertTrue(clubsList.get(0).getStatistics().getGoalsFor() - clubsList.get(0).getStatistics().getGoalsAgainst()
                >= clubsList.get(1).getStatistics().getGoalsFor() - clubsList.get(1).getStatistics().getGoalsAgainst());
    }

    private void updateStats(CollectiveStatistics stats, int goalsFor, int goalsAgainst) {
        stats.update(goalsFor, goalsAgainst);
    }
}
