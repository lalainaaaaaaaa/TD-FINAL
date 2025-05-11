package edu.soccer.app.dao.operations;

import edu.soccer.app.dao.entity.clubs;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BestclubsCrudOperationsImpl implements CrudOperations<clubs> {

    private final List<clubs> clubsList = new ArrayList<>();

    @Override
    public List<clubs> getAll(int page, int size) {
        // Simple pagination (sans vérification des limites)
        int fromIndex = page * size;
        int toIndex = Math.min(fromIndex + size, clubsList.size());
        if (fromIndex > toIndex) {
            return new ArrayList<>();
        }
        return clubsList.subList(fromIndex, toIndex);
    }

    @Override
    public clubs findById(Long id) {
        if (id == null) return null;
        Optional<clubs> club = clubsList.stream()
                .filter(c -> c.getId() == id)
                .findFirst();
        return club.orElse(null);
    }

    @Override
    public List<clubs> saveAll(List<clubs> entities) {
        clubsList.addAll(entities);
        return entities;
    }

    @Override
    public clubs create(clubs club) {
        clubsList.add(club);
        return club;
    }

    @Override
    public clubs read(int id) {
        Optional<clubs> club = clubsList.stream()
                .filter(c -> c.getId() == id)
                .findFirst();
        return club.orElse(null);
    }

    @Override
    public List<clubs> readAll() {
        return new ArrayList<>(clubsList);
    }

    @Override
    public clubs update(clubs club) {
        for (int i = 0; i < clubsList.size(); i++) {
            if (clubsList.get(i).getId() == club.getId()) {
                clubsList.set(i, club);
                return club;
            }
        }
        return null; // pas trouvé
    }

    @Override
    public boolean delete(int id) {
        return clubsList.removeIf(c -> c.getId() == id);
    }
}
