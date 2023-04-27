package org.example;

import java.util.Arrays;

public class ExplorationMap {
    private final Cell[][] matrix;
    private final int size;

    public ExplorationMap(int dimension) {
        matrix = new Cell[dimension][dimension];
        size = dimension;
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                matrix[i][j] = new Cell();
            }
        }
    }

    public int getSize() {
        return size;
    }

    public Cell[][] getMatrix() {
        return matrix;
    }

    public int visit(int row, int col, Robot robot) {
        synchronized (matrix[row][col]) {
            if (!matrix[row][col].getVisited()) {
                matrix[row][col].setTokens(robot.getExploration().getMemory().extractTokens(size));
                matrix[row][col].setVisited(true);
                System.out.println("Cell " + row + " by " + col + " was visited succesfully by robot " + robot.getName());
                return matrix[row][col].getTokens().size();
            }
            return -1;
        }
    }


    @Override
    public String toString() {
        return "ExplorationMap{" +
                "matrix=" + Arrays.toString(matrix) +
                '}';
    }

}
