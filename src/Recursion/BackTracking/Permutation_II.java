package Recursion.BackTracking;

import java.util.*;

public class Permutation_II {
    void swap(int i, int idx,int arr[])
    {
        int t=arr[i];
        arr[i]=arr[idx];
        arr[idx]=t;
    }
    void perm(int idx, int arr[], List<List<Integer>> lt)
    {
        if(idx==arr.length)
        {
            List<Integer> t=new ArrayList<>();
            int i,l=arr.length;
            for(i=0;i<l;i++)
                t.add(arr[i]);
            lt.add(t);
        }
        Set<Integer> visited = new HashSet<>();
        int i,len=arr.length;
        for(i=idx;i<len;i++)
        {
            if (visited.contains(arr[i])) {
                continue;
            }
            visited.add(arr[i]);
            swap(i,idx,arr);
            perm(idx+1,arr,lt);
            swap(i,idx,arr);
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        int i,l=nums.length;
        List<List<Integer>> lt=new ArrayList<>();
        Arrays.sort(nums);
        perm(0,nums,lt);
        return lt;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Permutation_II ob = new Permutation_II();
        int arr[]={1,1,2};
        List<List<Integer>> res=ob.permuteUnique(arr);
        System.out.println(res);
    }
}
