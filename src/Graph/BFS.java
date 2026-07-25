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
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++) {
            if(!visited[i]) {
                Queue<Integer> q=new LinkedList<>();
                q.offer(i);
                visited[i] = true;
                while (!q.isEmpty()) {
                    int node = q.poll();
                    System.out.print(node + " ");
                    for (int neighbour : graph.get(node)) {
                        if (!visited[neighbour]) {
                            visited[neighbour] = true;
                            q.offer(neighbour);
                        }
                    }
                }
            }
        }
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        BFS ob = new BFS();
        //int vertices=6;
        int vertices=10;
        //int edges[][]={{0,1},{0,2},{0,3},{1,4},{1,5}};                // Undirected Unweighted Graph
        int[][] edges = {
                {0, 1}, {1, 2}, {2, 0},  // Component 1 (Triangle: 0-1-2)
                {4, 5},                  // Component 2 (Line: 4-5)
                {7, 8}, {8, 9}           // Component 3 (Line: 7-8-9)
        };
        List<List<Integer>> adjList=ob.createGraphList(edges, vertices);
        System.out.println("Adjacency List: ");
        ob.displayList(adjList, vertices);
        System.out.print("BFS Traversal of graph: ");
        ob.bfs(adjList, vertices);
    }
}
