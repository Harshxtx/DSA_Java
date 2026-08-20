package Dynamic_Programming.String_DP;

import java.util.*;

public class Min_Ins_Del_to_Convert_String {
    int minOperations(String s1, String s2) {
        int l1=s1.length(),l2=s2.length();
        int dp[][]=new int[l1+1][l2+1];
        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int res=dp[l1][l2];
        return (l1+l2)-2*res;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Min_Ins_Del_to_Convert_String ob = new Min_Ins_Del_to_Convert_String();
        String s1="geeksforgeeks", s2="geeks";
        int min=ob.minOperations(s1,s2);
        System.out.println("Minimum Operations required: "+min);
    }
}
