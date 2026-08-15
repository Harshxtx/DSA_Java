package Dynamic_Programming.Subsequence_DP;

import java.util.*;

public class Target_Sum {
    int solve(int idx,int arr[],int target,int dp[][]){
        if(idx==0){
            if(target==0 && arr[0]==0) return 2;
            if(target==0 || arr[0]==target) return 1;
            return 0;
        }
        if(dp[idx][target]!=-1) return dp[idx][target];

        int take=0;
        if(arr[idx]<=target)
            take=solve(idx-1,arr,target-arr[idx],dp);
        int notTake=solve(idx-1,arr,target,dp);

        return dp[idx][target]=take+notTake;
    }
    int numSubset(int[] nums, int target) {
        int n=nums.length;
        int dp[][]=new int[n][target+1];
        for(int a[]:dp){
            Arrays.fill(a,-1);
        }
        return solve(n-1,nums,target,dp);
    }
    public int findTargetSumWays(int[] nums, int target) {
        int tsum=0;
        for(int n:nums){
            tsum+=n;
        }
        if(tsum-target<0 || (tsum-target)%2!=0) return 0;
        int s2=(tsum-target)/2;
        int count=numSubset(nums,s2);
        return count;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Target_Sum ob = new Target_Sum();
        int arr[]={1,1,1,1,1};
        int target=3;
        int res=ob.findTargetSumWays(arr,target);
        System.out.println("No. of way to get the target sum:"+res);
    }
}
