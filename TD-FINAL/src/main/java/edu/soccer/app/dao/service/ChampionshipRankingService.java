package edu.soccer.app.dao.service;

import edu.soccer.app.dao.entity.ChampionshipRanking;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChampionshipRankingService {

    private List<ChampionshipRanking> rankings = new ArrayList<>();

    public List<ChampionshipRanking> getAllRankings() {
        return rankings;
    }

    public void addRanking(ChampionshipRanking ranking) {
        rankings.add(ranking);
    }

    public void updateRanking(int index, ChampionshipRanking updatedRanking) {
        if (index >= 0 && index < rankings.size()) {
            rankings.set(index, updatedRanking);
        }
    }

    public void clearRankings() {
        rankings.clear();
    }
}