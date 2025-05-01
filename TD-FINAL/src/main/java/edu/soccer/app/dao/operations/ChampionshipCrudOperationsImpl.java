package edu.soccer.app.dao.operations;

import edu.soccer.app.dao.entity.Championship;

import java.util.ArrayList;
import java.util.List;

public class ChampionshipCrudOperationsImpl implements ChampionshipCrudOperations {
    private static List<Championship> championships = new ArrayList<>();

    static {
        championships.add(new Championship("Premier League", "England"));
        championships.add(new Championship("La Liga", "Spain"));
        championships.add(new Championship("Bundesliga", "Germany"));
    }

    @Override
    public Championship getChampionshipByName(String name) {
        for (Championship championship : championships) {
            if (championship.getName().equalsIgnoreCase(name)) {
                return championship;
            }
        }
        throw new IllegalArgumentException("Championship not found: " + name);
    }

    @Override
    public List<Championship> findAll() {
        return new ArrayList<>(championships);
    }

    @Override
    public void addChampionship(Championship championship) {
        if (championship.getName() == null || championship.getName().isEmpty()) {
            throw new IllegalArgumentException("Championship name cannot be null or empty.");
        }
        championships.add(championship);
    }

    @Override
    public void updateChampionship(Championship updatedChampionship) {
        Championship existingChampionship = getChampionshipByName(updatedChampionship.getName());
        if (existingChampionship != null) {
            existingChampionship.setCurrentSeason(updatedChampionship.getCurrentSeason());
            existingChampionship.getTeams().clear();
            existingChampionship.getTeams().addAll(updatedChampionship.getTeams());
        }
    }

    @Override
    public void deleteChampionship(String name) {
        if (!championships.removeIf(championship -> championship.getName().equalsIgnoreCase(name))) {
            throw new IllegalArgumentException("Championship not found: " + name);
        }
    }
}