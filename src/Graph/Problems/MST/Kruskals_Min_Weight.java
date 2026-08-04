package Graph.Problems.MST;

import java.util.*;
class Disjoint {
    int[] parent;
    int[] rank;
    int[] size;

    Disjoint(int V) {
        parent = new int[V];
        rank = new int[V];
        size = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
            rank[i] = 0;
            size[i] = 1;
        }
    }

    int findParent(int node) {
        if (node == parent[node])
            return node;
        return parent[node] = findParent(parent[node]);
    }

    void unionBySize(int u, int v) {
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        if (ulp_u == ulp_v)
            return;

        if (size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        } else {
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }
}
class Kruskals_Algorithm {
    class Edge{
        int src;
        int dest;
        int weight;
        Edge(int src,int dest,int weight){
            this.src=src;
            this.dest=dest;
            this.weight=weight;
        }
    }
    int kruskalsMST(int V, int[][] edges) {
        List<Edge> edgeList=new ArrayList<>();
        for(int e[]:edges){
            edgeList.add(new Edge(e[0],e[1],e[2]));
        }
        Disjoint ds=new Disjoint(V);
        Collections.sort(edgeList,(x,y) -> x.weight-y.weight);
        int mstWt=0;
        for(Edge edge:edgeList) {
            int u=edge.src;
            int v=edge.dest;
            int wt=edge.weight;
            if(ds.findParent(u)!=ds.findParent(v)){
                mstWt+=wt;
                ds.unionBySize(u,v);
            }
        }
        return mstWt;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Kruskals_Algorithm ob = new Kruskals_Algorithm();
        int V=5;
        int edge[][]={{0,1,2},{0,2,1},{1,2,1},{2,3,2},{2,4,2},{3,4,1}};
        int minWt=ob.kruskalsMST(V,edge);
        System.out.println("The minimum weight of the tree: "+minWt);
    }
}
