package Array;

import java.util.Scanner;

public class Max_Subarray {
    int Kadans(int arr[]){
        int i,l=arr.length,max=Integer.MIN_VALUE,sum=0;
        for(i=0;i<l;i++)
        {
            sum+=arr[i];
            if(sum>max)
                max=sum;
            if(sum<0)
                sum=0;
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
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

        Max_Subarray ob=new Max_Subarray();
        int sum=ob.Kadans(arr);
        System.out.println("Maximum Sum: "+sum);
    }
}
