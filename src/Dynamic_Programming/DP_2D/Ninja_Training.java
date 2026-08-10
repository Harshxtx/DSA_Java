package Dynamic_Programming.DP_2D;

import java.util.*;

public class Ninja_Training {
    //1. Recursive
//    int solve(int day,int last,int arr[][]){
//        if(day==0){
//            int max=0;
//            for(int i=0;i<3;i++){
//                if(i!=last)
//                    max=Math.max(max,arr[day][i]);
//            }
//            return max;
//        }
//        int max=0;
//        for(int i=0;i<3;i++){
//            if(i!=last){
//                int point=arr[day][i]+solve(day-1,i,arr);
//                max=Math.max(max,point);
//            }
//        }
//        return max;
//    }
//    public int maximumPoints(int mat[][]) {
//        return solve(mat.length-1,3,mat);
//    }

    //2. Memoization
//    int solve(int day,int last,int arr[][],int dp[][]){
//        if(day==0){
//            int max=0;
//            for(int i=0;i<3;i++){
//                if(i!=last)
//                    max=Math.max(max,arr[day][i]);
//            }
//            return dp[day][last]=max;
//        }
//        if(dp[day][last]!=-1)
//            return dp[day][last];
//        int max=0;
//        for(int i=0;i<3;i++){
//            if(i!=last){
//                int point=arr[day][i]+solve(day-1,i,arr,dp);
//                max=Math.max(max,point);
//            }
//        }
//        return dp[day][last]=max;
//    }
//    public int maximumPoints(int mat[][]) {
//        int n=mat.length;
//        int dp[][]=new int[n][4];
//        for(int i=0;i<n;i++){
//            Arrays.fill(dp[i],-1);
//        }
//        return solve(n-1,3,mat,dp);
//    }

    //3. Tabulation
//    int maximumPoints(int mat[][]) {
//        int n=mat.length;
//        int dp[][]=new int[n][4];
//
//        dp[0][0]=Math.max(mat[0][1],mat[0][2]);
//        dp[0][1]=Math.max(mat[0][0],mat[0][2]);
//        dp[0][2]=Math.max(mat[0][0],mat[0][1]);
//        dp[0][3]=Math.max(mat[0][0],Math.max(mat[0][1],mat[0][2]));
//
//        for(int day=1;day<n;day++){
//            for(int last=0;last<4;last++){
//                dp[day][last]=0;
//                for(int task=0;task<3;task++){
//                    if(task!=last){
//                        int point=mat[day][task]+dp[day-1][task];
//                        dp[day][last]=Math.max(dp[day][last],point);
//                    }
//                }
//            }
//        }
//        return dp[n-1][3];
//    }

    //4. Space Optimization
    int maximumPoints(int mat[][]) {
        int n=mat.length;
        int dp[]=new int[4];

        dp[0]=Math.max(mat[0][1],mat[0][2]);
        dp[1]=Math.max(mat[0][0],mat[0][2]);
        dp[2]=Math.max(mat[0][0],mat[0][1]);
        dp[3]=Math.max(mat[0][0],Math.max(mat[0][1],mat[0][2]));

        for(int day=1;day<n;day++){
            int temp[]=new int[4];
            for(int last=0;last<4;last++){
                temp[last]=0;
                for(int task=0;task<3;task++){
                    if(task!=last){
                        int point=mat[day][task]+dp[task];
                        temp[last]=Math.max(temp[last],point);
                    }
                }
            }
            dp=temp;
        }
        return dp[3];
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Ninja_Training ob = new Ninja_Training();
        int mat[][]={{1,2,5},{3,1,1},{3,3,3}};
        int ans=ob.maximumPoints(mat);
        System.out.println("The max. no. of Merit points can be collected: "+ans);
    }
}
