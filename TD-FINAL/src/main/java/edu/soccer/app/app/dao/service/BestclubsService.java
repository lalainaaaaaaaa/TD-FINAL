package edu.soccer.app.dao.service;

import edu.soccer.app.dao.entity.clubs;
import edu.soccer.app.dao.entity.Bestclubs;

import java.util.List;

public class BestclubsService {

    public clubs getBestTeam(List<clubs> teams) {
        return Bestclubs.bestTeam(teams);
    }
}
