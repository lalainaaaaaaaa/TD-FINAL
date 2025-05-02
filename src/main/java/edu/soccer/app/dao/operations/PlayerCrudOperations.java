package edu.soccer.app.dao.operations;

import edu.soccer.app.dao.entity.Player;
import java.util.List;

public interface PlayerCrudOperations {
    Player getPlayerByNumber(int number);

    List<Player> findAll();

    void addPlayer(Player player);

    void updatePlayer(Player updatedPlayer);

    void deletePlayer(int number);
}