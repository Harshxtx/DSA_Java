package Graph.Problems.Shortest_Path;
// Shortest Path in Unweighted Graph (BFS)
//
// Since every edge has equal weight (1),
// BFS always reaches a node using the
// minimum number of edges.
//
// Algorithm:
// 1. Initialize all distances as -1.
// 2. Distance of source = 0.
// 3. Perform BFS.
// 4. Whenever an unvisited neighbour
//    is found, update:
//       dist[neighbour] = dist[node] + 1
//
// Time Complexity : O(V + E)
//
// Space Complexity : O(V + E)
//
// Applications:
// • Shortest Path in Unweighted Graph
// • Social Networks
// • Minimum Moves Problems
// • Maze Problems

import java.util.*;

public class Shortest_Path_Unweighted_Undirected_Graph {
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
    public int shortestPath(int V, int[][] edges, int src, int dest) {
        List<List<Integer>> adj=createGraphList(edges,V);

        int dis[]=new int[V];
        Arrays.fill(dis,(int)-1);
        Queue<Integer> q=new LinkedList<>();
        dis[src] = 0;
        q.add(src);
        while(!q.isEmpty()){
            int node=q.poll();
            if(node==dest)
                return dis[dest];
            for(int adjNode:adj.get(node)){
                if(dis[adjNode]==-1){
                    dis[adjNode]=dis[node]+1;
                    q.add(adjNode);
                }
            }
        }
        return dis[dest];

    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Shortest_Path_Unweighted_Undirected_Graph ob = new Shortest_Path_Unweighted_Undirected_Graph();
        int V=9;
        int edges[][]={{0, 1}, {0, 3}, {1, 2}, {3, 4}, {4, 5}, {2, 6}, {5, 6}, {6, 7}, {6, 8}, {7, 8}};
        int src=0,dest=8;
        int dis=ob.shortestPath(V, edges, src, dest);
        if(dis!=-1)
            System.out.println("Shortest Distance from " + src + " to " + dest + " = " + dis);
        else
            System.out.println("There is no path exists from " + src + " to " + dest + " = " + dis);
    }
}
