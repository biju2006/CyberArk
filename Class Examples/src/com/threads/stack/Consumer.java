package com.threads.stack;

import java.util.concurrent.Callable;

public class Consumer implements Callable<Integer> {
    private Stack stack;

    public Consumer(Stack stack) {
        this.stack = stack;
    }

    @Override
    public Integer call() throws NumberFormatException{
        int total = 0;
        for(int i=0;i<20;i++){
            total+=stack.pop();
            try{Thread.sleep(50);}catch(Exception e){}
        }
        if(total%2==0){
            return total;
        }else
            throw new NumberFormatException("not even!!! "+total);
    }
}
