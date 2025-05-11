package edu.soccer.app.TestCentral;

import edu.soccer.app.dao.EntityCentral.Club;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClubTestUnitaire {

    @Test
    void testGettersAndSetters() {
        Club club = new Club();
        club.setId(4);
        club.setName("Club 4");
        club.setCity("City 4");
        club.setChampionshipId(1);

        assertEquals(4, club.getId());
        assertEquals("Club 4", club.getName());
        assertEquals("City 4", club.getCity());
        assertEquals(1, club.getChampionshipId());
    }
}
