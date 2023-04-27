package org.example;

public class Timekeeper extends Thread {
    private final Exploration exploration;
    private final long timeLimitMillis;

    public Timekeeper(Exploration exploration, long timeLimitMillis) {
        this.exploration = exploration;
        this.timeLimitMillis = timeLimitMillis;
        setDaemon(true);
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        while (true) {
            long currentTime = System.currentTimeMillis();
            long elapsedTime = currentTime - startTime;
            if (elapsedTime > timeLimitMillis) {
                System.out.println("Time limit exceeded. Stopping exploration...");
                exploration.stop();
                break;
            }
            try {
                Thread.sleep(250); // Sleep for 100 ms before checking the elapsed time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }



            System.out.println("Elapsed time: " + elapsedTime + " ms");


        }
    }

}
