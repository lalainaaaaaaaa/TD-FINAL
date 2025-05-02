package edu.soccer.app.dao.operations;

import edu.soccer.app.dao.entity.Team;
import java.util.List;

public interface TeamCrudOperations {
    Team getTeamByName(String name);

    List<Team> findAll();

    void addTeam(Team team);

    void updateTeam(Team updatedTeam);

    void deleteTeam(String name);
}