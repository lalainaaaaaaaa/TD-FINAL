package edu.soccer.app.Test;

import edu.soccer.app.dao.entity.matchMaker;
import edu.soccer.app.dao.entity.matches;
import edu.soccer.app.dao.entity.clubs;
import edu.soccer.app.dao.entity.season;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class matchMakerTestUnitaire {

    private List<matches> matchesList;

    @BeforeEach
    void setUp() {
        clubs club1 = new clubs(1, "Club 1", "C1", 1902, "Stade 1", "Entraîneur 1", "Français");
        clubs club2 = new clubs(2, "Club 2", "C2", 1905, "Stade 2", "Entraîneur 2", "Italien");
        clubs club3 = new clubs(3, "Club 3", "C3", 1910, "Stade 3", "Entraîneur 3", "Allemand");

        season season2024 = new season(2024);

        matches m1 = new matches(club1, club2, season2024);
        m1.setHomeScore(4);
        m1.setAwayScore(1);

        matches m2 = new matches(club2, club3, season2024);
        m2.setHomeScore(0);
        m2.setAwayScore(1);

        matches m3 = new matches(club3, club1, season2024);
        m3.setHomeScore(1);
        m3.setAwayScore(5);

        matches m4 = new matches(club2, club1, season2024);
        m4.setHomeScore(1);
        m4.setAwayScore(1);

        matchesList = new ArrayList<>();
        matchesList.add(m1);
        matchesList.add(m2);
        matchesList.add(m3);
        matchesList.add(m4);
    }

    @Test
    void testBestMatch() {
        matches best = matchMaker.bestMatch(matchesList);
        assertNotNull(best, "Best match shouldn't be null");
        assertEquals(5, best.getAwayScore());
        assertEquals(1, best.getHomeScore());
        assertEquals("Club 3", best.getHomeTeam().getName());
        assertEquals("Club 1", best.getAwayTeam().getName());
    }

    @Test
    void testBestMatchEmptyList() {
        matches best = matchMaker.bestMatch(new ArrayList<>());
        assertNull(best, "If list is empty, the best match should be null");
    }

    @Test
    void testBestMatchNullList() {
        matches best = matchMaker.bestMatch(null);
        assertNull(best, "If list is empty, the best match should be null");
    }
}
