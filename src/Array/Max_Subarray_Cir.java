package Array;

import java.util.*;
public class Max_Subarray_Cir {
    int KadansCir(int arr[]){
        int i,l=arr.length;
        int totalSum = 0;
        int currMaxSum = 0, currMinSum = 0;
        int maxSum = arr[0], minSum = arr[0];
        for(i=0;i<l;i++)
        {
            currMaxSum = Math.max(currMaxSum + arr[i], arr[i]);
            maxSum = Math.max(maxSum, currMaxSum);

            currMinSum = Math.min(currMinSum + arr[i], arr[i]);
            minSum = Math.min(minSum, currMinSum);

            totalSum += arr[i];
        }
        int normalSum = maxSum;
        int circularSum = totalSum - minSum;

        if(minSum == totalSum)
            return normalSum;

        return Math.max(normalSum, circularSum);
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Max_Subarray_Cir ob = new Max_Subarray_Cir();
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

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

        int sum=ob.KadansCir(arr);
        System.out.println("Maximum Sum in a Circular Array: "+sum);
    }
}
