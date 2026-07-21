package Heap.Problems;

import java.util.*;

public class Kth_Smallest_Element {
    int findKthSmallest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i, l = nums.length;
        for (int n : nums) {
            pq.offer(n);
        }
        for (i = 1; i < k; i++) {
            pq.poll();
        }
        return pq.poll();
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Kth_Smallest_Element ob = new Kth_Smallest_Element();
        int arr[]={3,2,1,5,6,4};
        int k=2;
        int smallest=ob.findKthSmallest(arr, k);
        System.out.println("The 2nd Smallest element in the array: "+smallest);
    }
}
