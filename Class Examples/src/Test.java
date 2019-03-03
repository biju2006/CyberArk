import com.com.nice.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test{


    public static void main(String[] args) {
        System.out.println(args[0]);
        Stam<Integer> s1=new Stam<>(5);
        s1.print();
        Stam<String> s2=new Stam<>("Hello");
        s2.print();
        Stam<Date> s3=new Stam<>(new Date());
        s3.print();
        s3.printSub(new java.sql.Date(7862387));

    }
}
