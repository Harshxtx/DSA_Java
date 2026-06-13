package Sorting;

import java.util.*;

public class Quick {
    void quickSort(int arr[], int low, int high) {          //Time complexity: O(n log n) in avg and O(n^2) in worst
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }
    int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Quick ob = new Quick();
        int arr[] = {1, 4, 6, 3, 7, 5, 2};
        System.out.println("Array before sorted: " + Arrays.toString(arr));
        ob.quickSort(arr,0,arr.length-1);
        System.out.println("Array after sorted: " + Arrays.toString(arr));
    }
}
