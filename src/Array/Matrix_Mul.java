package Array;

import java.util.*;

public class Matrix_Mul {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Matrix_Mul ob = new Matrix_Mul();

//        System.out.print("Enter rows and columns of first matrix: ");
//        int r1 = sc.nextInt();
//        int c1 = sc.nextInt();
//
//        System.out.print("Enter rows and columns of second matrix: ");
//        int r2 = sc.nextInt();
//        int c2 = sc.nextInt();
//
//        if (c1 != r2) {
//            System.out.println("Matrix multiplication is not possible.");
//            return;
//        }

        int[][] A = {
                {1, 2, 3},
                {4, 5, 6}
        };
        int[][] B = {
                {7, 8},
                {9, 10},
                {11, 12}
        };
        int[][] C = new int[2][2];
        int r1=2,c1=3;
        int r2=3,c2=2;

//        System.out.println("Enter elements of first matrix:");
//        for (int i = 0; i < r1; i++) {
//            for (int j = 0; j < c1; j++) {
//                A[i][j] = sc.nextInt();
//            }
//        }
//        System.out.println("Enter elements of second matrix:");
//        for (int i = 0; i < r2; i++) {
//            for (int j = 0; j < c2; j++) {
//                B[i][j] = sc.nextInt();
//            }
//        }

        // Matrix multiplication
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        // Display result
        System.out.println("Resultant Matrix:");
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
    }
}
