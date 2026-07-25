package Graph;
// Breadth First Search (BFS)
//
// BFS is a graph traversal algorithm
// that visits vertices level by level.
//
// It uses a Queue (FIFO).
//
// Algorithm:
// 1. Mark source as visited.
// 2. Push source into queue.
// 3. While queue is not empty:
//      • Remove front node.
//      • Visit it.
//      • Push all unvisited neighbours.
//
// Time Complexity : O(V + E)
//
// Space Complexity : O(V)
//
// Applications:
// • Shortest Path in Unweighted Graph
// • Number of Islands
// • Flood Fill
// • Rotten Oranges
// • Cycle Detection
// • Bipartite Graph

import java.util.*;

public class BFS {
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
    void bfs(List<List<Integer>> graph,int V){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[V];
        int src=0;
        q.offer(src);
        visited[src]=true;
        while(!q.isEmpty()){
            int node = q.poll();
            System.out.print(node + " ");
            for(int neighbour:graph.get(node)) {
                if(!visited[neighbour]){
                    visited[neighbour]=true;
                    q.offer(neighbour);
                }
            }
        }
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        BFS ob = new BFS();
        int vertices=4;
        int edges[][]={{0,1},{0,2},{1,2},{1,3}};                // Undirected Unweighted Graph
        List<List<Integer>> adjList=ob.createGraphList(edges, vertices);
        System.out.println("Adjacency List: ");
        ob.displayList(adjList, vertices);
        System.out.print("BFS Traversal of graph: ");
        ob.bfs(adjList, vertices);
    }
}
