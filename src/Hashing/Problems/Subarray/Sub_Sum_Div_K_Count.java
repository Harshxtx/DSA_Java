package Hashing.Problems.Subarray;

import java.util.*;

public class Sub_Sum_Div_K_Count {
    int subarraysDivByK(int[] nums, int k) {
        int i, l = nums.length;
        int sum = 0, count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (i = 0; i < l; i++) {
            sum += nums[i];
            int rem = (sum % k + k) % k;                //to handle -ve dividend
            if (map.containsKey(rem)) {
                count += map.get(rem);
            }
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        return count;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Sub_Sum_Div_K_Count ob = new Sub_Sum_Div_K_Count();
        int arr[]={4,5,0,-2,-3,1};
        int k=5;
        int res=ob.subarraysDivByK(arr,k);
        System.out.println("The total no. of subarray with sum divisible by "+k+" : "+res);
    }
}
