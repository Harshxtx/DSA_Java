package Heap.Problems;

import java.util.*;

public class K_Closest_Points_Origin {
    int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        int i, l1 = points.length;
        for (i = 0; i < l1; i++) {
            int x = points[i][0];
            int y = points[i][1];
            int dis = y * y + x * x;
            pq.add(new int[]{i, dis});
            if (pq.size() > k)
                pq.poll();
        }
        int res[][] = new int[k][2];
        for (i = 0; i < k; i++) {
            int arr[] = pq.poll();
            res[i] = points[arr[0]];
        }
        return res;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        K_Closest_Points_Origin ob = new K_Closest_Points_Origin();
        int arr[][]={{3,3},{5,-1},{-2,4}};
        int k=2;
        int res[][]= ob.kClosest(arr,k);
        System.out.println("Close Points to origin are:");
        for(int a[]:res){
            System.out.println(Arrays.toString(a));

        }
    }
}
