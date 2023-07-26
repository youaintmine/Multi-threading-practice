package com.youaintmine.multithreading.parallelization;

import com.sun.source.tree.NewArrayTree;

import java.util.Arrays;
import java.util.Random;

public class Run {

    public static void main(String[] args) {

    }

    private static Integer[] createArr(int n) {
        Random random = new Random();
        Integer a[] = new Integer[n];

        for (int i =0; i<n; i++)
            a[i] = random.nextInt(n);

        return a;
    }
}
