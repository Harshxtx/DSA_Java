package Sorting;

import java.util.*;

public class InBuildSort {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        //1. Array
        int arr[] = {1, 4, 6, 3, 7, 5, 2};
        System.out.println("Array before sorted: " + Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("Array after sorted: " + Arrays.toString(arr));
        System.out. println();

        //2. ArrayList
        ArrayList<Integer> list=new ArrayList<>(Arrays.asList(1, 4, 6, 3, 7, 5, 2));
        System.out.println("ArrayList before sorted: " + list);
        Collections.sort(list);
        System.out.println("ArrayList after sorted: " + list);


        //3. Using comparator
        String arr1[] = {"apple", "kiwi", "banana", "fig"};
        Arrays.sort(arr1,(a, b) -> a.length() - b.length());
        System.out.println(Arrays.toString(arr1));

        ArrayList<Integer> lt = new ArrayList<>(Arrays.asList(5, 1, 8, 3, 2));
        Collections.sort(lt, Collections.reverseOrder());
        System.out.println(lt);

        int arr2[][] = {
                {3, 10},
                {1, 20},
                {2, 15}
        };
        Arrays.sort(arr2,(a, b) -> a[0] - b[0]);       //can use: Integer.compare(b, a)
//        Arrays.sort(arr, (a, b) ->            //if first element[0] is equal, then compare by second element[1]
//            if (a[0] != b[0]) {
//                return Integer.compare(a[0], b[0]);
//            }
//            return Integer.compare(a[1], b[1]);
//        });
        for (int row[] : arr2)
            System.out.println(Arrays.toString(row));
    }
}
