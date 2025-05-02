package edu.soccer.app.dao.operations;

import edu.soccer.app.dao.entity.Bestplayers;

import java.util.ArrayList;
import java.util.List;

public class BestplayersCrudOperationsImpl implements BestplayersCrudOperations {

    private static List<edu.soccer.app.dao.entity.players> players = new ArrayList<>();

    @Override
    public void addPlayer(edu.soccer.app.dao.entity.players player) {
        players.add(player);
    }

    @Override
    public edu.soccer.app.dao.entity.players getPlayerByName(String name) {
        for (edu.soccer.app.dao.entity.players player : players) {
            if (player.getName().equalsIgnoreCase(name)) {
                return player;
            }
        }
        return null;
    }

    @Override
    public void updatePlayer(edu.soccer.app.dao.entity.players updatedPlayer) {
        edu.soccer.app.dao.entity.players existingPlayer = getPlayerByName(updatedPlayer.getName());
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
        players.removeIf(player -> player.getName().equalsIgnoreCase(name));
    }

    @Override
    public edu.soccer.app.dao.entity.players getBestPlayer() {
        return Bestplayers.bestPlayer(players);
    }

    @Override
    public List<edu.soccer.app.dao.entity.players> findAll() {
        return new ArrayList<>(players);
    }
}
