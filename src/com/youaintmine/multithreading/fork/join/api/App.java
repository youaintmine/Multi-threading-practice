package com.youaintmine.multithreading.fork.join.api;

import java.util.concurrent.ForkJoinPool;

public class App {
    public static void main(String[] args) {
//
        System.out.println(Runtime.getRuntime().availableProcessors());
//
//        ForkJoinPool pool = new ForkJoinPool();
//        SimpleRecursiveAction action = new SimpleRecursiveAction(800);
//        action.invoke(); //Perform and wait for the task also it can rerturn a given value

        //RecursiveTask
//        ForkJoinPool pool = new ForkJoinPool();
//        SimpleRecursiveTask task = new SimpleRecursiveTask(200);
//        System.out.println(pool.invoke(task));

        //Simple Fibonacci
        ForkJoinPool pool = new ForkJoinPool();
        System.out.println(pool.invoke(new SampleFibonacci(30)));

        //Simple max finding algorithm
        System.out.println("Parallel Max Task");

    }
}
