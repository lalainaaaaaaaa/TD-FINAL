package edu.soccer.app.api;

import edu.soccer.app.dao.EntityCentral.*;
import edu.soccer.app.dao.entity.*;
import edu.soccer.app.dao.service.ChampionshipRankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ApiCentralEndpoint {

    private List<Player> playerList = new ArrayList<>();
    private List<Match> matchList = new ArrayList<>();
    private List<Season> seasonList = new ArrayList<>();
    private List<Club> clubList = new ArrayList<>();
    private List<Championship> championshipList = new ArrayList<>();

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ChampionshipRankingService championshipRankingService;

    @Value("${api.key}")
    private String apiKey;


    @PostMapping("/synchronization")
    public ResponseEntity<String> synchronizeData() {
        List<String> apiUrls = List.of(
                "http://championship1/api/data",
                "http://championship2/api/data",
                "http://championship3/api/data",
                "http://championship4/api/data",
                "http://championship5/api/data"
        );

        List<ChampionshipData> allData = new ArrayList<>();
        for (String url : apiUrls) {
            try {
                HttpHeaders headers = new HttpHeaders();
                headers.set("X-API-KEY", apiKey);
                HttpEntity<Void> entity = new HttpEntity<>(headers);
                ResponseEntity<ChampionshipData> response = restTemplate.exchange(
                        url, HttpMethod.GET, entity, ChampionshipData.class
                );
                if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
                    allData.add(response.getBody());
                }
            } catch (Exception e) {
                System.err.println("Failed to fetch data from " + url + ": " + e.getMessage());
            }
        }
        return ResponseEntity.ok("Data synchronized successfully.");
    }

    @GetMapping("/bestPlayers")
    public ResponseEntity<List<Player>> getBestPlayers(
            @RequestParam(required = false) Integer top,
            @RequestParam(required = false) String playingTimeUnit) {
        List<Player> bestPlayers = new ArrayList<>(playerList);

        if (playingTimeUnit != null) {
            bestPlayers = bestPlayers.stream()
                    .filter(player -> playingTimeUnit.equalsIgnoreCase(player.getPlayingTimeUnit()))
                    .collect(Collectors.toList());
        }
        if (top != null && top > 0) {
            bestPlayers = bestPlayers.stream().limit(top).collect(Collectors.toList());
        }
        return ResponseEntity.ok(bestPlayers);
    }


    @GetMapping("/championshipRankings")
    public ResponseEntity<List<ChampionshipRanking>> getChampionshipRankings() {
        List<ChampionshipRanking> rankings = championshipRankingService.getAllRankings();
        return ResponseEntity.ok(rankings);
    }

    @GetMapping("/players")
    public ResponseEntity<List<Player>> getAllPlayers(
            @RequestParam(required = false) String club,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer ageMin,
            @RequestParam(required = false) Integer ageMax) {
        List<Player> filteredPlayers = playerList.stream()
                .filter(player -> club == null || (player.getTeam() != null && player.getTeam().equalsIgnoreCase(club)))
                .filter(player -> name == null || (player.getName() != null && player.getName().toLowerCase().contains(name.toLowerCase())))
                .filter(player -> ageMin == null || player.getAge() >= ageMin)
                .filter(player -> ageMax == null || player.getAge() <= ageMax)
                .collect(Collectors.toList());
        return ResponseEntity.ok(filteredPlayers);
    }

    @PostMapping("/players")
    public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
        playerList.add(player);
        return ResponseEntity.status(HttpStatus.CREATED).body(player);
    }

    @PutMapping("/players/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable int id, @RequestBody Player updatedPlayer) {
        for (int i = 0; i < playerList.size(); i++) {
            if (playerList.get(i).getId() == id) {
                playerList.set(i, updatedPlayer);
                return ResponseEntity.ok(updatedPlayer);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/clubs")
    public ResponseEntity<List<Club>> getAllClubs(
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String name) {
        List<Club> filteredClubs = clubList.stream()
                .filter(club -> city == null || (club.getLocation() != null && club.getLocation().toLowerCase().contains(city.toLowerCase())))
                .filter(club -> name == null || (club.getName() != null && club.getName().toLowerCase().contains(name.toLowerCase())))
                .collect(Collectors.toList());
        return ResponseEntity.ok(filteredClubs);
    }

    @PostMapping("/clubs")
    public ResponseEntity<Club> addClub(@RequestBody Club club) {
        clubList.add(club);
        return ResponseEntity.status(HttpStatus.CREATED).body(club);
    }

    @GetMapping("/matches")
    public ResponseEntity<List<Match>> getAllMatches(@RequestParam(required = false) String date) {
        List<Match> filteredMatches = matchList.stream()
                .filter(match -> date == null || (match.getDate() != null && match.getDate().equals(date)))
                .collect(Collectors.toList());
        Collections.reverse(filteredMatches);
        return ResponseEntity.ok(filteredMatches);
    }

    @PostMapping("/matches")
    public ResponseEntity<Match> addMatch(@RequestBody Match match) {
        matchList.add(match);
        return ResponseEntity.status(HttpStatus.CREATED).body(match);
    }


    @GetMapping("/seasons")
    public ResponseEntity<List<Season>> getAllSeasons() {
        return ResponseEntity.ok(seasonList);
    }

    @PostMapping("/seasons")
    public ResponseEntity<Season> addSeason(@RequestBody Season season) {
        seasonList.add(season);
        return ResponseEntity.status(HttpStatus.CREATED).body(season);
    }

    @GetMapping("/championships")
    public ResponseEntity<List<Championship>> getAllChampionships(
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) String name) {
        List<Championship> filteredChampionships = championshipList.stream()
                .filter(champ -> year == null || champ.getYear() == year)
                .filter(champ -> name == null || (champ.getName() != null && champ.getName().toLowerCase().contains(name.toLowerCase())))
                .collect(Collectors.toList());
        return ResponseEntity.ok(filteredChampionships);
    }

    @PostMapping("/championships")
    public ResponseEntity<Championship> addChampionship(@RequestBody Championship championship) {
        championshipList.add(championship);
        return ResponseEntity.status(HttpStatus.CREATED).body(championship);
    }
}
