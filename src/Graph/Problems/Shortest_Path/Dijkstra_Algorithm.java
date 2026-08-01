package Graph.Problems.Shortest_Path;
// Dijkstra Algorithm
//
// Finds the shortest distance from a
// source node to all other nodes in a
// weighted graph with non-negative
// edge weights.
//
// Algorithm:
// 1. Initialize all distances as INF.
// 2. Set source distance = 0.
// 3. Push the source into a Min Heap
//    (Priority Queue).
// 4. Always process the node having
//    the minimum current distance.
// 5. Relax all adjacent edges.
// 6. If a shorter distance is found,
//    update it and push it into the
//    Priority Queue.
//
// Time Complexity : O((V + E) log V)
// Space Complexity : O(V + E)
//
// Applications:
// • GPS Navigation
// • Network Routing
// • Maps
// • Shortest Path Problems
// • Packet Routing
//
// Note:
// • Works for both Directed and
//   Undirected Weighted Graphs.
// • Does NOT work for graphs having
//   Negative Edge Weights.

import java.util.*;

public class Dijkstra_Algorithm {
    class Pair{
        int val;
        int distance;
        Pair(int val,int distance) {
            this.val=val;
            this.distance=distance;
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
            int dis=a[2];
            graph.get(u).add(new Pair(v,dis));
            graph.get(v).add(new Pair(u, dis));          //remove this for Directed graph
        }
        return graph;
    }
    public int[] dijkstra(int V, int[][] edges, int src) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        List<List<Pair>> adj = createGraphList(edges, V);

        int dist[] = new int[V];
        Arrays.fill(dist, (int) 1e9);

        dist[src] = 0;
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            int node = pq.peek().val;
            int dis = pq.peek().distance;
            pq.poll();

            if (dis > dist[node]) continue;

            for(Pair neighbour : adj.get(node)){
                int v = neighbour.val;
                int wt = neighbour.distance;

                if(dis + wt < dist[v]){
                    dist[v] = dis + wt;
                    pq.offer(new Pair(v, dist[v]));
                }
            }
        }
        return dist;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Dijkstra_Algorithm ob = new Dijkstra_Algorithm();
        int V=5;
        int src=0;
        int edges[][]={{0, 1, 4}, {0, 2, 8}, {1, 4, 6}, {2, 3, 2}, {3, 4, 10}};
        int dis[]= ob.dijkstra(V,edges,0);
        for(int i=0;i<V;i++){
            System.out.println("Distance from "+src+" to "+i+" is "+dis[i]);
        }
    }
}
