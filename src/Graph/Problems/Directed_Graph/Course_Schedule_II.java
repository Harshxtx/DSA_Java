package Graph.Problems.Directed_Graph;

import java.util.*;

public class Course_Schedule_II {
    List<List<Integer>> createGraphList(int edges[][],int V){
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<V;i++){
            graph.add(new ArrayList<>());
        }
        for(int a[]:edges){
            int u=a[0];
            int v=a[1];
            graph.get(v).add(u);
        }
        return graph;
    }
    public List<Integer> findOrder(int V, int[][] prerequisites) {
        List<List<Integer>> adjList=createGraphList(prerequisites,V);
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
        if(ans.size()==V)
            return ans;
        return new ArrayList<>();
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Course_Schedule_II ob = new Course_Schedule_II();
        int numCourses=4;
        int prerequisites[][]={{1,0},{2,0},{3,1},{3,2}};
        List<Integer> ans=ob.findOrder(numCourses, prerequisites);
        if(!ans.isEmpty()){
            System.out.println("Solution: "+ans);
        }
        else{
            System.out.println("No solution");
        }
    }
}
