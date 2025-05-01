package edu.soccer.app.dao.operations;

import edu.soccer.app.dao.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerCrudOperationsImpl implements PlayerCrudOperations {
    private List<Player> players = new ArrayList<>();

    public PlayerCrudOperationsImpl() {
        players.add(new Player("Lionel Messi", 10, "Forward", "Argentina", 36));
        players.add(new Player("Cristiano Ronaldo", 7, "Forward", "Portugal", 38));
        players.add(new Player("Neymar Jr", 11, "Forward", "Brazil", 31));
    }

    @Override
    public Player getPlayerByNumber(int number) {
        for (Player player : players) {
            if (player.getNumber() == number) {
                return player;
            }
        }
        throw new IllegalArgumentException("Player not found: " + number);
    }

    @Override
    public List<Player> findAll() {
        return new ArrayList<>(players);
    }

    @Override
    public void addPlayer(Player player) {
        if (player.getName() == null || player.getName().isEmpty()) {
            throw new IllegalArgumentException("Player name cannot be null or empty.");
        }
        players.add(player);
    }

    @Override
    public void updatePlayer(Player updatedPlayer) {
        Player existingPlayer = getPlayerByNumber(updatedPlayer.getNumber());
        if (existingPlayer != null) {
            existingPlayer.updatePosition(updatedPlayer.getPosition());
            existingPlayer.updateNationality(updatedPlayer.getNationality());
            existingPlayer.updateAge(updatedPlayer.getAge());
        }
    }

    @Override
    public void deletePlayer(int number) {
        if (!players.removeIf(player -> player.getNumber() == number)) {
            throw new IllegalArgumentException("Player not found: " + number);
        }
    }
}