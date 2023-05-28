package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private static Database single_instance = null;
    private List<Player> players = new ArrayList<>();
    private List<Game> games = new ArrayList<>();

    public List<Player> getPlayers() {
        return players;
    }

    private Database() {
        players.add(new Player("Ionica", 1));
        players.add(new Player("Andrei", 2));
        players.add(new Player("Stefan", 3));
        players.add(new Player("Marian", 4));
        Player firstPlayer = new Player("Nicolae", 5);
        Player secondPlayer = new Player("Octavian", 6);
        players.add(firstPlayer);
        players.add(secondPlayer);
        List<Move> moves = new ArrayList<>();
        moves.add(new Move("1 9 9"));
        moves.add(new Move("2 9 10"));
        moves.add(new Move("1 8 9"));
        moves.add(new Move("2 9 11"));
        moves.add(new Move("1 7 9"));
        moves.add(new Move("2 9 12"));
        moves.add(new Move("1 10 9"));
        moves.add(new Move("2 8 10"));
        moves.add(new Move("1 11 9"));
        moves.add(new Move("2 7 10"));
        moves.add(new Move("1 6 9"));
        moves.add(new Move("2 10 10"));
        moves.add(new Move("1 12 9"));
        games.add(new Game(firstPlayer, secondPlayer, moves));

    }

    public List<Game> getGames() {
        return games;
    }

    public static Database getInstance() {
        if (single_instance == null) {
            single_instance = new Database();
        }
        return single_instance;
    }


}
