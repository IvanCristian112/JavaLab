package org.example;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class AI {
    DrawingPanel drawingPanel;

    public AI(DrawingPanel drawingPanel) {
        this.drawingPanel = drawingPanel;
    }

    private Set<Line> generateMoves(Set<Line> lines, Color currentPlayerColor) {
        Set<Line> moves = new HashSet<>();
        for (Line line : lines) {
            if (line.color == Color.BLACK) {
                Line newLine = new Line(line.startXCoordinate, line.startYCoordinate, line.endXCoordinate, line.endYCoordinate);
                newLine.setColor(currentPlayerColor);
                moves.add(newLine);
            }
        }
        return moves;
    }

    private int evaluate(Set<Line> lines, Color currentPlayerColor) {
        if (drawingPanel.checkForTriangle(lines, currentPlayerColor)) {
            return Integer.MAX_VALUE;
        } else if (drawingPanel.checkForTriangle(lines, getOpponentColor(currentPlayerColor))) {
            return Integer.MIN_VALUE;
        } else {
            return 0;
        }
    }

    private Color getOpponentColor(Color currentPlayerColor) {
        return currentPlayerColor == Color.RED ? Color.BLUE : Color.RED;
    }

    private int minimax(Set<Line> lines, int depth, boolean isMaximizingPlayer, Color currentPlayerColor, int alpha, int beta) {
        if (depth == 0 || drawingPanel.checkForTriangle(lines, currentPlayerColor) || drawingPanel.checkForTriangle(lines, getOpponentColor(currentPlayerColor))) {
            return evaluate(lines, currentPlayerColor);
        }

        if (isMaximizingPlayer) {
            int maxEval = Integer.MIN_VALUE;
            Set<Line> moves = generateMoves(lines, currentPlayerColor);
            for (Line move : moves) {
                Set<Line> newLines = new HashSet<>(lines);
                newLines.remove(move);
                newLines.add(move);
                int eval = minimax(newLines, depth - 1, false, getOpponentColor(currentPlayerColor), alpha, beta);
                maxEval = Math.max(maxEval, eval);
                alpha = Math.max(alpha, eval);
                if (beta <= alpha) {
                    break;
                }
            }
            return maxEval;
        } else {
            int minEval = Integer.MAX_VALUE;
            Set<Line> moves = generateMoves(lines, currentPlayerColor);
            for (Line move : moves) {
                Set<Line> newLines = new HashSet<>(lines);
                newLines.remove(move);
                newLines.add(move);
                int eval = minimax(newLines, depth - 1, true, getOpponentColor(currentPlayerColor), alpha, beta);
                minEval = Math.min(minEval, eval);
                beta = Math.min(beta, eval);
                if (beta <= alpha) {
                    break;
                }
            }
            return minEval;
        }
    }

    private Line findBestMove(Set<Line> lines, Color currentPlayerColor) {
        int bestValue = Integer.MIN_VALUE;
        Line bestMove = null;

        for (Line move : generateMoves(lines, currentPlayerColor)) {
            Set<Line> newLines = new HashSet<>(lines);
            newLines.remove(move);
            newLines.add(move);
            int moveValue = minimax(newLines, 3, false, getOpponentColor(currentPlayerColor), Integer.MIN_VALUE, Integer.MAX_VALUE);
            if (moveValue > bestValue) {
                bestValue = moveValue;
                bestMove = move;
            }
        }
        return bestMove;
    }
}
