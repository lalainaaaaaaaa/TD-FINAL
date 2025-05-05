package edu.soccer.app.dao.operations;

import edu.soccer.app.dao.entity.clubs;
import java.util.List;

public interface clubsCrudOperations {
    void addTeam(clubs club);
    void updateTeam(clubs club);
    void deleteTeam(String name);
    clubs getTeamByName(String name);
    List<clubs> findAll();
    clubs getBestTeam();
}
