package Sorting;

import java.util.*;

public class Selection {
    void SelectionSort(int arr[]){                      //Time Complexity: O(n^2)
        int i,j,l=arr.length;
        for(i=0;i<l-1;i++)
        {
            int d=i;
            for(j=i+1;j<l;j++)
            {
                if(arr[j]<arr[d])
                    d=j;
            }
            int t=arr[i];
            arr[i]=arr[d];
            arr[d]=t;
        }
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Selection ob = new Selection();
        int arr[] = {1, 4, 6, 3, 7, 5, 2};
        System.out.println("Array before sorted: " + Arrays.toString(arr));
        ob.SelectionSort(arr);
        System.out.println("Array after sorted: " + Arrays.toString(arr));
    }
}
