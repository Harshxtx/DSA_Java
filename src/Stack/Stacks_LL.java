package Stack;

import java.util.*;
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}
public class Stacks_LL {
    private Node top;
    private int size;

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        size++;
    }
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        int popped = top.data;
        top = top.next;
        size--;
        return popped;
    }
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return top.data;
    }
    public boolean isEmpty() {
        return top == null;
    }
    public int size() {
        return size;
    }
    public void display() {
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Stacks_LL stack = new Stacks_LL();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.display();

        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());

        stack.display();
    }
}
