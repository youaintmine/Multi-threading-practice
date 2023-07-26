package com.youaintmine.multithreading.parallelization;

public class SumProblem extends Thread{

    private int[] nums;
    private int low;
    private int high;

    private int partialSum;
    public SumProblem(int[] num, int low, int high){
        this.nums = num;
        this.low = low;
        this.high = high;
    }

    @Override
    public void run() {
        partialSum = 0;

        for (int i = low; i <high ; i++) {
            partialSum += nums[i];
        }
    }

    public int getPartialSum() {
        return partialSum;
    }
}
