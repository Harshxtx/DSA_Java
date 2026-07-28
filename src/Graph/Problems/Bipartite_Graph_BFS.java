package Graph.Problems;

import java.util.*;

public class Bipartite_Graph_BFS {
    boolean colorGraph(int src,int graph[][], int color[]){
        Queue<Integer> q=new LinkedList<>();
        q.offer(src);
        color[src]=1;
        while(!q.isEmpty()){
            int node=q.poll();
            for(int neighbour:graph[node]){
                if(color[neighbour]==0){
                    color[neighbour]=-color[node];
                    q.offer(neighbour);
                }
                else if(color[neighbour]==color[node])
                    return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int color[]= new int[graph.length];
        for (int i=0;i<graph.length;i++) {
            if (color[i]==0) {
                if (!colorGraph(i, graph, color))
                    return false;
            }
        }
        return true;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Bipartite_Graph_BFS ob = new Bipartite_Graph_BFS();
        int graph[][]= {{1,2,3},
                        {0,2},
                        {0,1,3},
                        {0,2},
        };
        if (ob.isBipartite(graph)) {
            System.out.println("Given Graph is Bipartite");
        }
        else  {
            System.out.println("Given Graph is not Bipartite");
        }
    }
}
