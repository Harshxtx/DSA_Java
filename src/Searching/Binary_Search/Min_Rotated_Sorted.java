package Searching.Binary_Search;

import java.util.*;

public class Min_Rotated_Sorted {
    int findMin(int[] nums) {
        int l=0,r=nums.length-1;
        while(l<r)
        {
            int m=(l+r)/2;
            if(nums[m]<=nums[r])
                r=m;
            else
                l=m+1;
        }
        return l;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Min_Rotated_Sorted ob = new Min_Rotated_Sorted();
        int arr[]={4,5,6,7,0,1,2};
        int idx=ob.findMin(arr);
        System.out.println("The index of min element is: "+idx+" and the element is: "+arr[idx]);
    }
}
