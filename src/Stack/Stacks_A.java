package Stack;

public class Stacks_A {
    int[] stack;
    int top;
    int capacity;
    Stacks_A(int size) {
        capacity = size;
        stack = new int[capacity];
        top = -1;
    }
    void push(int value) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        stack[++top] = value;
        System.out.println(value + " pushed into stack");
    }
    int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return stack[top--];
    }
    int peek() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return stack[top];
    }
    boolean isEmpty() {
        return top == -1;
    }

    int size() {
        return top + 1;
    }
    void display() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return;
        }
        System.out.print("Stack: ");
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Stacks_A st = new Stacks_A(5);

        st.push(10);                    //adding value in stack
        st.push(20);
        st.push(30);

        st.display();

        System.out.println("Top Element: " + st.peek());    //display the last element

        System.out.println("Popped: " + st.pop());          //remove the last element

        st.display();

        System.out.println("Size: " + st.size());
    }
}
