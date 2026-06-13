package Sorting;

import java.util.*;

public class Counting {
    void countingSort(int arr[]) {                  //Time Complexity: O(n+k)
        int max = Arrays.stream(arr).max().getAsInt();
        int count[] = new int[max + 1];
        for (int num : arr)
            count[num]++;

        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[index++] = i;
                count[i]--;
            }
        }
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Counting ob = new Counting();
        int arr[] = {4, 2, 2, 8, 3, 3, 1};
        System.out.println("Array before sorted: " + Arrays.toString(arr));
        ob.countingSort(arr);
        System.out.println("Array after sorted: " + Arrays.toString(arr));
    }
}
