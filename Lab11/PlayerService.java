package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    private Database database = Database.getInstance();

    public List<Player> getPlayers() {
        return database.getPlayers();
    }

    public ResponseEntity<String> addPlayer(Player player) {
        int id = database.getPlayers().size() + 1;
        player.setID(id);
        database.getPlayers().add(player);
        return new ResponseEntity<>(
                "Player created successfully", HttpStatus.CREATED);
    }


    public ResponseEntity<String> updatePlayer(int id, String Name) {
        for (Player player : database.getPlayers()) {
            if (player.getID() == id) {
                player.setName(Name);
                return new ResponseEntity<>("Player updated successfully", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Player not found", HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<String> deletePlayer(int id) {
        for (Player player : database.getPlayers()) {
            if (player.getID() == id) {
                database.getPlayers().remove(player);
                return new ResponseEntity<>("Player deleted successfully", HttpStatus.GONE);
            }
        }
        return new ResponseEntity<>("Player not found", HttpStatus.NOT_FOUND);
    }
}

