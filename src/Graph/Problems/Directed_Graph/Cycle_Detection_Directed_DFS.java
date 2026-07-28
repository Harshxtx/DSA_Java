package Graph.Problems.Directed_Graph;

import java.util.*;

public class Cycle_Detection_Directed_DFS {
    ArrayList<ArrayList<Integer>> createGraphList(int edges[][],int V){
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for(int i=0;i<V;i++){
            graph.add(new ArrayList<>());
        }
        for(int a[]:edges){
            int u=a[0];
            int v=a[1];
            graph.get(u).add(v);
        }
        return graph;
    }
    boolean detectCycle(int node,ArrayList<ArrayList<Integer>> adjList,boolean vis[],boolean pathVis[]){
        vis[node]=true;
        pathVis[node]=true;
        for(int adjNode:adjList.get(node)){
            if(!vis[adjNode]){
                if(detectCycle(adjNode,adjList,vis,pathVis))
                    return true;
            }
            else if(pathVis[adjNode]){
                return true;
            }
        }
        pathVis[node]=false;
        return false;
    }
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adjList) {
        boolean vis[] = new boolean[V];
        boolean pathVis[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (detectCycle(i, adjList, vis, pathVis))
                    return true;
            }
        }
        return false;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Cycle_Detection_Directed_DFS ob = new Cycle_Detection_Directed_DFS();
        int edges[][] = {{0, 1}, {1, 2}, {2, 0}, {2, 3}};
        int V=4;
        ArrayList<ArrayList<Integer>> adjList=ob.createGraphList(edges, V);
        if(ob.isCyclic(V,adjList)){
            System.out.println("Cycle found");
        }
        else{
            System.out.println("Not found");
        }
    }
}
