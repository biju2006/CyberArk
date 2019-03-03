package com.threads.stack;

import java.util.concurrent.Callable;

public class Producer implements Callable<Integer> {
    private Stack stack;

    public Producer(Stack stack) {
        this.stack = stack;
    }

    @Override
    public Integer call() {
        int total=0;
        for(int i=0;i<20;i++){
            int rand=(int)(Math.random()*100);
            total+=rand;
            stack.push(rand);
            try{Thread.sleep(50);}catch(Exception e){}
        }
        if(total%2==0){
            return total;
        }else
            throw new NumberFormatException("not even!!! "+total);
    }
}
