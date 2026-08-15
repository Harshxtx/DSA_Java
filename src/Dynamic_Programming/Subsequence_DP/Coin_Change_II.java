package Dynamic_Programming.Subsequence_DP;

import java.util.*;

public class Coin_Change_II {
    // 1.Recursion
//    int solve(int idx,int coins[],int amt){
//        if(idx==0) return amt%coins[0]==0?1:0;
//
//        int notTake=solve(idx-1,coins,amt);
//        int take=0;
//        if(coins[idx]<=amt){
//            take=solve(idx,coins,amt-coins[idx]);
//        }
//        return take+notTake;
//    }
//    public int change(int amount, int[] coins) {
//        int n=coins.length;
//        return solve(n-1,coins,amount);
//    }

    // 2.Memoization
//    int solve(int idx,int coins[],int amt,int dp[][]){
//        if(idx==0) return amt%coins[0]==0?1:0;
//        if (dp[idx][amt]!=-1) return dp[idx][amt];
//
//        int notTake=solve(idx-1,coins,amt,dp);
//        int take=0;
//        if(coins[idx]<=amt){
//            take=solve(idx,coins,amt-coins[idx],dp);
//        }
//        return dp[idx][amt]=take+notTake;
//    }
//    public int change(int amount, int[] coins) {
//        int n=coins.length;
//        int dp[][]=new int[n][amount+1];
//        for(int d[]:dp){
//            Arrays.fill(d,-1);
//        }
//        return solve(n-1,coins,amount,dp);
//    }

    // 3.Tabulation
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int dp[][]=new int[n][amount+1];
        for(int i=0;i<=amount;i++){
            dp[0][i]=i%coins[0]==0?1:0;
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=amount;j++){
                int notTake=dp[i-1][j];
                int take=0;
                if(coins[i]<=j){
                    take=dp[i][j-coins[i]];
                }
                dp[i][j]=take+notTake;
            }
        }
        return dp[n-1][amount];
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Coin_Change_II ob = new Coin_Change_II();
        int arr[]={1,2,5};
        int amount=5;
        int ans=ob.change(amount, arr);
        System.out.println("No. of combination to sum up the amount: "+ans);
    }
}
