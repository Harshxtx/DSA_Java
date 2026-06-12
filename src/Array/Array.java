package Array;

import  java.util.*;
public class Array {
    static void swap(int arr[],int i, int j){
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int[] numbers = {10, 20, 30, 40, 50};  //int arr[]=new int[5];

//        System.out.println("Input array elements:");
//        for (int i = 0; i < numbers.length; i++) {
//            numebrs[i]=in.nextInt();

        System.out.println("First Element: "+numbers[0]); //takes O(1) time

        System.out.println("Array elements:");          //takes O(n) time
        for (int i = 0; i < numbers.length; i++) {
            if(i>0)
                System.out.print(", ");
            System.out.print(numbers[i]);
        }
        System.out.println();

        int sum = 0;
        for (int i = 0; i < numbers.length; i++)
            sum += numbers[i];

        System.out.println("Sum = " + sum);

        int arr[]=numbers;
        arr[3]=70;
        System.out.println("Number after update: ");
        for (int i = 0; i < numbers.length; i++) {
            if(i>0)
                System.out.print(", ");
            System.out.print(numbers[i]);
        }
        System.out.println();

        swap(numbers,3,4);
        System.out.println("Number after Swap: ");
        for (int i = 0; i < numbers.length; i++) {
            if(i>0)
                System.out.print(", ");
            System.out.print(numbers[i]);
        }
        System.out.println();
    }
}
