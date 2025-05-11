package edu.soccer.app.TestCentral;

import edu.soccer.app.dao.EntityCentral.Coach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CoachTestUnitaire {

    @Test
    void testGettersAndSetters() {
        Coach coach = new Coach();
        coach.setId(1);
        coach.setName("Coach 1");
        coach.setAge(45);
        coach.setClubId(4);

        assertEquals(1, coach.getId());
        assertEquals("Coach 1", coach.getName());
        assertEquals(45, coach.getAge());
        assertEquals(4, coach.getClubId());
    }
}
