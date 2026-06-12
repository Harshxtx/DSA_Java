package Array;

import  java.util.*;
public class Max_Min {
    int largest(int arr[]){
        int i,largest=arr[0];
        for(i=1;i<arr.length;i++)
            largest=Math.max(largest,arr[i]);
        return largest;
    }
    int sec_largest(int arr[]){
        int i,lar=Integer.MIN_VALUE,lar2=Integer.MIN_VALUE;
        for(i=0;i<arr.length;i++){
            if(arr[i] > lar) {
                lar2 = lar;
                lar = arr[i];
            }
            else if(arr[i] < lar && arr[i] > lar2) {
                lar2 = arr[i];
            }
        }
        return lar2;
    }
    int smallest(int arr[]){
        int i,smallest=arr[0];
        for(i=1;i<arr.length;i++)
            smallest=Math.min(smallest,arr[i]);
        return smallest;
        }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = {10, 20, 30, 40, 50};  //int arr[]=new int[5];

//        System.out.println("Input array elements:");
//        for (int i = 0; i < numbers.length; i++) {
//            arr[i]=in.nextInt();

        System.out.println("Array elements:");
        for (int i = 0; i < arr.length; i++) {
            if (i > 0)
                System.out.print(", ");
            System.out.print(arr[i]);
        }
        System.out.println();

        Max_Min ob = new Max_Min();
        int large = ob.largest(arr);
        int largest2 = ob.sec_largest(arr);
        int small = ob.smallest(arr);

        System.out.println("Largest Element: " + large);
        System.out.println("Second Largest Element: " + largest2);
        System.out.println("Smallest Element: " + small);
    }
}
