package Heap.Problems;

import java.util.*;

public class Top_K_Frequent {
    int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp=new HashMap<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b) -> mp.get(a)-mp.get(b));
        for(int n: nums){
            mp.put(n,mp.getOrDefault(n,0)+1);
        }
        for(int n: mp.keySet()){
            pq.add(n);
            if(pq.size()>k)
                pq.poll();
        }
        int res[]=new int[k];
        for(int i=0;i<k;i++)
            res[i]=pq.poll();
        return res;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Top_K_Frequent ob = new Top_K_Frequent();
        int arr[]={1,2,1,2,1,2,3,1,3,2};
        int k=2;
        int res[]=ob.topKFrequent(arr,k);
        System.out.println("The K frequent elements in the array are: "+Arrays.toString(res));
    }
}
