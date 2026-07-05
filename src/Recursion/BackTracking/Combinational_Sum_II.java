package Recursion.BackTracking;

import java.util.*;

public class Combinational_Sum_II {
    void findsum(int idx,int arr[],int target,List<List<Integer>> lt,List<Integer> t){
        if(target==0){
            lt.add(new ArrayList<>(t));
            return;
        }
        for(int i=idx;i<arr.length;i++){
            if(i>idx && arr[i]==arr[i-1])
                continue;
            if(arr[i]>target)
                break;
            t.add(arr[i]);
            findsum(i+1,arr,target-arr[i],lt,t);
            t.remove(t.size()-1);
        }
    }
    List<List<Integer>> combinationSum2(int[] cand, int target) {
        List<List<Integer>> lt=new ArrayList<>();
        Arrays.sort(cand);
        findsum(0,cand,target,lt,new ArrayList<>());
        return lt;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Combinational_Sum_II ob = new Combinational_Sum_II();
        int arr[]={10,1,2,7,6,1,5};
        int target=8;
        List<List<Integer>> res=ob.combinationSum2(arr,target);
        System.out.println(res);
    }
}
