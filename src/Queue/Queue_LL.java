package Queue;

import java.util.*;
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}
public class Queue_LL {
    Node front;
    Node rear;
    int size;

    public boolean isEmpty() {
        return front == null;
    }
    public int size() {
        return size;
    }
    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }
        int removed = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return removed;
    }
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        return front.data;
    }
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }
        Node temp = front;
        System.out.print("Front -> ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("<- Rear");
    }
    public static void main(String[] args) {
        Queue_LL q = new Queue_LL();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        q.display();
        System.out.println("Removed: " + q.dequeue());
        q.display();
        System.out.println("Front Element: " + q.peek());
        System.out.println("Size: " + q.size());
        System.out.println("Is Empty: " + q.isEmpty());
    }
}
