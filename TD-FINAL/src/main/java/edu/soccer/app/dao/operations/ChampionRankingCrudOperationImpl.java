package edu.soccer.app.dao.operations;

import edu.soccer.app.dao.entity.ChampionshipRanking;
import edu.soccer.app.dao.operations.ChampionRankingCrudOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChampionRankingCrudOperationImpl implements ChampionRankingCrudOperations<ChampionshipRanking> {

    private final List<ChampionshipRanking> rankings = new ArrayList<>();

    @Override
    public void addRanking(ChampionshipRanking ranking) {

    }

    @Override
    public ChampionshipRanking getRankingByIndex(int index) {
        return null;
    }

    @Override
    public void updateRanking(int index, ChampionshipRanking updatedRanking) {

    }

    @Override
    public void deleteRanking(int index) {

    }

    @Override
    public List<ChampionshipRanking> findAll() {
        return rankings;
    }

    @Override
    public void clearRankings() {

    }

    @Override
    public ChampionshipRanking findByIndex(int index) {
        if (index >= 0 && index < rankings.size()) {
            return rankings.get(index);
        }
        return null;
    }

    @Override
    public void save(ChampionshipRanking ranking) {
        rankings.add(ranking);
    }

    @Override
    public void update(int index, ChampionshipRanking updatedRanking) {
        if (index >= 0 && index < rankings.size()) {
            rankings.set(index, updatedRanking);
        }
    }

    @Override
    public void delete(int index) {
        if (index >= 0 && index < rankings.size()) {
            rankings.remove(index);
        }
    }

    @Override
    public void clear() {
        rankings.clear();
    }
}
