package edu.soccer.app.dao.operations;

import edu.soccer.app.dao.entity.players;

import java.util.List;

public interface playersCrudOperations {

    players getPlayerByNumber(int number);

    List<players> findAll();

    void addPlayer(players player);

    void updatePlayer(players updatedPlayer);

    void deletePlayer(int number);
}
