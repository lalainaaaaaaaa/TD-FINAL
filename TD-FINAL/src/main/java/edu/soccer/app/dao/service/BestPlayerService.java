package edu.soccer.app.dao.service;

import edu.soccer.app.dao.entity.Player;
import edu.soccer.app.dao.entity.BestPlayer;

import java.util.List;

public class BestPlayerService {

    public Player getBestPlayer(List<Player> players) {
        return BestPlayer.bestPlayer(players);
    }
}
