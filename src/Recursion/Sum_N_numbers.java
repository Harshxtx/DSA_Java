package Recursion;

import java.util.*;

public class Sum_N_numbers {
    int sum(int n){
        if(n<=1)
            return 1;
        return n+sum(n-1);
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Sum_N_numbers ob = new Sum_N_numbers();
        int n=10;
        int sum=ob.sum(n);
        System.out.println("Sum of first N natural number: "+ sum);
    }
}
