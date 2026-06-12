package Array;

import  java.util.*;
public class Rev_Array {
    void rev_array(int arr[]){
        int l=0,u=arr.length-1;
        while(l<u){
            int t= arr[l];
            arr[l]=arr[u];
            arr[u]=t;
            l++;
            u--;
        }
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int[] arr = {10, 20, 30, 40, 50};  //int arr[]=new int[5];

//        System.out.println("Input array elements:");
//        for (int i = 0; i < numbers.length; i++) {
//            arr[i]=in.nextInt();

        System.out.println("Array elements:");
        for (int i = 0; i < arr.length; i++) {
            if(i>0)
                System.out.print(", ");
            System.out.print(arr[i]);
        }
        System.out.println();

        Rev_Array ob=new Rev_Array();
        ob.rev_array(arr);
        System.out.println("Array after Reverse: ");
        for (int i = 0; i < arr.length; i++) {
            if(i>0)
                System.out.print(", ");
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}
