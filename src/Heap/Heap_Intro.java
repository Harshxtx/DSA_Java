package Heap;
// Heap
//
// A Heap is a Complete Binary Tree that satisfies the Heap Property.
//
// Types of Heap:
// 1. Max Heap
//    - Parent node >= Children
//    - Root contains the largest element.
//
// 2. Min Heap
//    - Parent node <= Children
//    - Root contains the smallest element.
//
// Complete Binary Tree:
// - Every level is completely filled except possibly the last.
// - Last level is filled from left to right.
// - First Element is always the root or maximum(or minimum) element in max(or min)heap
//
// Array Representation:
// Parent(i)      = (i - 1) / 2
// Left Child(i) = 2 * i + 1
// Right Child(i)= 2 * i + 2
//
// Common Operations:
//
// Insert      : O(log n)
// Delete Root : O(log n)
// Peek Root   : O(1)
// Heapify     : O(log n)
// Build Heap  : O(n)
//
// Applications:
// - Priority Queue
// - Heap Sort
// - Kth Largest / Smallest Element
// - Median of Data Stream
// - Merge K Sorted Arrays/Lists
// - Dijkstra's Algorithm
// - Prim's Algorithm


import java.util.*;

public class Heap_Intro {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Heap_Intro ob = new Heap_Intro();

        // Max Heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.offer(10);
        maxHeap.offer(5);
        maxHeap.offer(30);
        maxHeap.offer(20);

        System.out.println("Max Heap Root: " + maxHeap.peek());

        // Min Heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(10);
        minHeap.offer(5);
        minHeap.offer(30);
        minHeap.offer(20);

        System.out.println("Min Heap Root: " + minHeap.peek());
    }
}
