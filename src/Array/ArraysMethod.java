package Array;

import  java.util.*;
public class ArraysMethod {
        public static void main(String[] args) {

            // Original array
            int[] arr = {5, 2, 8, 1, 9};
            int newarr[]= {5, 2, 8, 1, 9};
            // 1. toString()
            System.out.println("Original Array: " + Arrays.toString(arr));

            // 2. sort()
            Arrays.sort(newarr);
            System.out.println("Sorted Array: " + Arrays.toString(newarr));

            // 3. binarySearch()
            int index = Arrays.binarySearch(newarr, 8);
            System.out.println("Index of 8: " + index);

            // 4. copyOf()
            int[] copy = Arrays.copyOf(arr, arr.length);
            System.out.println("Copied Array: " + Arrays.toString(copy));

            // 5. copyOfRange()
            int[] range = Arrays.copyOfRange(arr, 1, 4);
            System.out.println("Array from index 1 to 3: " + Arrays.toString(range));

            // 6. fill()
            int[] filled = new int[5];
            Arrays.fill(filled, 10);
            System.out.println("Filled Array: " + Arrays.toString(filled));

            // 7. equals()
            int[] arr2 = {5, 2, 1, 8, 9};
            boolean result = Arrays.equals(arr, arr2);
            System.out.println("arr equals arr2? " + result);

            // 8. compare()
            int compareResult = Arrays.compare(arr, arr2);
            System.out.println("Compare Result: " + compareResult);

            // 9. mismatch()
            int mismatchIndex = Arrays.mismatch(arr, arr2);
            System.out.println("Mismatch Index: " + mismatchIndex);

            // 10. parallelSort()
            int[] arr3 = {7, 4, 9, 2, 6};
            Arrays.parallelSort(arr3);
            System.out.println("Parallel Sorted Array: " + Arrays.toString(arr3));

            // 11. setAll()
            int[] squares = new int[5];
            Arrays.setAll(squares, i -> i * i);
            System.out.println("Squares Array: " + Arrays.toString(squares));

            // 12. parallelSetAll()
            int[] cubes = new int[5];
            Arrays.parallelSetAll(cubes, i -> i * i * i);
            System.out.println("Cubes Array: " + Arrays.toString(cubes));

            // 13. parallelPrefix()
            int[] prefix = {1, 2, 3, 4, 5};
            Arrays.parallelPrefix(prefix, (x, y) -> x + y);
            System.out.println("Prefix Sum Array: " + Arrays.toString(prefix));

            // 14. deepToString() for 2D arrays
            int[][] matrix = {
                    {1, 2},
                    {3, 4}
            };
            System.out.println("2D Array: " + Arrays.deepToString(matrix));

            // 15. deepEquals()
            int[][] matrix2 = {
                    {1, 2},
                    {3, 4}
            };
            System.out.println("Matrices Equal? " + Arrays.deepEquals(matrix, matrix2));

    }
}
