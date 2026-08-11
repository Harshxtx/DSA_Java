package Dynamic_Programming.Grid_DP;

import java.util.*;

public class Triangle_Path_Sum {
    // 1.Recursion
//    int solve(int i,int j,List<List<Integer>> list){
//        if(list.size()-1==i) return list.get(i).get(j);
//
//        int down=solve(i+1,j,list);
//        int diagonal=solve(i+1,j+1,list);
//
//        return list.get(i).get(j)+Math.min(down,diagonal);
//    }
//    public int minimumTotal(List<List<Integer>> triangle) {
//        return solve(0,0,triangle);
//    }

    // 2.Memoization
//    int solve(int i,int j,List<List<Integer>> list,Integer dp[][]){
//        if(list.size()-1==i) return list.get(i).get(j);
//        if(dp[i][j]!=null) return dp[i][j];
//
//        int down=solve(i+1,j,list,dp);
//        int diagonal=solve(i+1,j+1,list,dp);
//
//        return dp[i][j]=list.get(i).get(j)+Math.min(down,diagonal);
//    }
//    public int minimumTotal(List<List<Integer>> triangle) {
//        int n=triangle.size();
//        Integer dp[][]=new Integer[n][n];
//        return solve(0,0,triangle,dp);
//    }

    // 3.Tabulation
//    int minimumTotal(List<List<Integer>> triangle) {
//        int n=triangle.size();
//        int dp[][]=new int[n][n];
//        for(int i=0;i<n;i++){
//            dp[n-1][i]=triangle.get(n-1).get(i);
//        }
//        for(int i=n-2;i>=0;i--){
//            for(int j=i;j>=0;j--){
//                int down=dp[i+1][j];
//                int diagonal=dp[i+1][j+1];
//                dp[i][j]=triangle.get(i).get(j)+Math.min(down,diagonal);
//            }
//        }
//        return dp[0][0];
//    }

    // 4.Space Optimization
    int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int prev[]=new int[n];
        for(int i=0;i<n;i++){
            prev[i]=triangle.get(n-1).get(i);
        }
        for(int i=n-2;i>=0;i--){
            int curr[]=new int[i+1];
            for(int j=i;j>=0;j--){
                int down=prev[j];
                int diagonal=prev[j+1];
                curr[j]=triangle.get(i).get(j)+Math.min(down,diagonal);
            }
            prev=curr;
        }
        return prev[0];
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Triangle_Path_Sum ob = new Triangle_Path_Sum();
        List<List<Integer>> triangle1 = List.of(
                List.of(2),
                List.of(3, 4),
                List.of(6, 5, 7),
                List.of(4, 1, 8, 3)
        );
        int min=ob.minimumTotal(triangle1);
        System.out.println("Minimum path in a triangle to reach the base: "+min);
    }
}
