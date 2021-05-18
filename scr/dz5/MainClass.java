package dz5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class MainClass {
    public static final int CARS_COUNT = 4;
    public static final String END_RACE = "Дорога 40 метров";  // последний этап трассы

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch cdlr = new CountDownLatch(CARS_COUNT);   //  ожидание старта
        CountDownLatch cdls = new CountDownLatch(CARS_COUNT);   //  ожидание завершения
        Semaphore smp = new Semaphore(CARS_COUNT/2);    // ограничитель тунелля

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(END_RACE, new Road(60), new Tunnel(smp), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }

        for (int i = 0; i < cars.length; i++) {
            cars[i].readyToStart(cdlr).start();
        }
        cdlr.await();

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");

        for (int i = 0; i < cars.length; i++) {
            cars[i].start(cdls).start();
        }
        cdls.await();



        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");

        race.rezults();

    }
}
