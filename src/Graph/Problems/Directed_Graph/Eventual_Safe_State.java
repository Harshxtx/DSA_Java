package Graph.Problems.Directed_Graph;
// Eventual Safe States - DFS
//
// A node is called Safe if every possible
// path starting from it eventually ends
// at a terminal node.
//
// If any path reaches a cycle,
// then the node is NOT safe.
//
// Algorithm:
//
// 1. Perform DFS.
// 2. Detect cycles using visited[]
//    and pathVisited[].
// 3. Nodes not involved in any cycle
//    are marked safe.
//
// Time Complexity : O(V + E)
//
// Space Complexity : O(V)

import java.util.*;

public class Eventual_Safe_State {
    boolean dfsCheck(int node,int adj[][],boolean vis[],boolean pathVis[],boolean check[]){
        vis[node]=true;
        pathVis[node]=true;
        check[node]=false;
        for(int it:adj[node]){
            if(!vis[it]){
                if(dfsCheck(it,adj,vis,pathVis,check))
                    return true;
            }
            else if(pathVis[it]){
                return true;
            }
        }
        check[node]=true;
        pathVis[node]=false;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        boolean vis[] = new boolean[graph.length];
        boolean pathVis[] = new boolean[graph.length];
        boolean check[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                dfsCheck(i, graph, vis, pathVis,check);
            }
        }
        List<Integer> safeNode=new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            if (check[i]) {
                safeNode.add(i);
            }
        }
        return safeNode;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Eventual_Safe_State ob = new Eventual_Safe_State();
        int graph[][]={{1,2},{2,3},{5},{0},{5},{},{}};
        List<Integer> safeNode=ob.eventualSafeNodes(graph);
        System.out.println("The Safe Nodes are:"+safeNode);
    }
}
