package Graph.Problems.Shortest_Path;
// Cheapest Flights Within K Stops
//
// Finds the minimum cost from src to dst
// using at most K intermediate stops.
//
// Uses BFS because the number of stops
// is the main constraint.
//
// State:
// • node
// • stops
// • cost
//
// At most K + 1 edges can be used.
//
// Time Complexity:
// • O(K × E)
//
// Space Complexity:
// • O(V + E)

import java.util.*;

public class Cheapest_Flights_K_Stops {
    class Pair{
        int first;
        int sec;
        Pair(int first,int sec){
            this.first=first;
            this.sec=sec;
        }
    }
    class Tuple{
        int stops;
        int node;
        int dis;
        Tuple(int stops,int node,int dis){
            this.stops=stops;
            this.node=node;
            this.dis=dis;
        }
    }
    List<List<Pair>> createList(int V,int edges[][]){
        List<List<Pair>> graph=new ArrayList<>();
        for(int i=0;i<V;i++)
            graph.add(new ArrayList<>());
        for(int a[]:edges){
            int u=a[0];
            int v=a[1];
            int wt=a[2];
            graph.get(u).add(new Pair(v,wt));
        }
        return graph;
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj=createList(n,flights);
        Queue<Tuple> q=new ArrayDeque<>();
        q.add(new Tuple(0,src,0));
        int dis[]=new int[n];
        Arrays.fill(dis,(int)1e9);
        dis[src]=0;
        while(!q.isEmpty()){
            Tuple curr=q.poll();
            int stops=curr.stops;
            int node=curr.node;
            int cost=curr.dis;
            if(stops>k) continue;
            for(Pair it:adj.get(node)){
                int adjNode=it.first;
                int edWt=it.sec;
                if(cost+edWt<dis[adjNode] && stops<=k){
                    dis[adjNode]=cost+edWt;
                    q.add(new Tuple(stops+1,adjNode,cost+edWt));
                }
            }
        }
        if(dis[dst]==(int)1e9)
            return -1;
        return dis[dst];
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Cheapest_Flights_K_Stops ob = new Cheapest_Flights_K_Stops();
        int n=4;
        int flights[][]={{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src=0,dest=3,stops=1;
        int cheap= ob.findCheapestPrice(n,flights,src,dest,stops);
        System.out.println("The cheapest flight with "+stops+" stops: "+cheap);
    }
}
