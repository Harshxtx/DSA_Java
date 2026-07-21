package Heap;
// Heapify
//
// Heapify restores the Heap Property for a subtree
// rooted at a given index.
//
// For Max Heap:
// - Compare the current node with its left and right child.
// - Find the largest among them.
// - If the largest is not the current node,
//   swap them.
// - Recursively heapify the affected subtree.
//
// Heapify assumes that the left and right subtrees
// are already valid heaps.
//
// Time Complexity: O(log n)
// Space Complexity: O(log n) (Recursive Stack)

import java.util.*;

public class Heapify {

    void heapify(int arr[], int n, int index){
        int largest = index;
        int left = 2*index+1;
        int right = 2*index+2;

        if(left<n && arr[left]>arr[largest])
            largest = left;

        if(right<n && arr[right]>arr[largest])
            largest = right;

        if(largest!=index){
            int temp = arr[index];
            arr[index] = arr[largest];
            arr[largest] = temp;
            heapify(arr,n,largest);
        }
    }

    public static void main(String[] args) {
        Heapify obj = new Heapify();

        int arr[]={20,50,30};

        obj.heapify(arr,arr.length,0);
        System.out.println(Arrays.toString(arr));
    }
}