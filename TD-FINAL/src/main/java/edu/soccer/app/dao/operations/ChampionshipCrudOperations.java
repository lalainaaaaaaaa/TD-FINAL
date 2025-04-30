package edu.soccer.app.dao.operations;

import edu.soccer.app.dao.entity.Championship;

import java.util.ArrayList;
import java.util.List;

public class ChampionshipCrudOperations {
    private static List<Championship> championships = new ArrayList<>();

    static {
        championships.add(new Championship("Premier League", "England"));
        championships.add(new Championship("La Liga", "Spain"));
        championships.add(new Championship("Bundesliga", "Germany"));
    }

    public static Championship getChampionshipByName(String name) {
        for (Championship championship : championships) {
            if (championship.getName().equalsIgnoreCase(name)) {
                return championship;
            }
        }
        return null;
    }

    public static List<Championship> findAll() {
        return new ArrayList<>(championships);
    }

    public static void addChampionship(Championship championship) {
        championships.add(championship);
    }

    public static void updateChampionship(Championship updatedChampionship) {
        Championship existingChampionship = getChampionshipByName(updatedChampionship.getName());
        if (existingChampionship != null) {
            existingChampionship.setCurrentSeason(updatedChampionship.getCurrentSeason());
            existingChampionship.getTeams().clear();
            existingChampionship.getTeams().addAll(updatedChampionship.getTeams());
        }
    }

    public static void deleteChampionship(String name) {
        championships.removeIf(championship -> championship.getName().equalsIgnoreCase(name));
    }
}