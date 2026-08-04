package Graph.Problems.MST;

import java.util.*;

public class Number_Of_Operations_To_Make_Network_Connected {
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
    public int makeConnected(int V, int[][] connections) {
        parent = new int[V];
        size = new int[V];
        for(int i = 0; i < V; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        int extra=0;
        for(int e[]:connections){
            if(findParent(e[0])==findParent(e[1]))
                extra++;
            else
                unionBySize(e[0],e[1]);
        }
        int count=0;
        for(int i=0;i<V;i++){
            if(findParent(i)==i)
                count++;
        }
        if(extra>=count-1)
            return count-1;
        return -1;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Number_Of_Operations_To_Make_Network_Connected ob = new Number_Of_Operations_To_Make_Network_Connected();
        int V=6;
        int edges[][]={{0,1},{0,2},{0,3},{1,2},{1,3}};
        int connections=ob.makeConnected(V, edges);
        if (connections == -1)
            System.out.println("Not Possible");
        else
            System.out.println("Minimum Operations Required: " + connections);
    }
}
