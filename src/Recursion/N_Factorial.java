package Recursion;

import java.util.*;

public class N_Factorial {
    int factorial(int n){
        if(n==0)
            return 1;
        return n*factorial(n-1);
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        N_Factorial ob = new N_Factorial();
        int n=6;
        int fact=ob.factorial(n);
        System.out.println("Factorial of "+n+" is : "+ fact);
    }
}
