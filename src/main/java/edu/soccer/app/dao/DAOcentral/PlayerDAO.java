package edu.soccer.app.dao.DAOcentral;

import edu.soccer.app.dao.EntityCentral.Player;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerDAO {
    private final Connection connection;

    public PlayerDAO(Connection connection) {
        this.connection = connection;
    }

    public void insert(Player player) throws SQLException {
        String sql = "INSERT INTO player (name, position, nationality, club_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, player.getName());
            stmt.setString(2, player.getPosition());
            stmt.setInt(4, player.getClubId());
            stmt.executeUpdate();
        }
    }

    public List<Player> getAll() throws SQLException {
        List<Player> list = new ArrayList<>();
        String sql = "SELECT * FROM player";
        try (Statement stmt = connection.createStatement()) {
            try (ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    list.add(new Player(
                    ));
                }
            }
        }
        return list;
    }
}
