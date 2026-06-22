package Queue.Problems;

import java.util.*;

public class Kth_Lar_Ele {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int i,l=nums.length;
        for(int n:nums){
            pq.offer(n);
        }
        for(i=1;i<k;i++){
            pq.poll();
        }
        return pq.poll();
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Kth_Lar_Ele ob = new Kth_Lar_Ele();
        int arr[]={3,2,1,5,6,4};
        int k=2;
        System.out.println("The 2nd largest element is:"+ob.findKthLargest(arr,k));
    }
}
