package edu.soccer.app.dao.operations;

import edu.soccer.app.dao.entity.Player;
import java.util.List;

public interface BestPlayerCrudOperations {
    void addPlayer(Player player);

    Player getPlayerByName(String name);

    void updatePlayer(Player updatedPlayer);

    void deletePlayer(String name);

    Player getBestPlayer();

    List<Player> findAll();
}
