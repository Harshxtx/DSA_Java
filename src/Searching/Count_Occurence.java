package Searching;

import java.util.*;

public class Count_Occurence {
    int firstOccurrence(int arr[], int target) {
        int low = 0, high = arr.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                ans = mid;
                high = mid - 1;
            }
            else if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return ans;
    }
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
    int CountOccurence(int arr[], int target) {
        int first = firstOccurrence(arr, target);

        if (first == -1)
            return 0;

        int last = lastOccurrence(arr, target);

        return last - first + 1;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Count_Occurence ob = new Count_Occurence();
        int arr[]={1,2,4,6,7,7,7,8,8,9};                //Array must be sorted
        int target=7;                              //else, use Arrays.sort(arr);
        int f=ob.CountOccurence(arr,target);
        if(f==-1)
            System.out.println("Element not found");
        else
            System.out.println("Element occurs "+ f+" times");
    }
}
