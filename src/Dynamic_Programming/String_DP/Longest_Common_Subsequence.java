package Dynamic_Programming.String_DP;

import java.util.*;

public class Longest_Common_Subsequence {
    // 1.Recursive
//    int solve(int idx1,int idx2,String word1,String word2){
//        if(idx1<0 || idx2<0) return 0;
//
//        if(word1.charAt(idx1)==word2.charAt(idx2)){
//            return 1+solve(idx1-1,idx2-1,word1,word2);
//        }
//        return Math.max(solve(idx1-1,idx2,word1,word2),solve(idx1,idx2-1,word1,word2));
//    }
//    public int longestCommonSubsequence(String text1, String text2) {
//        int l1=text1.length(),l2=text2.length();
//        return solve(l1-1,l2-1,text1,text2);
//    }

    // 2.Memoization
//    int solve(int idx1,int idx2,String word1,String word2,int dp[][]){
//        if(idx1<0 || idx2<0) return 0;
//        if(dp[idx1][idx2]!=-1) return dp[idx1][idx2];
//
//        if(word1.charAt(idx1)==word2.charAt(idx2)){
//            return dp[idx1][idx2]=1+solve(idx1-1,idx2-1,word1,word2,dp);
//        }
//        return dp[idx1][idx2]=Math.max(solve(idx1-1,idx2,word1,word2,dp),solve(idx1,idx2-1,word1,word2,dp));
//    }
//    public int longestCommonSubsequence(String text1, String text2) {
//        int l1=text1.length(),l2=text2.length();
//        int dp[][]=new int[l1][l2];
//        for(int d[]:dp){
//            Arrays.fill(d,-1);
//        }
//        return solve(l1-1,l2-1,text1,text2,dp);
//    }

    // 3.Tabulation
//    int longestCommonSubsequence(String text1, String text2) {
//        int l1=text1.length(),l2=text2.length();
//        int dp[][]=new int[l1+1][l2+1];
//        for(int i=1;i<=l1;i++){
//            for(int j=1;j<=l2;j++){
//                if(text1.charAt(i-1)==text2.charAt(j-1)){
//                    dp[i][j]=1+dp[i-1][j-1];
//                }
//                else{
//                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
//                }
//            }
//        }
//        return dp[l1][l2];
//    }

    // 4.Space Optimisation
    int longestCommonSubsequence(String text1, String text2) {
        int l1=text1.length(),l2=text2.length();
        int prev[]=new int[l2+1];
        for(int i=1;i<=l1;i++){
            int curr[]=new int[l2+1];
            for(int j=1;j<=l2;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    curr[j]=1+prev[j-1];
                }
                else{
                    curr[j]=Math.max(prev[j],curr[j-1]);
                }
            }
            prev=curr;
        }
        return prev[l2];
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Longest_Common_Subsequence ob = new Longest_Common_Subsequence();
        String word1="abcde";
        String word2="ace";
        int res=ob.longestCommonSubsequence(word1,word2);
        System.out.println("Length of longest common subsequence is: "+res);
    }
}
