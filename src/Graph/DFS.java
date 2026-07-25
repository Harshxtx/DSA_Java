package Graph;
// Depth First Search (DFS)
//
// DFS is a graph traversal algorithm
// that explores as deep as possible
// before backtracking.
//
// It uses Recursion (or Stack).
//
// Algorithm:
// 1. Mark current node as visited.
// 2. Visit the current node.
// 3. Recursively visit every unvisited neighbour.
//
// Time Complexity : O(V + E)
//
// Space Complexity : O(V)
//
// Applications:
// • Connected Components
// • Cycle Detection
// • Topological Sort
// • Strongly Connected Components
// • Finding Paths
// • Bridges & Articulation Points

import java.util.*;

public class DFS {
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
    void displayList(List<List<Integer>> graph,int V){
        for(int i=0;i<V;i++) {
            System.out.print(i + " -> ");
            for(int neighbour:graph.get(i)) {
                System.out.print(neighbour + " ");
            }
            System.out.println();
        }
    }
    void dfsRec(List<List<Integer>> adj,boolean[] visited,int node){
        visited[node]=true;
        System.out.print(node+ " ");
        for(int neighbour:adj.get(node)) {
            if(!visited[neighbour]){
                dfsRec(adj,visited,neighbour);
            }
        }
    }
    void dfs(List<List<Integer>> adj){
        boolean[] visited=new boolean[adj.size()];
        dfsRec(adj,visited,0);
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        DFS ob = new DFS();
        int vertices=4;
        int edges[][]={{0,1},{0,2},{1,2},{1,3}};                // Undirected Unweighted Graph
        List<List<Integer>> adjList=ob.createGraphList(edges, vertices);
        System.out.println("Adjacency List: ");
        ob.displayList(adjList, vertices);
        System.out.print("DFS Traversal of graph: ");
        ob.dfs(adjList);
    }
}
