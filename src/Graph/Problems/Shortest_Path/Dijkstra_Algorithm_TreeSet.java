package Graph.Problems.Shortest_Path;
// Dijkstra Algorithm using TreeSet
//
// Finds the shortest distance from a
// source node to all other nodes in a
// weighted graph with non-negative
// edge weights.
//
// Algorithm:
// 1. Initialize all distances as INF.
// 2. Set source distance = 0.
// 3. Insert the source into a TreeSet.
// 4. Always process the node having
//    the minimum current distance.
// 5. Relax all adjacent edges.
// 6. If a shorter distance is found,
//    remove the old pair from the
//    TreeSet, update the distance,
//    and insert the new pair.
//
// Time Complexity : O((V + E) log V)
// Space Complexity : O(V + E)

import java.util.*;

public class Dijkstra_Algorithm_TreeSet {
    class Pair{
        int val;
        int distance;

        Pair(int val, int distance){
            this.val = val;
            this.distance = distance;
        }
    }
    List<List<Pair>> createGraphList(int edges[][], int V){
        List<List<Pair>> graph = new ArrayList<>();

        for(int i=0;i<V;i++)
            graph.add(new ArrayList<>());
        for(int a[] : edges){
            int u = a[0];
            int v = a[1];
            int dis = a[2];

            graph.get(u).add(new Pair(v, dis));
            graph.get(v).add(new Pair(u, dis)); // remove this line and use next for directed
        }
        return graph;
    }
    public int[] dijkstra(int V, int[][] edges, int src){
        List<List<Pair>> adj = createGraphList(edges, V);
        int dist[] = new int[V];
        Arrays.fill(dist,(int)1e9);

        TreeSet<Pair> set = new TreeSet<>(
                (a, b) -> {
                    if (a.distance == b.distance)
                        return a.val - b.val;
                    return a.distance - b.distance;
                }
        );
        dist[src] = 0;
        set.add(new Pair(src, 0));
        while(!set.isEmpty()){
            Pair curr = set.pollFirst();
            int node = curr.val;
            int dis = curr.distance;

            for(Pair neighbour : adj.get(node)){
                int v = neighbour.val;
                int wt = neighbour.distance;
                if(dis + wt < dist[v]){
                    if(dist[v] != (int)1e9)
                        set.remove(new Pair(v, dist[v]));       // Remove old distance
                    dist[v] = dis + wt;
                    set.add(new Pair(v, dist[v]));              // Insert updated distance
                }
            }
        }
        return dist;
    }
    public static void main(String args[]){
        Dijkstra_Algorithm_TreeSet ob = new Dijkstra_Algorithm_TreeSet();
        int V=5;
        int src=0;
        int edges[][]={{0, 1, 4}, {0, 2, 8}, {1, 4, 6}, {2, 3, 2}, {3, 4, 10}};
        int dis[]= ob.dijkstra(V,edges,0);
        for(int i=0;i<V;i++){
            System.out.println("Distance from "+src+" to "+i+" is "+dis[i]);
        }
    }
}
