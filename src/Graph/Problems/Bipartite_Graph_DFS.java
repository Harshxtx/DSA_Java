package Graph.Problems;
// Bipartite Graph - DFS
//
// A graph is Bipartite if its vertices
// can be coloured using only two colours
// such that no two adjacent vertices
// have the same colour.
//
// DFS Algorithm:
//
// 1. Colour the current node.
// 2. Visit all neighbours.
// 3. If a neighbour is uncoloured,
//    colour it with the opposite colour
//    and continue DFS.
// 4. If a neighbour already has the
//    same colour as the current node,
//    the graph is NOT Bipartite.
//
// Time Complexity : O(V + E)
//
// Space Complexity : O(V)
//
// Applications:
// • Graph Colouring
// • Scheduling Problems
// • Matching Problems
// • Detecting Odd-Length Cycles

import java.util.*;

public class Bipartite_Graph_DFS {
    boolean colorGraph(int node,int col,int graph[][], int color[]){
        color[node]=col;
        for(int adjNode:graph[node]){
            if(color[adjNode]==0){
                if(!colorGraph(adjNode,-col,graph,color))
                    return false;
            }
            else if(color[adjNode]==col){
                return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int color[]= new int[graph.length];
        for (int i=0;i<graph.length;i++) {
            if (color[i]==0) {
                if (!colorGraph(i,1,graph,color))
                    return false;
            }
        }
        return true;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Bipartite_Graph_DFS ob = new Bipartite_Graph_DFS();
        int graph[][]= {{1,3},
                        {0,2},
                        {1,3},
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
