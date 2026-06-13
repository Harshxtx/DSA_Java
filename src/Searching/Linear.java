package Searching;

import java.util.*;

public class Linear {
    int linearSearch(int arr[], int target){                 //Time Complexity: O(n)
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Linear ob = new Linear();
        int arr[]={1,4,6,3,8,7,2,5};
        int key=7;
        int f=ob.linearSearch(arr,key);
        if(f==-1)
            System.out.println("Element not found");
        else
            System.out.println("Element found at index: "+ f);
    }
}
