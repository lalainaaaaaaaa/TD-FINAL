package edu.soccer.app.dao.service;

import edu.soccer.app.dao.entity.players;
import edu.soccer.app.dao.entity.Bestplayers;

import java.util.List;

public class BestplayersService {

    public players getBestPlayer(List<players> players) {
        return Bestplayers.bestPlayer(players);
    }
}
