package Recursion.BackTracking;

import java.util.*;

public class Subset_II {
    void solve(int idx,int nums[], List<List<Integer>> lt, List<Integer> t){
        lt.add(new ArrayList<>(t));
        for(int i=idx;i<nums.length;i++){
            if(i>idx && nums[i]==nums[i-1])
                continue;
            t.add(nums[i]);
            solve(i+1,nums,lt,t);
            t.remove(t.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> lt=new ArrayList<>();
        Arrays.sort(nums);
        solve(0,nums,lt,new ArrayList<>());
        return lt;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Subset_II ob = new Subset_II();
        int arr[]={1,2,2};
        List<List<Integer>> res=ob.subsetsWithDup(arr);
        System.out.println(res);
    }
}
