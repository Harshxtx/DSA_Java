package Graph.Problems.Shortest_Path;
// Floyd-Warshall Application
//
// Finds the city with the smallest number of
// reachable cities within a given distance threshold.
//
// Steps:
// 1. Find shortest distances between every pair
//    using Floyd-Warshall.
// 2. Count reachable cities for each city.
// 3. Return the city with the smallest count.
// 4. If counts are equal, choose the city
//    with the larger index.
//
// Time Complexity: O(V³)
// Space Complexity: O(V²)
//
// Application:
// • Network analysis
// • City/route optimization
// • Finding reachable locations within a limit

import java.util.*;

public class City_With_Smallest_Neighbour {
    int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int dist[][]=new int[n][n];
        int INF=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i],INF);
            dist[i][i]=0;
        }
        for(int e[]:edges){
            int u=e[0];
            int v=e[1];
            int wt=e[2];
            dist[u][v]=wt;
            dist[v][u]=wt;
        }

        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dist[i][k]!=INF && dist[k][j]!=INF){
                        dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                    }
                }
            }
        }
        int cntCity=n;
        int cityNo=-1;
        for(int i=0;i<n;i++){
            int cnt=0;
            for(int j=0;j<n;j++){
                if(dist[i][j]<=distanceThreshold)
                    cnt++;
            }
            if(cnt<=cntCity){
                cntCity=cnt;
                cityNo=i;
            }
        }
        return cityNo;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        City_With_Smallest_Neighbour ob = new City_With_Smallest_Neighbour();
        int n=4;
        int edges[][]={{0,1,3}, {1,2,1}, {1,3,4}, {2,3,1}};
        int distanceThreshold=4;
        int dis=ob.findTheCity(n, edges, distanceThreshold);
        System.out.println("City with the smallest number of reachable cities: "+dis);
    }
}
