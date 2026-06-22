package Queue;

import java.util.*;

public class BuiltInQueueLL {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        // Enqueue                                      //Time Complexity: O(1)
        q.offer(10);
        q.offer(20);
        q.offer(30);

        System.out.println("Queue: " + q);

        // Peek                                         //Time Complexity: O(1)
        System.out.println("Front Element: " + q.peek());

        // Dequeue                                     //Time Complexity: O(1)
        System.out.println("Removed: " + q.poll());

        // Empty Check                                 //Time Complexity: O(1)
        System.out.println("Is Empty: " + q.isEmpty());

        // Size                                         //Time Complexity: O(1)
        System.out.println("Size: " + q.size());

        System.out.println("Queue: " + q);

        // contains()                                       //Time Complexity: O(n)
        System.out.println("Is 10 available in Stack?: " + q.contains(10));

        // clear()                                          // Time Complexity: O(n)
        q.clear();

        System.out.println("Queue: " + q);

    }
}
