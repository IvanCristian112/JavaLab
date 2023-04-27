package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cell {

    private List<Token> tokens;
    private boolean isVisited;


    public Cell() {
        tokens = new ArrayList<>();
        isVisited = false;
    }

    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public boolean getVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }
}
