package edu.soccer.app.dao.operations;

import edu.soccer.app.dao.entity.players;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BestplayersCrudOperationsImpl implements BestplayersCrudOperations {

    private final List<players> playersList = new ArrayList<>();

    @Override
    public void addPlayer(players player) {
        playersList.add(player);
    }

    @Override
    public players getPlayerByName(String name) {
        if (name == null) return null;
        Optional<players> player = playersList.stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .findFirst();
        return player.orElse(null);
    }

    @Override
    public void updatePlayer(players updatedPlayer) {
        if (updatedPlayer == null) return;
        for (int i = 0; i < playersList.size(); i++) {
            if (playersList.get(i).getName().equalsIgnoreCase(updatedPlayer.getName())) {
                playersList.set(i, updatedPlayer);
                return;
            }
        }
    }

    @Override
    public void deletePlayer(String name) {
        if (name == null) return;
        playersList.removeIf(p -> p.getName().equalsIgnoreCase(name));
    }

    @Override
    public players getBestPlayer() {
        if (playersList.isEmpty()) return null;

        players bestPlayer = playersList.get(0);
        int maxGoals = bestPlayer.getIndividualStatistics() != null ? bestPlayer.getIndividualStatistics().getGoals() : 0;

        for (players p : playersList) {
            int goals = p.getIndividualStatistics() != null ? p.getIndividualStatistics().getGoals() : 0;
            if (goals > maxGoals) {
                maxGoals = goals;
                bestPlayer = p;
            }
        }
        return bestPlayer;
    }

    @Override
    public List<players> findAll() {
        return new ArrayList<>(playersList);
    }
}
