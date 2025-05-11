package edu.soccer.app.dao.operations;

import edu.soccer.app.dao.entity.players;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class playersCrudOperationsImpl implements playersCrudOperations {

    private final List<players> playersList = new ArrayList<>();

    @Override
    public players getPlayerByNumber(int number) {
        Optional<players> player = playersList.stream()
                .filter(p -> p.getNumber() == number)
                .findFirst();
        return player.orElse(null);
    }

    @Override
    public List<players> findAll() {
        return new ArrayList<>(playersList);
    }

    @Override
    public void addPlayer(players player) {
        if (player != null) {
            playersList.add(player);
        }
    }

    @Override
    public void updatePlayer(players updatedPlayer) {
        if (updatedPlayer == null) return;
        for (int i = 0; i < playersList.size(); i++) {
            if (playersList.get(i).getNumber() == updatedPlayer.getNumber()) {
                playersList.set(i, updatedPlayer);
                return;
            }
        }
    }

    @Override
    public void deletePlayer(int number) {
        playersList.removeIf(p -> p.getNumber() == number);
    }
}
