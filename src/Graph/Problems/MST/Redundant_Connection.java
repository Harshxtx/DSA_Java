package Graph.Problems.MST;

import java.util.*;

public class Redundant_Connection {
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
    public int[] findRedundantConnection(int[][] edges) {
        int V=edges.length+1;
        parent = new int[V];
        size = new int[V];
        for(int i = 0; i < V; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        for(int e[]:edges){
            if(findParent(e[0])==findParent(e[1]))
                return e;
            else
                unionBySize(e[0],e[1]);
        }
        return new int[0];
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Redundant_Connection ob = new Redundant_Connection();
        int edges[][]={{1,2},{2,3},{3,4},{1,4},{1,5}};
        int res[]= ob.findRedundantConnection(edges);
        System.out.println("The Connections breaks: "+Arrays.toString(res));
    }
}
