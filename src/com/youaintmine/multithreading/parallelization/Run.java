package com.youaintmine.multithreading.parallelization;

import com.sun.source.tree.NewArrayTree;

import java.util.Arrays;
import java.util.Random;

public class Run {

    public static void main(String[] args) {
        int numThreads = Runtime.getRuntime().availableProcessors();
        System.out.println(numThreads);

        Integer[] n1 = createArr(1000000);
        Integer[] n2 = Arrays.copyOf(n1, n1.length);

        //Parallel MergeSort
        ParallelMergeSort parallelMergeSort = new ParallelMergeSort(n1);

        Long startTime1 = System.currentTimeMillis();
        parallelMergeSort.parallelMergeSort(0, n1.length-1, numThreads);
        Long endTime1 = System.currentTimeMillis();
        System.out.println("Time for Parallel Sorting is : " +(endTime1 - startTime1));

        MergeSort mergeSort = new MergeSort(n2);

        Long startTime2 = System.currentTimeMillis();
        mergeSort.sort();
        Long endTime2 = System.currentTimeMillis();
        System.out.println("Time for sequential mergeSort is : "+(endTime2-startTime2));

    }

    private static Integer[] createArr(int n) {
        Random random = new Random();
        Integer a[] = new Integer[n];

        for (int i =0; i<n; i++)
            a[i] = random.nextInt(n);

        return a;
    }
}
