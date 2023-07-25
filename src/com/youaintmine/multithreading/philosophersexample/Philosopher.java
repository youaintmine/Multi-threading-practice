package com.youaintmine.multithreading.philosophersexample;

import java.util.Random;

public class Philosopher implements Runnable{

    private int id;
    private volatile boolean full;
    private Chopstick leftChopStick;
    private Chopstick rightChopStick;
    private Random random;
    private int eatingCounter;

    public Philosopher(int id, Chopstick leftChopStick, Chopstick rightChopSticks) {
        this.id = id;
        this.leftChopStick = leftChopStick;
        this.rightChopStick = rightChopSticks;
        this.random = new Random();
    }

    @Override
    public void run() {
        try {
            while (!full) {
                think();
                if(leftChopStick.pickUp(this, State.LEFT)) {
                    //the philosopher is able to acquire the left chopstick
                    if(rightChopStick.pickUp(this, State.RIGHT)) {
                        eat();
                        rightChopStick.putDown(this, State.RIGHT);
                    }
                    leftChopStick.putDown(this, State.LEFT);
                }
            }
        }catch (Exception e){

        }
    }

    private void think() throws InterruptedException {
        System.out.println(this + " is thinking...");
        // philosopher thinks for a random time
        Thread.sleep(random.nextInt(1000));
    }

    private void eat() throws InterruptedException {
        System.out.println(this + " is eating...");
        eatingCounter++;
        // philosopher thinks for a random time
        Thread.sleep(random.nextInt(1000));
    }

    public void setFull(boolean full) {
        this.full = full;
    }

    public int getEatingCounter() {
        return this.eatingCounter;
    }

    public boolean isFull() {
        return this.full;
    }

    @Override
    public String toString() {
        return "Philosopher "+id;
    }
}
