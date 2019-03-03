package com;

public class StaticEx {

    static{
        System.out.println("Loaded...");
    }

    public StaticEx(){
        System.out.println("Created...");
    }

    public static void main(String[] args) {
        StaticEx e1=new StaticEx();
        StaticEx e2=new StaticEx();
        e1=null;
        e2=null;
        System.gc();
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("done....");
    }
}
