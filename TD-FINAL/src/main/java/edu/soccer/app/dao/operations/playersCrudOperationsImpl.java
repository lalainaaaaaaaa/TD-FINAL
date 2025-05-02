package edu.soccer.app.dao.operations;

import edu.soccer.app.dao.entity.players;

import java.util.ArrayList;
import java.util.List;

public class playersCrudOperationsImpl implements playersCrudOperations {
    private List<edu.soccer.app.dao.entity.players> players = new ArrayList<>();

    public playersCrudOperationsImpl() {
        players.add(new players("Lionel Messi", 10, "Forward", "Argentina", 36));
        players.add(new players("Cristiano Ronaldo", 7, "Forward", "Portugal", 38));
        players.add(new players("Neymar Jr", 11, "Forward", "Brazil", 31));
    }

    @Override
    public edu.soccer.app.dao.entity.players getPlayerByNumber(int number) {
        for (edu.soccer.app.dao.entity.players player : players) {
            if (player.getNumber() == number) {
                return player;
            }
        }
        throw new IllegalArgumentException("Player not found: " + number);
    }

    @Override
    public List<edu.soccer.app.dao.entity.players> findAll() {
        return new ArrayList<>(players);
    }

    @Override
    public void addPlayer(edu.soccer.app.dao.entity.players player) {
        if (player.getName() == null || player.getName().isEmpty()) {
            throw new IllegalArgumentException("Player name cannot be null or empty.");
        }
        players.add(player);
    }

    @Override
    public void updatePlayer(edu.soccer.app.dao.entity.players updatedPlayer) {
        edu.soccer.app.dao.entity.players existingPlayer = getPlayerByNumber(updatedPlayer.getNumber());
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