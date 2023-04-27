package org.example;

public class ParseUserInput {
    private final Exploration exploration;

    public ParseUserInput(Exploration exploration) {
        this.exploration = exploration;
    }

    public void parseInput(String string) {
        if (string.startsWith("stop")) {
            if (string.equalsIgnoreCase("stop all")) {
                System.out.println("command received");
                exploration.pauseAllRobots();
            } else {
                int index = string.indexOf(" ");
                if (index != -1 && index + 1 < string.length()) {
                    String afterSpace = string.substring(index + 1);
                    int robotValue = Integer.valueOf(afterSpace);
                    if (robotValue < exploration.getRobots().size()) {
                        exploration.getRobots().get(robotValue).pause();
                    }
                }
            }
        } else if (string.startsWith("start")) {
            if (string.equalsIgnoreCase("start all")) {
                System.out.println("command received");
                exploration.resumeAllRobots();
            } else {
                int index = string.indexOf(" ");
                if (index != -1 && index + 1 < string.length()) {
                    String afterSpace = string.substring(index + 1);
                    int robotValue = Integer.valueOf(afterSpace);

                    if (robotValue < exploration.getRobots().size()) {
                        exploration.getRobots().get(robotValue).resume();
                    }
                }

            }
        }
    }
}
