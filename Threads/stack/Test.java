package com.threads.stack;

public class Test {
    public static void main(String[] args) {
        Stack s=new Stack();
        new Thread(new Consumer(s)).start();
        new Thread(new Consumer(s)).start();
        new Thread(new Consumer(s)).start();
        new Thread(new Consumer(s)).start();
        new Thread(new Consumer(s)).start();
        new Thread(new Producer(s)).start();
        new Thread(new Producer(s)).start();
        new Thread(new Producer(s)).start();
        new Thread(new Producer(s)).start();
        new Thread(new Producer(s)).start();


    }
}
