package Graph.Problems;

import java.util.*;

public class Distinct_Number_Of_Islands {
    void dfs(int r,int c,char grid[][],boolean vis[][],ArrayList<String> shape,int r0,int c0){
        vis[r][c]=true;
        shape.add(Integer.toString(r-r0)+" "+Integer.toString(c-c0));
        int n=grid.length,m=grid[0].length;
        int dRow[]={-1,0,1,0};
        int dCol[]={0,-1,0,1};
        for(int i=0;i<4;i++){
            int nrow=r+dRow[i];
            int ncol=c+dCol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]=='L' && !vis[nrow][ncol]){
                dfs(nrow,ncol,grid,vis,shape,r0,c0);
            }
        }
    }
    public int countDistinctIslands(char[][] grid) {
        int i,j,l1=grid.length,l2=grid[0].length;
        boolean[][] vis=new boolean[l1][l2];
        HashSet<ArrayList<String>> hs=new HashSet<>();
        for(i=0;i<l1;i++){
            for(j=0;j<l2;j++){
                if(!vis[i][j] && grid[i][j]=='L'){
                    ArrayList<String> shape=new ArrayList<>();
                    dfs(i,j,grid,vis,shape,i,j);
                    hs.add(shape);
                }
            }
        }
        return hs.size();
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Distinct_Number_Of_Islands ob = new Distinct_Number_Of_Islands();
        char grid[][]= {{'L', 'L', 'W', 'L', 'L'},
                        {'L', 'W', 'W', 'W', 'W'},
                        {'W', 'W', 'L', 'W', 'L'},
                        {'L', 'W', 'W', 'L', 'L'}
        };
        int count=ob.countDistinctIslands(grid);
        System.out.println("Number of Distinct Islands are: "+count);
    }
}
