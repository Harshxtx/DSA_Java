package Hashing.Problems.Subarray;

import java.util.*;

public class Sub_Sum_K_Len {
    int subarraySum(int[] nums, int k) {
        int i,l=nums.length;
        int sum=0,max=0;
        HashMap<Integer, Integer> map=new HashMap<>();
        map.put(0,-1);                       //(sum,idx)        //-1 while finding length
        for(i=0;i<l;i++){
            sum+=nums[i];
            if(map.containsKey(sum-k)){
                int len=i-map.get(sum-k);
                max=Math.max(max,len);
            }
            if(!map.containsKey(sum))
                map.put(sum,i);
        }
        return max;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Sub_Sum_K_Len ob = new Sub_Sum_K_Len();
        int arr[]={1,2,1,2,2,1,1,1,1,1,3};
        int k=4;
        int res=ob.subarraySum(arr,k);
        System.out.println("The largest length of subarray with sum "+k+" : "+res);
    }
}
