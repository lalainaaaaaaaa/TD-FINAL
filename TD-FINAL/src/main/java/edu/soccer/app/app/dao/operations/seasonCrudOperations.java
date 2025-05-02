package edu.soccer.app.dao.operations;

import edu.soccer.app.dao.entity.season;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface seasonCrudOperations {
    void loadSeasonsFromDatabase(Connection connection) throws SQLException;

    season getSeasonByYear(int year);

    List<season> findAll();

    void addSeason(season season);

    void updateSeason(season updatedSeason);

    void deleteSeason(int year);
}
