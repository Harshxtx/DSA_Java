package Graph.Problems.Directed_Graph;
// Cycle Detection in Directed Graph - BFS (Kahn's Algorithm)
//
// Kahn's Algorithm uses Topological Sorting.
//
// Idea:
//
// 1. Compute indegree of every vertex.
// 2. Push all vertices having indegree = 0 into a queue.
// 3. Remove nodes one by one.
// 4. Decrease indegree of their neighbours.
// 5. If neighbour's indegree becomes 0,
//    push it into the queue.
//
// If every vertex gets processed,
// the graph has NO cycle.
//
// If some vertices remain unprocessed,
// a cycle exists.
//
// Time Complexity : O(V + E)
//
// Space Complexity : O(V)

import java.util.*;

public class Cycle_Detection_Directed_BFS_Kahns_Algo {
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
    boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adjList) {
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
        int cnt=0;
        while(!q.isEmpty()){
            int node=q.poll();
            cnt++;
            for(int it:adjList.get(node)){
                indegree[it]--;
                if(indegree[it]==0)
                    q.offer(it);
            }
        }

        return cnt!=V;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Cycle_Detection_Directed_BFS_Kahns_Algo ob = new Cycle_Detection_Directed_BFS_Kahns_Algo();
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
