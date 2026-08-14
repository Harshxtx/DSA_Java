package Dynamic_Programming.Subsequence_DP;

import java.util.*;

public class Subset_Sum {
    // 1.Recursion
//    boolean solve(int idx,int arr[],int target){
//        if(target==0) return true;
//        if(idx==0) return arr[0]==target;
//        boolean take=false;
//        if(arr[idx]<=target)
//            take=solve(idx-1,arr,target-arr[idx]);
//        boolean notTake=solve(idx-1,arr,target);
//        return take||notTake;
//    }
//    boolean isSubsetSum(int arr[], int sum) {
//        int n=arr.length-1;
//        return solve(n,arr,sum);
//    }

    // 2.Memoization
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
//    boolean isSubsetSum(int arr[], int sum) {
//        int n=arr.length;
//        int dp[][]=new int[n][sum+1];
//        for(int a[]:dp){
//            Arrays.fill(a,-1);
//        }
//        return solve(n-1,arr,sum,dp);
//    }

    // 3.Tabulation
    boolean isSubsetSum(int arr[], int sum) {
        int n=arr.length;
        boolean dp[][]=new boolean[n][sum+1];
        for(int i=0;i<n;i++){
            dp[i][0]=true;
        }
        if(arr[0]<=sum)
            dp[0][arr[0]]=true;
        for(int i=1;i<n;i++){
            for(int target=1;target<=sum;target++){
                boolean take=false;
                if(arr[i]<=target)
                    take=dp[i-1][target-arr[i]];
                boolean notTake=dp[i-1][target];
                dp[i][target]=take||notTake;
            }
        }
        return dp[n-1][sum];
    }

    // 2nd part: No. of Subsets presents
//    int solve(int idx,int arr[],int target,int dp[][]){
//        if(target==0) return 1;
//        if(idx==0) return arr[0]==target?1:0;
//        if(dp[idx][target]!=-1) return dp[idx][target];
//
//        int take=0;
//        if(arr[idx]<=target)
//            take=solve(idx-1,arr,target-arr[idx],dp);
//        int notTake=solve(idx-1,arr,target,dp);
//
//        return dp[idx][target]=take+notTake;
//    }
//    int numSubset(int[] nums, int target) {
//        int n=nums.length;
//        int dp[][]=new int[n][target+1];
//        for(int a[]:dp){
//            Arrays.fill(a,-1);
//        }
//        return solve(n-1,nums,target,dp);
//    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Subset_Sum ob = new Subset_Sum();
        int arr[]={3,34,4,12,5,2};
        int sum=9;
        boolean ans = ob.isSubsetSum(arr,sum);
        System.out.println("Subset is present with the target sum: "+ans);
    }
}
