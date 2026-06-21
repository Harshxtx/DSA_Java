package Queue;

import java.util.*;

public class Queue_A {
    int[] arr;
    int rear;
    int size;
    Queue_A(int capacity) {
        arr = new int[capacity];
        rear = -1;
        size = capacity;
    }
    public boolean isEmpty() {
        return rear == -1;
    }
    public boolean isFull() {
        return rear == size - 1;
    }
    public int size() {
        return rear + 1;
    }
    public void enqueue(int data) {

        if (rear == size - 1) {
            System.out.println("Queue Overflow");
            return;
        }
        arr[++rear] = data;
    }
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }
        int front = arr[0];
        for (int i = 0; i < rear; i++) {
            arr[i] = arr[i + 1];
        }
        rear--;
        return front;
    }
    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return arr[0];
    }
    public void display() {

        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }

        System.out.print("Front -> ");

        for (int i = 0; i <= rear; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println("<- Rear");
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Queue_A q = new Queue_A(5);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        q.display();
        System.out.println("Size: " + q.size());
        System.out.println("Front Element: " + q.peek());
        System.out.println("Removed: " + q.dequeue());
        q.display();
        System.out.println("Is Empty: " + q.isEmpty());
        System.out.println("Is Full: " + q.isFull());
    }
}
