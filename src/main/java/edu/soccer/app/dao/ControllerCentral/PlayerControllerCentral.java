package edu.soccer.app.dao.ControllerCentral;

import edu.soccer.app.dao.EntityCentral.Player;
import edu.soccer.app.dao.ServiceCentral.PlayerServiceCentral;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerControllerCentral {

    private PlayerServiceCentral playerService;

    public void PlayerController(PlayerServiceCentral playerService) {
        this.playerService = playerService;
    }

    public PlayerControllerCentral(PlayerServiceCentral playerService) {
        this.playerService = playerService;
    }

    @PostMapping
    public ResponseEntity<String> addPlayer(@RequestBody Player player) {
        try {
            playerService.addPlayer(player);
            return ResponseEntity.ok("Joueur ajouté avec succès !");
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de l'ajout du joueur : " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers() {
        try {
            List<Player> players = playerService.getAllPlayers();
            return ResponseEntity.ok(players);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }
}
