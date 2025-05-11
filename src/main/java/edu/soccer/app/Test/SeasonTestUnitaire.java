package edu.soccer.app.TestCentral;

import edu.soccer.app.dao.EntityCentral.Season;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SeasonTestUnitaire {

    @Test
    void testGettersAndSetters() {
        Season season = new Season();
        season.setId(2024);
        season.setYear("2024");
        season.setChampionshipId(1);

        assertEquals(2024, season.getId());
        assertEquals("2024", season.getYear());
        assertEquals(1, season.getChampionshipId());
    }
}
