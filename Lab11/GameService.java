package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public class GameService {
    private Database database = Database.getInstance();

    public List<Game> getGames() {
        return database.getGames();
    }
}
