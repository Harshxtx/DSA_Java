package Loops;

import java.util.*;
public class Fibonacci {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int i,f1=0,f2=1,n;
        System.out.println("Enter the no. sequence of fibonacci  series");
        n=in.nextInt();
        for(i=1;i<=n;i++){
            System.out.print(f1+", ");
            int f3=f1+f2;
            f1=f2;
            f2=f3;
        }
    }

}
