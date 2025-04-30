package edu.soccer.app.dao.operations;

import edu.soccer.app.dao.entity.Player;
import edu.soccer.app.dao.entity.BestPlayer;

import java.util.ArrayList;
import java.util.List;

public class BestPlayerCrudOperations {

    private static List<Player> players = new ArrayList<>();

    public static void addPlayer(Player player) {
        players.add(player);
    }

    public static Player getPlayerByName(String name) {
        for (Player player : players) {
            if (player.getName().equalsIgnoreCase(name)) {
                return player;
            }
        }
        return null;
    }

    public static void updatePlayer(Player updatedPlayer) {
        Player existingPlayer = getPlayerByName(updatedPlayer.getName());
        if (existingPlayer != null) {
            existingPlayer.updatePosition(updatedPlayer.getPosition());
            existingPlayer.updateNationality(updatedPlayer.getNationality());
            existingPlayer.updateAge(updatedPlayer.getAge());


            existingPlayer.getIndividualStatistics().setGoals(updatedPlayer.getIndividualStatistics().getGoals());
            existingPlayer.getIndividualStatistics().setPlayingTime(updatedPlayer.getIndividualStatistics().getPlayingTime());
        }
    }

    public static void deletePlayer(String name) {
        players.removeIf(player -> player.getName().equalsIgnoreCase(name));
    }

    public static Player getBestPlayer() {
        return BestPlayer.bestPlayer(players);
    }

    public static List<Player> findAll() {
        return new ArrayList<>(players);
    }
}
