package edu.soccer.app.dao.operations;

import edu.soccer.app.dao.entity.Bestplayers;
import edu.soccer.app.dao.entity.players;

import java.util.ArrayList;
import java.util.List;

public class BestplayersCrudOperationsImpl implements BestplayersCrudOperations {

    private static List<players> players = new ArrayList<>();

    @Override
    public void addPlayer(players player) {
        players.add(player);
    }

    @Override
    public players getPlayerByName(String name) {
        for (players player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    @Override
    public void updatePlayer(players updatedPlayer) {
        players existingPlayer = getPlayerByName(updatedPlayer.getName());
        if (existingPlayer != null) {
            existingPlayer.updatePosition(updatedPlayer.getPosition());
            existingPlayer.updateNationality(updatedPlayer.getNationality());
            existingPlayer.updateAge(updatedPlayer.getAge());

            existingPlayer.getIndividualStatistics().setGoals(updatedPlayer.getIndividualStatistics().getGoals());
            existingPlayer.getIndividualStatistics().setPlayingTime(updatedPlayer.getIndividualStatistics().getPlayingTime());
        }
    }

    @Override
    public void deletePlayer(String name) {
        players.removeIf(player -> player.getName().equals(name));
    }

    @Override
    public players getBestPlayer() {
        return Bestplayers.bestPlayer(players);
    }

    @Override
    public List<players> findAll() {
        return new ArrayList<>(players);
    }
}
