package Dynamic_Programming.Subsequence_DP;

import java.util.*;

public class Unbounded_Knapsack {
    // 1.Recursion
//    int solve(int i,int wt[],int val[],int capacity){
//        if(i==0) return (capacity/wt[0])*val[0];
//        int notTake=solve(i-1,wt,val,capacity);
//        int take=0;
//        if(wt[i]<=capacity){
//            take=val[i]+solve(i,wt,val,capacity-wt[i]);
//        }
//        return Math.max(take,notTake);
//    }
//    int knapSack(int val[], int wt[], int capacity) {
//        int n=wt.length;
//        return solve(n-1,wt,val,capacity);
//    }

    // 2.Memoization
//    int solve(int i,int wt[],int val[],int capacity,int dp[][]){
//        if(i==0) return (capacity/wt[0])*val[0];
//        if(dp[i][capacity]!=-1) return dp[i][capacity];
//
//        int notTake=solve(i-1,wt,val,capacity,dp);
//        int take=0;
//        if(wt[i]<=capacity){
//            take=val[i]+solve(i,wt,val,capacity-wt[i],dp);
//        }
//        return dp[i][capacity]=Math.max(take,notTake);
//    }
//    public int knapSack(int val[], int wt[], int capacity) {
//        int n=wt.length;
//        int dp[][]=new int[n][capacity+1];
//        for(int a[]:dp)
//            Arrays.fill(a,-1);
//        return solve(n-1,wt,val,capacity,dp);
//    }

    // 3.Tabulation
    int knapSack(int val[], int wt[], int capacity) {
        int n=wt.length;
        int dp[][]=new int[n][capacity+1];

        for(int c=wt[0];c<=capacity;c++){
            dp[0][c]=(c/wt[0])*val[0];;
        }

        for(int i=1;i<n;i++){
            for(int c=0;c<=capacity;c++){
                int notTake=dp[i-1][c];
                int take=0;
                if(wt[i]<=c){
                    take=val[i]+dp[i][c-wt[i]];
                }
                dp[i][c]=Math.max(take,notTake);
            }
        }
        return dp[n-1][capacity];
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Unbounded_Knapsack ob = new Unbounded_Knapsack();
        int val[]={10,40,50,70};
        int wt[]={1,3,4,5};
        int capacity=8;
        int ans=ob.knapSack(val,wt,capacity);
        System.out.println("Maximum profit of Knapsack: "+ans);
    }
}
