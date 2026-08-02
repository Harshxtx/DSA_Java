package Graph.Problems.Shortest_Path;
// Bellman-Ford Algorithm
//
// Finds the shortest distance from a
// source node to all other nodes in a
// weighted graph.
//
// Unlike Dijkstra, Bellman-Ford works
// even when the graph contains
// negative edge weights.
//
// Algorithm:
// 1. Initialize all distances as INF.
// 2. Set source distance = 0.
// 3. Relax all edges exactly (V - 1)
//    times.
// 4. Perform one extra relaxation.
// 5. If any distance is still updated,
//    a Negative Weight Cycle exists.
//
// Time Complexity : O(V × E)
// Space Complexity : O(V)
//
// Applications:
// • Graphs with Negative Weights
// • Currency Exchange Problems
// • Network Routing
// • Detecting Negative Cycles
// • Shortest Path Problems

import java.util.*;

public class Bellman_Ford_Algorithm {
    int[] bellmanFord(int V, int[][] edges, int src) {
        int dist[]=new int[V];
        Arrays.fill(dist,(int)1e8);
        dist[src]=0;
        for(int i=0;i<V-1;i++){
            for(int a[]:edges){
                int u=a[0];
                int v=a[1];
                int wt=a[2];
                if(dist[u]!=1e8 && dist[u]+wt<dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }
        for(int a[]:edges){
            int u=a[0];
            int v=a[1];
            int wt=a[2];
            if(dist[u]!=1e8 && dist[u]+wt<dist[v])
                return new int[]{-1};
        }
        return dist;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Bellman_Ford_Algorithm ob = new Bellman_Ford_Algorithm();
        int V=5;
        int src=0;
        int edges[][]={{1, 3, 2}, {4, 3, -1}, {2, 4, 1}, {1, 2, 1}, {0, 1, 5}};
        int dist[]=ob.bellmanFord(V,edges,src);
        if(dist[0]!=-1){
            for(int i=0;i<V;i++)
                System.out.println("Distance from "+src+" to "+i+" is "+dist[i]);
        }
        else
            System.out.println("Negative Cycle Exists");
    }
}
