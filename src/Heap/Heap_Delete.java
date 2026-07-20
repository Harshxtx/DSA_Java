package Heap;
// Max Heap - Delete Root
//
// Deletes the root element (maximum element)
// from a Max Heap.
//
// Algorithm:
// 1. Replace the root with the last element.
// 2. Remove the last element.
// 3. Compare the root with its children.
// 4. Swap with the larger child if necessary.
// 5. Repeat until the Heap Property is restored.
//
// This process is called Heapify Down (Bubble Down).
//
// Time Complexity: O(log n)
// Space Complexity: O(1)

import java.util.*;

public class Heap_Delete {
    ArrayList<Integer> heap = new ArrayList<>();

    void insert(int val){
        heap.add(val);
        int index=heap.size()-1;

        while(index>0){
            int parent=(index-1)/2;

            if(heap.get(parent)<heap.get(index)){
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
    void delete(){
        if(heap.size()==0)
            return;
        int last = heap.size()-1;
        heap.set(0, heap.get(last));
        heap.remove(last);
        heapify(0);
    }

    void heapify(int index){
        int largest = index;
        int left = 2*index+1;
        int right = 2*index+2;

        if(left<heap.size() && heap.get(left)>heap.get(largest))
            largest = left;

        if(right<heap.size() && heap.get(right)>heap.get(largest))
            largest = right;

        if(largest!=index){
            int temp = heap.get(index);
            heap.set(index, heap.get(largest));
            heap.set(largest,temp);
            heapify(largest);
        }
    }

    void display(){
        System.out.println(heap);
    }

    public static void main(String[] args) {
        Heap_Delete h = new Heap_Delete();

        h.insert(50);
        h.insert(30);
        h.insert(40);
        h.insert(10);
        h.insert(5);
        h.insert(20);

        System.out.print("Original Heap: ");
        h.display();

        h.delete();

        System.out.print("After deleting root: ");
        h.display();
    }
}