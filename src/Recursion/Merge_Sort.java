package Recursion;

import java.util.*;

public class Merge_Sort {
    void merge(int arr[], int start, int mid, int end) {
        int a[] = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;

        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j])
                a[k++] = arr[i++];
            else
                a[k++] = arr[j++];
        }

        while (i <= mid) {
            a[k++] = arr[i++];
        }
        while (j <= end) {
            a[k++] = arr[j++];
        }
        for (i = 0; i < k; i++)
            arr[i + start] = a[i];
    }

    void MergeSort(int arr[], int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            MergeSort(arr, start, mid);
            MergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Merge_Sort ob = new Merge_Sort();
        int arr[] = {1, 4, 6, 3, 7, 5, 2};
        System.out.println("Array before sorted: " + Arrays.toString(arr));
        ob.MergeSort(arr, 0, arr.length - 1);
        System.out.println("Array after sorted: " + Arrays.toString(arr));
    }
}
