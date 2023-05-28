package com.example.demo;

import java.util.List;

public class Game {
    private Player firstPlayer;
    private Player secondPlayer;
    private List<Move> moves;

    public Game(Player firstPlayer, Player secondPlayer, List<Move> moves) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.moves = moves;
    }

    public Game() {
    }

    @Override
    public String toString() {
        return "Game{" +
                "firstPlayer=" + firstPlayer +
                ", secondPlayer=" + secondPlayer +
                ", moves=" + moves +
                '}';
    }

    public Player getFirstPlayer() {
        return firstPlayer;
    }

    public Player getSecondPlayer() {
        return secondPlayer;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setFirstPlayer(Player firstPlayer) {
        this.firstPlayer = firstPlayer;
    }

    public void setSecondPlayer(Player secondPlayer) {
        this.secondPlayer = secondPlayer;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }


}
