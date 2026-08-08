package Dynamic_Programming.DP_1D;

import java.util.*;

public class Climbing_Stairs {

//    int climbStairs(int n) {
//        if(n<=1)
//            return 1;
//        return climbStairs(n-1)+climbStairs(n-2);
//    }
//    int climbStairs(int n,int dp[]) {
//        if(n<=1)
//            return 1;
//        if(dp[n]!=-1)
//            return dp[n];
//        return dp[n]=climbStairs(n-1,dp)+climbStairs(n-2,dp);
//    }
//    int climbStairs(int n) {
//        if(n<=1)
//            return 1;
//        int dp[]=new int[n+1];
//        dp[0]=1;
//        dp[1]=1;
//        for(int i=2;i<=n;i++){
//            dp[i]=dp[i-1]+dp[i-2];
//        }
//        return dp[n];
//    }
    int climbStairs(int n) {
        if(n<=1)
            return 1;
        int prev2=1;
        int prev1=1;
        for(int i=2;i<=n;i++){
            int curr=prev1+prev2;
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Climbing_Stairs ob = new Climbing_Stairs();
        int n=5;

//        // Recursion
//        System.out.println("Ways to climb "+n+" stairs: "+ob.climbStairs(n));
//
//        // Memoization
//        int dp[]=new int[n+1];
//        Arrays.fill(dp,-1);
//        System.out.println("Ways to climb "+n+" stairs: "+ob.climbStairs(n,dp));
//
//        // Tabulation
//        System.out.println("Ways to climb "+n+" stairs: "+ob.climbStairs(n));

        // Space Optimization
        System.out.println("Ways to climb "+n+" stairs: "+ob.climbStairs(n));
    }
}
