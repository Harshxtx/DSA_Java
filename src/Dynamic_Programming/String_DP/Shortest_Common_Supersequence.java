package Dynamic_Programming.String_DP;

import java.util.*;

public class Shortest_Common_Supersequence {
    String shortestCommonSupersequence(String str1, String str2) {
        int l1=str1.length(),l2=str2.length();
        int dp[][]=new int[l1+1][l2+1];
        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l2;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }                                           //return (l1+l2)-dp[l1][l2] to get the length
        String ans="";
        int i=l1,j=l2;
        while(i>0 && j>0){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                ans=str1.charAt(i-1)+ans;
                i--;
                j--;
            }
            else if(dp[i-1][j]>dp[i][j-1]){
                ans=str1.charAt(i-1)+ans;
                i--;
            }
            else{
                ans=str2.charAt(j-1)+ans;
                j--;
            }

        }
        while(i>0){
            ans=str1.charAt(i-1)+ans;
            i--;
        }
        while(j>0){
            ans=str2.charAt(j-1)+ans;
            j--;
        }
        return ans;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Shortest_Common_Supersequence ob = new Shortest_Common_Supersequence();
        String s1="abac",s2="cab";
        String res= ob.shortestCommonSupersequence(s1,s2);
        System.out.println("Shortest Common Supersequence: "+res);
    }
}
