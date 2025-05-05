package edu.soccer.app.dao.ControllerCentral;

import edu.soccer.app.dao.EntityCentral.Season;
import edu.soccer.app.dao.ServiceCentral.SeasonServiceCentral;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/seasons")
public class SeasonControllerCentral {

    private SeasonServiceCentral seasonService;

    public void SeasonController(SeasonServiceCentral seasonService) {
        this.seasonService = seasonService;
    }

    public SeasonControllerCentral(SeasonServiceCentral seasonService) {
        this.seasonService = seasonService;
    }

    @PostMapping
    public ResponseEntity<String> addSeason(@RequestBody Season season) {
        try {
            seasonService.addSeason(season);
            return ResponseEntity.ok("Add Season successfully !");
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Add error : " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Season>> getAllSeasons() {
        try {
            List<Season> seasons = seasonService.getAllSeasons();
            return ResponseEntity.ok(seasons);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
