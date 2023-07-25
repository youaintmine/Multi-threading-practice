package com.youaintmine.multithreading.studentlibrary;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StudentLibrary {

    public static void main(String[] args) {
        System.out.println("Student Library Simulation");

        Student[] students = null;
        Book[] books = null;
        ExecutorService executorService = Executors.newFixedThreadPool(Constants.NUM_STUDENTS);

        try {
            books = new Book[Constants.NUM_BOOKS];
            students = new Student[Constants.NUM_STUDENTS];

            for(int i =0; i<Constants.NUM_BOOKS; i++)
                books[i] = new Book(i+1);

            for (int i =0; i<Constants.NUM_STUDENTS; i++){
                students[i] = new Student(i+1, books);
                executorService.execute(students[i]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}
