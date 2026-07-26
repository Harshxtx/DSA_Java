package Graph.Problems;
// Cycle Detection (Undirected Graph) - DFS
//
// Detect whether an undirected graph
// contains a cycle using DFS.
//
// During DFS, we keep track of:
//
// Current Node
// Parent Node
//
// If we visit an already visited neighbour
// that is NOT the parent,
// a cycle exists.
//
// Why Parent?
//
// In an undirected graph,
// every edge appears twice.
//
// Without parent checking,
// we would incorrectly detect
// every parent-child edge as a cycle.
//
// Time Complexity : O(V + E)
//
// Space Complexity : O(V)
//
// Applications:
// • Tree Verification
// • Network Analysis
// • Graph Validation
// • Connected Components

import java.util.*;

public class Cycle_Detection_Undirected_DFS {
    List<List<Integer>> createGraphList(int edges[][],int V){
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<V;i++){
            graph.add(new ArrayList<>());
        }
        for(int a[]:edges){
            int u=a[0];
            int v=a[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return graph;
    }
    boolean detectCycle(int node,int parent,List<List<Integer>> adj, boolean vis[]){
        vis[node]=true;
        for(int adjNode:adj.get(node)){
            if(!vis[adjNode]){
                if(detectCycle(adjNode,node,adj,vis))
                    return true;
            }
            else if(parent!=adjNode){
                return true;
            }
        }
        return false;
    }
    boolean isCycle(int V, List<List<Integer>> adjList) {
        boolean vis[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (detectCycle(i, -1, adjList, vis))
                    return true;
            }
        }
        return false;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Cycle_Detection_Undirected_DFS ob = new Cycle_Detection_Undirected_DFS();
        int edges[][] = {{0, 1}, {0, 2}, {1, 2}, {2, 3}};
        int V=4;
        List<List<Integer>> adjList=ob.createGraphList(edges, V);
        if(ob.isCycle(V,adjList)){
            System.out.println("Cycle found");
        }
        else{
            System.out.println("Not found");
        }
    }
}
