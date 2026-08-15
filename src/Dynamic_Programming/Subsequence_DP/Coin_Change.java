package Dynamic_Programming.Subsequence_DP;

import java.util.*;

public class Coin_Change {
    // 1.Recursion
//    int solve(int idx,int coins[],int amt){
//        if(idx==0){
//            if(amt%coins[idx]==0) return amt/coins[idx];
//            else
//                return (int)1e9;
//        }
//        int notTake=solve(idx-1,coins,amt);
//        int take=(int)1e9;
//        if(coins[idx]<=amt){
//            take=1+solve(idx,coins,amt-coins[idx]);
//        }
//        return Math.min(take,notTake);
//    }
//    public int coinChange(int[] coins, int amount) {
//        int n=coins.length;
//        int ans=solve(n-1,coins,amount);
//        return ans>=(int)1e9?-1:ans;
//    }

    // 2.Memoization
//    int solve(int idx,int coins[],int amt,int dp[][]){
//        if(idx==0){
//            if(amt%coins[idx]==0) return amt/coins[idx];
//            else
//                return (int)1e9;
//        }
//        if(dp[idx][amt]!=-1) return dp[idx][amt];
//
//        int notTake=solve(idx-1,coins,amt,dp);
//        int take=(int)1e9;
//        if(coins[idx]<=amt){
//            take=1+solve(idx,coins,amt-coins[idx],dp);
//        }
//        return dp[idx][amt]=Math.min(take,notTake);
//    }
//    public int coinChange(int[] coins, int amount) {
//        int n=coins.length;
//        int dp[][]=new int[n][amount+1];
//        for(int d[]:dp){
//            Arrays.fill(d,-1);
//        }
//        int ans=solve(n-1,coins,amount,dp);
//        return ans>=(int)1e9?-1:ans;
//    }

    // 3.Tabulation
//    int coinChange(int[] coins, int amount) {
//        int n=coins.length;
//        int dp[][]=new int[n][amount+1];
//        for(int i=0;i<=amount;i++){
//            if(i%coins[0]==0)
//                dp[0][i]=i/coins[0];
//            else
//                dp[0][i]=(int)1e9;
//        }
//        for(int i=1;i<n;i++){
//            for(int j=0;j<=amount;j++){
//                int notTake=dp[i-1][j];
//                int take=(int)1e9;
//                if(coins[i]<=j){
//                    take=1+dp[i][j-coins[i]];
//                }
//                dp[i][j]=Math.min(take,notTake);
//            }
//        }
//        int ans=dp[n-1][amount];
//        return ans>=(int)1e9?-1:ans;
//    }

    // 4.Space Optimisation
    int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int prev[]=new int[amount+1];
        for(int i=0;i<=amount;i++){
            if(i%coins[0]==0)
                prev[i]=i/coins[0];
            else
                prev[i]=(int)1e9;
        }
        for(int i=1;i<n;i++){
            int curr[]=new int[amount+1];
            for(int j=0;j<=amount;j++){
                int notTake=prev[j];
                int take=(int)1e9;
                if(coins[i]<=j){
                    take=1+curr[j-coins[i]];
                }
                curr[j]=Math.min(take,notTake);
            }
            prev=curr;
        }
        int ans=prev[amount];
        return ans>=(int)1e9?-1:ans;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Coin_Change ob = new Coin_Change();
        int coint[]={1,5,6,9};
        int amt=11;
        int min=ob.coinChange(coint,amt);
        System.out.println("Minimum number of coins needed: "+min);
    }
}
