package edu.soccer.app.dao.ServiceCentral;


import edu.soccer.app.dao.DAOcentral.ChampionshipDAO;
import edu.soccer.app.dao.EntityCentral.Championship;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ChampionshipService {

    private final ChampionshipDAO championshipDAO;

    // pour constructeur pour injecter le ChampionshipDAO
    public ChampionshipService(ChampionshipDAO championshipDAO) {
        this.championshipDAO = championshipDAO;
    }

    // pour récupérer tous les championnats
    public List<Championship> getAllChampionships() throws SQLException {
        return championshipDAO.getAll();
    }

    // pour Ajouter un championnat
    public void addChampionship(Championship championship) throws SQLException {
        championshipDAO.insert(championship);
    }
}

