package Queue.Priority_Queue;

import java.util.*;

public class MinHeap {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();      //Smallest element gets highest priority: MinHeap

        // Enqueue                                        //Time Complexity: O(log n)
        pq.offer(10);
        pq.offer(5);
        pq.offer(20);
        pq.offer(1);

        System.out.println(pq);                     // Internal heap representation, not sorted order

//        while (!pq.isEmpty()) {                   //will prioritize
//            System.out.println(pq.poll());
//        }

        // Peek                                         //Time Complexity: O(1)
        System.out.println("Front Element: " + pq.peek());

        // Dequeue                                     //Time Complexity: O(log n)
        System.out.println("Removed: " + pq.poll());

        // Empty Check                                 //Time Complexity: O(1)
        System.out.println("Is Empty: " + pq.isEmpty());

        // Size                                         //Time Complexity: O(1)
        System.out.println("Size: " + pq.size());

        System.out.println("Queue: " + pq);

        // contains()                                       //Time Complexity: O(n)
        System.out.println("Is 10 available in Stack?: " + pq.contains(10));

        // clear()                                          // Time Complexity: O(n)
        pq.clear();

        System.out.println("Queue: " + pq);
    }
}
