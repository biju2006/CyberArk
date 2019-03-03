package com.threads.stack;

public class Producer implements Runnable {
    private Stack stack;

    public Producer(Stack stack) {
        this.stack = stack;
    }

    @Override
    public void run() {
        for(int i=0;i<20;i++){
            stack.push((int)(Math.random()*100));
            try{Thread.sleep(50);}catch(Exception e){}
        }
    }
}
