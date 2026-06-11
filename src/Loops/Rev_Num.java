package Loops;

import java.util.*;
public class Rev_Num {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num;
        System.out.println("Enter the no.");
        num = in.nextInt();
        int n = num, rnum = 0;
        while (n != 0) {
            rnum = rnum * 10 + (n % 10);
            n /= 10;
        }
        System.out.println("Number= " + num + " \nReverse number= " + rnum);
    }
}
