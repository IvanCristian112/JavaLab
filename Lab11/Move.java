package com.example.demo;

public class Move {
    private String move;

    // Default constructor needed for deserialization
    public Move() {
    }
    public Move(String move) throws IllegalArgumentException {
        if (!move.matches("^[12]\\s+\\d+\\s+\\d+\\s*")) {
            throw new IllegalArgumentException("Invalid move format. Expected format: 'number number'");
        }
        this.move = move;
    }

    public String getMove() {
        return move;
    }

    // This method validates the input and throws an exception if the input is invalid
    public void setMove(String move) {
        if (!move.matches("^[12]\\s+\\d+\\s+\\d+\\s*")) {
            throw new IllegalArgumentException("Invalid move format. Expected format: 'number number'");
        }
        this.move = move;
    }

    @Override
    public String toString() {
        return "Move{" +
                "move='" + move + '\'' +
                '}';
    }
}
