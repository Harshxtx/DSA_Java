package Searching;

import java.util.*;

public class Last_Occurenece {
    int lastOccurrence(int arr[], int target) {
        int low = 0, high = arr.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                ans = mid;
                low = mid + 1;
            }
            else if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return ans;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Last_Occurenece ob = new Last_Occurenece();
        int arr[]={1,2,4,6,7,7,8,9};                //Array must be sorted
        int target=7;                              //else, use Arrays.sort(arr);
        int f=ob.lastOccurrence(arr,target);
        if(f==-1)
            System.out.println("Element not found");
        else
            System.out.println("Element last occur at: "+ f);
    }
}
