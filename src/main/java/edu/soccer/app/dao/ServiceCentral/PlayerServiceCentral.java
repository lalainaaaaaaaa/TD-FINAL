package edu.soccer.app.dao.ServiceCentral;

import edu.soccer.app.dao.DAOcentral.PlayerDAO;
import edu.soccer.app.dao.EntityCentral.Player;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class PlayerServiceCentral {

    private final PlayerDAO playerDAO;

    public PlayerServiceCentral(PlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }

    public void addPlayer(Player player) throws SQLException {
        playerDAO.insert(player);
    }

    public List<Player> getAllPlayers() throws SQLException {
        return playerDAO.getAll();
    }
}

