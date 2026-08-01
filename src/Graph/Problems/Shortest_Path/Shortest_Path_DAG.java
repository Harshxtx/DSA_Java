package Graph.Problems.Shortest_Path;
// Shortest Path in Directed Acyclic Graph (DAG)
//
// Algorithm:
// 1. Perform Topological Sort.
// 2. Initialize all distances as INF.
// 3. Set source distance = 0.
// 4. Process vertices in Topological Order.
// 5. Relax all outgoing edges.
//
// Time Complexity : O(V + E)
//
// Space Complexity : O(V + E)
//
// Applications:
// • Dependency Graphs
// • Task Scheduling
// • Workflow Optimization
// • Shortest Path in DAG

import java.util.*;

public class Shortest_Path_DAG {
    class Pair{
        int val;
        int weight;
        Pair(int val,int weight) {
            this.val=val;
            this.weight=weight;
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
            int wt=a[2];
            graph.get(u).add(new Pair(v,wt));
        }
        return graph;
    }
    void topoSort(int node,List<List<Pair>> adjList,boolean vis[],Stack<Integer> st){
        vis[node]=true;
        for(Pair neighbor:adjList.get(node)){
            if(!vis[neighbor.val]){
                topoSort(neighbor.val,adjList,vis,st);
            }
        }
        st.push(node);
    }
    public int[] shortestPath(int V,int[][] edges,int src) {
        List<List<Pair>> adj=createGraphList(edges,V);

        boolean vis[] = new boolean[V];
        Stack<Integer> st=new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                topoSort(i, adj, vis, st);
            }
        }
        int dis[]=new int[V];
        Arrays.fill(dis,(int)1e9);
        dis[src]=0;
        while(!st.isEmpty()){
            int node=st.pop();
            if(dis[node]!=(int)1e9){
                for(int i=0;i<adj.get(node).size();i++){
                    int v=adj.get(node).get(i).val;
                    int wt=adj.get(node).get(i).weight;
                    if(dis[node]+wt<dis[v]){
                        dis[v]=dis[node]+wt;
                    }
                }
            }
        }
        for(int i=0;i<V;i++){
            if(dis[i]==(int)(1e9)){
                dis[i]=-1;
            }
        }
        return dis;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Shortest_Path_DAG ob = new Shortest_Path_DAG();
        int V=6;
        int edge[][]={{0,1,2}, {0,4,1}, {4,5,4}, {4,2,2}, {1,2,3}, {2,3,6}, {5,3,1}};
        int src=0;
        int dest=V-1;
        int dis[]= ob.shortestPath(V,edge,src);
        System.out.println("Shortest Distances from Source " + src + ":");
        for(int i=0;i<V;i++) {
            if(dis[i] == -1)
                System.out.println(src + " -> " + i + " : INF");
            else
                System.out.println(src + " -> " + i + " : " + dis[i]);
        }
        if (dis[dest] == -1)
            System.out.println("\nNo path exists from " + src + " to " + dest);
        else
            System.out.println("\nShortest Distance from " + src + " to " + dest + " = " + dis[dest]);
    }
}
