package edu.soccer.app.dao.DAOcentral;

import edu.soccer.app.dao.EntityCentral.Season;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SeasonDAO {
    private final Connection connection;

    public SeasonDAO(Connection connection) {
        this.connection = connection;
    }

    public void insert(Season season) throws SQLException {
        String sql = "INSERT INTO season (year, championship_id) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, season.getYear());
            stmt.setInt(2, season.getChampionshipId());
            stmt.executeUpdate();
        }
    }

    public List<Season> getAll() throws SQLException {
        List<Season> list = new ArrayList<>();
        String sql = "SELECT * FROM season";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Season(rs.getInt("id"), rs.getString("year"), rs.getInt("championship_id")));
            }
        }
        return list;
    }
}

