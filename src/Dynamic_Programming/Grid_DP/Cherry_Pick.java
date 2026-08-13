package Dynamic_Programming.Grid_DP;

import java.util.*;

public class Cherry_Pick {
    // 1.Recursion
//    int solve(int r1,int c1,int r2,int c2,int grid[][],int n){
//        if(r1>=n || c1>=n || r2>=n || c2>=n || grid[r1][c1]==-1 || grid[r2][c2]==-1) return (int)-1e9;
//        if(r1==n-1 && c1==n-1) return grid[r1][c1];
//
//        int cherries=0;
//        if(r1==r2 && c1==c2){
//            cherries+=grid[r1][c1];
//        }
//        else{
//            cherries+=grid[r1][c1]+grid[r2][c2];
//        }
//        int dd=solve(r1+1,c1,r2+1,c2,grid,n);
//        int dr=solve(r1+1,c1,r2,c2+1,grid,n);
//        int rd=solve(r1,c1+1,r2+1,c2,grid,n);
//        int rr=solve(r1,c1+1,r2,c2+1,grid,n);
//
//        cherries+=Math.max(Math.max(dd,dr),Math.max(rd,rr));
//
//        return cherries;
//    }
//    public int cherryPickup(int[][] grid) {
//        return Math.max(0,solve(0,0,0,0,grid,grid.length));
//    }

    // 2.Memoization
//    int solve(int r1,int c1,int r2,int c2,int grid[][],int n,int dp[][][][]){
//        if(r1>=n || c1>=n || r2>=n || c2>=n || grid[r1][c1]==-1 || grid[r2][c2]==-1) return (int)-1e9;
//        if(r1==n-1 && c1==n-1) return grid[r1][c1];
//        if(dp[r1][c1][r2][c2]!=-1) return dp[r1][c1][r2][c2];
//        int cherries=0;
//        if(r1==r2 && c1==c2){
//            cherries+=grid[r1][c1];
//        }
//        else{
//            cherries+=grid[r1][c1]+grid[r2][c2];
//        }
//        int dd=solve(r1+1,c1,r2+1,c2,grid,n,dp);
//        int dr=solve(r1+1,c1,r2,c2+1,grid,n,dp);
//        int rd=solve(r1,c1+1,r2+1,c2,grid,n,dp);
//        int rr=solve(r1,c1+1,r2,c2+1,grid,n,dp);
//        int max=Math.max(Math.max(dd,dr),Math.max(rd,rr));
//        if(max==(int)-1e9) return max;
//        return dp[r1][c1][r2][c2]=cherries+max;
//    }
//    public int cherryPickup(int[][] grid) {
//        int n=grid[0].length;
//        int dp[][][][]=new int[n][n][n][n];
//        for(int[][] mat:dp) {
//            for(int[] arr:mat) {
//                Arrays.fill(arr,-1);
//            }
//        }
//        return Math.max(0,solve(0,0,0,0,grid,n,dp));
//    }
    //Optimized
//    int solve(int r1,int c1,int r2,int grid[][],int n,int dp[][][]){
//        int c2=r1+c1-r2;
//        if(r1>=n || c1>=n || r2>=n || c2>=n || grid[r1][c1]==-1 || grid[r2][c2]==-1) return (int)-1e9;
//        if(r1==n-1 && c1==n-1) return grid[r1][c1];
//        if(dp[r1][c1][r2]!=-1) return dp[r1][c1][r2];
//
//        int cherries=0;
//        if(r1==r2 && c1==c2){
//            cherries+=grid[r1][c1];
//        }
//        else{
//            cherries+=grid[r1][c1]+grid[r2][c2];
//        }
//
//        int f1=solve(r1+1,c1,r2+1,grid,n,dp);
//        int f2=solve(r1+1,c1,r2,grid,n,dp);
//        int f3=solve(r1,c1+1,r2+1,grid,n,dp);
//        int f4=solve(r1,c1+1,r2,grid,n,dp);
//
//        cherries+=Math.max(Math.max(f1,f2),Math.max(f3,f4));
//
//        return dp[r1][c1][r2]=cherries;
//    }
//    public int cherryPickup(int[][] grid) {
//        int n=grid[0].length;
//        int dp[][][]=new int[n][n][n];
//        for(int[][] mat:dp) {
//            for(int[] arr:mat) {
//                Arrays.fill(arr,-1);
//            }
//        }
//        return Math.max(0,solve(0,0,0,grid,n,dp));
//    }

    // 3.Tabulation
    int cherryPickup(int[][] grid) {
        int n = grid.length;
        int NEG = (int) -1e9;
        int dp[][][] = new int[n][n][n];
        for (int[][] mat : dp) {
            for (int[] arr : mat) {
                Arrays.fill(arr, NEG);
            }
        }
        dp[n - 1][n - 1][n - 1] = grid[n - 1][n - 1];
        for (int r1 = n - 1; r1 >= 0; r1--) {
            for (int c1 = n - 1; c1 >= 0; c1--) {
                for (int r2 = n - 1; r2 >= 0; r2--) {
                    if (r1 == n - 1 && c1 == n - 1 &&
                            r2 == n - 1) {
                        continue;
                    }
                    int c2 = r1 + c1 - r2;
                    if (c2 < 0 || c2 >= n)
                        continue;
                    if (grid[r1][c1] == -1 || grid[r2][c2] == -1)
                        continue;
                    int cherries;
                    if (r1 == r2 && c1 == c2) {
                        cherries = grid[r1][c1];
                    } else {
                        cherries = grid[r1][c1] + grid[r2][c2];
                    }

                    int f1 = NEG;
                    int f2 = NEG;
                    int f3 = NEG;
                    int f4 = NEG;

                    if (r1 + 1 < n && r2 + 1 < n)
                        f1 = dp[r1 + 1][c1][r2 + 1];

                    if (r1 + 1 < n && c2 + 1 < n)
                        f2 = dp[r1 + 1][c1][r2];

                    if (c1 + 1 < n && r2 + 1 < n)
                        f3 = dp[r1][c1 + 1][r2 + 1];

                    if (c1 + 1 < n && c2 + 1 < n)
                        f4 = dp[r1][c1 + 1][r2];

                    int best = Math.max(Math.max(f1, f2),Math.max(f3, f4));

                    if (best != NEG) {
                        dp[r1][c1][r2] = cherries + best;
                    }
                }
            }
        }
        return Math.max(0, dp[0][0][0]);
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Cherry_Pick ob = new Cherry_Pick();
        int grid[][]={{0,-1,1},{1,0,-1},{1,1,1}};
        int max=ob.cherryPickup(grid);
        System.out.println("Maximum cherry Pickup: "+max);
    }
}
