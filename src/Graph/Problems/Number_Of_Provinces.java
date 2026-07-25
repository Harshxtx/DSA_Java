package Graph.Problems;

import java.util.*;

public class Number_Of_Provinces {
    // 1st Method: Using DFS Traversal
    void dfsRec(int[][] matrix,boolean[] visited,int node){
        visited[node]=true;
        for(int i=0;i<matrix.length;i++) {
            if(matrix[node][i]==1 && !visited[i]){
                dfsRec(matrix,visited,i);
            }
        }
    }
    int findCircleNum(int[][] matrix) {
        boolean[] visited=new boolean[matrix.length];
        int count=0;
        for (int i=0;i<matrix.length;i++) {
            if(!visited[i]){
                dfsRec(matrix, visited, i);
                count++;
            }
        }
        return count;
    }

    // 2nd Method: Using BFS Traversal
//    int findCircleNum(int[][] matrix) {
//        int count=0;
//        boolean[] visited = new boolean[matrix.length];
//        for(int i=0;i<matrix.length;i++) {
//            if(!visited[i]) {
//                count++;
//                Queue<Integer> q=new LinkedList<>();
//                q.offer(i);
//                visited[i] = true;
//                while (!q.isEmpty()) {
//                    int node = q.poll();
//                    for(int j=0;j<matrix.length;j++) {
//                        if (matrix[node][j]==1 && !visited[j]) {
//                            visited[j] = true;
//                            q.offer(j);
//                        }
//                    }
//                }
//            }
//        }
//        return count;
//    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Number_Of_Provinces ob = new Number_Of_Provinces();
        int matrix[][]={{1,1,0},{1,1,0},{0,0,1}};
        int provinces=ob.findCircleNum(matrix);
        System.out.println("Number of provinces are: "+provinces);
    }
}
