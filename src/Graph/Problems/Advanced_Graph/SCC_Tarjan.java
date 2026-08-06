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
// Strongly Connected Components.
//
// Time Complexity:
// • O(V + E)
//
// Space Complexity:
// • O(V)
//
// Applications:
// • Finding SCCs
// • Condensation Graph (DAG of SCCs)
// • Cycle Detection in Directed Graphs
// • Dependency Resolution
// • Deadlock Detection
// • Compiler Optimizations

import java.util.*;

public class SCC_Tarjan {
    int timer=0;
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

    void dfs(int node,List<List<Integer>> adj,boolean vis[],boolean inStack[],
             int tin[],int low[],Stack<Integer> st,List<List<Integer>> sccList){
        vis[node]=true;
        inStack[node]=true;
        tin[node]=low[node]=timer;
        timer++;
        st.push(node);

        for(int n:adj.get(node)){
            if(!vis[n]){
                dfs(n,adj,vis,inStack,tin,low,st,sccList);
                low[node]=Math.min(low[node],low[n]);
            }
            else if(inStack[n]){
                low[node]=Math.min(low[node],tin[n]);
            }
        }

        if(low[node]==tin[node]){
            List<Integer> comp=new ArrayList<>();
            while(true){
                int top=st.pop();
                inStack[top]=false;
                comp.add(top);
                if(top==node)
                    break;
            }
            sccList.add(comp);
        }
    }

    List<List<Integer>> tarjanSCC(int V,int[][] edges){
        List<List<Integer>> adj=createGraphList(edges,V);
        boolean vis[]=new boolean[V];
        boolean inStack[]=new boolean[V];
        int tin[]=new int[V];
        int low[]=new int[V];
        Stack<Integer> st=new Stack<>();
        List<List<Integer>> sccList=new ArrayList<>();
        timer=0;

        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(i,adj,vis,inStack,tin,low,st,sccList);
            }
        }
        return sccList;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        SCC_Tarjan ob = new SCC_Tarjan();
        int V=5;
        int edges[][]={{0, 2}, {0, 3}, {1, 0}, {2, 1}, {3, 4}};
        List<List<Integer>> sccList=ob.tarjanSCC(V,edges);
        System.out.println("The Strongly Connected Components are: ");
        for(List<Integer> lt:sccList){
            System.out.println(lt);
        }
    }
}
