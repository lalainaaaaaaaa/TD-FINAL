package edu.soccer.app.dao.operations;

import edu.soccer.app.dao.entity.Player;
import edu.soccer.app.dao.entity.BestPlayer;

import java.util.ArrayList;
import java.util.List;

public class BestPlayerCrudOperationsImpl implements BestPlayerCrudOperations {

    private static List<Player> players = new ArrayList<>();

    @Override
    public void addPlayer(Player player) {
        players.add(player);
    }

    @Override
    public Player getPlayerByName(String name) {
        for (Player player : players) {
            if (player.getName().equalsIgnoreCase(name)) {
                return player;
            }
        }
        return null;
    }

    @Override
    public void updatePlayer(Player updatedPlayer) {
        Player existingPlayer = getPlayerByName(updatedPlayer.getName());
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
    public Player getBestPlayer() {
        return BestPlayer.bestPlayer(players);
    }

    @Override
    public List<Player> findAll() {
        return new ArrayList<>(players);
    }
}
