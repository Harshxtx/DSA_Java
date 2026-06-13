package Sorting;

import java.util.*;

public class Insertion {
    void InsertionSort(int arr[]){                      //Time Complexity: O(n^2)
        int i,l=arr.length;
        for(i=1;i<l;i++)
        {
            int min=arr[i];
            int j=i-1;
            while(j>=0 && min<arr[j])
            {
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=min;
        }
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Insertion ob = new Insertion();
        int arr[] = {1, 4, 6, 3, 7, 5, 2};
        System.out.println("Array before sorted: " + Arrays.toString(arr));
        ob.InsertionSort(arr);
        System.out.println("Array after sorted: " + Arrays.toString(arr));
    }
}
