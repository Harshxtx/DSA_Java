package Dynamic_Programming.DP_1D;

import java.util.*;

public class House_Robber_II {
    int solve(int[] nums,int start,int end) {
        int n=nums.length;
        int prev2=0;
        int prev1=0;
        for(int i=start;i<=end;i++){
            int curr=Math.max(prev1,prev2+nums[i]);
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
    public int rob(int[] nums) {
        if(nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
        if(nums.length==2)
            return Math.max(nums[0],nums[1]);
        int n=nums.length;
        int ans1=solve(nums,0,n-2);
        int ans2=solve(nums,1,n-1);
        return Math.max(ans1,ans2);
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        House_Robber_II ob = new House_Robber_II();
        int arr[]={1,2,3,1};
        int rob=ob.rob(arr);
        System.out.println("The max amt of money robbed in the house arrange in circle:"+rob);
    }
}
