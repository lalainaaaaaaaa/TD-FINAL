package edu.soccer.app.dao.operations;

import edu.soccer.app.dao.entity.championships;

import java.util.ArrayList;
import java.util.List;

public class championshipsCrudOperationsImpl implements championshipsCrudOperations {
    private static List<edu.soccer.app.dao.entity.championships> championships = new ArrayList<>();

    static {
        championships.add(new championships("Premier League", "England"));
        championships.add(new championships("La Liga", "Spain"));
        championships.add(new championships("Bundesliga", "Germany"));
    }

    @Override
    public edu.soccer.app.dao.entity.championships getChampionshipByName(String name) {
        for (edu.soccer.app.dao.entity.championships championship : championships) {
            if (championship.getName().equalsIgnoreCase(name)) {
                return championship;
            }
        }
        throw new IllegalArgumentException("Championship not found: " + name);
    }

    @Override
    public List<edu.soccer.app.dao.entity.championships> findAll() {
        return new ArrayList<>(championships);
    }

    @Override
    public void addChampionship(edu.soccer.app.dao.entity.championships championship) {
        if (championship.getName() == null || championship.getName().isEmpty()) {
            throw new IllegalArgumentException("Championship name cannot be null or empty.");
        }
        championships.add(championship);
    }

    @Override
    public void updateChampionship(edu.soccer.app.dao.entity.championships updatedChampionship) {
        edu.soccer.app.dao.entity.championships existingChampionship = getChampionshipByName(updatedChampionship.getName());
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