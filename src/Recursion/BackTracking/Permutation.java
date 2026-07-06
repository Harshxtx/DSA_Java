package Recursion.BackTracking;

import java.util.*;

public class Permutation {
      // 2nd method
//    void swap(int i, int idx,int arr[])
//    {
//        int t=arr[i];
//        arr[i]=arr[idx];
//        arr[idx]=t;
//    }
//    void perm(int idx, int arr[], List<List<Integer>> lt)
//    {
//        if(idx==arr.length)
//        {
//            List<Integer> t=new ArrayList<>();
//            int i,l=arr.length;
//            for(i=0;i<l;i++)
//                t.add(arr[i]);
//            lt.add(t);
//            return;
//        }
//        int i,len=arr.length;
//        for(i=idx;i<len;i++)
//        {
//            swap(i,idx,arr);      // choose current element
//            perm(idx+1,arr,lt);   // explore remaining positions
//            swap(i,idx,arr);      // undo (backtrack)
//        }
//    }
    // 1st method
    void perm(int arr[], List<List<Integer>> lt,List<Integer> t, boolean vis[])
    {
        if(t.size()==arr.length)
        {
            lt.add(new ArrayList<>(t));
            return;
        }
        int i,len=arr.length;
        for(i=0;i<len;i++)
        {
            if(!vis[i]){
                vis[i]=true;
                t.add(arr[i]);
                perm(arr,lt,t,vis);
                t.remove(t.size()-1);
                vis[i]=false;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lt=new ArrayList<>();
        List<Integer> t=new ArrayList<>();
        boolean vis[]=new boolean[nums.length];
        //perm(0,nums,lt);
        perm(nums,lt,t,vis);
        return lt;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Permutation ob = new Permutation();
        int arr[]={1,2,3};
        List<List<Integer>> res=ob.permute(arr);
        for(List<Integer> lt: res){
            System.out.print(lt+" ");
        }
    }
}
