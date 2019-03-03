package com.threads;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        int i=0;
        while(i<100){
            System.out.println(i++);
            try{Thread.sleep(20);}catch(Exception e){}
        }
    }
}
