package Graph.Problems.MST;
// Prim's Algorithm
//
// Finds the Minimum Weight of the
// Minimum Spanning Tree (MST).
//
// Algorithm:
// 1. Start from any vertex.
// 2. Insert it into a Min Heap.
// 3. Pick the minimum weight edge.
// 4. If the node is already visited,
//    ignore it.
// 5. Otherwise include it in the MST
//    and add its weight.
// 6. Insert all unvisited neighbours
//    into the Min Heap.
//
// Time Complexity : O(E log V)
// Space Complexity : O(V + E)
//
// Applications:
// • Road Construction
// • Network Design
// • Cable Connections
// • Electric Grid Design

import java.util.*;

public class Prims_Min_Weight {
    class Pair{
        int node;
        int weight;
        Pair(int node,int weight){
            this.node=node;
            this.weight=weight;
        }
    }
    List<List<Pair>> createGraphList(int edges[][],int V){
        List<List<Pair>> graph=new ArrayList<>();
        for(int i=0;i<V;i++){
            graph.add(new ArrayList<>());
        }
        for(int a[]:edges){
            int u=a[0];
            int v=a[1];
            int wt=a[2];
            graph.get(u).add(new Pair(v,wt));
            graph.get(v).add(new Pair(u,wt));
        }
        return graph;
    }
    int spanningTree(int V, int[][] edges) {
        List<List<Pair>> adj=createGraphList(edges,V);
        boolean vis[]=new boolean[V];
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b) -> a.weight-b.weight);
        pq.add(new Pair(0,0));
        int sum=0;
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int node=curr.node;
            int wt=curr.weight;
            if(vis[node])
                continue;
            vis[node]=true;
            sum+=wt;
            for(Pair neighbour:adj.get(node)){
                int adjNode=neighbour.node;
                int edWt=neighbour.weight;
                if(!vis[adjNode]){
                    pq.add(new Pair(adjNode,edWt));
                }
            }
        }
        return sum;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Prims_Min_Weight ob = new Prims_Min_Weight();
        int V=5;
        int edge[][]={{0,1,2},{0,2,1},{1,2,1},{2,3,2},{2,4,2},{3,4,1}};
        int minWt=ob.spanningTree(V,edge);
        System.out.println("The minimum weight of the tree: "+minWt);
    }
}
