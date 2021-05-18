package dz5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Car {
    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    public Thread readyToStart (CountDownLatch cdl) {
        Thread thr = new Thread(() -> {
            try {
                System.out.println(this.name + " готовится");
                Thread.sleep(500 + (int) (Math.random() * 800));
                System.out.println(this.name + " готов");
            } catch (Exception e) {
                e.printStackTrace();
            }
            cdl.countDown();
        });
        return thr;
    }

    public Thread start (CountDownLatch cdl) {
        Semaphore smp = new Semaphore(CARS_COUNT/2);
        Thread thr = new Thread(() -> {
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this, race);
        }
        cdl.countDown();
        });
        return thr;
    }
}
