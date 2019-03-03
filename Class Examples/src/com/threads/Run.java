package com.threads;

public class Run {
    public static void main(String[] args) {
        MyRunnable r=new MyRunnable();
        Thread t1=new Thread(r);
        t1.setDaemon(true);
        t1.start();
        try{t1.join();}catch(Exception ex){ex.printStackTrace();}
        for(int i=0;i<1000;i++){
            System.out.print("*");
        }
        System.out.println("Done!");
    }
}
