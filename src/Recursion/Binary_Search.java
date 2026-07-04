package Recursion;

import java.util.*;

public class Binary_Search {
    boolean bin_search(int arr[],int target,int l,int u){
        if(l<=u){
            int mid=l+(u-l)/2;
            if(target==arr[mid])
                return true;
            else if(target>arr[mid])
                return bin_search(arr,target,mid+1,u);
            else
                return bin_search(arr,target,l,mid-1);
        }
        return false;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Binary_Search ob = new Binary_Search();
        int arr[]={1,2,3,4,5,6,7,8,9,10};
        int target=8;
        if(ob.bin_search(arr,target,0,arr.length-1))
            System.out.println("Element found");
        else
            System.out.println("Not found");

    }
}
