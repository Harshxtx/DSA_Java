package Recursion;

import java.util.*;

public class Print_N_to_1 {
    void display(int n){
        if(n>0){
            System.out.print(n+" ");
            display(n-1);
        }
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Print_N_to_1 ob = new Print_N_to_1();
        int n=10;
        ob.display(n);
    }
}
