package Graph.Problems.MST;

import java.util.*;

public class Prims_MST {
    class Pair{
        int weight;
        int node;
        int parent;
        public Pair(int weight,int node,int parent){
            this.weight=weight;
            this.node=node;
            this.parent=parent;
        }
    }
    class Edge{
        int u;
        int v;
        int wt;
        public Edge(int u,int v,int wt){
            this.u=u;
            this.v=v;
            this.wt=wt;
        }
    }
    List<List<Pair>> createGraphList(int edges[][], int V){
        List<List<Pair>> graph=new ArrayList<>();
        for(int i=0;i<V;i++){
            graph.add(new ArrayList<>());
        }
        for(int a[]:edges){
            int u=a[0];
            int v=a[1];
            int wt=a[2];
            graph.get(u).add(new Pair(wt,v,u));
            graph.get(v).add(new Pair(wt,u,v));
        }
        return graph;
    }
    List<Edge> primsMST(int V, int[][] edges){
        List<List<Pair>> adj=createGraphList(edges,V);
        List<Edge> res=new ArrayList<>();
        boolean vis[]=new boolean[V];
        PriorityQueue<Pair> pq=new PriorityQueue<>((a, b) -> a.weight-b.weight);
        pq.add(new Pair(0,0,-1));
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int wt=curr.weight;
            int node=curr.node;
            int par=curr.parent;
            if(vis[node])
                continue;
            if(par!=-1){
                res.add(new Edge(par,node,wt));
            }
            vis[node]=true;
            for(Pair neighbour:adj.get(node)){
                int adjNode=neighbour.node;
                int edWt=neighbour.weight;
                if(!vis[adjNode]){
                    pq.add(new Pair(edWt,adjNode,node));
                }
            }
        }
        return res;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Prims_MST ob = new Prims_MST();
        int V=5;
        int edge[][]={{0,1,2},{0,2,1},{1,2,1},{2,3,2},{2,4,2},{3,4,1}};
        List<Edge> mst=ob.primsMST(V,edge);
        System.out.println("Edges in Minimum Spanning Tree:");
        for (Edge ed : mst) {
            System.out.println(ed.u + " -> " +ed.v + " : " + ed.wt);
        }
    }
}
