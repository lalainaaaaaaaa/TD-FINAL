package edu.soccer.app.dao.operations;

import edu.soccer.app.dao.entity.clubs;
import java.util.ArrayList;
import java.util.List;

public class clubsCrudOperationsImpl implements clubsCrudOperations {

    private List<clubs> clubList = new ArrayList<>();

    @Override
    public void addTeam(clubs club) {
        clubList.add(club);
    }

    @Override
    public void updateTeam(clubs club) {
        for (int i = 0; i < clubList.size(); i++) {
            clubs c = clubList.get(i);
            if (c.getId() == club.getId()) {
                clubList.set(i, club);
                return;
            }
        }
    }

    @Override
    public void deleteTeam(String name) {
        for (int i = 0; i < clubList.size(); i++) {
            clubs c = clubList.get(i);
            if (c.getName().equals(name)) {
                clubList.remove(i);
                return;
            }
        }
    }

    @Override
    public clubs getTeamByName(String name) {
        for (int i = 0; i < clubList.size(); i++) {
            clubs c = clubList.get(i);
            if (c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public List<clubs> findAll() {
        List<clubs> copy = new ArrayList<>();
        for (int i = 0; i < clubList.size(); i++) {
            copy.add(clubList.get(i));
        }
        return copy;
    }

    @Override
    public clubs getBestTeam() {
        if (clubList.size() == 0) {
            return null;
        }
        clubs best = clubList.get(0);
        for (int i = 1; i < clubList.size(); i++) {
            clubs c = clubList.get(i);
            if (c.getPoints() > best.getPoints()) {
                best = c;
            }
        }
        return best;
    }
}
