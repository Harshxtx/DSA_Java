package Conditional_Statements;

import java.util.*;
public class if_else_if_else {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int marks=92;
        //marks=in.nextInt();
        if (marks >= 90) {
            System.out.println("Grade: A");
        } else if (marks >= 75) {
            System.out.println("Grade: B");
        } else if (marks >= 50) {
            System.out.println("Grade: C");
        } else {
            System.out.println("Grade: Fail");
        }
    }
}
