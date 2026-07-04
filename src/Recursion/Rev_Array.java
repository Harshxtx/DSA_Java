package Recursion;

import java.util.*;

public class Rev_Array {
    void revArray(int arr[],int l,int r){
        if(l<r){
            int t=arr[l];
            arr[l]=arr[r];
            arr[r]=t;
            revArray(arr,l+1,r-1);
        }
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Rev_Array ob = new Rev_Array();
        int arr[]={1,2,3,4,5,6,7,8,9,10};
        int l=0,u=arr.length-1;
        ob.revArray(arr,l,u);
        System.out.println("Array after reverse: "+Arrays.toString(arr));
    }
}
