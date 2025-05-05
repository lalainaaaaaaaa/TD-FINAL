package edu.soccer.app.dao.ServiceCentral;

import edu.soccer.app.dao.DAOcentral.SeasonDAO;
import edu.soccer.app.dao.EntityCentral.Season;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class SeasonServiceCentral {
    private final SeasonDAO seasonDAO;

    public SeasonServiceCentral(SeasonDAO seasonDAO) {
        this.seasonDAO = seasonDAO;
    }

    public void addSeason(Season season) throws SQLException {
        seasonDAO.insert(season);
    }

    public List<Season> getAllSeasons() throws SQLException {
        return seasonDAO.getAll();
    }
}
