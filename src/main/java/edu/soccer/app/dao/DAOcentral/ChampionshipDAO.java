package edu.soccer.app.dao.DAOcentral;

import edu.soccer.app.dao.EntityCentral.Championship;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChampionshipDAO {
    private final Connection connection;

    public ChampionshipDAO(Connection connection) {
        this.connection = connection;
    }

    public void insert(Championship championship) throws SQLException {
        String sql = "INSERT INTO championship (name, country) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, championship.getName());
            stmt.setString(2, championship.getCountry());
            stmt.executeUpdate();
        }
    }

    public List<Championship> getAll() throws SQLException {
        List<Championship> list = new ArrayList<>();
        String sql = "SELECT * FROM championship";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Championship(rs.getInt("id"), rs.getString("name"), rs.getString("country")));
            }
        }
        return list;
    }
}
