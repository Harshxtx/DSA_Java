package Graph.Problems.Directed_Graph;
// Topological Sort - DFS
//
// Topological Sorting is a linear ordering
// of vertices such that for every directed
// edge u → v,
// vertex u appears before vertex v.
//
// It is only possible for Directed
// Acyclic Graphs (DAG).
//
// Algorithm:
//
// 1. Perform DFS.
// 2. Visit all neighbours.
// 3. Push the current node into a stack
//    after visiting all neighbours.
// 4. Pop all nodes from the stack.
//
// Time Complexity : O(V + E)
//
// Space Complexity : O(V)

import java.util.*;

public class Topological_Sort_DFS {
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
    void dfs(int node,ArrayList<ArrayList<Integer>> adjList,boolean vis[],Stack<Integer> st){
        vis[node]=true;
        for(int adjNode:adjList.get(node)){
            if(!vis[adjNode]){
                dfs(adjNode,adjList,vis,st);
            }
        }
        st.push(node);
    }
    ArrayList<Integer> topoSort(int V, ArrayList<ArrayList<Integer>> adjList) {
        boolean vis[] = new boolean[V];
        Stack<Integer> st=new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, adjList, vis, st);
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        while(!st.isEmpty()){
            ans.add(st.pop());
        }
        return ans;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Topological_Sort_DFS ob = new Topological_Sort_DFS();
        int V=6;
        int edges[][]={{1, 3}, {2, 3}, {4, 1}, {4, 0}, {5, 0}, {5, 2}};
        ArrayList<ArrayList<Integer>> adjList=ob.createGraphList(edges,V);
        ArrayList<Integer> ans=ob.topoSort(V, adjList);
        System.out.println("Topological Sort:"+ans);
    }
}
