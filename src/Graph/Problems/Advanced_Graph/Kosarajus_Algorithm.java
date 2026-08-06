package Graph.Problems.Advanced_Graph;
// Kosaraju's Algorithm
//
// Used to find all Strongly
// Connected Components (SCC)
// in a Directed Graph.
//
// Works in three steps:
//
// 1. DFS
//    • Store vertices according
//      to their finishing time.
//
// 2. Reverse Graph
//    • Reverse every edge.
//
// 3. DFS on Reversed Graph
//    • Process vertices according
//      to the stack order.
//    • Every DFS gives one SCC.
//
// Time Complexity:
// • O(V + E)
//
// Space Complexity:
// • O(V + E)
//
// Applications:
// • Finding Strongly Connected Components
// • Condensation Graph
// • Cycle Detection in Directed Graphs
// • Dependency Resolution
// • Deadlock Detection
// • Compiler Optimizations
import java.util.*;

public class Kosarajus_Algorithm {
    List<List<Integer>> createGraphList(int edges[][],int V){
        List<List<Integer>> graph=new ArrayList<>();
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
    List<List<Integer>> reverseGraph(List<List<Integer>> adjList,int V){
        List<List<Integer>> revAdjList=new ArrayList<>();
        for(int i=0;i<V;i++){
            revAdjList.add(new ArrayList<>());
        }
        for(int u=0;u<V;u++){
            for(int v:adjList.get(u)){
                revAdjList.get(v).add(u);
            }
        }
        return revAdjList;
    }
    Stack<Integer> getFinishOrder(List<List<Integer>> adjList,int V){
        Stack<Integer> st=new Stack<>();
        boolean[] vis=new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(i,vis,adjList,st);
            }
        }
        return st;
    }
    void dfs(int node, boolean vis[], List<List<Integer>> adj, Stack<Integer> st){
        vis[node]=true;
        for(int n:adj.get(node)){
            if(!vis[n]){
                dfs(n,vis,adj,st);
            }
        }
        st.push(node);
    }
    void dfs2(int node, boolean vis[], List<List<Integer>> adj){
        vis[node]=true;
        for(int n:adj.get(node)){
            if(!vis[n]){
                dfs2(n,vis,adj);
            }
        }
    }
    int kosaraju(int V, int[][] edges) {
        List<List<Integer>> adjList=createGraphList(edges,V);

        Stack<Integer> st=getFinishOrder(adjList,V);

        List<List<Integer>> revAdjList=reverseGraph(adjList,V);

        boolean vis[]=new boolean[V];
        int scc=0;
        while(!st.isEmpty()){
            int node=st.pop();
            if(!vis[node]){
                scc++;
                dfs2(node,vis,revAdjList);
            }
        }
        return scc;
    }

    void dfs3(int node, boolean vis[], List<List<Integer>> adj,List<Integer> comp){
        vis[node]=true;
        comp.add(node);
        for(int n:adj.get(node)){
            if(!vis[n]){
                dfs3(n,vis,adj,comp);
            }
        }
    }
    List<List<Integer>> kosarajuLSCC(int V, int[][] edges) {
        List<List<Integer>> adjList=createGraphList(edges,V);

        Stack<Integer> st=getFinishOrder(adjList,V);

        List<List<Integer>> revAdjList=reverseGraph(adjList,V);

        boolean vis[]=new boolean[V];
        List<List<Integer>> sccList=new ArrayList<>();
        while(!st.isEmpty()){
            int node=st.pop();
            if(!vis[node]){
                List<Integer> component=new ArrayList<>();
                dfs3(node,vis,revAdjList,component);
                sccList.add(component);
            }
        }
        return sccList;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Kosarajus_Algorithm ob = new Kosarajus_Algorithm();
        int V=5;
        int edges[][]={{0, 2}, {0, 3}, {1, 0}, {2, 1}, {3, 4}};
        int scc=ob.kosaraju(V, edges);
        System.out.println("The no. of Strongly Connected Components: "+scc);
        List<List<Integer>> sccList=ob.kosarajuLSCC(V,edges);
        System.out.println("The Strongly Connected Components are: ");
        for(List<Integer> lt:sccList){
            System.out.println(lt);
        }
    }
}
