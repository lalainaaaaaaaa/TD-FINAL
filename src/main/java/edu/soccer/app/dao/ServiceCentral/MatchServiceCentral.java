package edu.soccer.app.dao.ServiceCentral;

import edu.soccer.app.dao.DAOcentral.MatchDAO;
import edu.soccer.app.dao.EntityCentral.Match;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class MatchServiceCentral {
    private final MatchDAO matchDAO;

    public MatchServiceCentral(MatchDAO matchDAO) {
        this.matchDAO = matchDAO;
    }

    public void addMatch(Match match) throws SQLException {
        matchDAO.insert(match);
    }

    public List<Match> getAllMatches() throws SQLException {
        return matchDAO.getAll();
    }
}

