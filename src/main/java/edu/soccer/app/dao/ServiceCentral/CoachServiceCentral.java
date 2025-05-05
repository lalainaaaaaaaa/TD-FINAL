package edu.soccer.app.dao.ServiceCentral;


import edu.soccer.app.dao.DAOcentral.CoachDAO;
import edu.soccer.app.dao.EntityCentral.Coach;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class CoachServiceCentral {
    private CoachDAO coachDAO;

    //  injecter le CoachDAO
    public void CoachService(CoachDAO coachDAO) {
        this.coachDAO = coachDAO;
    }

    public CoachServiceCentral(CoachDAO coachDAO) {
        this.coachDAO = coachDAO;
    }

    // Méthode pour ajouter un coach
    public void addCoach(Coach coach) throws SQLException {
        coachDAO.insert(coach);
    }
}

