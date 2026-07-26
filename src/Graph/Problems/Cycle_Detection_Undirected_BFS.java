package Graph.Problems;
// Cycle Detection (Undirected Graph) - BFS
//
// Detect whether an undirected graph
// contains a cycle.
//
// We perform BFS while storing:
//
// (Current Node, Parent Node)
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
// every node would incorrectly
// detect a cycle with its parent.
//
// Time Complexity : O(V + E)
//
// Space Complexity : O(V)
//
// Applications:
// • Network Validation
// • Graph Analysis
// • Connected Components
// • Tree Verification

import java.util.*;

public class Cycle_Detection_Undirected_BFS {
    class Pair{
        int parent;
        int Node;
        Pair(int Node, int parent){
            this.parent=parent;
            this.Node=Node;
        }
    }
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
    boolean detectCycle(int src,List<List<Integer>> adj, boolean vis[]){
        vis[src]=true;
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(src,-1));
        while(!q.isEmpty()){
            Pair curr=q.poll();
            int node=curr.Node;
            int parNode=curr.parent;
            for(int neighbour:adj.get(node)){
                if(!vis[neighbour]){
                    vis[neighbour]=true;
                    q.offer(new Pair(neighbour,node));
                }
                else if(parNode!=neighbour){
                    return true;
                }
            }
        }
        return false;
    }
    boolean isCycle(int V, List<List<Integer>> adjList) {
        boolean vis[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (detectCycle(i, adjList, vis))
                    return true;
            }
        }
        return false;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Cycle_Detection_Undirected_BFS ob = new Cycle_Detection_Undirected_BFS();
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
