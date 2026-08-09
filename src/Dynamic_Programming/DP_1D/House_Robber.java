package Dynamic_Programming.DP_1D;

import java.util.*;

public class House_Robber {
    // 1. Recursive
//    int solve(int i,int nums[]){
//        if(i<0) return 0;
//        if(i==0) return nums[0];
//        int skip=solve(i-1,nums);
//        int rob=nums[i]+solve(i-2,nums);
//        return Math.max(skip,rob);
//    }
//    public int rob(int[] nums) {
//        return solve(nums.length-1,nums);
//    }

    // 2. Memoization
//    int solve(int i,int nums[],int dp[]){
//        if(i<0) return 0;
//        if(i==0) return nums[0];
//        if(dp[i]!=-1) return dp[i];
//        int skip=solve(i-1,nums,dp);
//        int rob=nums[i]+solve(i-2,nums,dp);
//        return dp[i]=Math.max(skip,rob);
//    }
//    public int rob(int[] nums) {
//        int n=nums.length;
//        int dp[]=new int[n];
//        Arrays.fill(dp,-1);
//        return solve(nums.length-1,nums,dp);
//    }

    // 3. Tabulation
//    int rob(int[] nums) {
//        if(nums.length==0)
//            return 0;
//        if(nums.length==1)
//            return nums[0];
//        int n=nums.length;
//        int dp[]=new int[n];
//        dp[0]=nums[0];
//        dp[1]=Math.max(nums[1],nums[0]);
//        for(int i=2;i<n;i++){
//            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
//        }
//        return dp[n-1];
//    }

    // 4.Space Optimization
    int rob(int[] nums) {
        if(nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
        int n=nums.length;
        int prev2=nums[0];
        int prev1=Math.max(nums[1],nums[0]);
        for(int i=2;i<n;i++){
            int curr=Math.max(prev1,prev2+nums[i]);
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        House_Robber ob = new House_Robber();
        int arr[]={4,2,3,4};
        int rob=ob.rob(arr);
        System.out.println("The max amt of money robbed: "+rob);
    }
}
