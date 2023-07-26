package com.youaintmine.multithreading.parallelization;

public class ParallelSum {
    private SumProblem[] workers;
    private int nThreads;

    public ParallelSum(int nThreads) {
        this.nThreads = nThreads;
        this.workers = new SumProblem[nThreads];
    }

    public int sum(int[] nums) {
        int size = (int) Math.ceil(nums.length*1.0 / nThreads);

        for (int i = 0; i < nThreads; i++) {
            workers[i] = new SumProblem(nums, i*size, (i+1)*size);
            workers[i].start();
        }

        try {
            for(SumProblem w: this.workers)
                w.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        int total = 0;

        for(SumProblem w : workers)
            total += w.getPartialSum();
    }
}
