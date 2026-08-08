package Dynamic_Programming.DP_1D;

import java.util.*;

public class Frog_Jump {
        // 1. Recursive
//    int solve(int i,int height[]){
//        if(i==0)
//            return 0;
//        int j1=solve(i-1,height)+Math.abs(height[i]-height[i-1]);
//        int j2=Integer.MAX_VALUE;
//        if(i>1){
//            j2=solve(i-2,height)+Math.abs(height[i]-height[i-2]);
//        }
//        return Math.min(j1,j2);
//    }
//    int minCost(int[] height) {
//        int n=height.length;
//        return solve(n-1,height);
//    }

    // 2. Memoization
//    int solve(int i,int height[],int dp[]){
//        if(i==0)
//            return 0;
//        if(dp[i]!=-1)
//            return dp[i];
//        int j1=solve(i-1,height,dp)+Math.abs(height[i]-height[i-1]);
//        int j2=Integer.MAX_VALUE;
//        if(i>1){
//            j2=solve(i-2,height,dp)+Math.abs(height[i]-height[i-2]);
//        }
//        return dp[i]=Math.min(j1,j2);
//    }
//    int minCost(int[] height) {
//        int n=height.length;
//        int dp[]=new int[n];
//        Arrays.fill(dp,-1);
//        return solve(n-1,height,dp);
//    }

    // 3. Tabulation
//    int minCost(int[] height) {
//        int n=height.length;
//        if(n==1)
//            return 0;
//        int dp[]=new int[n];
//        dp[0]=0;
//        for(int i=1;i<n;i++){
//            int x=dp[i-1]+Math.abs(height[i]-height[i-1]);
//            int y=Integer.MAX_VALUE;
//            if(i>1){
//                y=dp[i-2]+Math.abs(height[i]-height[i-2]);
//            }
//            dp[i]=Math.min(x,y);
//        }
//        return dp[n-1];
//    }

    // 4. Space Optimisation
    int minCost(int[] height) {
        int n=height.length;
        if(n==1)
            return 0;
        int prev1=Math.abs(height[0]-height[1]);
        int prev2=0;
        for(int i=2;i<n;i++){
            int one=prev1+Math.abs(height[i]-height[i-1]);
            int two=prev2+Math.abs(height[i]-height[i-2]);
            int curr=Math.min(one,two);
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Frog_Jump ob = new Frog_Jump();
        int height[]={30, 20, 50, 10, 40};
        int min=ob.minCost(height);
        System.out.println("Minimum cost for frog to jump to last stair: "+min);
    }
}
