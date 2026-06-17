package Stack;

import java.util.*;

public class Stacks {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        Stack<Integer> stack = new Stack<>();           //Space Complexity: O(n)

        // push                                         //Time Complexity:
        stack.push(10);
        stack.push(20);
        stack.push(30);

        //printing whole stack                          //Time Complexity: O(1)
        System.out.println("Stack: " + stack);

        // peek()                                       //Time Complexity: O(1)
        System.out.println("Top Element: " + stack.peek());

        // pop()                                         //Time Complexity: O(1)
        System.out.println("Popped Element: " + stack.pop());
        System.out.println("Stack after pop: " + stack);

        // isEmpty()                                     //Time Complexity: O(1)
        System.out.println("Is Stack Empty? " + stack.isEmpty());

        // size()                                         //Time Complexity: O(1)
        System.out.println("Size of Stack: " + stack.size());

        // search()                                       //Time Complexity: O(n)
        System.out.println("Position of 10 from top: " + stack.search(10));

        // contains()                                       //Time Complexity: O(n)
        System.out.println("Is 10 available in Stack?: " + stack.contains(10));

        // clear()
        stack.clear();

        System.out.println("Stack after clear: " + stack);
    }
}
