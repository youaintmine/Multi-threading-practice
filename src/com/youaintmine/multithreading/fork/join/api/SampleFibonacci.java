package com.youaintmine.multithreading.fork.join.api;

import java.util.concurrent.RecursiveTask;

public class SampleFibonacci extends RecursiveTask<Double> {

    double n;

    public SampleFibonacci(double n){
        this.n = n;
    }


    @Override
    protected Double compute() {
        if(n<=1)
            return n;

        SampleFibonacci f1 = new SampleFibonacci(n-1);
        SampleFibonacci f2 = new SampleFibonacci(n-2);

        f1.fork();
        f2.fork();

        Double nthFib;
        nthFib = f1.join() + f2.join();

        return nthFib;
    }
}
