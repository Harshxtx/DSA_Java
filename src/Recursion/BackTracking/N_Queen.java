package Recursion.BackTracking;

import java.util.*;

public class N_Queen {
    boolean isSafe(int r,int c,char board[][],int n){
        int i,j;
        for(i=0;i<c;i++){
            if(board[r][i]=='Q')
                return false;
        }
        i=r;
        j=c;
        while(i>=0 && j>=0){
            if(board[i][j]=='Q')
                return false;
            i--;
            j--;
        }
        i=r;
        j=c;
        while(i<n && j>=0){
            if(board[i][j]=='Q')
                return false;
            i++;
            j--;
        }
        return true;
    }
    void nqueen(int c,char board[][],List<List<String>> ans,int n){
        if(c==board.length)
        {
            List<String> st=new ArrayList<>();
            for(int i=0;i<n;i++){
                st.add(new String(board[i]));
            }
            ans.add(new ArrayList<>(st));
            return;
        }
        for(int r=0;r<board.length;r++){
            if(isSafe(r,c,board,n)){
                board[r][c]='Q';
                nqueen(c+1,board,ans,n);
                board[r][c]='.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList<>();
        char board[][]=new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        nqueen(0,board,res,n);
        return res;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        N_Queen ob = new N_Queen();
        int n=4;
        List<List<String>> res=ob.solveNQueens(n);
        System.out.println(res);
    }
}
