package edu.soccer.app.dao.operations;

import edu.soccer.app.dao.entity.clubs;
import java.util.List;

public interface clubsCrudOperations {
    clubs getTeamByName(String name);

    List<clubs> findAll();

    void addTeam(clubs team);

    void updateTeam(clubs updatedTeam);

    void deleteTeam(String name);
}