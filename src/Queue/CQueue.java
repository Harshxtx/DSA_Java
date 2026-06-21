package Queue;

import java.util.*;
public class CQueue {
    int[] arr;
    int front;
    int rear;
    int size;
    int capacity;

    CQueue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];

        front = 0;
        rear = -1;
        size = 0;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public boolean isFull() {
        return size == capacity;
    }
    public int size() {
        return size;
    }
    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue Overflow");
            return;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = data;
        size++;
    }
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }
        int removed = arr[front];
        front = (front + 1) % capacity;
        size--;
        return removed;
    }
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        return arr[front];
    }
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }
        System.out.print("Front -> ");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.print(arr[index] + " ");
        }
        System.out.println("<- Rear");
    }
    public static void main(String[] args) {
        CQueue q = new CQueue(5);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);

        q.display();
        System.out.println("Removed: " + q.dequeue());
        System.out.println("Removed: " + q.dequeue());
        q.display();
        q.enqueue(50);
        q.enqueue(60);
        q.display();
        System.out.println("Front Element: " + q.peek());
        System.out.println("Size: " + q.size());
        System.out.println("Is Empty: " + q.isEmpty());
        System.out.println("Is Full: " + q.isFull());
    }
}
