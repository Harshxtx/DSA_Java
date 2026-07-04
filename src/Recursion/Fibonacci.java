package Recursion;

import java.util.*;

public class Fibonacci {
    void fib(int n,int f1,int f2){
        if(n>0){
            System.out.print(f1+" ");
            fib(n-1,f2,f1+f2);
        }
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Fibonacci ob = new Fibonacci();
        int n=10;
        System.out.println("The Fibonacci series :");
        ob.fib(n,0,1);
    }
}
