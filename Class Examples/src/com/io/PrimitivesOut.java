package com.io;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class PrimitivesOut {

    public static void main(String[] args) {
        try(DataOutputStream out=new DataOutputStream(
                new BufferedOutputStream(
                new FileOutputStream("c:/tmp/aaa.dat")))){
            out.writeInt(20);
            out.writeBoolean(true);
            out.writeUTF("Hello");
            out.writeFloat(5.5f);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
