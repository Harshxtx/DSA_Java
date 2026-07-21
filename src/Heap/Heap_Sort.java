package Heap;
// Heap Sort
//
// Heap Sort sorts an array using a Max Heap.
//
// Algorithm:
// 1. Convert the array into a Max Heap.
// 2. Swap the root (maximum element)
//    with the last element.
// 3. Reduce the heap size by one.
// 4. Heapify the root.
// 5. Repeat until the heap size becomes one.
//
// Heap Sort is an in-place comparison sorting algorithm.
//
// Time Complexity:
// Best Case   : O(n log n)
// Average Case: O(n log n)
// Worst Case  : O(n log n)
//
// Space Complexity: O(1)

import java.util.*;

public class Heap_Sort {

    void heapify(int arr[], int n, int index){
        int largest=index;
        int left=2*index+1;
        int right=2*index+2;

        if(left<n && arr[left]>arr[largest])
            largest=left;

        if(right<n && arr[right]>arr[largest])
            largest=right;

        if(largest!=index){
            int temp=arr[index];
            arr[index]=arr[largest];
            arr[largest]=temp;
            heapify(arr,n,largest);
        }
    }
    void heapSort(int arr[]){
        int n=arr.length;
        for(int i=n/2-1;i>=0;i--){
            heapify(arr,n,i);
        }
        for(int i=n-1;i>0;i--){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            heapify(arr,i,0);
        }
    }
    public static void main(String[] args) {
        Heap_Sort obj=new Heap_Sort();

        int arr[]={40,10,30,50,20};

        obj.heapSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}