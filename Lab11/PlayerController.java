package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/players")
    public List<Player> getPlayers() {
        return playerService.getPlayers();
    }

    @PostMapping("/players")
    public ResponseEntity<String> addPlayer(@RequestBody Player player) {
        return playerService.addPlayer(player);
    }


    @PutMapping("/players/{id}")
    public ResponseEntity<String> updatePlayer(@PathVariable int id, @RequestParam String Name) {
        return playerService.updatePlayer(id, Name);
    }

    @DeleteMapping("/players/{id}")
    public ResponseEntity<String> deletePlayer(@PathVariable int id) {
        return playerService.deletePlayer(id);
    }
}
