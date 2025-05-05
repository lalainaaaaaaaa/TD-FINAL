package edu.soccer.app.dao.ControllerCentral;

import edu.soccer.app.dao.EntityCentral.Match;
import edu.soccer.app.dao.ServiceCentral.MatchServiceCentral;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/matches")
public class MatchControllerCentral {

    private MatchServiceCentral matchService;

    public void MatchController(MatchServiceCentral matchService) {
        this.matchService = matchService;
    }

    public MatchControllerCentral(MatchServiceCentral matchService) {
        this.matchService = matchService;
    }

    @PostMapping
    public ResponseEntity<String> addMatch(@RequestBody Match match) {
        try {
            matchService.addMatch(match);
            return ResponseEntity.ok("add match with succes !");
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error  : " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Match>> getAllMatches() {
        try {
            List<Match> matches = matchService.getAllMatches();
            return ResponseEntity.ok(matches);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
