package com.youaintmine.multithreading.fork.join.api;

import java.util.concurrent.RecursiveTask;

public class SimpleRecursiveTask extends RecursiveTask<Integer> {
    private int num;
    public SimpleRecursiveTask(int num) {
        this.num = num;
    }

    @Override
    protected Integer compute() {
        if(num>100){
            //Parallelization is set in
            System.out.println("Parallel execution is splitting the task... " + num);

            SimpleRecursiveTask t1 = new SimpleRecursiveTask(num/2);
            SimpleRecursiveTask t2 = new SimpleRecursiveTask(num/2);

            t1.fork();
            t2.fork();

            //wait or these tasks to be fin
            int subSol = 0;
            subSol += t1.join();
            subSol += t2.join();

            return subSol;
        }else {
            //the problem is too small
            System.out.println("The problem is too small, so tread sequentially... "+num);

            return 2*num;
        }
    }
}
