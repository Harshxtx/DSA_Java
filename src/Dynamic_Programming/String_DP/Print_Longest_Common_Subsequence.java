package Dynamic_Programming.String_DP;

import java.util.*;

public class Print_Longest_Common_Subsequence {
    String allLCS(String text1, String text2) {
        int l1=text1.length(),l2=text2.length();
        int dp[][]=new int[l1+1][l2+1];
        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l2;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        String ans="";
        int i=l1,j=l2;
        while(i>0 && j>0){
            if(text1.charAt(i-1)==text2.charAt(j-1)){
                ans=text1.charAt(i-1)+ans;
                i--;j--;
            }
            else if(dp[i-1][j]>dp[i][j-1]){
                i--;
            }
            else{
                j--;
            }
        }
        return ans;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Print_Longest_Common_Subsequence ob = new Print_Longest_Common_Subsequence();
        String word1="abcde";
        String word2="ace";
        String res=ob.allLCS(word1,word2);
        System.out.println("Longest common subsequence is: "+res);
    }
}
