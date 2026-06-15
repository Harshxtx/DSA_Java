package OOPS.Wrapper_Class;

import java.util.*;

public class Other_Wrappers {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        //bitCount(): count the no. of one's in its binary form
        System.out.println("\nInteger.bitCount(13): "+Integer.bitCount(13));           //13 -> 1101 //ans:3

        //Returns the highest power of 2 present in the number
        System.out.println("Integer.highestOneBit(13): " +Integer.highestOneBit(13));  //13 -> 1101   //ans:8

        //Returns the lowest set bit
        System.out.println("Integer.lowestOneBit(12): " +Integer.lowestOneBit(12));    //12 ->1100    //ans: 4

        //Counts zeros before the first 1 in 32-bit
        System.out.println("Integer.numberOfLeadingZeros(8): "+Integer.numberOfLeadingZeros(8));//ans:28

        //Counts zeros after the last 1
        System.out.println("Integer.numberOfTrailingZeros(12): " +Integer.numberOfTrailingZeros(12));//12->1100  //ans:2

        //Reverses all 32 bits
        System.out.println("Reverse of '5' in binary:"+Integer.reverse(5));
        //Returns the sign of a number
        System.out.println("Integer.signum(-10): " +Integer.signum(-10));   //-1
        System.out.println("Integer.signum(0): "+Integer.signum(0));        //0
        System.out.println("Integer.signum(10): "+Integer.signum(10));      //1

        //return sum
        System.out.println("Integer.sum(10, 20): "+Integer.sum(10, 20));    //30

        //Returns max
        System.out.println("Integer.max(10, 20): "+Integer.max(10, 20));     //20

        //Returns max
        System.out.println("Integer.min(10, 20): " +Integer.min(10, 20));    //10

        // decode(): Parses decimal, octal, and hexadecimal strings
        System.out.println("\nInteger.decode(\"123\"): " +Integer.decode("123"));
        System.out.println("Integer.decode(\"0123\"): "+Integer.decode("0123"));
        System.out.println("Integer.decode(\"0x7B\"): "+ Integer.decode("0x7B"));

    }
}
