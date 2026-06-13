package Searching;

import java.util.*;

public class Insert_Pos {
    int searchInsert(int arr[], int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return low;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Insert_Pos ob = new Insert_Pos();
        int arr[]={2,5,6,8,9,10,12,17,19,22};          //Array must be sorted
        int ins=15;                              //else, use Arrays.sort(arr);
        int f=ob.searchInsert(arr,ins);
        System.out.println("Element can be insert at index: "+ f);
    }
}
