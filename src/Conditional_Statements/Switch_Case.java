package Conditional_Statements;

import java.util.*;
public class Switch_Case {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);

        System.out.print("Enter first number: ");
        double num1 = in.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = in.nextDouble();

        System.out.println("\nChoose an operation:");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");

        System.out.print("Enter your choice (1-4): ");
        int op = in.nextInt();
        switch (op) {
            case 1:
                System.out.println("Result= "+(num1+num2));
                break;
            case 2:
                System.out.println("Result= "+(num1-num2));
                break;
            case 3:
                System.out.println("Result= "+(num1*num2));
                break;
            case 4:
                System.out.println("Result= "+(num1/num2));
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }
}
