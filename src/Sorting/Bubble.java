package Sorting;

import java.util.*;

public class Bubble {
    void BubbleSort(int arr[]){                 //Time Complexity: O(n^2)
        int i,j,l=arr.length;
        for(i=0;i<l-1;i++)
        {
            for(j=0;j<l-1-i;j++)
            {
                if(arr[j]>arr[j+1])
                {
                    int t=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=t;
                }
            }
        }
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Bubble ob = new Bubble();
        int arr[]={1,4,6,3,7,5,2};
        System.out.println("Array before sorted: "+Arrays.toString(arr));
        ob.BubbleSort(arr);
        System.out.println("Array after sorted: "+Arrays.toString(arr));
    }
}
