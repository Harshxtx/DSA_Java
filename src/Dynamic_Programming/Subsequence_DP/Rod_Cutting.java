package Dynamic_Programming.Subsequence_DP;

import java.util.*;

public class Rod_Cutting {
    // 1.Recursion
//    int solve(int idx,int price[],int rodLength){
//        if(idx==0) return rodLength*price[0];
//
//        int notTake=solve(idx-1,price,rodLength);
//        int take=(int)-1e9;
//        if(rodLength>=idx+1){
//            take=price[idx]+solve(idx,price,rodLength-idx-1);
//        }
//        return Math.max(take,notTake);
//    }
//    public int cutRod(int[] price) {
//        int n=price.length;
//        return solve(n-1,price,n);
//    }

    // 2.Memoization
//    int solve(int idx,int price[],int rodLength,int dp[][]){
//        if(idx==0) return rodLength*price[0];
//        if(dp[idx][rodLength]!=-1) return dp[idx][rodLength];
//
//        int notTake=solve(idx-1,price,rodLength,dp);
//        int take=(int)-1e9;
//        if(rodLength>=idx+1){
//            take=price[idx]+solve(idx,price,rodLength-idx-1,dp);
//        }
//        return dp[idx][rodLength]=Math.max(take,notTake);
//    }
//    public int cutRod(int[] price) {
//        int n=price.length;
//        int dp[][]=new int[n][n+1];
//        for(int d[]:dp){
//            Arrays.fill(d,-1);
//        }
//        return solve(n-1,price,n,dp);
//    }

    // 3.Tabulation
    int cutRod(int[] price) {
        int n=price.length;
        int dp[][]=new int[n][n+1];
        for(int i=0;i<=n;i++){
            dp[0][i]=i*price[0];
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=n;j++){
                int notTake=dp[i-1][j];
                int take=(int)-1e9;
                if(j>=i+1){
                    take=price[i]+dp[i][j-i-1];
                }
                dp[i][j]=Math.max(take,notTake);
            }
        }
        return dp[n-1][n];
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Rod_Cutting ob = new Rod_Cutting();
        int price[]={1, 5, 8, 9, 10, 17, 17, 20};
        int value=ob.cutRod(price);
        System.out.println("Maximum value earned: "+value);
    }
}
