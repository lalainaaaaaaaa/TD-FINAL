package edu.soccer.app.dao.operations;

import edu.soccer.app.dao.entity.Season;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface SeasonCrudOperations {
    void loadSeasonsFromDatabase(Connection connection) throws SQLException;

    Season getSeasonByYear(int year);

    List<Season> findAll();

    void addSeason(Season season);

    void updateSeason(Season updatedSeason);

    void deleteSeason(int year);
}
