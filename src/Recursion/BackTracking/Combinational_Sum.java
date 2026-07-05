package Recursion.BackTracking;

import java.util.*;

public class Combinational_Sum {
    void findsum(int idx,int arr[],int target,List<List<Integer>> ds,List<Integer> ans){
        if(idx==arr.length){
            if(target==0){
                ds.add(new ArrayList<>(ans));
            }
            return;
        }
        if(target>=arr[idx]){
            ans.add(arr[idx]);                                  // choose current element
            findsum(idx,arr,target-arr[idx],ds,ans);    // explore with same value
            ans.remove(ans.size()-1);                  //undo choice
        }
        findsum(idx+1,arr,target,ds,ans);              // skip current element
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        findsum(0,candidates,target,res,new ArrayList<>());
        return res;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Combinational_Sum ob = new Combinational_Sum();
        int arr[]={2,3,6,5};
        int target=8;
        List<List<Integer>> res=ob.combinationSum(arr,target);
        System.out.println(res);
    }
}
