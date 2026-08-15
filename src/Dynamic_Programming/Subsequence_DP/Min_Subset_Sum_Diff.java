package Dynamic_Programming.Subsequence_DP;

import java.util.*;

public class Min_Subset_Sum_Diff {
    // Tabulation
    int minDifference(int arr[]) {
        int maxSum=0;
        for(int n:arr){
            maxSum+=n;
        }

        int n=arr.length;
        boolean dp[][]=new boolean[n][maxSum+1];
        for(int i=0;i<n;i++){
            dp[i][0]=true;
        }
        if(arr[0]<=maxSum)
            dp[0][arr[0]]=true;

        for(int i=1;i<n;i++){
            for(int target=1;target<=maxSum;target++){

                boolean take=false;
                if(arr[i]<=target)
                    take=dp[i-1][target-arr[i]];
                boolean notTake=dp[i-1][target];

                dp[i][target]=take||notTake;
            }
        }

        int min=(int)1e9;
        for(int i=0;i<=maxSum/2;i++){
            if(dp[n-1][i]==true)
                min=Math.min(min,Math.abs((maxSum-i)-i));
        }
        return min;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Min_Subset_Sum_Diff ob = new Min_Subset_Sum_Diff();
        int arr[]={1,6,11,5};
        int res=ob.minDifference(arr);
        System.out.println("Minimum difference in partition of two subsets: "+res);
    }
}
