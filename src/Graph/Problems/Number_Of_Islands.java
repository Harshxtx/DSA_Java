package Graph.Problems;

import java.util.*;

public class Number_Of_Islands {
    class Pair{
        int fst;
        int sec;
        Pair(int fst,int sec){
            this.fst=fst;
            this.sec=sec;
        }
    }
    void bfs(int r,int c,int vis[][], char grid[][]){
        vis[r][c]=1;
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(r,c));
        int n=grid.length,m=grid[0].length;
        while(!q.isEmpty()){
            int row=q.peek().fst;
            int col=q.peek().sec;
            q.poll();

            int dRow[]={-1,0,1,0};                                  // for 4 directions
            int dCol[]={0,1,0,-1};
            for(int i=0;i<4;i++){
                int nrow=row+dRow[i];
                int ncol=col+dCol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]=='1' && vis[nrow][ncol]==0){
                    vis[nrow][ncol]=1;
                    q.add(new Pair(nrow,ncol));
                }
            }

//            for(int delrow=-1;delrow<=1;delrow++){                //for 8 directions
//                for(int delcol=-1;delcol<=1;delcol++){
//                    int nrow=row+delrow;
//                    int ncol=col+delcol;
//                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]=='1' && vis[nrow][ncol]==0){
//                        vis[nrow][ncol]=1;
//                        q.add(new Pair(nrow,ncol));
//                    }
//                }
//            }
        }
    }
    public int numIslands(char[][] grid) {
        int cnt=0;
        int n=grid.length,m=grid[0].length;
        int[][] vis=new int[n][m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]=='1'){
                    cnt++;
                    bfs(i,j,vis,grid);
                }
            }
        }
        return cnt;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Number_Of_Islands ob = new Number_Of_Islands();
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        int noOfIslands=ob.numIslands(grid);
        System.out.println("No. of Islands are: "+noOfIslands);
    }
}
