package Recursion;

import java.util.*;

public class Print_1_to_N {
    void display(int n){
        if(n>0){
            display(n-1);
            System.out.print(n+" ");
        }
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Print_1_to_N ob = new Print_1_to_N();
        int n=10;
        ob.display(n);
    }
}
