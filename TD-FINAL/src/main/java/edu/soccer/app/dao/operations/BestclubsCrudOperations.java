package edu.soccer.app.dao.operations;

import edu.soccer.app.dao.entity.clubs;
import java.util.List;

public interface BestclubsCrudOperations {
    void addTeam(clubs team);

    clubs getTeamByName(String name);

    void updateTeam(clubs updatedTeam);

    void deleteTeam(String name);

    clubs getBestTeam();

    List<clubs> findAll();
}
