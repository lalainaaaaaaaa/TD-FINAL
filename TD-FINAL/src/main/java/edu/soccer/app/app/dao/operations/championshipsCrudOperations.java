package edu.soccer.app.dao.operations;

import edu.soccer.app.dao.entity.championships;
import java.util.List;

public interface championshipsCrudOperations {
    championships getChampionshipByName(String name);

    List<championships> findAll();

    void addChampionship(championships championship);

    void updateChampionship(championships updatedChampionship);

    void deleteChampionship(String name);
}