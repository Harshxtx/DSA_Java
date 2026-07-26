package Graph.Problems;

import java.util.*;

class Surrounded_Region{
    int dRow[]={-1,0,1,0};
    int dCol[]={0,1,0,-1};
    void dfs(int r,int c,char board[][],boolean vis[][]){
        vis[r][c]=true;
        for(int i=0;i<4;i++){
            int nrow=r+dRow[i];
            int ncol=c+dCol[i];
            if(nrow>=0 && nrow<vis.length && ncol>=0 && ncol<vis[0].length && !vis[nrow][ncol] && board[nrow][ncol]=='O')
                dfs(nrow,ncol,board,vis);
        }
    }
    public void solve(char[][] board) {
        int i,j,l1=board.length,l2=board[0].length;
        boolean vis[][]=new boolean[l1][l2];
        for(j=0;j<l2;j++){
            if(!vis[0][j] && board[0][j]=='O'){
                dfs(0,j,board,vis);
            }
            if(!vis[l1-1][j] && board[l1-1][j]=='O'){
                dfs(l1-1,j,board,vis);
            }
        }
        for(i=0;i<l1;i++){
            if(!vis[i][0] && board[i][0]=='O'){
                dfs(i,0,board,vis);
            }
            if(!vis[i][l2-1] && board[i][l2-1]=='O'){
                dfs(i,l2-1,board,vis);
            }
        }
        for(i=0;i<l1;i++){
            for(j=0;j<l2;j++){
                if(!vis[i][j] && board[i][j]=='O')
                    board[i][j]='X';
            }
        }
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Surrounded_Region ob=new Surrounded_Region();
        char board[][]={{'X','X','X','X'},
                        {'X','O','O','X'},
                        {'X','X','O','X'},
                        {'X','O','X','X'}};
        ob.solve(board);
        for(char ch[]:board){
            System.out.println(Arrays.toString(ch));
        }
    }
}
