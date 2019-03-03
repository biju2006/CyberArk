package com.threads.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test {
    public static void main(String[] args) {
        Stack s=new Stack();

        List<Callable<Integer>> tasks=new ArrayList<>();
        tasks.add(new Consumer(s));
        tasks.add(new Consumer(s));
        tasks.add(new Consumer(s));
        tasks.add(new Consumer(s));
        tasks.add(new Consumer(s));
        tasks.add(new Producer(s));
        tasks.add(new Producer(s));
        tasks.add(new Producer(s));
        tasks.add(new Producer(s));
        tasks.add(new Producer(s));

        ExecutorService exe=Executors.newFixedThreadPool(6,new MyThreadFactory());
        try {
            List<Future<Integer>> results=  exe.invokeAll(tasks);
            for(Future<Integer> result:results){
                try{
                    System.out.println("Completed: "+result.get());
                }catch (Exception e){
                    System.out.println(e.getCause().getMessage());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
