package edu.soccer.app.dao.controller;

import edu.soccer.app.dao.entity.IndividualStatistics;
import edu.soccer.app.dao.entity.players;
import edu.soccer.app.dao.entity.season;
import edu.soccer.app.dao.service.playerStatisticsService;
import edu.soccer.app.dao.service.playersService;
import edu.soccer.app.dao.service.seasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerStatisticsController {

    private final playersService playerService;
    private final seasonService seasonService;
    private final playerStatisticsService playerStatisticsService;

    @Autowired
    public PlayerStatisticsController(playersService playerService,
                                      seasonService seasonService,
                                      playerStatisticsService playerStatisticsService) {
        this.playerService = playerService;
        this.seasonService = seasonService;
        this.playerStatisticsService = playerStatisticsService;
    }

    // Endpoint GET /api/players avec filtres optionnels club et name
    @GetMapping
    public List<players> getPlayers(
            @RequestParam(required = false) String club,
            @RequestParam(required = false) String name) {
        return playerService.findAllFiltered(club, name);
    }

    // Endpoint GET /api/players/{id}/statistics/{seasonYear}
    @GetMapping("/{id}/statistics/{seasonYear}")
    public ResponseEntity<IndividualStatistics> getPlayerStatisticsBySeason(@PathVariable String id,
                                                                            @PathVariable int seasonYear) {
        players player = playerService.findById(id);
        if (player == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        season season = seasonService.findByYear(seasonYear);
        if (season == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        IndividualStatistics totalStats = playerStatisticsService.calculateTotalStatistics(player, season);
        return ResponseEntity.ok(totalStats);
    }
}
