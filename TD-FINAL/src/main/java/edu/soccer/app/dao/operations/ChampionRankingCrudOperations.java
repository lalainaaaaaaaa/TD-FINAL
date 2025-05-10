package edu.soccer.app.dao.operations;

import edu.soccer.app.dao.entity.ChampionshipRanking;
import java.util.List;

public interface ChampionRankingCrudOperations<C> {

    void addRanking(ChampionshipRanking ranking);

    ChampionshipRanking getRankingByIndex(int index);

    void updateRanking(int index, ChampionshipRanking updatedRanking);

    void deleteRanking(int index);

    List<ChampionshipRanking> findAll();

    void clearRankings();

    ChampionshipRanking findByIndex(int index);

    void save(ChampionshipRanking ranking);

    void update(int index, ChampionshipRanking updatedRanking);

    void delete(int index);

    void clear();
}
