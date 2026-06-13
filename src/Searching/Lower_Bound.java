package Searching;

import java.util.*;

public class Lower_Bound {
    int lowerBound(int arr[], int target) {
        int low = 0, high = arr.length - 1;
        int ans = arr.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= target) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return ans;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Lower_Bound ob = new Lower_Bound();
        int arr[]={1, 2, 2, 2, 4, 5, 7, 9};        //Array must be sorted
        int target=2;                              //else, use Arrays.sort(arr);
        int f=ob.lowerBound(arr,target);
        System.out.println("Lower bound of the Element at index: "+ f);
    }
}
