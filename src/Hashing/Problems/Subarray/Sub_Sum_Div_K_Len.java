package Hashing.Problems.Subarray;

import java.util.*;

public class Sub_Sum_Div_K_Len {
    int longestSubarrayDivK(int[] nums, int k) {
        int i, l = nums.length;
        long sum = 0;
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (i = 0; i < l; i++) {
            sum += nums[i];
            int rem = (int)((sum % k + k) % k);
            if(map.containsKey(rem)){
                int len=i-map.get(rem);
                max=Math.max(max,len);
            }
            if(!map.containsKey(rem))
                map.put(rem,i);
        }
        return max;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Sub_Sum_Div_K_Len ob = new Sub_Sum_Div_K_Len();
        int arr[]={2, 7, 6, 1, 4, 5};
        int k=3;
        int res=ob.longestSubarrayDivK(arr,k);
        System.out.println("The longest subarray with sum divisible by "+k+" : "+res);
    }
}
