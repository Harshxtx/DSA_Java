package Graph.Problems.Advanced_Graph;
// Tarjan's Algorithm
//
// A DFS based algorithm that uses
// Discovery Time (tin[]) and
// Lowest Reachable Time (low[]).
//
// It can be used to find:
// • Bridges
// • Articulation Points
// • Strongly Connected Components (SCC)
//
// This implementation finds
// Bridges (Critical Connections).
//
// Bridge Condition:
// • low[child] > tin[parent]
//
// Time Complexity:
// • O(V + E)
//
// Space Complexity:
// • O(V)
//
// Applications:
// • Finding Critical Connections
// • Network Reliability
// • Road / Bridge Analysis
// • Communication Networks

import java.util.*;

public class Bridges_Tarjan {
    int timer=1;
    List<List<Integer>> createGraphList(List<List<Integer>> connections,int V){
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<V;i++){
            graph.add(new ArrayList<>());
        }
        for(List<Integer> lt:connections){
            int u=lt.get(0);
            int v=lt.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return graph;
    }
    void dfs(int node,int parent,List<List<Integer>> adj,boolean vis[],int tin[],int low[],List<List<Integer>> bridges){
        vis[node]=true;
        tin[node]=low[node]=timer;
        timer++;
        for(int n:adj.get(node)){
            if(n==parent) continue;
            if(!vis[n]){
                dfs(n,node,adj,vis,tin,low,bridges);
                low[node]=Math.min(low[node],low[n]);
                if(low[n]>tin[node]){
                    bridges.add(Arrays.asList(node,n));
                }
            }
            else{
                low[node]=Math.min(low[node],low[n]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj=createGraphList(connections,n);
        boolean vis[]=new boolean[n];
        int tin[]=new int[n];
        int low[]=new int[n];
        List<List<Integer>> bridges=new ArrayList<>();
        timer=1;
        for(int i=0;i<n;i++) {
            if(!vis[i]) {
                dfs(i, -1, adj, vis, tin, low, bridges);
            }
        }
        return bridges;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Bridges_Tarjan ob = new Bridges_Tarjan();
        int n=4;
        List<List<Integer>> connection=List.of(
                List.of(0, 1),
                List.of(1, 2),
                List.of(2, 0),
                List.of(1, 3)
        );
        List<List<Integer>> bridges=ob.criticalConnections(n,connection);
        System.out.println("The bridges are:");
        for(List<Integer> lt:bridges){
            System.out.println(lt);
        }
    }
}
