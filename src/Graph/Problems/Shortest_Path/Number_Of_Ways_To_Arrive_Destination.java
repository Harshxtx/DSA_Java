package Graph.Problems.Shortest_Path;
// Number of Ways to Arrive at Destination
//
// Finds the number of shortest paths from
// source (0) to destination (n - 1).
//
// Uses Dijkstra's Algorithm.
//
// Maintain:
// • dist[node] -> shortest distance
// • ways[node] -> number of shortest paths
//
// If a shorter path is found:
// • Update distance
// • ways[adjNode] = ways[node]
//
// If another shortest path is found:
// • Add ways[node] to ways[adjNode]
//
// Result is taken modulo 1e9 + 7.
//
// Time Complexity:
// • O(E log V)
//
// Space Complexity:
// • O(V + E)
//
// Application:
// • Counting shortest paths
// • Network routing
// • Finding multiple optimal routes

import java.util.*;

public class Number_Of_Ways_To_Arrive_Destination {
    class Pair{
        int first;
        long sec;
        Pair(int first,long sec){
            this.first=first;
            this.sec=sec;
        }
    }
    List<List<Pair>> createList(int V,int edges[][]){
        List<List<Pair>> graph=new ArrayList<>();
        for(int i=0;i<V;i++)
            graph.add(new ArrayList<>());
        for(int a[]:edges){
            int u=a[0];
            int v=a[1];
            long wt=a[2];
            graph.get(u).add(new Pair(v,wt));
            graph.get(v).add(new Pair(u,wt));
        }
        return graph;
    }
    public int countPaths(int n, int[][] roads) {
        int mod=(int)1e9+7;
        List<List<Pair>> adj=createList(n,roads);
        long dist[]=new long[n];
        long ways[]=new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0]=0;
        ways[0]=1;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b) -> Long.compare(a.sec,b.sec));
        pq.add(new Pair(0,0));
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int node=curr.first;
            long dis=curr.sec;
            if(dis>dist[node]) continue;
            for(Pair it:adj.get(node)){
                int adjNode=it.first;
                long edWt=it.sec;
                if(dis+edWt<dist[adjNode]){
                    dist[adjNode]=dis+edWt;
                    pq.offer(new Pair(adjNode,dis+edWt));
                    ways[adjNode]=ways[node];
                }
                else if(dis+edWt==dist[adjNode]){
                    ways[adjNode]=(ways[adjNode]+ways[node])%mod;
                }
            }
        }
        return (int)ways[n-1]%mod;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Number_Of_Ways_To_Arrive_Destination ob = new Number_Of_Ways_To_Arrive_Destination();
        int n=7;
        int roads[][]={{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};
        int cnt=ob.countPaths(n,roads);
        System.out.println("Number of ways to arrive at destination with minimum time: "+cnt);
    }
}
