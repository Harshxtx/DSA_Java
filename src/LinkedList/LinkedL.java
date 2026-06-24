package LinkedList;

import java.util.*;

public class LinkedL {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<>();           //works as a doubly-linkedlist

        // Add Elements                                 //Time Complexity: O(1)
        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println("Linked List: "+ list);

        // Add at Beginning                             //Time Complexity: O(1)
        list.addFirst(5);

        // Add at End                                   //Time Complexity: O(1)
        list.addLast(40);

        System.out.println("\nAfter addFirst & addLast:");
        System.out.println(list);

        // Add at Specific Index(index,value)            //Time Complexity: O(n)
        list.add(2, 15);

        System.out.println("\nAfter add at index:");
        System.out.println(list);

        // Get Elements
        //System.out.println("\nFirst Element: "+ list.getFirst());     //Time Complexity: O(1)  // will throw error if list is empty
        System.out.println("\nFirst Element: "+list.peekFirst());       //will return null if list is empty
        //System.out.println("Last Element: "+ list.getLast());         //Time Complexity: O(1)  // will throw error if list is empty
        System.out.println("Last Element: "+ list.peekLast());          //will return null if list is empty
        System.out.println("Element at Index 2: "+ list.get(2));        //Time Complexity: O(n)

        // Remove Elements
        list.removeFirst();                                         //Time Complexity: O(1)
        list.removeLast();                                          //Time Complexity: O(1)
        list.remove(1);                                       //Time Complexity: O(n)

        System.out.println("\nAfter Removals:");
        System.out.println(list);

        // Search                                                   //Time Complexity: O(n)
        System.out.println("\nContains 20? "+ list.contains(20));
        System.out.println("Contains 100? "+ list.contains(100));

        // Size                                                     //Time Complexity: O(1)
        System.out.println("\nSize: "+ list.size());

        // Empty Check                                              //Time Complexity: O(1)
        System.out.println("Is Empty: "+ list.isEmpty());

        // Traversal                                                //Time Complexity: O(n)
        System.out.println("\nTraversal:");
        for(Integer val : list){
            System.out.print(val + ", ");
        }

        // Clear                                                    //Time Complexity: O(n)
        list.clear();

        System.out.println("\n\nAfter clear(): "+ list);
    }
}
