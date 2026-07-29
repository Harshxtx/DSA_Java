package Graph.Problems.Directed_Graph;
// Cycle Detection in Directed Graph - DFS
//
// In a directed graph, a cycle exists
// if during DFS we visit a node that
// is already present in the current DFS path.
//
// visited[]   -> Node has been visited before.
// pathVisited[] -> Node is currently in the recursion stack.
//
// If an adjacent node is already in the
// current DFS path, a cycle exists.
//
// Time Complexity : O(V + E)
//
// Space Complexity : O(V)
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
    // Method 1 : Using visited[] and pathVisited[]
//    boolean detectCycle(int node,ArrayList<ArrayList<Integer>> adjList,boolean vis[],boolean pathVis[]){
//        vis[node]=true;
//        pathVis[node]=true;
//        for(int adjNode:adjList.get(node)){
//            if(!vis[adjNode]){
//                if(detectCycle(adjNode,adjList,vis,pathVis))
//                    return true;
//            }
//            else if(pathVis[adjNode]){
//                return true;
//            }
//        }
//        pathVis[node]=false;
//        return false;
//    }
//    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adjList) {
//        boolean vis[] = new boolean[V];
//        boolean pathVis[] = new boolean[V];
//        for (int i = 0; i < V; i++) {
//            if (!vis[i]) {
//                if (detectCycle(i, adjList, vis, pathVis))
//                    return true;
//            }
//        }
//        return false;
//    }
    // Method 2:Using Single State Array
    boolean detectCycle(int node,ArrayList<ArrayList<Integer>> adjList,int vis[]){
        vis[node]=2;
        for(int adjNode:adjList.get(node)){
            if(vis[adjNode]==0){
                if(detectCycle(adjNode,adjList,vis))
                    return true;
            }
            else if(vis[adjNode]==2){
                return true;
            }
        }
        vis[node]=1;
        return false;
    }
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adjList) {
        int vis[] = new int[V];
        for (int i = 0; i < V; i++) {
            if (vis[i]==0) {
                if (detectCycle(i, adjList, vis))
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
