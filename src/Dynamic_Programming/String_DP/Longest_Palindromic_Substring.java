package Dynamic_Programming.String_DP;

import java.util.*;

public class Longest_Palindromic_Substring {
    // 1.
//    String longestPalindrome(String s) {
//        int n = s.length();
//        boolean[][] dp = new boolean[n][n];
//
//        int start = 0;
//        int maxLen = 1;
//
//        for (int i = n - 1; i >= 0; i--) {
//            for (int j = i; j < n; j++) {
//
//                if (s.charAt(i) == s.charAt(j)) {
//
//                    if (j - i <= 2 || dp[i + 1][j - 1]) {
//                        dp[i][j] = true;
//
//                        if (j - i + 1 > maxLen) {
//                            maxLen = j - i + 1;
//                            start = i;
//                        }
//                    }
//                }
//            }
//        }
//
//        return s.substring(start, start + maxLen);
//    }

    // 2.
    String longestPalindrome(String s) {
        int l=s.length();
        int maxLen=0;
        int dp[][]=new int[l+1][l+1];
        int st=0;
        for(int i=1;i<=l;i++){
            for(int j=1;j<=l;j++){
                if(s.charAt(i-1)==s.charAt(l-j)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                if(maxLen<dp[i][j]){
                    int ost=i-dp[i][j];
                    int revst=l-j;
                    if(ost==revst){
                        maxLen=dp[i][j];
                        st=ost;
                    }
                }
            }
        }
        return s.substring(st,st+maxLen);
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Longest_Palindromic_Substring ob = new Longest_Palindromic_Substring();
        String st="babad";
        String res=ob.longestPalindrome(st);
        System.out.println("Longest Palindromic Substring: "+res);
    }
}
