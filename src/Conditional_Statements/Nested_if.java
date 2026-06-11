package Conditional_Statements;

import java.util.*;
public class Nested_if {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        System.out.print("Enter your age: 20");
        int age=20;
        //age=in.nextInt();
        System.out.println();
        if (age>=18) {
            System.out.print("Do you have a learner's license? (T/F): ");
            char ch = in.next().charAt(0);

            if (ch=='T' || ch=='t') {
                System.out.println("You are eligible to apply for a driving license.");
            } else {
                System.out.println("You need a learner's license first.");
            }
        }
        else {
            System.out.println("You are not eligible because you are under 18.");
        }
    }
}
