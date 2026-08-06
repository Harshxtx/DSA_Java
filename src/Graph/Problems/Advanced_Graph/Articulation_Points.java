package Graph.Problems.Advanced_Graph;
// Tarjan's Algorithm - Articulation Points (Cut Vertices)
//
// Finds all vertices whose removal
// increases the number of connected
// components in an undirected graph.
//
// Idea:
// • DFS Traversal
// • Store:
//   - tin[]  -> Time of Insertion
//   - low[]  -> Lowest reachable time
//
// Conditions:
//
// 1. Non-root Node
//    If low[child] >= tin[node]
//    then node is an Articulation Point.
//
// 2. Root Node
//    If DFS Root has more than
//    one child then it is an
//    Articulation Point.
//
// Time Complexity:
// • O(V + E)
//
// Space Complexity:
// • O(V)
//
// Applications:
// • Finding Critical Vertices
// • Network Reliability
// • Communication Networks
// • Road / Bridge Planning
// • Graph Connectivity Analysis

import java.util.*;

public class Articulation_Points {
    int timer=1;
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
    void dfs(int node,int parent,List<List<Integer>> adj,boolean vis[],int tin[],int low[],boolean isArticulation[]){
        vis[node]=true;
        tin[node]=low[node]=timer;
        timer++;
        int childCount = 0;
        for(int n:adj.get(node)){
            if(n==parent) continue;
            if(!vis[n]){
                childCount++;
                dfs(n,node,adj,vis,tin,low,isArticulation);
                low[node]=Math.min(low[node],low[n]);
                if(low[n]>=tin[node] && parent!=-1){
                    isArticulation[node]=true;
                }
            }
            else{
                low[node]=Math.min(low[node],tin[n]);
            }
        }
        if (parent == -1 && childCount > 1) {
            isArticulation[node] = true;
        }
    }
    List<Integer> articulationPoints(int n, int[][] edges) {
        List<List<Integer>> adj=createGraphList(edges,n);
        boolean vis[]=new boolean[n];
        int tin[]=new int[n];
        int low[]=new int[n];
        boolean isArticulation[]=new boolean[n];
        timer=1;
        for(int i=0;i<n;i++) {
            if(!vis[i]) {
                dfs(i, -1, adj, vis, tin, low, isArticulation);
            }
        }
        List<Integer> ans=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (isArticulation[i]) {
                ans.add(i);
            }
        }
        if (ans.isEmpty()) {
            ans.add(-1);
        }
        return ans;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Articulation_Points ob = new Articulation_Points();
        int V=5;
        int edges[][]={{0, 1}, {1, 4}, {4, 3}, {4, 2}, {2, 3}};
        List<Integer> ap=ob.articulationPoints(V, edges);
        System.out.println(ap);
    }
}
