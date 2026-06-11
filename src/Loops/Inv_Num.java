package Loops;

import java.util.*;
public class Inv_Num {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num=32145;
        System.out.println("Enter the no.");
        //num = in.nextInt();
        int n = num, inv = 0, k = 1;
        while (n != 0) {
            int r = n % 10;
            inv = inv + k * (int) Math.pow(10, r-1);
            k++;
            n/=10;
        }
        System.out.println("Number= " + num + " \nInverse number= " + inv);
    }
}
