package edu.soccer.app.dao.operations;

import edu.soccer.app.dao.entity.clubs;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class clubsCrudOperationsImpl implements clubsCrudOperations {

    private final List<clubs> clubsList = new ArrayList<>();

    @Override
    public void addTeam(clubs club) {
        clubsList.add(club);
    }

    @Override
    public void updateTeam(clubs club) {
        if (club == null || club.getName() == null) return;
        for (int i = 0; i < clubsList.size(); i++) {
            if (clubsList.get(i).getName().equalsIgnoreCase(club.getName())) {
                clubsList.set(i, club);
                return;
            }
        }
    }

    @Override
    public void deleteTeam(String name) {
        if (name == null) return;
        clubsList.removeIf(c -> c.getName().equalsIgnoreCase(name));
    }

    @Override
    public clubs getTeamByName(String name) {
        if (name == null) return null;
        Optional<clubs> club = clubsList.stream()
                .filter(c -> c.getName().equalsIgnoreCase(name))
                .findFirst();
        return club.orElse(null);
    }

    @Override
    public List<clubs> findAll() {
        return new ArrayList<>(clubsList);
    }

    @Override
    public clubs getBestTeam() {
        if (clubsList.isEmpty()) return null;

        clubs bestTeam = clubsList.get(0);
        int maxPoints = 0;
        if (bestTeam.getStatistics() != null) {
            maxPoints = bestTeam.getStatistics().getPoints();
        }

        for (clubs c : clubsList) {
            if (c.getStatistics() != null && c.getStatistics().getPoints() > maxPoints) {
                maxPoints = c.getStatistics().getPoints();
                bestTeam = c;
            }
        }
        return bestTeam;
    }
}
