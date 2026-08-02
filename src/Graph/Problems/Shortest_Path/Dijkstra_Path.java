package Graph.Problems.Shortest_Path;
// Dijkstra Algorithm (Print Shortest Path)
//
// Finds the shortest path from a
// source node to a destination node
// in a weighted graph having
// non-negative edge weights.
//
// Algorithm:
// 1. Initialize all distances as INF.
// 2. Set source distance = 0.
// 3. Maintain a parent[] array where
//    parent[i] stores the previous
//    node in the shortest path.
// 4. Insert the source into a Min Heap
//    (Priority Queue).
// 5. Always process the node having
//    the minimum current distance.
// 6. Relax all adjacent edges.
// 7. Whenever a shorter distance is
//    found, update:
//       • distance
//       • parent
//       • Priority Queue
// 8. After Dijkstra finishes,
//    backtrack using parent[] from
//    destination to source.
// 9. Reverse the obtained path to
//    get the correct shortest path.
//
//   Note:
// • Returns the actual shortest path
//   instead of only the shortest distance.

import java.util.*;

public class Dijkstra_Path {
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
        for(int i=0;i<=V;i++){
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
    public List<Integer> shortestPath(int V, int[][] edges, int src, int dest) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        List<List<Pair>> adj = createGraphList(edges, V);

        int dist[] = new int[V+1];
        int par[]=new int[V+1];

        for(int i=0;i<=V;i++){
            dist[i]=(int)(1e9);
            par[i]=i;
        }
        dist[src] = 0;

        pq.add(new Pair(src, 0));
        while (!pq.isEmpty()) {
            int node = pq.peek().val;
            int dis = pq.peek().distance;
            pq.poll();

            if(dis>dist[node]) continue;

            for(Pair neighbour : adj.get(node)){
                int v = neighbour.val;
                int wt = neighbour.distance;

                if(dis + wt < dist[v]){
                    dist[v] = dis + wt;
                    pq.offer(new Pair(v, dist[v]));
                    par[v]=node;
                }
            }
        }
        List<Integer> path=new ArrayList<>();
        if(dist[dest]==1e9){
            path.add(-1);
            return path;
        }
        int node=dest;
        while(par[node]!=node){
            path.add(node);
            node=par[node];
        }
        path.add(src);
        Collections.reverse(path);
        return path;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Dijkstra_Path ob = new Dijkstra_Path();
        int V=5;
        int src=1;
        int dest=5;
        int edges[][]={{1, 2, 2}, {2, 5, 5}, {2, 3, 4}, {1, 4, 1}, {4, 3, 3}, {3, 5, 1}};
        List<Integer> path=ob.shortestPath(V, edges, src, dest);
        if(path.get(0)!=-1){
            System.out.println("The Shortest path to reach the destination: "+path);
        }
        else {
            System.out.println("Path is not possible");
        }
    }
}
