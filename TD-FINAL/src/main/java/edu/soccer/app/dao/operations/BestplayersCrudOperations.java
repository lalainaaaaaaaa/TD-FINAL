package edu.soccer.app.dao.operations;

import edu.soccer.app.dao.entity.players;
import java.util.List;

public interface BestplayersCrudOperations {
    void addPlayer(players player);

    players getPlayerByName(String name);

    void updatePlayer(players updatedPlayer);

    void deletePlayer(String name);

    players getBestPlayer();

    List<players> findAll();
}
