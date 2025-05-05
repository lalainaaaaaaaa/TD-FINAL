package edu.soccer.app.dao.DAOcentral;

import edu.soccer.app.dao.EntityCentral.Club;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClubDAO {
    private final Connection connection;

    public ClubDAO(Connection connection) {
        this.connection = connection;
    }

    public void insert(Club club) throws SQLException {
        String sql = "INSERT INTO club (name, stadium, championship_id) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, club.getName());
            stmt.setInt(2, club.getChampionshipId());
            stmt.executeUpdate();
        }
    }

    public List<Club> getAll() throws SQLException {
        List<Club> list = new ArrayList<>();
        String sql = "SELECT id, name, stadium, championship_id FROM club";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Club club = new Club();
                club.setId(rs.getInt("id"));
                club.setName(rs.getString("name"));
                club.setChampionshipId(rs.getInt("championship_id"));
                list.add(club);
            }
        }

        return list;
    }

}
