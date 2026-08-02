package Graph.Problems.Shortest_Path;
// Time Complexity : O(N × M)
//
// Space Complexity : O(N × M)
//
// Applications:
// • Grid Shortest Path
// • Maze Problems
// • Robot Navigation
// • Matrix Traversal

import java.util.*;

public class Shortest_Dis_Binary_Maze {
    class tuple{
        int distance;
        int row;
        int col;
        tuple(int distance,int row,int col){
            this.distance=distance;
            this.row=row;
            this.col=col;
        }
    }
    public int shortestPath(int[][] mat, int[] src, int[] dest) {
        if(mat[src[0]][src[1]]==0 || mat[dest[0]][dest[1]]==0)
            return -1;
        if(src[0]==dest[0] && src[1]==dest[1])
            return 0;
        int n=mat.length,m=mat[0].length;
        Queue<tuple> q=new LinkedList<>();
        int dist[][]=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i],(int)1e9);
        }
        dist[src[0]][src[1]]=0;
        q.add(new tuple(0,src[0],src[1]));
//        int dRow[]={-1,0,1,0};                            //for 4 direction
//        int dCol[]={0,1,0,-1};
        while(!q.isEmpty()){
            tuple curr=q.poll();
            int dis=curr.distance;
            int r=curr.row;
            int c=curr.col;
//            for(int i=0;i<4;i++){
//                int nrow=r+dRow[i];
//                int ncol=c+dCol[i];
//                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && mat[nrow][ncol]==1 && dis+1<dist[nrow][ncol]){
//                    dist[nrow][ncol]=1+dis;
//                    if(nrow==dest[0] && ncol==dest[1]){
//                        return dis+1;
//                    }
//                    q.add(new tuple(1+dis,nrow,ncol));
//                }
//            }
            for(int delrow=-1;delrow<=1;delrow++){
                for(int delcol=-1;delcol<=1;delcol++){
                    int nrow=r+delrow;
                    int ncol=c+delcol;
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && mat[nrow][ncol]==1 && dis+1<dist[nrow][ncol]){
                        dist[nrow][ncol]=1+dis;
                        if(nrow==dest[0] && ncol==dest[1]){
                            return dis+1;
                        }
                        q.add(new tuple(1+dis,nrow,ncol));
                    }
                }
            }
        }
        return -1;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Shortest_Dis_Binary_Maze ob = new Shortest_Dis_Binary_Maze();
        int mat[][]={{1, 1, 1, 1},
                     {1, 1, 0, 1},
                     {1, 1, 1, 1},
                     {1, 1, 0, 0},
                     {1, 0, 0, 1}
        };
        int src[]={0,0};
        int dest[]={2,2};
        int dis=ob.shortestPath(mat, src, dest);
        if(dis!=-1)
            System.out.println("The shortest path: "+dis);
        else
            System.out.println("No path exists");
    }
}
