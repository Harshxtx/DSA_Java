package Dynamic_Programming.DP_1D;

import java.util.*;

public class Frog_Jump_K_Distance {
//
//     1. Recursion
//    int solve(int i,int height[],int k){
//        if(i==0)
//            return 0;
//        int minCost=Integer.MAX_VALUE;
//        for(int j=1;j<=k;j++){
//            if(i-j>=0){
//                int cost=solve(i-j,height,k)+Math.abs(height[i]-height[i-j]);
//                minCost=Math.min(minCost,cost);
//            }
//        }
//        return minCost;
//    }
//    int minCost(int height[],int k){
//        int n=height.length;
//        return solve(n-1,height,k);
//    }

//     2. Memoization
//    int solve(int i,int height[],int k,int dp[]){
//        if(i==0)
//            return 0;
//        if(dp[i]!=-1)
//            return dp[i];
//        int minCost=Integer.MAX_VALUE;
//        for(int j=1;j<=k;j++){
//            if(i-j>=0){
//                int cost=solve(i-j,height,k,dp)+Math.abs(height[i]-height[i-j]);
//                minCost=Math.min(minCost,cost);
//            }
//        }
//        return dp[i]=minCost;
//    }
//    int minCost(int height[],int k){
//        int n=height.length;
//        int dp[]=new int[n];
//        Arrays.fill(dp,-1);
//        return solve(n-1,height,k,dp);
//    }

//  3. Tabulation
    int minCost(int height[],int k){
        int n=height.length;
        int dp[]=new int[n];
        dp[0]=0;
        for(int i=1;i<n;i++){
            int minCost=Integer.MAX_VALUE;
            for(int j=1;j<=k;j++){
                if(i-j>=0){
                    int cost=dp[i-j]+Math.abs(height[i]-height[i-j]);
                    minCost=Math.min(minCost,cost);
                }
            }
            dp[i]=minCost;
        }
        return dp[n-1];
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Frog_Jump_K_Distance ob = new Frog_Jump_K_Distance();

        int height[]={30,10,60,10,60,50};
        int k=2;
        System.out.println("Minimum cost for frog to jump to last stair: "+ob.minCost(height,k));
    }
}