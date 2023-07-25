package com.youaintmine.multithreading.philosophersexample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) throws InterruptedException{
        System.out.println("Philosophers Problem");

        ExecutorService executorService = null;
        Philosopher[] philosophers = null;
        Chopstick[] chopsticks = null;

        try {
            philosophers = new Philosopher[Constants.NUM_PHILOSOPHERS];
            chopsticks = new Chopstick[Constants.NUM_CHOPSTICKS];
            for (int i=0; i<Constants.NUM_CHOPSTICKS; ++i)
                chopsticks[i] = new Chopstick(i);

            executorService = Executors.newFixedThreadPool(Constants.NUM_PHILOSOPHERS);

            for (int i=0; i<Constants.NUM_PHILOSOPHERS;++i){
                philosophers[i] = new Philosopher(i, chopsticks[i], chopsticks[(i+1)%Constants.NUM_PHILOSOPHERS]);
                executorService.execute(philosophers[i]);
            }
            Thread.sleep(Constants.SIM_RUNNING_TIME);

            for (Philosopher philosopher : philosophers)
                philosopher.setFull(true);
        } finally {
            executorService.shutdown();

            while(!executorService.isTerminated())
                Thread.sleep(1000);

            for (Philosopher philosopher : philosophers){
                System.out.println(philosopher+" eat #"+philosopher.getEatingCounter()+" times.");
            }
        }
    }
}
