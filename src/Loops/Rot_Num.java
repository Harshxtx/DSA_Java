package Loops;

import java.util.*;
public class Rot_Num {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num=12345;
        int n = num, i = 1, k=3;
        int d=(int)Math.log10(num)+1;
        System.out.println("Enter the times to be rotated.");
        //k = in.nextInt();
        k=k%d;
        while (i<=k) {
            int r = n % 10;
            n=(r*(int)Math.pow(10,d))+n;
            n/=10;
            i++;
        }
        System.out.println("Number= " + num + " \nRotated number= " + n);
    }
}
