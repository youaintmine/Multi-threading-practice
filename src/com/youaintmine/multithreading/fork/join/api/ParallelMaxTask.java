package com.youaintmine.multithreading.fork.join.api;

import javax.print.attribute.standard.Finishings;
import java.util.concurrent.RecursiveTask;

public class ParallelMaxTask extends RecursiveTask<Long> {
    private long[] nums;
    private int lowIndex;
    private int highIndex;

    public ParallelMaxTask(long[] nums, int lowIndex, int highIndex) {
       this.nums = nums;
       this.lowIndex = lowIndex;
       this.highIndex = highIndex;
    }

    @Override
    protected Long compute() {
        //if the array is small - use sequential maximum
        if(highIndex - lowIndex < 1000) {
            return sequentialMaxFinding();
        }else {
            //use parallelisation note that the Fork-Join will handle all the Divide and Conquer
            int middleIndex = (highIndex + lowIndex)/2;

            ParallelMaxTask t1 = new ParallelMaxTask(nums, lowIndex, middleIndex);
            ParallelMaxTask t2 = new ParallelMaxTask(nums, middleIndex+1, highIndex);

            //this is the task in parallel manner invocation
            invokeAll(t1, t2);
            return Math.max(t1.join(), t2.join());
        }
    }

    private Long sequentialMaxFinding() {
        long max = nums[lowIndex];

        for (int i = lowIndex; i <highIndex ; i++) {
            if(nums[i] > max)
                max = nums[i];
        }
        return max;
    }
}
