package com.youaintmine.multithreading.fork.join.api;

import java.util.concurrent.RecursiveAction;

public class SimpleRecursiveAction extends RecursiveAction {

    private int simulatedWork;

    public SimpleRecursiveAction(int simulatedWork) {
        this.simulatedWork = simulatedWork;
    }

    @Override
    protected void compute() {
        //if the task is too large, then split and execute parallel, else sequentially

        if(simulatedWork > 100) {
            System.out.println("Parallel execution and split the tasks... " + simulatedWork);
            SimpleRecursiveAction action1 = new SimpleRecursiveAction(simulatedWork/2);
            SimpleRecursiveAction action2 = new SimpleRecursiveAction(simulatedWork/2);

            action1.fork(); //It means that above SimpleRecursiveAction can be executed can be executed with
                            //half of the threads present in the fork-join pool
            action2.fork();

//            action1.join();
//            action2.join();
            invokeAll(action1, action2); //Wait for these actions to be completed

        }else {
            System.out.println("Sequential Execution is fine ... ");
            System.out.println("The size of the task : " + simulatedWork);
        }
    }
}
