package edu.soccer.app.dao.operations;

import edu.soccer.app.dao.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerCrudOperations {
    private static List<Player> players = new ArrayList<>();

    static {
        players.add(new Player("Lionel Messi", 10, "Forward", "Argentina", 36));
        players.add(new Player("Cristiano Ronaldo", 7, "Forward", "Portugal", 38));
        players.add(new Player("Neymar Jr", 11, "Forward", "Brazil", 31));
    }

    public static Player getPlayerByNumber(int number) {
        for (Player player : players) {
            if (player.getNumber() == number) {
                return player;
            }
        }
        return null;
    }

    public static List<Player> findAll() {
        return new ArrayList<>(players);
    }

    public static void addPlayer(Player player) {
        players.add(player);
    }

    public static void updatePlayer(Player updatedPlayer) {
        Player existingPlayer = getPlayerByNumber(updatedPlayer.getNumber());
        if (existingPlayer != null) {
            existingPlayer.updatePosition(updatedPlayer.getPosition());
            existingPlayer.updateNationality(updatedPlayer.getNationality());
            existingPlayer.updateAge(updatedPlayer.getAge());
        }
    }

    public static void deletePlayer(int number) {
        players.removeIf(player -> player.getNumber() == number);
    }
}