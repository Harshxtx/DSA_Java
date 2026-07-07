package Searching.Binary_Search;

import java.util.*;

public class Rotated_Sorted {
    int search(int[] nums, int target) {
        int l=0,r=nums.length-1;
        while(l<=r)
        {
            int m=(l+r)/2;
            if(nums[m]==target)
                return m;
            else if (nums[l]<=nums[m])
            {
                if(nums[l]<=target && target<=nums[m])
                    r=m-1;
                else
                    l=m+1;
            }
            else
            {
                if(nums[m]<=target && target<=nums[r])
                    l=m+1;
                else
                    r=m-1;
            }
        }
        return -1;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Rotated_Sorted ob = new Rotated_Sorted();
        int arr[]={4,5,6,7,0,1,2};
        int target=0;
        int idx=ob.search(arr,target);
        System.out.println("The index of "+target+" is: "+idx);
    }
}
