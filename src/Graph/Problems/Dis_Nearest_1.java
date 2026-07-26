package Graph.Problems;
// Distance of Nearest Cell Having 1
//
// Given a binary matrix,
// find the distance of every cell
// from its nearest cell containing 1.
//
// We use Multi-Source BFS.
//
// Initially,
// every cell containing 1 is inserted
// into the queue with distance 0.
//
// BFS spreads simultaneously from
// every source.
//
// The first time a cell is visited,
// it is guaranteed to have the
// shortest distance.
//
// Time Complexity : O(N × M)
//
// Space Complexity : O(N × M)
//
// Applications:
// • Distance Transform
// • Nearest Facility Problems
// • Multi-Source BFS
// • Fire Spread
// • Virus Spread

import java.util.*;

public class Dis_Nearest_1 {
    class Triple{
        int row;
        int col;
        int dis;
        Triple(int row,int col,int dis){
            this.row=row;
            this.col=col;
            this.dis=dis;
        }
    }
    public int [][] nearest(int[][] grid) {
        int l1=grid.length,l2=grid[0].length;
        int vis[][]=new int[l1][l2];
        int dis[][]=new int[l1][l2];
        Queue<Triple> q=new LinkedList<>();
        for(int i=0;i<l1;i++){
            for(int j=0;j<l2;j++){
                if(grid[i][j]==1){
                    q.offer(new Triple(i,j,0));
                    vis[i][j]=1;
                }
            }
        }
        int dRow[]={-1,0,1,0};
        int dCol[]={0,1,0,-1};
        while(!q.isEmpty()){
            Triple curr=q.poll();
            int r=curr.row;
            int c=curr.col;
            int steps=curr.dis;
            q.poll();
            dis[r][c]=steps;
            for(int i=0;i<4;i++){
                int nrow=r+dRow[i];
                int ncol=c+dCol[i];
                if(nrow>=0 && nrow<l1 && ncol>=0 && ncol<l2 && vis[nrow][ncol]==0){
                    q.add(new Triple(nrow,ncol,steps+1));
                    vis[nrow][ncol]=1;
                }
            }
        }
        return dis;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Dis_Nearest_1 ob = new Dis_Nearest_1();
        int[][] grid = {{0, 1, 1, 0},
                {1, 1, 0, 0},
                {0, 0, 1, 1}
        };
        int ans[][]=ob.nearest(grid);
        for(int a[]:ans){
            System.out.println(Arrays.toString(a));
        }
    }
}