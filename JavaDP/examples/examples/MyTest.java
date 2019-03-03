package examples;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class MyTest {
 
    static void setFieldValue(Field field, Object newValue)
            throws IllegalAccessException, IllegalArgumentException, NoSuchFieldException {
        field.setAccessible(true);
 
        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
 
        field.set(null, newValue);
    }
 
    static {
        try {
            Class<?> ic = Class.forName("java.lang.Integer$IntegerCache");
            if (ic != null) {
                Field f = ic.getDeclaredField("cache");
                Integer ar[] = new Integer[1024];
                Arrays.fill(ar, 42);
                setFieldValue(f, ar);
            }
        } catch (Exception ex) {
        }
    }
 
    public static void main(String[] args) {
        Integer ada = 128;
        System.out.println("ada = " + ada);
        
        Integer a = 100;
        Integer b = 0;
        System.out.println(a+" "+b);
        Integer c=200;
        System.out.println(a==b); 
        System.out.println(a==c);
        System.out.println(a);
    }
}