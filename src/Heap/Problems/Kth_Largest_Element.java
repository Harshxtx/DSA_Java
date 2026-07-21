package Heap.Problems;

import java.util.*;

public class Kth_Largest_Element {
    int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
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
        Kth_Largest_Element ob = new Kth_Largest_Element();
        int arr[]={3,2,1,5,6,4};
        int k=2;
        int largest=ob.findKthLargest(arr, k);
        System.out.println("The 2nd Largest element in the array: "+largest);
    }
}
