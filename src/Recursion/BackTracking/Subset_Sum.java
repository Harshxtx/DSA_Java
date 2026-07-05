package Recursion.BackTracking;

import java.util.*;

public class Subset_Sum {
    void solve(int idx,int nums[],int sum, List<Integer> t){
        if(idx==nums.length){
            t.add(sum);
            return;
        }
        solve(idx+1,nums,sum+nums[idx],t);          // include current element in sum
        solve(idx+1,nums,sum,t);                         // exclude current element
    }
    List<Integer> subsetSums(int[] arr) {
        List<Integer> ans=new ArrayList<>();
        solve(0,arr,0,ans);
        Collections.sort(ans);
        return ans;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Subset_Sum ob = new Subset_Sum();
        int arr[]={1,2,3};
        List<Integer> res=ob.subsetSums(arr);
        System.out.println(res);
    }
}
