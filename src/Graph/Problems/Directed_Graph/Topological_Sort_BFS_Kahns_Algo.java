package Graph.Problems.Directed_Graph;
// Topological Sort - BFS (Kahn's Algorithm)
//
// Topological Sorting is a linear ordering
// of vertices such that for every directed
// edge u → v,
// vertex u appears before vertex v.
//
// Kahn's Algorithm:
//
// 1. Compute indegree of every vertex.
// 2. Push all vertices having indegree = 0
//    into a queue.
// 3. Remove a node from the queue.
// 4. Add it to the answer.
// 5. Reduce indegree of all its neighbours.
// 6. If any neighbour's indegree becomes 0,
//    push it into the queue.
//
// Works only for DAG.
//
// Time Complexity : O(V + E)
//
// Space Complexity : O(V)

import java.util.*;

public class Topological_Sort_BFS_Kahns_Algo {
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
    ArrayList<Integer> topoSort(int V, ArrayList<ArrayList<Integer>> adjList) {
        int indegree[] = new int[V];
        for(int i=0;i<V;i++){
            for(int it:adjList.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i]==0) {
                q.offer(i);
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        while(!q.isEmpty()){
            int node=q.poll();
            ans.add(node);
            for(int it:adjList.get(node)){
                indegree[it]--;
                if(indegree[it]==0)
                    q.offer(it);
            }
        }
        return ans;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Topological_Sort_BFS_Kahns_Algo ob = new Topological_Sort_BFS_Kahns_Algo();
        int V=6;
        int edges[][]={{1, 3}, {2, 3}, {4, 1}, {4, 0}, {5, 0}, {5, 2}};
        ArrayList<ArrayList<Integer>> adjList=ob.createGraphList(edges,V);
        ArrayList<Integer> ans=ob.topoSort(V, adjList);
        System.out.println("Topological Sort:"+ans);
    }
}
