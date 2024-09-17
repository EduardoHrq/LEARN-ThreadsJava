package org.using_volatile;

public class Runner implements Runnable {

    public Race race;
    public String runner;

    public Runner(String runner, Race race) {
        this.race = race;
        this.runner = runner;
    }

    @Override
    public void run() {
        System.out.println(STR."\{runner} running...");
//        System.out.printf("\n winner: %s", runner);
        while (!race.isFinished()) {
            this.race.setFinished(true);
            System.out.println(STR."winner: \{runner}");
            return;
        }

        System.out.println(STR."defeat: \{runner}");
    }

}
