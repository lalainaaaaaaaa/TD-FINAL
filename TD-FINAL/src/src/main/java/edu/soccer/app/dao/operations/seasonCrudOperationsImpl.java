package edu.soccer.app.dao.operations;

import edu.soccer.app.dao.entity.season;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class seasonCrudOperationsImpl implements seasonCrudOperations {
    private static List<season> seasons = new ArrayList<>();

    @Override
    public void loadSeasonsFromDatabase(Connection connection) throws SQLException {
        String sql = "SELECT * FROM Season";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int year = rs.getInt("year");
                seasons.add(new season(year));
            }
        }
    }

    @Override
    public season getSeasonByYear(int year) {
        for (edu.soccer.app.dao.entity.season season : seasons) {
            if (season.getYear() == year) {
                return season;
            }
        }
        return null;
    }

    @Override
    public List<season> findAll() {
        return new ArrayList<>(seasons);
    }

    @Override
    public void addSeason(season season) {
        seasons.add(season);
    }

    @Override
    public void updateSeason(season updatedSeason) {
        season existingSeason = getSeasonByYear(updatedSeason.getYear());
        if (existingSeason != null) {
            existingSeason.getMatches().clear();
            existingSeason.getMatches().addAll(updatedSeason.getMatches());
        }
    }

    @Override
    public void deleteSeason(int year) {
        seasons.removeIf(season -> season.getYear() == year);
    }
}
