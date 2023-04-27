package org.example;

public class Robot implements Runnable {
    private final String name;
    private Exploration exploration;
    private boolean running = true;
    private int row;

    private boolean hasRow = false;
    private boolean paused = false;
    private int tokens = 0;

    public Exploration getExploration() {
        return exploration;
    }

    public void setExploration(Exploration exploration) {
        this.exploration = exploration;
    }

    public String getName() {
        return name;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    public int getTokens() {
        return tokens;
    }

    public Robot(String name) {
        this.name = name;
    }

    public int getFirstRow() {
        for (int i = 0; i < exploration.getMap().getSize(); i++) {
            if (!exploration.getMap().getMatrix()[i][0].getVisited()) {
                hasRow = true;
                return i;
            }
        }
        hasRow = false;
        return -1;
    }

    public synchronized void pause() {
        paused = true;
    }

    public synchronized void resume() {
        paused = false;
        notify();
    }

    @Override
    public void run() {
        while (running) {
            if (!hasRow) {
                row = getFirstRow();
                if (row == -1) {
                    running = false;
                }
            }

            //each robot will try to explore a line of the matrix
            for (int i = 0; i < exploration.getMap().getSize(); i++) {
                synchronized (this) {
                    while (paused) {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }

                if (running) {
                    int placedTokens = exploration.getMap().visit(row, i, this);
                    if (placedTokens > 0) tokens += placedTokens;
                    if (i == exploration.getMap().getSize() - 1) {
                        row = getFirstRow();
                        if (row == -1) {
                            running = false;
                        }
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

}
