package edu.soccer.app.dao.operations;

import edu.soccer.app.dao.entity.Season;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SeasonCrudOperationsImpl implements SeasonCrudOperations {
    private static List<Season> seasons = new ArrayList<>();

    @Override
    public void loadSeasonsFromDatabase(Connection connection) throws SQLException {
        String sql = "SELECT * FROM Season";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int year = rs.getInt("year");
                seasons.add(new Season(year));
            }
        }
    }

    @Override
    public Season getSeasonByYear(int year) {
        for (Season season : seasons) {
            if (season.getYear() == year) {
                return season;
            }
        }
        return null;
    }

    @Override
    public List<Season> findAll() {
        return new ArrayList<>(seasons);
    }

    @Override
    public void addSeason(Season season) {
        seasons.add(season);
    }

    @Override
    public void updateSeason(Season updatedSeason) {
        Season existingSeason = getSeasonByYear(updatedSeason.getYear());
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
