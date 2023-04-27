package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Exploration exploration = new Exploration(15);

        exploration.addRobot(new Robot("Wall-E"));
        exploration.addRobot(new Robot("R2D2"));
        exploration.addRobot(new Robot("Optimus Prime"));
        exploration.addRobot(new Robot("Cristi Frasinaru"));


        Timekeeper timekeeper = new Timekeeper(exploration, 10000);
        timekeeper.start();
        exploration.start();
        try {
            timekeeper.join();
            //exploration.waitForRobots();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Scanner input = new Scanner(System.in);
        while (true) {
            if (exploration.isExplorationComplete()) exploration.displayTokens();
            String line = input.nextLine();
            ParseUserInput parseUserInput = new ParseUserInput(exploration);
            parseUserInput.parseInput(line);
        }
    }
}
