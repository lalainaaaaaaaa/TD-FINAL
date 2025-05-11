package edu.soccer.app.TestCentral;

import edu.soccer.app.dao.EntityCentral.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTestUnitaire {

    @Test
    void testGettersAndSetters() {
        Player player = new Player();
        player.setId(7);
        player.setName("Attaquant 4");
        player.setAge(17);
        player.setPosition("STRIKER");
        player.setGoals(5);
        player.setClubId(4);

        assertEquals(7, player.getId());
        assertEquals("Attaquant 4", player.getName());
        assertEquals(17, player.getAge());
        assertEquals("STRIKER", player.getPosition());
        assertEquals(5, player.getGoals());
        assertEquals(4, player.getClubId());
    }
}
