package Dynamic_Programming.Grid_DP;

import java.util.*;

public class Unique_Path_with_Obstacles {
    // 1.Recursion
//    int solve(int i,int j,int arr[][]){
//        if(i<0 || j<0) return 0;
//        if(arr[i][j]==1) return 0;                                //for obstacles
//        if(i==0 && j==0) return 1;
//
//        int up=solve(i-1,j,arr);
//        int left=solve(i,j-1,arr);
//
//        return up+left;
//    }
//    public int uniquePathsWithObstacles(int[][] og) {
//        return solve(og.length-1,og[0].length-1,og);
//    }

    // 2.Memoization
//    int solve(int i,int j,int arr[][],int dp[][]){
//        if(i<0 || j<0) return 0;
//        if(arr[i][j]==1) return 0;                        //for obstacles
//        if(i==0 && j==0) return 1;
//        if(dp[i][j]!=-1) return dp[i][j];
//
//        int up=solve(i-1,j,arr,dp);
//        int left=solve(i,j-1,arr,dp);
//
//        return dp[i][j]=up+left;
//    }
//    public int uniquePathsWithObstacles(int[][] og) {
//        int m=og.length,n=og[0].length;
//        int dp[][]=new int[m][n];
//        for(int i=0;i<m;i++){
//            Arrays.fill(dp[i],-1);
//        }
//        return solve(m-1,n-1,og,dp);
//    }

    // 3.Tabulation
//    int uniquePathsWithObstacles(int[][] path) {
//        int i,j,l1=path.length,l2=path[0].length;
//        int dp[][]=new int[l1][l2];
//        dp[0][0]=1;
//        for(i=0;i<l1;i++)
//        {
//            for(j=0;j<l2;j++)
//            {
//                if(i==0 && j==0)
//                    continue;
//
//                if(path[i][j]==1)                     //for obstacles
//                    dp[i][j]=0;
//                else if(i==0)
//                    dp[i][j]=dp[i][j-1];
//                else if(j==0)
//                    dp[i][j]=dp[i-1][j];
//                else
//                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
//            }
//        }
//        return dp[l1-1][l2-1];
//    }

    // 4. Space Optimization
    int uniquePathsWithObstacles(int[][] og) {
        int i,j,l1=og.length,l2=og[0].length;
        if(og[0][0]==1 || og[l1-1][l2-1]==1)
            return 0;
        int prev[]=new int[l2];
        prev[0]=1;
        for(i=0;i<l1;i++){
            int curr[]=new int[l2];
            curr[0]=prev[0];
            for(j=0;j<l2;j++){
                if(i==0 && j==0)
                    continue;

                int up=0,left=0;
                if(og[i][j]==1){                //for obstacles
                    curr[j]=0;
                    continue;
                }
                if(i>0)
                    up=prev[j];
                if(j>0)
                    left=curr[j-1];
                curr[j]=up+left;
            }
            prev=curr;
        }
        return prev[l2-1];
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Unique_Path_with_Obstacles ob = new Unique_Path_with_Obstacles();
        int path[][] = {{0,0,0},
                        {0,0,0},
                        {0,1,0}
        };
        int ways=ob.uniquePathsWithObstacles(path);
        System.out.println("Total no. of unique paths with obstacles are: "+ways);
    }
}
