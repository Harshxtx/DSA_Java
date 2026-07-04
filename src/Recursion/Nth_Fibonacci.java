package Recursion;

import java.util.*;

public class Nth_Fibonacci {
    int fib(int n){
        if(n<=1)
        return n;
        return fib(n-1)+fib(n-2);
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Nth_Fibonacci ob = new Nth_Fibonacci();
        int n=5;
        int res=ob.fib(n);
        System.out.println("The nth term of fibonacci :"+ res);
    }
}
