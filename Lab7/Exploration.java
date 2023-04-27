package org.example;

import java.util.ArrayList;
import java.util.List;

public class Exploration {
    private final SharedMemory memory;
    private final ExplorationMap map;
    private final List<Robot> robots;
    private final List<Thread> robotThreads;


    public SharedMemory getMemory() {
        return memory;
    }

    public ExplorationMap getMap() {
        return map;
    }

    public List<Robot> getRobots() {
        return robots;
    }

    public Exploration(int dimension) {
        memory = new SharedMemory(dimension);
        map = new ExplorationMap(dimension);
        robots = new ArrayList<>();
        robotThreads = new ArrayList<>();
    }

    public List<Thread> getRobotThreads() {
        return robotThreads;
    }

    public void addRobot(Robot robot) {
        this.robots.add(robot);
        robot.setExploration(this);
    }


    public void start() {
        for (Robot robot : robots) {
            Thread thread = new Thread(robot);
            robotThreads.add(thread);
            thread.start();
        }
    }

    public void pauseAllRobots() {
        for (Robot robot : robots) {
            robot.pause();
        }
    }

    public void resumeAllRobots() {
        for (Robot robot : robots) {
            robot.resume();
        }
    }


    public void stop() {
        for (Robot robot : robots) {
            robot.setRunning(false);
        }
    }

    public boolean isExplorationComplete() {
        for (int i = 0; i < map.getSize(); i++) {
            for (int j = 0; j < map.getSize(); j++) {
                if (!map.getMatrix()[i][j].getVisited()) {
                    return false;
                }
            }
        }
        return true;
    }

    public void displayTokens() {
        for (Robot robot : robots) {
            System.out.println("Robot " + robot.getName() + " has placed " + robot.getTokens() + " tokens");
        }
    }
}
