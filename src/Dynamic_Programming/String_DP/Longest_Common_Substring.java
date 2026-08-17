package Dynamic_Programming.String_DP;

import java.util.*;

class Longest_Common_Substring {
    int longCommSubstr(String s1, String s2) {
        int l1=s1.length(),l2=s2.length();
        int maxLen=0;
        int dp[][]=new int[l1+1][l2+1];
        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                maxLen=Math.max(maxLen,dp[i][j]);
            }
        }
        return maxLen;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Longest_Common_Substring ob = new Longest_Common_Substring();
        String s1 = "ABCDGH", s2 = "ACDGHR";
        int len= ob.longCommSubstr(s1,s2);
        System.out.println("Maximum length of the common Substring: "+len);
    }
}
