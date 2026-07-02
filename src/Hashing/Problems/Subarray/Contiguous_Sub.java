package Hashing.Problems.Subarray;

import java.util.*;

public class Contiguous_Sub {
    int findMaxLength(int[] nums) {
        int i,l=nums.length;
        int sum=0,max=0;
        HashMap<Integer, Integer> map=new HashMap<>();
        map.put(0,-1);                 //(sum, idx)       //-1 when finding length
        for(i=0;i<l;i++){
            if(nums[i]==0)
                sum-=1;
            else
                sum+=1;
            if(map.containsKey(sum)){
                int len=i-map.get(sum);
                max=Math.max(max,len);
            }
            else
                map.put(sum,i);
        }
        return max;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Contiguous_Sub ob = new Contiguous_Sub();
        int arr[]={0,1,1,1,1,1,0,0,0};
        int res=ob.findMaxLength(arr);
        System.out.println("The largest length of a contiguous subarray with equal of 0 and 1: "+res);
    }
}
