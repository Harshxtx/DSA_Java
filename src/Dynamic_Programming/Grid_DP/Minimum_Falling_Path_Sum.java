package Dynamic_Programming.Grid_DP;

import java.util.*;

public class Minimum_Falling_Path_Sum {
    // 1.Recursive
//    int solve(int i,int j,int mat[][]){
//        if(j<0 || j>=mat[0].length) return (int) 1e9;
//        if(i==0) return mat[0][j];
//
//        int up=solve(i-1,j,mat);
//        int rdia=solve(i-1,j+1,mat);
//        int ldia=solve(i-1,j-1,mat);
//
//        return mat[i][j]+Math.min(up,Math.min(rdia,ldia));
//    }
//    public int minFallingPathSum(int[][] mat) {
//        int min=(int) 1e9;
//        for(int i=0;i<mat[0].length;i++){
//            min=Math.min(min,solve(mat.length-1,i,mat));
//        }
//        return min;
//    }

    // 2.Memoization
//    int solve(int i,int j,int mat[][],int dp[][]){
//        if(j<0 || j>=mat[0].length) return (int)1e9;
//        if(i==0) return mat[0][j];
//        if(dp[i][j]!=(int)-1e5) return dp[i][j];
//
//        int up=solve(i-1,j,mat,dp);
//        int rdia=solve(i-1,j+1,mat,dp);
//        int ldia=solve(i-1,j-1,mat,dp);
//
//        return dp[i][j]=mat[i][j]+Math.min(up,Math.min(rdia,ldia));
//    }
//    public int minFallingPathSum(int[][] mat) {
//        int min=(int)1e9;
//        int m=mat.length,n=mat[0].length;
//
//        int dp[][]=new int[m][n];
//        for(int d[]:dp) Arrays.fill(d,(int)-1e5);
//
//        for(int i=0;i<n;i++){
//            min=Math.min(min,solve(m-1,i,mat,dp));
//        }
//        return min;
//    }

    // 3.Tabualtion
//    int minFallingPathSum(int[][] mat) {
//        int min=(int)1e9;
//        int m=mat.length,n=mat[0].length;
//
//        int dp[][]=new int[m][n];
//        for(int i=0;i<n;i++) {
//            dp[0][i]=mat[0][i];
//        }
//
//        for(int i=1;i<m;i++){
//            for(int j=0;j<n;j++){
//                int up=dp[i-1][j];
//                int ldia=(j>0)?dp[i-1][j-1]:(int)1e9;
//                int rdia=(j<n-1)?dp[i-1][j+1]:(int)1e9;
//
//                dp[i][j]=mat[i][j]+Math.min(up,Math.min(rdia,ldia));
//            }
//        }
//
//        for(int i=0;i<n;i++){
//            min=Math.min(min,dp[m-1][i]);
//        }
//
//        return min;
//    }

    // 4.Space Optimization
    int minFallingPathSum(int[][] mat) {
        int min = (int) 1e9;
        int m = mat.length, n = mat[0].length;

        int prev[] = new int[n];
        for (int j = 0; j < n; j++) {
            prev[j] = mat[0][j];
        }

        for (int i = 1; i < m; i++) {
            int curr[] = new int[n];
            for (int j = 0; j < n; j++) {
                int up = prev[j];
                int ldia = (j > 0) ? prev[j - 1] : (int) 1e9;
                int rdia = (j < n - 1) ? prev[j + 1] : (int) 1e9;

                curr[j] = mat[i][j] + Math.min(up, Math.min(rdia, ldia));
            }
            prev = curr;
        }

        for (int i = 0; i < n; i++) {
            min = Math.min(min, prev[i]);
        }

        return min;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Minimum_Falling_Path_Sum ob = new Minimum_Falling_Path_Sum();
        int arr[][]={{2,1,3},{6,5,4},{7,8,9}};
        int min=ob.minFallingPathSum(arr);
        System.out.println("Minimum cost of falling in the matrix: "+min);
    }
}
