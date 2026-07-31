package Graph.Problems.Directed_Graph;
// Course Schedule I
//
// There are numCourses courses labelled
// from 0 to numCourses - 1.
//
// prerequisites[i] = [a, b]
// means you must complete course b
// before taking course a.
//
// This problem can be solved using:
//
// 1. DFS Cycle Detection
// 2. Kahn's Algorithm (Topological Sort)
//
// If the graph contains a cycle,
// it is impossible to finish all courses.
//
// Time Complexity : O(V + E)
//
// Space Complexity : O(V + E)
import java.util.*;

public class Course_Schedule_I {
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
    // 1st Method: DFS Cycle Detection
//    boolean detectCycle(int src,List<List<Integer>> adj, int vis[]){
//        vis[src]=2;
//        for(int neighbour:adj.get(src)){
//            if(vis[neighbour]==2){
//                return true;
//            }
//            if(vis[neighbour]==0){
//                if(detectCycle(neighbour,adj,vis))
//                    return true;
//            }
//        }
//        vis[src]=1;
//        return false;
//    }
//    public boolean canFinish(int V, int[][] prerequisites) {
//        int vis[]=new int[V];
//        List<List<Integer>> adjList=createGraphList(prerequisites,V);
//        for(int i=0;i<V;i++){
//            if(vis[i]==0){
//                if(detectCycle(i,adjList,vis))
//                    return false;
//            }
//        }
//        return true;
//    }

    // 2nd Method: Kahn's Algorithm
    boolean canFinish(int V, int[][] prerequisites) {
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
        return cnt==V;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Course_Schedule_I ob = new Course_Schedule_I();
        int numCourses=2;
        int prerequisites[][]={{0,1}};
        if(ob.canFinish(numCourses, prerequisites)) {
            System.out.println("It is possible to finish the Course Schedule");
        }
        else  {
            System.out.println("It is not possible to finish the Course Schedule");
        }
    }
}
