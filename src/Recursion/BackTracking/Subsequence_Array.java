package Recursion.BackTracking;
// Time Complexity: O(2^n * n)
// Space Complexity: O(n)
import java.util.*;

public class Subsequence_Array {
    void solve(int idx,int nums[], List<List<Integer>> lt, List<Integer> t){
        if(idx==nums.length){
            lt.add(new ArrayList<>(t));
            return;
        }
        t.add(nums[idx]);          // choose
        solve(idx+1,nums,lt,t);    // explore
        t.remove(t.size()-1);      // undo (backtrack)
        solve(idx+1,nums,lt,t);    // don't choose
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lt=new ArrayList<>();
        List<Integer> t=new ArrayList<>();
        solve(0,nums,lt,t);
        return lt;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Subsequence_Array ob = new Subsequence_Array();
        int arr[]={1,2,3};
        List<List<Integer>> res=ob.subsets(arr);
        for(List<Integer> lt:res){
            System.out.print(lt+" ");
        }
    }
}
