package Graph.Problems.Directed_Graph;

import java.util.*;

class Eventual_Safe_State_BFS_Kahn_Algo {
    public List<Integer> eventualSafeNodes(int V, int[][] edges) {
        List<List<Integer>> revAdj = new ArrayList<>();
        for (int i = 0; i < V; i++){
            revAdj.add(new ArrayList<>());
        }
        int indegree[]=new int[V];
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            revAdj.get(v).add(u);
            indegree[u]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i]==0) {
                q.offer(i);
            }
        }
        List<Integer> safeNode=new ArrayList<>();
        while(!q.isEmpty()){
            int node=q.poll();
            safeNode.add(node);
            for(int it:revAdj.get(node)){
                indegree[it]--;
                if(indegree[it]==0)
                    q.offer(it);
            }
        }
        return safeNode;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Eventual_Safe_State_BFS_Kahn_Algo ob = new Eventual_Safe_State_BFS_Kahn_Algo();
        int graph[][]={{1,0},{1,2},{1,3},{1,4},{2,3},{3,4}};
        int V=5;
        List<Integer> safeNode=ob.eventualSafeNodes(V,graph);
        System.out.println("The Safe Nodes are:"+safeNode);
    }
}
