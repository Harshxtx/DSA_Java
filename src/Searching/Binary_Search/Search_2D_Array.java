package Searching.Binary_Search;

import java.util.*;

public class Search_2D_Array {
    boolean searchMatrix(int[][] arr, int t) {
        int l1 = arr.length, l2 = arr[0].length;
        int l = 0, u = (l1 * l2) - 1;
        while (l <= u) {
            int m = l + (u - l) / 2;
            int i = m / l2;
            int j = m % l2;
            if (arr[i][j] == t)
                return true;
            else if (arr[i][j] > t)
                u = m - 1;
            else
                l = m + 1;
        }
        return false;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Search_2D_Array ob = new Search_2D_Array();
        int arr[][]={{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target=20;
        String res=ob.searchMatrix(arr,target)?"is Present":"not Present";
        System.out.println(target+" "+res);
    }
}
