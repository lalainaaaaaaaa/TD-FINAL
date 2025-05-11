package edu.soccer.app.dao.service;

import edu.soccer.app.dao.entity.players;
import edu.soccer.app.dao.operations.playersCrudOperations;

import java.util.List;

public class playersService {

    private final playersCrudOperations playersDao;

    public playersService(playersCrudOperations playersDao) {
        this.playersDao = playersDao;
    }

    public void addPlayer(players player) {
        playersDao.addPlayer(player);
    }

    public void updatePlayer(players player) {
        playersDao.updatePlayer(player);
    }

    public void deletePlayerByNumber(int number) {
        playersDao.deletePlayer(number);
    }

    public players getPlayerByNumber(int number) {
        return playersDao.getPlayerByNumber(number);
    }

    public List<players> getAllPlayers() {
        return playersDao.findAll();
    }

    public players getBestPlayer() {
        List<players> allPlayers = playersDao.findAll();
        if (allPlayers.isEmpty()) {
            return null;
        }

        players bestPlayer = allPlayers.get(0);
        int maxGoals = bestPlayer.getIndividualStatistics() != null ? bestPlayer.getIndividualStatistics().getGoals() : 0;

        for (players p : allPlayers) {
            int goals = p.getIndividualStatistics() != null ? p.getIndividualStatistics().getGoals() : 0;
            if (goals > maxGoals) {
                maxGoals = goals;
                bestPlayer = p;
            }
        }
        return bestPlayer;
    }

    public players findById(String id) {
        return null;
    }

    public List<players> findAll() {
        return null;
    }

    public List<players> findAllFiltered(String club, String name) {
        return null;
    }
}
