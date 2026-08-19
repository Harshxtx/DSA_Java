package Dynamic_Programming.String_DP;

import java.util.*;

public class Minimum_Insertions_to_Make_Palindrome {
    int minInsertions(String s) {
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
        return l-dp[l][l];
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Minimum_Insertions_to_Make_Palindrome ob = new Minimum_Insertions_to_Make_Palindrome();
        String st="mbadm";
        int min=ob.minInsertions(st);
        System.out.println("Minimum insertion to make the String Palindrome: "+min);
    }
}
