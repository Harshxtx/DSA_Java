package Hashing.Problems.Subarray;

import java.util.*;

public class Sub_Sum_K_Count {
    int subarraySum(int[] nums, int k) {
        int i,l=nums.length;
        int sum=0,ans=0;
        HashMap<Integer, Integer> map=new HashMap<>();
        map.put(0,1);                       //(sum,count)        //1 while counting
        for(i=0;i<l;i++){
            sum+=nums[i];
            if(map.containsKey(sum-k)){
                ans+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Sub_Sum_K_Count ob = new Sub_Sum_K_Count();
        int arr[]={1,2,3};
        int k=3;
        int res=ob.subarraySum(arr,k);
        System.out.println("The total no. of subarray with sum "+k+" : "+res);
    }
}
