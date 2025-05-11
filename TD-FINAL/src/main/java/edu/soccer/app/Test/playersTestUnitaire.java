package edu.soccer.app.Test;

import edu.soccer.app.dao.entity.players;
import edu.soccer.app.dao.entity.clubs;
import edu.soccer.app.dao.entity.IndividualStatistics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class playersTestUnitaire {

    private players player1;
    private players player2;

    @BeforeEach
    void setUp() {
        clubs club1 = new clubs(1, "FC Barcelona", "FCB", 1899, "Camp Nou", "Xavi", "Espagne");
        clubs club2 = new clubs(2, "Real Madrid", "RM", 1902, "Santiago Bernabeu", "Ancelotti", "Espagne");

        player1 = new players("p01", "Lionel Messi", 10, 35, "Attaquant", "Argentin", 32000, club1);
        player2 = new players("p02", "Karim Benzema", 9, 34, "Attaquant", "Français", 31000, club2);


        IndividualStatistics stats1 = player1.getIndividualStatistics();
        stats1.setGoals(30);
        stats1.setAssists(12);
        stats1.setYellowCards(3);

        IndividualStatistics stats2 = player2.getIndividualStatistics();
        stats2.setGoals(25);
        stats2.setAssists(10);
        stats2.setYellowCards(2);
    }

    @Test
    void testPlayerCreationAndStats() {
        assertEquals("Lionel Messi", player1.getName());
        assertEquals(10, player1.getNumber());
        assertEquals("FC Barcelona", player1.getClub().getName());
        assertEquals(30, player1.getIndividualStatistics().getGoals());
        assertEquals(12, player1.getIndividualStatistics().getAssists());
        assertEquals(3, player1.getIndividualStatistics().getYellowCards());

        assertEquals("Karim Benzema", player2.getName());
        assertEquals(9, player2.getNumber());
        assertEquals("Real Madrid", player2.getClub().getName());
        assertEquals(25, player2.getIndividualStatistics().getGoals());
        assertEquals(10, player2.getIndividualStatistics().getAssists());
        assertEquals(2, player2.getIndividualStatistics().getYellowCards());
    }
}
