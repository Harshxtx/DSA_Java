package Hashing.Problems;

import java.util.*;

public class Two_Sum {
    int[] twoSum(int nums[],int target){
        Map<Integer, Integer> map= new HashMap<>();
        int i,l=nums.length;
        for(i=0;i<l;i++)
        {
            if(map.containsKey(target-nums[i]))
                return new int[]{i,map.get(target-nums[i])};
            else
                map.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Two_Sum ob = new Two_Sum();
        int arr[]={2,7,11,15};
        int target=9;
        int res[]=ob.twoSum(arr,target);
        System.out.println("Indices of both the values are: "+Arrays.toString(res));
    }
}
