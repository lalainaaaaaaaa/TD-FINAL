package edu.soccer.app.dao.ServiceCentral;


import edu.soccer.app.dao.DAOcentral.ClubDAO;
import edu.soccer.app.dao.EntityCentral.Club;
import org.springframework.stereotype.Service;
import java.sql.SQLException;
import java.util.List;


@Service
public class ClubServiceCentral {
    private ClubDAO clubDAO;

    public void ClubService(ClubDAO clubDAO) {
        this.clubDAO = clubDAO;
    }

    public ClubServiceCentral(ClubDAO clubDAO) {
        this.clubDAO = clubDAO;
    }

    public List<Club> getAllClubs() throws SQLException {
        return clubDAO.getAll();
    }

    public void addClub(Club club) throws SQLException {
        clubDAO.insert(club);
    }
}

