package edu.soccer.app.dao.controller;

import edu.soccer.app.dao.entity.ChampionshipRanking;
import edu.soccer.app.dao.service.ChampionshipRankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ChampionshipRankingController {

    @Autowired
    private ChampionshipRankingService championshipRankingService;

    @GetMapping("/championshipRankings")
    public List<ChampionshipRanking> getChampionshipRankings() {
        return championshipRankingService.getAllRankings();
    }

    @PostMapping("/championshipRankings")
    public ResponseEntity<String> addRanking(@RequestBody ChampionshipRanking ranking) {
        championshipRankingService.addRanking(ranking);
        return ResponseEntity.ok("Ranking added successfully.");
    }

    @PutMapping("/championshipRankings/{index}")
    public ResponseEntity<String> updateRanking(@PathVariable int index,
                                                @RequestBody ChampionshipRanking updatedRanking) {
        championshipRankingService.updateRanking(index, updatedRanking);
        return ResponseEntity.ok("Ranking updated successfully.");
    }
}