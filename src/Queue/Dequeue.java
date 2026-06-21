package Queue;

import java.util.*;

public class Dequeue {
    public static void main(String[] args) {
        Deque<Integer> dq = new ArrayDeque<>();

        // Insert at Rear                               //Time Complexity: O(1)
        dq.offerLast(10);
        dq.offerLast(20);

        // Insert at Front                              //Time Complexity: O(1)
        dq.offerFirst(5);

        System.out.println(dq);

        // Remove from Front                            //Time Complexity: O(1)
        System.out.println("Removed Front: " + dq.pollFirst());

        // Remove from Rear                             //Time Complexity: O(1)
        System.out.println("Removed Rear: "+ dq.pollLast());

        System.out.println(dq);

        // Peek from Front                              //Time Complexity: O(1)
        System.out.println("Front: " + dq.peekFirst());

        // Peek from Rear                               //Time Complexity: O(1)
        System.out.println("Rear: " + dq.peekLast());

        // Empty Check                                  //Time Complexity: O(1)
        System.out.println("Is Empty: " + dq.isEmpty());

        // Size                                         //Time Complexity: O(1)
        System.out.println("Size: " + dq.size());

        System.out.println("Queue: " + dq);

        // contains()                                       //Time Complexity: O(n)
        System.out.println("Is 10 available in Stack?: " + dq.contains(10));

        // clear()
        dq.clear();

        System.out.println("Queue: " + dq);
    }
}