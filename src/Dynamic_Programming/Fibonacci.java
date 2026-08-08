package Dynamic_Programming;
// This is a simple example to understand the evolution of Dynamic Programming:
//
// Recursion
//     ↓
// Memoization
//     ↓
// Tabulation
//     ↓
// Space Optimization
import java.util.*;

class Fibonacci {
    // 1. Recursion
    // Directly follows the Fibonacci recurrence.
    // The same subproblems are calculated multiple times.
    //
    // Time Complexity: O(2^n)
    // Space Complexity: O(n) - Recursion Stack
    static int fibRecursion(int n){
        if(n<=1)
            return n;
        return fibRecursion(n-1)+fibRecursion(n-2);
    }

    // 2. Memoization
    // Top-Down DP.
    // Store the answer of each subproblem so it is not calculated again.
    //
    // Time Complexity: O(n)
    // Space Complexity: O(n) - DP Array + Recursion Stack
    static int fibMemoization(int n,int dp[]){
        if(n<=1)
            return n;
        if(dp[n]!=-1)
            return dp[n];
        return dp[n]=fibMemoization(n-1,dp)+fibMemoization(n-2,dp);
    }

    // 3. Tabulation
    // Bottom-Up DP.
    // Start from the smallest subproblems and build the answer up to n.
    //
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    static int fibTabulation(int n){
        if(n<=1)
            return n;
        int dp[]=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    // 4. Space Optimization
    // In tabulation, we only need the previous two values.
    // So the complete DP array is not required.
    //
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    static int fibSpaceOptimized(int n){
        if(n<=1)
            return n;
        int prev2=0;
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
        int n=10;

        // Recursion
        System.out.println("Fibonacci using Recursion: "+fibRecursion(n));

        // Memoization
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println("Fibonacci using Memoization: "+fibMemoization(n,dp));

        // Tabulation
        System.out.println("Fibonacci using Tabulation: "+fibTabulation(n));

        // Space Optimization
        System.out.println("Fibonacci using Space Optimization: "+fibSpaceOptimized(n));
    }
}
