package com.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PrintFile {
    public static void main(String[] args) {
        try(BufferedReader in=new BufferedReader(new FileReader("C:/Program Files/Java/jdk1.8.0_71/COPYRIGHT"))){
            String line=in.readLine();
            while(line!=null){
                System.out.println(line);
                line=in.readLine();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
