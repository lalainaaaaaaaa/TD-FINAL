package edu.soccer.app.dao.service;

import edu.soccer.app.dao.entity.Team;
import edu.soccer.app.dao.entity.BestTeam;

import java.util.List;

public class BestTeamService {

    public Team getBestTeam(List<Team> teams) {
        return BestTeam.bestTeam(teams);
    }
}
