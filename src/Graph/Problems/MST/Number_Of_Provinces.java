package Graph.Problems.MST;

import java.util.*;

public class Number_Of_Provinces {
    int[] parent;
    int[] size;
    int findParent(int node) {
        if (node == parent[node])
            return node;
        return parent[node]=findParent(parent[node]);
    }
    void unionBySize(int u, int v) {
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        if (ulp_u == ulp_v)
            return;

        if (size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        }
        else {
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }
    public int findCircleNum(int[][] matrix) {
        int V=matrix.length;
        parent = new int[V];
        size = new int[V];
        for(int i = 0; i < V; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        for(int i=0;i<V;i++){
            for(int j=i+1;j<V;j++){
                if(matrix[i][j]==1)
                    unionBySize(i,j);
            }
        }
        int count=0;
        for(int i=0;i<V;i++){
            if(findParent(i)==i)
                count++;
        }
        return count;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Number_Of_Provinces ob = new Number_Of_Provinces();
        int matrix[][]={{1,1,0},{1,1,0},{0,0,1}};
        int provinces=ob.findCircleNum(matrix);
        System.out.println("Number of provinces are: "+provinces);
    }
}
