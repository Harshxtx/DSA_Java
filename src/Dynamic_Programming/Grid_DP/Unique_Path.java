package Dynamic_Programming.Grid_DP;

import java.util.*;

public class Unique_Path {
    // 1. Recursion
//    int solve(int i,int j){
//        if(i==0 && j==0) return 1;
//        if(i<0 || j<0) return 0;
//
//        int up=solve(i-1,j);
//        int left=solve(i,j-1);
//
//        return up+left;
//    }
//    public int uniquePaths(int m, int n) {
//        return solve(m-1,n-1);
//    }
    // 2. Memoization
//    int solve(int i,int j,int dp[][]){
//        if(i==0 && j==0) return 1;
//        if(i<0 || j<0) return 0;
//        if(dp[i][j]!=-1) return dp[i][j];
//
//        int up=solve(i-1,j,dp);
//        int left=solve(i,j-1,dp);
//
//        return dp[i][j]=up+left;
//    }
//    public int uniquePaths(int m, int n) {
//        int dp[][]=new int[m][n];
//        for(int d[]:dp)
//            Arrays.fill(d,-1);
//        return solve(m-1,n-1,dp);
//    }
    // 3. Tabulation
//    int uniquePaths(int m, int n) {
//        int dp[][] = new int[m][n];
//        dp[0][0] = 1;
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (i == 0 && j == 0) continue;
//                int up = 0, left = 0;
//                if (i > 0) {
//                    up = dp[i - 1][j];
//                }
//                if (j > 0) {
//                    left = dp[i][j - 1];
//                }
//                dp[i][j] = up + left;
//            }
//        }
//        return dp[m - 1][n - 1];
//    }

    // 4.Space Optimization
    int uniquePaths(int m, int n) {
        int prev[] = new int[n];
        prev[0] = 1;
        for (int i = 0; i < m; i++) {
            int curr[]=new int[n];
            curr[0]=prev[0];
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    continue;
                int up=0,left=0;
                if (i > 0) {
                    up=prev[j];
                }
                if (j > 0) {
                    left=curr[j-1];
                }
                curr[j] = up + left;
            }
            prev=curr;
        }
        return prev[n - 1];
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Unique_Path ob = new Unique_Path();
        int m=3,n=7;
        int ways = ob.uniquePaths(m, n);
        System.out.println("Total no. of unique paths are: "+ways);
    }
}
