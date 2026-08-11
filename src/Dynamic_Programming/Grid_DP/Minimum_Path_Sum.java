package Dynamic_Programming.Grid_DP;

import java.util.*;

public class Minimum_Path_Sum {
    // 1.Recursion
//    int solve(int i,int j,int arr[][]){
//        if(i==0 && j==0) return arr[0][0];
//        if(i<0 || j<0) return Integer.MAX_VALUE;
//        int up=solve(i-1,j,arr);
//        int left=solve(i,j-1,arr);
//        return arr[i][j]+Math.min(up,left);
//    }
//    public int minPathSum(int[][] grid) {
//        int l1=grid.length,l2=grid[0].length;
//        return solve(l1-1,l2-1,grid);
//    }

    // 2.Memoization
//    int solve(int i,int j,int arr[][],int dp[][]){
//        if(i==0 && j==0) return arr[0][0];
//        if(i<0 || j<0) return Integer.MAX_VALUE;
//        if(dp[i][j]!=-1) return dp[i][j];
//
//        int up=solve(i-1,j,arr,dp);
//        int left=solve(i,j-1,arr,dp);
//
//        return dp[i][j]=arr[i][j]+Math.min(up,left);
//    }
//    public int minPathSum(int[][] grid) {
//        int l1=grid.length,l2=grid[0].length;
//        int dp[][]=new int[l1][l2];
//        for(int i=0;i<l1;i++){
//            Arrays.fill(dp[i],-1);
//        }
//        return solve(l1-1,l2-1,grid,dp);
//    }

    // 3.Tabulation
//    int minPathSum(int[][] grid) {
//        int i, j, l1 = grid.length, l2 = grid[0].length;
//        int dp[][] = new int[l1][l2];
//        for (i = 0; i < l1; i++) {
//            for (j = 0; j < l2; j++) {
//                if (i == 0 && j == 0) {
//                    dp[0][0] = grid[0][0];
//                    continue;
//                }
//                int up=Integer.MAX_VALUE,left=Integer.MAX_VALUE;
//                if (i > 0)
//                    up = dp[i - 1][j];
//                if (j > 0)
//                    left = dp[i][j - 1];
//                dp[i][j] = grid[i][j] + Math.min(up, left);
//            }
//        }
//        return dp[l1 - 1][l2 - 1];
//    }

    // 4.Space Optimization
    int minPathSum(int[][] grid) {
        int i, j, l1 = grid.length, l2 = grid[0].length;
        int prev[] = new int[l2];
        for (i = 0; i < l1; i++) {
            int curr[]=new int[l2];
            for (j = 0; j < l2; j++) {
                if (i == 0 && j == 0) {
                    prev[0]=curr[0]=grid[0][0];
                    continue;
                }
                int up=Integer.MAX_VALUE,left=Integer.MAX_VALUE;
                if (i > 0)
                    up = prev[j];
                if (j > 0)
                    left = curr[j-1];
                curr[j] = grid[i][j] + Math.min(up, left);
            }
            prev=curr;
        }
        return prev[l2 - 1];
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Minimum_Path_Sum ob = new Minimum_Path_Sum();
        int grid[][]={{1,3,1},{1,5,1},{4,2,1}};
        int cost=ob.minPathSum(grid);
        System.out.println("Path with the min. cost: "+cost);
    }
}
