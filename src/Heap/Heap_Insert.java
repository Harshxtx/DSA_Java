package Heap;
// Max Heap - Insertion
//
// Inserts a new element into a Max Heap while
// maintaining the Heap Property.
//
// Algorithm:
// 1. Insert the element at the last position.
// 2. Compare it with its parent.
// 3. If the parent is smaller, swap them.
// 4. Repeat until the Heap Property is restored.
//
// This process is called Heapify Up (Bubble Up).
//
// Time Complexity: O(log n)
// Space Complexity: O(1)

import java.util.*;

public class Heap_Insert {
    ArrayList<Integer> heap = new ArrayList<>();

    void insert(int val){
        heap.add(val);
        int index=heap.size()-1;

        while(index>0){
            int parent = (index-1)/2;

            if(heap.get(parent) < heap.get(index)){
                int temp=heap.get(parent);
                heap.set(parent,heap.get(index));
                heap.set(index,temp);
                index = parent;
            }
            else{
                break;
            }
        }
    }

    void display(){
        System.out.println(heap);
    }
    public static void main(String[] args) {
        Heap_Insert h = new Heap_Insert();
        h.insert(10);
        h.insert(20);
        h.insert(30);
        h.insert(40);
        h.insert(50);
        h.insert(60);

        System.out.print("Heap after insertion: ");
        h.display();
    }
}