package Dynamic_Programming.String_DP;

import java.util.*;

public class Longest_Palindromic_Substring {
    // 1.Memoization
//    int solve(int idx1,int idx2,String word1,String word2,int dp[][]){
//        if(idx1<0 || idx2>=word2.length()) return 0;
//        if(dp[idx1][idx2]!=-1) return dp[idx1][idx2];
//
//        if(word1.charAt(idx1)==word2.charAt(idx2)){
//            return dp[idx1][idx2]=1+solve(idx1-1,idx2+1,word1,word2,dp);
//        }
//        return dp[idx1][idx2]=Math.max(solve(idx1-1,idx2,word1,word2,dp),solve(idx1,idx2+1,word1,word2,dp));
//    }
//    public int longestPalindromeSubseq(String s) {
//        int l=s.length();
//        int dp[][]=new int[l][l];
//        for(int d[]:dp){
//            Arrays.fill(d,-1);
//        }
//        return solve(l-1,0,s,s,dp);
//    }

    // 2.Tabulation
    int longestPalindromeSubseq(String s) {
        int l=s.length();
        int dp[][]=new int[l+1][l+1];
        for(int i=1;i<=l;i++){
            for(int j=1;j<=l;j++){
                if(s.charAt(i-1)==s.charAt(l-j)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[l][l];
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Longest_Palindromic_Substring ob = new Longest_Palindromic_Substring();
        String str="bbabab";
        int res=ob.longestPalindromeSubseq(str);
        System.out.println("Longest Palindromic Substring"+res);
    }
}
