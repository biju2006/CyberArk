package com.io;

import java.io.*;

public class PrimitivesIn {

    public static void main(String[] args) {
        try(DataInputStream in=new DataInputStream(
                new BufferedInputStream(
                new FileInputStream("c:/tmp/aaa.dat")))){
            System.out.println(in.readInt());
            System.out.println(in.readBoolean());

            System.out.println(in.readFloat());
            System.out.println(in.readUTF());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
