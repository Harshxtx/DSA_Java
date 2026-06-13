package Searching;

import java.util.*;

public class Binary {
    int BinarySearch(int arr[], int key) {                  //Time Complexity: O(log n)
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == key)
                return mid;
            else if (arr[mid] < key)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Binary ob = new Binary();
        int arr[]={1,2,3,4,5,6,7,8,9};          //Array must be sorted
        int key=8;                              //else, use Arrays.sort(arr);
        int f=ob.BinarySearch(arr,key);
        if(f==-1)
            System.out.println("Element not found");
        else
            System.out.println("Element found at index: "+ f);
    }
}
