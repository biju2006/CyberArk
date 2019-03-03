package com;

import java.util.Objects;

public class Demo {

    private int x;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Demo demo = (Demo) o;
        return x == demo.x;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x);
    }

    public static void main(String[] args) {
        System.out.println(new Object());

           outer:for(int i=1;i<1000;i++){
               if(i%7==0){
                   System.out.println("Boom");
                   continue;
               }
               int temp=i;
               while(temp>0){
                   int dig=temp%10;
                   if(dig==7){
                       System.out.println("Boom");
                       continue outer;
                   }
                   temp/=10;
               }
               System.out.println(i);
           }
    }
}
