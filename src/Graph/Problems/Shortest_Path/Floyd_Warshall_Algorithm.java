package Graph.Problems.Shortest_Path;
// Floyd-Warshall Algorithm
//
// Finds the shortest distance between
// every pair of vertices in a weighted
// graph (All-Pairs Shortest Path).
//
// Algorithm:
// 1. Initialize the distance matrix.
//    • dist[i][i] = 0
//    • dist[u][v] = edge weight
//    • Remaining distances = INF
// 2. Consider every vertex as an
//    intermediate (via) vertex.
// 3. Update the shortest distance
//    using:
//
//    dist[i][j] = min(dist[i][j],
//                     dist[i][via] +
//                     dist[via][j])
//
// 4. If after completion any
//    dist[i][i] < 0, a Negative
//    Weight Cycle exists.
//
// Time Complexity : O(V³)
// Space Complexity : O(V²)
//
// Applications:
// • All-Pairs Shortest Path
// • Network Routing
// • City Distance Problems
// • Graph Transitive Closure
// • Path Optimization

import java.util.*;

public class Floyd_Warshall_Algorithm {

    // Distance Matrix already given
//    void floydWarshall(int[][] dist) {
//        int V = dist.length;
//        int INF = (int) 1e8;
//        for(int via = 0; via < V; via++){
//            for(int i = 0; i < V; i++){
//                for(int j = 0; j < V; j++){
//                    if(dist[i][via]!=INF && dist[via][j]!=INF){
//                        dist[i][j]=Math.min(dist[i][j],dist[i][via]+dist[via][j]);
//                    }
//                }
//            }
//        }
//    }

    // Build From Scratch
    int[][] floydWarshall(int V,int[][] edges) {
        int[][] dist=new int[V][V];
        int INF=(int)1e8;
        for(int i=0;i<V;i++){
            Arrays.fill(dist[i],(int)1e8);
            dist[i][i]=0;
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            dist[u][v] = wt;
            // dist[v][u] = wt;                 // For undirected graph:
        }
        for(int via = 0; via < V; via++){
            for(int i = 0; i < V; i++){
                for(int j = 0; j < V; j++){
                    if(dist[i][via]!=INF && dist[via][j]!=INF){
                        dist[i][j]=Math.min(dist[i][j],dist[i][via]+dist[via][j]);
                    }
                }
            }
        }
        for(int i = 0; i < V; i++){
            if(dist[i][i] < 0){
                return new int[][]{{-1}};
            }
        }
        return dist;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Floyd_Warshall_Algorithm ob = new Floyd_Warshall_Algorithm();
        int INF = 100000000;
//        int[][] dist = {
//                {0,   4,   INF, 5,   INF},
//                {INF, 0,   1,   INF, 6  },
//                {2,   INF, 0,   3,   INF},
//                {INF, INF, 1,   0,   2  },
//                {1,   INF, INF, 4,   0  }
//        };
//        ob.floydWarshall(dist);
        int V=5;
        int[][] edges ={{0, 1, 4},
                {0, 3, 5},
                {1, 2, 1},
                {1, 4, 6},
                {2, 0, 2},
                {2, 3, 3},
                {3, 2, 1},
                {3, 4, 2},
                {4, 0, 1},
                {4, 3, 4}
        };
        int dist[][]=ob.floydWarshall(V,edges);
        if(dist[0][0]!=-1){
            for(int a[]:dist)
                System.out.println(Arrays.toString(a));
        }
        else
            System.out.println("Negative Cycle Exists");
    }
}