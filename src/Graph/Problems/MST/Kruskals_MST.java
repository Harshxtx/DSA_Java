package Graph.Problems.MST;
// Kruskal's Algorithm
//
// Finds the Minimum Spanning Tree (MST)
// using Greedy + Disjoint Set Union (DSU).
//
// Steps:
// 1. Store all edges.
// 2. Sort edges in ascending order of weight.
// 3. Traverse the sorted edges.
// 4. If the two vertices belong to different
//    components:
//      • Add the edge to the MST.
//      • Merge the components using DSU.
// 5. Ignore edges that form a cycle.
// 6. Stop after selecting V - 1 edges.
//
// Cycle Detection:
// • If both vertices have the same
//   Ultimate Parent, adding that edge
//   forms a cycle, so skip it.
//
// Data Structure Used:
// • Disjoint Set Union (Union By Size)
// • Path Compression
//
// Time Complexity:
// • Sorting Edges : O(E log E)
// • DSU Operations: O(E · α(V))
// • Overall       : O(E log E)
//
// Space Complexity:
// • O(E + V)
//
// Applications:
// • Minimum Spanning Tree
// • Network Design
// • Road Construction
// • Connecting Cities
// • Clustering Problems

import java.util.*;

public class Kruskals_MST {
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
    List<Edge> kruskalsMST(int V, int[][] edges) {
        List<Edge> edgeList=new ArrayList<>();
        for(int e[]:edges){
            edgeList.add(new Edge(e[0],e[1],e[2]));
        }
        Disjoint ds=new Disjoint(V);
        Collections.sort(edgeList,(x,y) -> x.weight-y.weight);
        List<Edge> res=new ArrayList<>();
        for(Edge edge:edgeList) {
            int u=edge.src;
            int v=edge.dest;
            if(ds.findParent(u)!=ds.findParent(v)){
                res.add(edge);
                ds.unionBySize(u,v);
                if(res.size()==V-1)
                    break;
            }
        }
        return res;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Kruskals_MST ob = new Kruskals_MST();
        int V=5;
        int edge[][]={{0,1,2},{0,2,1},{1,2,1},{2,3,2},{2,4,2},{3,4,1}};
        List<Edge> mst=ob.kruskalsMST(V,edge);
        System.out.println("Edges in Minimum Spanning Tree:");
        for (Edge ed : mst) {
            System.out.println(ed.src + " -> " +ed.dest + " : " + ed.weight);
        }
    }
}
