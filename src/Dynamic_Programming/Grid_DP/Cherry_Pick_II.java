package Dynamic_Programming.Grid_DP;

import java.util.*;

public class Cherry_Pick_II {
    // 1.Recursion
//    int solve(int row,int c1,int c2,int grid[][],int m,int n){
//        if(c1<0 || c1>n || c2<0 || c2>n) return (int)-1e8;
//        if(row==m){
//            if(c1!=c2)
//                return grid[row][c1]+grid[row][c2];
//            else
//                return grid[row][c1];
//        }
//        int max=0;
//        for(int i=-1;i<=1;i++){
//            for(int j=-1;j<=1;j++){
//                if(c1!=c2)
//                    max=Math.max(max,grid[row][c1]+grid[row][c2]+solve(row+1,c1+i,c2+j,grid,m,n));
//                else
//                    max=Math.max(max,grid[row][c1]+solve(row+1,c1+i,c2+j,grid,m,n));
//            }
//        }
//        return max;
//    }
//    public int cherryPickup(int[][] grid) {
//        return solve(0,0,grid[0].length-1,grid,grid.length-1,grid[0].length-1);
//    }

    // 2.Memoization
//    int solve(int row,int c1,int c2,int grid[][],int dp[][][],int m,int n){
//        if(c1<0 || c1>=n || c2<0 || c2>=n) return (int)-1e8;
//        if(row==m-1){
//            if(c1!=c2)
//                return grid[row][c1]+grid[row][c2];
//            else
//                return grid[row][c1];
//        }
//        if(dp[row][c1][c2]!=-1) return dp[row][c1][c2];
//        int max=0;
//        for(int i=-1;i<=1;i++){
//            for(int j=-1;j<=1;j++){
//                if(c1!=c2)
//                    max=Math.max(max,grid[row][c1]+grid[row][c2]+solve(row+1,c1+i,c2+j,grid,dp,m,n));
//                else
//                    max=Math.max(max,grid[row][c1]+solve(row+1,c1+i,c2+j,grid,dp,m,n));
//            }
//        }
//        return dp[row][c1][c2]=max;
//    }
//    public int cherryPickup(int[][] grid) {
//        int m=grid.length,n=grid[0].length;
//        int dp[][][]=new int[m][n][n];
//        for(int mat[][]:dp){
//            for(int a[]:mat){
//                Arrays.fill(a,-1);
//            }
//        }
//        return solve(0,0,grid[0].length-1,grid,dp,m,n);
//    }

    // 3.Tabulation
//    int cherryPickup(int[][] grid) {
//        int m=grid.length,n=grid[0].length;
//        int dp[][][]=new int[m][n][n];
//        for(int c1=0;c1<n;c1++){
//            for(int c2=0;c2<n;c2++){
//                if(c1!=c2){
//                    dp[m-1][c1][c2]=grid[m-1][c1]+grid[m-1][c2];
//                }
//                else{
//                    dp[m-1][c1][c2]=grid[m-1][c1];
//                }
//            }
//        }
//        for(int row=m-2;row>=0;row--){
//            for(int c1=0;c1<n;c1++){
//                for(int c2=0;c2<n;c2++){
//                    int max=0;
//                    for(int i=-1;i<=1;i++){
//                        for(int j=-1;j<=1;j++){
//                            int nc1=c1+i;
//                            int nc2=c2+j;
//                            if(nc1>=0 && nc1<n && nc2>=0 && nc2<n){
//                                max=Math.max(max,dp[row+1][nc1][nc2]);
//                            }
//                        }
//                    }
//                    if(c1!=c2){
//                        dp[row][c1][c2]=grid[row][c1]+grid[row][c2]+max;
//                    }
//                    else{
//                        dp[row][c1][c2]=grid[row][c1]+max;
//                    }
//                }
//            }
//        }
//        return dp[0][0][n-1];
//    }

    // 4.Space Optimization
    int cherryPickup(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int prev[][] = new int[n][n];
        for (int c1 = 0; c1 < n; c1++) {
            for (int c2 = 0; c2 < n; c2++) {
                if (c1 == c2)
                    prev[c1][c2] = grid[m - 1][c1];
                else
                    prev[c1][c2] = grid[m - 1][c1] + grid[m - 1][c2];
            }
        }
        for (int row = m - 2; row >= 0; row--) {
            int curr[][] = new int[n][n];
            for (int c1 = 0; c1 < n; c1++) {
                for (int c2 = 0; c2 < n; c2++) {
                    int max = Integer.MIN_VALUE;
                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                            int nc1 = c1 + i;
                            int nc2 = c2 + j;
                            if (nc1 >= 0 && nc1 < n && nc2 >= 0 && nc2 < n) {
                                max = Math.max(max, prev[nc1][nc2]);
                            }
                        }
                    }
                    if (c1 == c2) {
                        curr[c1][c2] = grid[row][c1] + max;
                    } else {
                        curr[c1][c2] =
                                grid[row][c1] + grid[row][c2] + max;
                    }
                }
            }
            prev = curr;
        }
        return prev[0][n - 1];
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Cherry_Pick_II ob = new Cherry_Pick_II();
        int grid[][] = {{3,1,1},
                        {2,5,1},
                        {1,5,5},
                        {2,1,1}
        };
        int cherries=ob.cherryPickup(grid);
        System.out.println("Max. cherries collected: "+cherries);
    }
}
