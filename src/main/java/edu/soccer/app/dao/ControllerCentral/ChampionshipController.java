package edu.soccer.app.dao.ControllerCentral;

import edu.soccer.app.dao.EntityCentral.Championship;
import edu.soccer.app.dao.ServiceCentral.ChampionshipService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/championships")  // L'URL de base pour les requêtes
public class ChampionshipController {

    private final ChampionshipService championshipService;

    // Constructeur pour injecter le ChampionshipService
    public ChampionshipController(ChampionshipService championshipService) {
        this.championshipService = championshipService;
    }

    // Méthode pour récupérer tous les championnats
    @GetMapping
    public List<Championship> getAllChampionships() throws SQLException {
        return championshipService.getAllChampionships();
    }

    // Méthode pour ajouter un nouveau championnat
    @PostMapping
    public ResponseEntity<String> addChampionship(@RequestBody Championship championship) {
        try {
            championshipService.addChampionship(championship);
            return ResponseEntity.ok("Championnat ajouté avec succès !");
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de l'ajout du championnat : " + e.getMessage());
        }
    }
}
