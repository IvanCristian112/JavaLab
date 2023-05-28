package com.example.demo;

import com.google.ortools.Loader;
import com.google.ortools.linearsolver.MPObjective;
import com.google.ortools.linearsolver.MPSolver;
import com.google.ortools.linearsolver.MPConstraint;
import com.google.ortools.linearsolver.MPVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class VertexSeparatorService {
    private List<Game> games = new ArrayList<>();
    private static final int numberOfGames = 500;
    private static final int numberOfPlayers = 200;

    public void GenerateData() {

        var Players = IntStream.rangeClosed(0, numberOfPlayers)
                .mapToObj(i -> new Player("P" + Integer.toString(numberOfPlayers - i), i))
                .toArray(Player[]::new);
        // for this part, we do not need any moves; for simplicity's sake, the moves can be void
        List<Move> moves = new ArrayList<>();
        for (int i = 0; i < numberOfGames; i++) {
            int x = (int) (Math.random() * 200);
            int y = (int) (Math.random() * 200);
            games.add(new Game(Players[x], Players[y], moves));
        }
    }

    public void solve() {
        Loader.loadNativeLibraries();
        MPSolver solver = MPSolver.createSolver("SCIP");


        MPVariable[][] y = new MPVariable[numberOfPlayers][numberOfPlayers];
        MPVariable[] x = new MPVariable[numberOfPlayers];

        for (int i = 0; i < numberOfPlayers; i++) {
            x[i] = solver.makeIntVar(0, 1, "x_" + i);

            for (int j = i; j < numberOfPlayers; j++) {
                y[i][j] = solver.makeIntVar(0, 1, "y_" + i + "_" + j);
                y[j][i] = y[i][j];  // to ensure symmetry
            }
        }

        // Constraint: max(|A|,|B|) <= 2n/3
        MPConstraint constraint = solver.makeConstraint(0, 2 * numberOfPlayers / 3, "balance");
        for (int i = 0; i < numberOfPlayers; i++) {
            constraint.setCoefficient(x[i], 1);
        }

        // Constraint: no player in A has ever played with a player in B
        for (Game game : games) {
            int player1 = game.getFirstPlayer().getID();
            int player2 = game.getSecondPlayer().getID();

            // Create constraints for each player pair
            MPConstraint playerPairConstraint = solver.makeConstraint(0, 1, "pair_" + player1 + "_" + player2);
            playerPairConstraint.setCoefficient(y[player1][player2], 1);
            playerPairConstraint.setCoefficient(x[player1], -1);
            playerPairConstraint.setCoefficient(x[player2], -1);
        }

        // Objective: Minimize the size of set C
        MPObjective objective = solver.objective();
        for (int i = 0; i < numberOfPlayers; i++) {
            objective.setCoefficient(x[i], 1);
        }
        objective.setMinimization();

        // Solve the problem
        MPSolver.ResultStatus resultStatus = solver.solve();
        System.out.println(resultStatus);
        // Check the solution
        if (resultStatus == MPSolver.ResultStatus.OPTIMAL) {
            System.out.println("Optimal solution found");

            // Output the members of set C
            for (int i = 0; i < numberOfPlayers; i++) {
                System.out.println(x[i].solutionValue());
                if (x[i].solutionValue() == 1) {
                    System.out.println("Player " + i + " is in set C");
                }
            }
        } else {
            System.out.println("No solution found");
        }
    }
    public static void main(String[] args){
        VertexSeparatorService vertexSeparatorService = new VertexSeparatorService();
        vertexSeparatorService.GenerateData();
        vertexSeparatorService.solve();
    }
}