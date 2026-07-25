package Graph.Problems;
// Rotten Oranges
//
// Given a grid where:
// 0 -> Empty Cell
// 1 -> Fresh Orange
// 2 -> Rotten Orange
//
// Every minute, every rotten orange
// spreads to its adjacent fresh oranges.
//
// We need to find the minimum time
// required to rot all fresh oranges.
//
// We solve this using Multi-Source BFS.
//
// Why Multi-Source BFS?
// Because all rotten oranges spread
// simultaneously.
//
// Time Complexity : O(N × M)
// Space Complexity : O(N × M)
//
// Applications:
// • Multi-Source BFS
// • Virus Spread
// • Fire Spread
// • Infection Simulation
// • Minimum Time Problems

import java.util.*;

public class Rotten_Oranges {
    class Triple{
        int row;
        int col;
        int time;
        Triple(int row,int col,int time){
            this.row=row;
            this.col=col;
            this.time=time;
        }
    }
    public int orangesRotting(int[][] grid) {
        int i,j,l1=grid.length,l2=grid[0].length;
        boolean vis[][]=new boolean[l1][l2];
        int cntFresh=0;
        Queue<Triple> q=new LinkedList<>();
        for(i=0;i<l1;i++){
            for(j=0;j<l2;j++){
                if(grid[i][j]==2){
                    q.offer(new Triple(i,j,0));
                    vis[i][j]=true;
                }
                if(grid[i][j]==1)
                    cntFresh++;
            }
        }
        int tm=0;
        int cnt=0;
        int dRow[]={-1,0,1,0};
        int dCol[]={0,1,0,-1};
        while(!q.isEmpty()){
            int r=q.peek().row;
            int c=q.peek().col;
            int t=q.peek().time;
            q.poll();
            tm=Math.max(tm,t);
            for(i=0;i<4;i++){
                int nrow=r+dRow[i];
                int ncol=c+dCol[i];
                if(nrow>=0 && nrow<l1 && ncol>=0 && ncol<l2 && !vis[nrow][ncol] && grid[nrow][ncol]==1){
                    q.add(new Triple(nrow,ncol,t+1));
                    vis[nrow][ncol]=true;
                    cnt++;
                }
            }
        }
        if(cnt!=cntFresh)
            return -1;
        return tm;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Rotten_Oranges ob = new Rotten_Oranges();
        int grid[][]={{2,1,1},{1,1,0},{0,1,1}};
        int time=ob.orangesRotting(grid);
        if(time!=-1)
            System.out.println("Minimum time taken to rotten the oranges: "+time);
        else
            System.out.println("All the oranges are not rotten");
    }
}
