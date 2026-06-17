package Stack;

import java.util.*;
class Stacks_AL {
    ArrayList<Integer> stack = new ArrayList<>();
    void push(int value) {
        stack.add(value);
        System.out.println(value + " pushed into stack");
    }
    int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return stack.remove(stack.size() - 1);
    }
    int peek() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return stack.get(stack.size() - 1);
    }
    boolean isEmpty() {
        return stack.isEmpty();
    }
    int size() {
        return stack.size();
    }
    void display() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return;
        }
        System.out.print("Stack: ");
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.print(stack.get(i) + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Stacks_AL st = new Stacks_AL();
        st.push(10);
        st.push(20);
        st.push(30);

        st.display();

        System.out.println("Top Element: " + st.peek());

        System.out.println("Popped: " + st.pop());

        st.display();

        System.out.println("Size: " + st.size());
    }
}
