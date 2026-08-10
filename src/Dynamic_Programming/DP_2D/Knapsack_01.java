package Dynamic_Programming.DP_2D;

import java.util.*;

public class Knapsack_01 {

//    1. Recursion
//    int solve(int i,int wt[],int val[],int capacity){
//        if(i==0){
//            if(wt[0]<=capacity)
//                return val[0];
//            return 0;
//        }
//        int notTake=solve(i-1,wt,val,capacity);
//        int take=0;
//        if(wt[i]<=capacity){
//            take=val[i]+solve(i-1,wt,val,capacity-wt[i]);
//        }
//        return Math.max(take,notTake);
//    }
//    int knapsack(int wt[],int val[],int capacity){
//        int n=wt.length;
//        return solve(n-1,wt,val,capacity);
//    }

//    2. Memoization
//    int solve(int i,int wt[],int val[],int capacity,int dp[][]){
//        if(i==0){
//            if(wt[0]<=capacity)
//                return val[0];
//            return 0;
//        }
//        if(dp[i][capacity]!=-1)
//            return dp[i][capacity];
//        int notTake=solve(i-1,wt,val,capacity,dp);
//        int take=0;
//        if(wt[i]<=capacity){
//            take=val[i]+solve(i-1,wt,val,capacity-wt[i],dp);
//        }
//        return dp[i][capacity]=Math.max(take,notTake);
//    }
//    int knapsack(int wt[],int val[],int capacity){
//        int n=wt.length;
//        int dp[][]=new int[n][capacity+1];
//        for(int i=0;i<n;i++){
//            Arrays.fill(dp[i],-1);
//        }
//        return solve(n-1,wt,val,capacity,dp);
//    }

        //3. Tabulation
//    int knapsack(int wt[],int val[],int capacity){
//        int n=wt.length;
//        int dp[][]=new int[n][capacity+1];
//
//        for(int c=wt[0];c<=capacity;c++){
//            dp[0][c]=val[0];
//        }
//        for(int i=1;i<n;i++){
//            for(int c=0;c<=capacity;c++){
//                int notTake=dp[i-1][c];
//                int take=0;
//                if(wt[i]<=c){
//                    take=val[i]+dp[i-1][c-wt[i]];
//                }
//                dp[i][c]=Math.max(take,notTake);
//            }
//        }
//        return dp[n-1][capacity];
//    }

    // 4. Space Optimization
    int knapsack(int wt[],int val[],int capacity){
        int n=wt.length;
        int dp[]=new int[capacity+1];

        for(int c=wt[0];c<=capacity;c++){
            dp[c]=val[0];
        }

        for(int i=1;i<n;i++){
            int temp[]=new int[capacity+1];

            for(int c=0;c<=capacity;c++){
                int notTake=dp[c];
                int take=0;
                if(wt[i]<=c){
                    take=val[i]+dp[c-wt[i]];
                }
                temp[c]=Math.max(take,notTake);
            }
            dp=temp;
        }
        return dp[capacity];
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Knapsack_01 ob = new Knapsack_01();

        int wt[]={1,3,4,5};
        int val[]={1,4,5,7};
        int capacity=7;

        int ans=ob.knapsack(wt,val,capacity);

        System.out.println("Maximum value in Knapsack: "+ans);
    }
}