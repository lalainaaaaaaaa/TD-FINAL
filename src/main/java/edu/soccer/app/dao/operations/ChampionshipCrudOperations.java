package edu.soccer.app.dao.operations;

import edu.soccer.app.dao.entity.Championship;
import java.util.List;

public interface ChampionshipCrudOperations {
    Championship getChampionshipByName(String name);

    List<Championship> findAll();

    void addChampionship(Championship championship);

    void updateChampionship(Championship updatedChampionship);

    void deleteChampionship(String name);
}