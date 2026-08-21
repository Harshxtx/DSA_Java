package Dynamic_Programming.String_DP;

import java.util.*;

public class Distinct_Subsequence {
    // 1.Recursive
//    int solve(int idx1,int idx2,String s1,String s2){
//        if(idx2<0) return 1;
//        if(idx1<0) return 0;
//
//        if(s1.charAt(idx1)==s2.charAt(idx2))
//            return solve(idx1-1,idx2-1,s1,s2)+solve(idx1-1,idx2,s1,s2);
//
//        return  solve(idx1-1,idx2,s1,s2);
//    }
//    public int numDistinct(String s, String t) {
//        int l1=s.length(),l2=t.length();
//        return solve(l1-1,l2-1,s,t);
//    }

    // 2.Memoization
//    int solve(int idx1,int idx2,String s1,String s2,int dp[][]){
//        if(idx2<0) return 1;
//        if(idx1<0) return 0;
//        if(dp[idx1][idx2]!=-1) return dp[idx1][idx2];
//
//        if(s1.charAt(idx1)==s2.charAt(idx2))
//            return dp[idx1][idx2]=solve(idx1-1,idx2-1,s1,s2,dp)+solve(idx1-1,idx2,s1,s2,dp);
//
//        return  dp[idx1][idx2]=solve(idx1-1,idx2,s1,s2,dp);
//    }
//    public int numDistinct(String s, String t) {
//        int l1=s.length(),l2=t.length();
//        int dp[][]=new int[l1][l2];
//        for(int a[]:dp){
//            Arrays.fill(a,-1);
//        }
//        return solve(l1-1,l2-1,s,t,dp);
//    }

    // 3.Tabulation
    int numDistinct(String s, String t) {
        int l1=s.length(),l2=t.length();
        int dp[][]=new int[l1+1][l2+1];
        for(int i=0;i<=l1;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l2;j++){
                if(s.charAt(i-1)==t.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        return dp[l1][l2];
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Distinct_Subsequence ob = new Distinct_Subsequence();
        String s1="rabbbit";
        String s2="rabbit";
        int ans=ob.numDistinct(s1,s2);
        System.out.println("The number of Distinct Subsequences are: "+ans);
    }
}
