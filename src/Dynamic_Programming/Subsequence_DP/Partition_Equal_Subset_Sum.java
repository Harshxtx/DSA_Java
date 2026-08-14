package Dynamic_Programming.Subsequence_DP;

import java.util.*;

public class Partition_Equal_Subset_Sum {
    // 1.Memoization
//    boolean solve(int idx,int arr[],int target,int dp[][]){
//        if(target==0) return true;
//        if(idx==0) return arr[0]==target;
//        if(dp[idx][target]!=-1) return dp[idx][target]==1;
//        boolean take=false;
//        if(arr[idx]<=target)
//            take=solve(idx-1,arr,target-arr[idx],dp);
//        boolean notTake=solve(idx-1,arr,target,dp);
//        dp[idx][target]=take||notTake?1:0;
//        return take||notTake;
//    }
//    public boolean canPartition(int[] nums) {
//        int n=nums.length;
//        int target=0;
//        for(int x:nums){
//            target+=x;
//        }
//        if(target%2!=0) return false;
//        target/=2;
//        int dp[][]=new int[n][target+1];
//        for(int a[]:dp){
//            Arrays.fill(a,-1);
//        }
//        return solve(n-1,nums,target,dp);
//    }

    // 2.Tabulation
    boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int x:nums){
            sum+=x;
        }
        if(sum%2!=0) return false;
        sum/=2;
        boolean dp[][]=new boolean[n][sum+1];
        for(int i=0;i<n;i++){
            dp[i][0]=true;
        }
        if(nums[0]<=sum)
            dp[0][nums[0]]=true;
        for(int i=1;i<n;i++){
            for(int target=1;target<=sum;target++){
                boolean take=false;
                if(nums[i]<=target)
                    take=dp[i-1][target-nums[i]];
                boolean notTake=dp[i-1][target];
                dp[i][target]=take||notTake;
            }
        }
        return dp[n-1][sum];
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Partition_Equal_Subset_Sum ob = new Partition_Equal_Subset_Sum();
        int nums[]={1,5,11,5};
        boolean ans = ob.canPartition(nums);
        System.out.println("Is partition possible: "+ans);
    }
}
