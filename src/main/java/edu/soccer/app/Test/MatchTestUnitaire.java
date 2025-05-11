package edu.soccer.app.TestCentral;

import edu.soccer.app.dao.EntityCentral.Match;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MatchTestUnitaire {

    @Test
    void testGettersAndSetters() {
        Match match = new Match();
        match.setId(1);
        match.setSeasonId(2024);
        match.setClubHomeId(4);
        match.setClubAwayId(5);
        match.setHomeGoals(4);
        match.setAwayGoals(1);
        match.setMatchDate("2024-05-01");

        assertEquals(1, match.getId());
        assertEquals(2024, match.getSeasonId());
        assertEquals(4, match.getClubHomeId());
        assertEquals(5, match.getClubAwayId());
        assertEquals(4, match.getHomeGoals());
        assertEquals(1, match.getAwayGoals());
        assertEquals("2024-05-01", match.getMatchDate());
    }
}
