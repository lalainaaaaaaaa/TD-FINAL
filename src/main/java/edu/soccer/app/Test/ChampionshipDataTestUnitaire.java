package edu.soccer.app.TestCentral;

import edu.soccer.app.dao.EntityCentral.Championship;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ChampionshipDataTestUnitaire {

    @Test
    void testGettersAndSetters() {
        Championship championship = new Championship();
        championship.setId(1);
        championship.setName("Ligue 1");
        championship.setCountry("France");

        assertEquals(1, championship.getId());
        assertEquals("Ligue 1", championship.getName());
        assertEquals("France", championship.getCountry());
    }
}
