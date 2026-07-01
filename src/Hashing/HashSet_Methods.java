package Hashing;

import java.util.*;

public class HashSet_Methods {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        HashSet<Integer> set = new HashSet<>();

        // add()         // O(1) average          //It stores values as HashMap keys
        set.add(10);
        set.add(20);
        set.add(30);

        // duplicate ignored
        set.add(20);
        System.out.println("HashSet:");
        System.out.println(set);

        // contains()      // O(1) average
        System.out.println("\nContains 20? "+set.contains(20));
        System.out.println("Contains 100? "+set.contains(100));

        // remove()        // O(1) average
        set.remove(10);
        System.out.println("\nAfter removing 10:");
        System.out.println(set);

        // size()          // O(1)
        System.out.println("\nSize: "+set.size());
        // isEmpty()       // O(1)
        System.out.println("Is Empty: "+set.isEmpty());

        // Traversal       // O(n)
        System.out.println("\nTraversal:");
        for(Integer val : set) {
            System.out.print(val + " ");
        }

        // clear()         // O(n)
        set.clear();
        System.out.println("\n\nAfter clear():");
        System.out.println(set);
    }
}
