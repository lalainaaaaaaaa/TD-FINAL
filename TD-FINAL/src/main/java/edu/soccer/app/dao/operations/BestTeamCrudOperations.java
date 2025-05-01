package edu.soccer.app.dao.operations;

import edu.soccer.app.dao.entity.Team;
import java.util.List;

public interface BestTeamCrudOperations {
    void addTeam(Team team);

    Team getTeamByName(String name);

    void updateTeam(Team updatedTeam);

    void deleteTeam(String name);

    Team getBestTeam();

    List<Team> findAll();
}
