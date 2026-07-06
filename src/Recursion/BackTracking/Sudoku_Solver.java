package Recursion.BackTracking;

import java.util.*;

public class Sudoku_Solver {
    boolean isValid(char board[][],int r,int c,char ch){
        for(int i=0;i<board.length;i++){
            if(board[i][c]==ch)
                return false;
            if(board[r][i]==ch)
                return false;
            if(board[3*(r/3)+i/3][3*(c/3)+i%3]==ch)                 //for 3*3 submatrix
                return false;
        }
        return true;
    }
    boolean solve(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    for(char c='1';c<='9';c++){
                        if(isValid(board,i,j,c)){
                            board[i][j]=c;              //chose digit
                            if(solve(board)==true)      //explore
                                return true;
                            else
                                board[i][j]='.';        //undo choice
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Sudoku_Solver ob = new Sudoku_Solver();
        char board[][]={{'5','3','.','.','7','.','.','.','.'}
                       ,{'6','.','.','1','9','5','.','.','.'}
                       ,{'.','9','8','.','.','.','.','6','.'}
                       ,{'8','.','.','.','6','.','.','.','3'}
                       ,{'4','.','.','8','.','3','.','.','1'}
                       ,{'7','.','.','.','2','.','.','.','6'}
                       ,{'.','6','.','.','.','.','2','8','.'}
                       ,{'.','.','.','4','1','9','.','.','5'}
                       ,{'.','.','.','.','8','.','.','7','9'}};
        ob.solveSudoku(board);
        for(int i=0;i<9;i++){
            System.out.println(Arrays.toString(board[i]));
        }
    }
}
