package Heap;
// Build Max Heap
//
// Converts an unsorted array into a Max Heap.
//
// Algorithm:
// 1. Start from the last non-leaf node.
// 2. Perform Heapify on every node
//    moving towards the root.
//
// Last Non-Leaf Node:
// (n / 2) - 1
//
// Bottom-Up Heap construction is more efficient
// than inserting elements one by one.
//
// Time Complexity: O(n)
// Space Complexity: O(log n)

import java.util.*;

public class Build_Heap {

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
            arr[index]=arr[largest];
            arr[largest]=temp;
            heapify(arr,n,largest);
        }
    }

    void buildHeap(int arr[]){
        int n=arr.length;
        for(int i=n/2-1;i>=0;i--){
            heapify(arr,n,i);
        }
    }

    public static void main(String[] args) {
        Build_Heap obj=new Build_Heap();

        int arr[]={10,40,30,20,15};

        obj.buildHeap(arr);

        System.out.println(Arrays.toString(arr));
    }
}