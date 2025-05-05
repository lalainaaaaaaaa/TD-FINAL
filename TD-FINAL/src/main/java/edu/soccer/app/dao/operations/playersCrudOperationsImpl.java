package edu.soccer.app.dao.operations;

import edu.soccer.app.dao.entity.players;
import java.util.ArrayList;
import java.util.List;

public class playersCrudOperationsImpl implements playersCrudOperations {
    private List<players> players = new ArrayList<>();

    public playersCrudOperationsImpl() {
        players.add(new players("Lionel Messi", 10, "Forward", "Argentina", 36));
        players.add(new players("Cristiano Ronaldo", 7, "Forward", "Portugal", 38));
        players.add(new players("Neymar Jr", 11, "Forward", "Brazil", 31));
    }

    @Override
    public players getPlayerByNumber(int number) {
        for (players player : players) {
            if (player.getNumber() == number) {
                return player;
            }
        }
        throw new IllegalArgumentException("Player not found: " + number);
    }

    @Override
    public List<players> findAll() {
        return new ArrayList<>(players);
    }

    @Override
    public void addPlayer(players player) {
        if (player.getName() == null || player.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Player name cannot be null or empty.");
        }
        players.add(player);
    }

    @Override
    public void updatePlayer(players updatedPlayer) {
        players existingPlayer = getPlayerByNumber(updatedPlayer.getNumber());
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
