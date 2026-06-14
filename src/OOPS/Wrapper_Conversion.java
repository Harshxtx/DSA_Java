package OOPS;

import java.util.*;

public class Wrapper_Conversion {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int n1=100;
        Integer num1 = n1;      // Autoboxing

        Integer num2=200;
        int n2 = num2;          // Unboxing     //num2.intValue(); //automatic

        System.out.println("Autoboxing: " + num1);
        System.out.println("Unboxing: " + n2);

        //valueOf(): give Object
        Integer intObj = Integer.valueOf("123");
        Double doubleObj = Double.valueOf("45.67");
        Boolean boolObj = Boolean.valueOf("true");

        System.out.println("\nInteger.valueOf(): " + intObj);
        System.out.println("Double.valueOf(): " + doubleObj);
        System.out.println("Boolean.valueOf(): " + boolObj);

        //parseXXX(): give primitive datatype value
        int intValue = Integer.parseInt("456");
        double doubleValue = Double.parseDouble("78.9");
        boolean boolValue = Boolean.parseBoolean("true");

        System.out.println("\nInteger.parseInt(): " + intValue);
        System.out.println("Double.parseDouble(): " + doubleValue);
        System.out.println("Boolean.parseBoolean(): " + boolValue);

        try {
            int x = Integer.parseInt("abc");
        }
        catch (NumberFormatException e) {
            System.out.println("Invalid Number: "+e);
        }

        //Base Conversion
        int n = 42;
        System.out.println("\nBinary: " + Integer.toBinaryString(n));
        System.out.println("Octal: " + Integer.toOctalString(n));
        System.out.println("Hexadecimal: " + Integer.toHexString(n));

    }
}
