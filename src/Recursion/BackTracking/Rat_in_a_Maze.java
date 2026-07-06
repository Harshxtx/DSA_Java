package Recursion.BackTracking;

import java.util.*;

public class Rat_in_a_Maze {
    void solve(int r,int c,int maze[][],List<String> ans,String st,boolean vis[][]){
        if(r==maze.length-1 && c==maze[0].length-1){
            ans.add(st);
            return;
        }
        if(r+1<maze.length && !vis[r+1][c] && maze[r+1][c]==1){
            vis[r][c]=true;
            solve(r+1,c,maze,ans,st+'D',vis);
            vis[r][c]=false;
        }
        if(c-1>=0 && !vis[r][c-1] && maze[r][c-1]==1){
            vis[r][c]=true;
            solve(r,c-1,maze,ans,st+'L',vis);
            vis[r][c]=false;
        }
        if(c+1<maze[0].length && !vis[r][c+1] && maze[r][c+1]==1){
            vis[r][c]=true;
            solve(r,c+1,maze,ans,st+'R',vis);
            vis[r][c]=false;
        }
        if(r-1>=0 && !vis[r-1][c] && maze[r-1][c]==1){
            vis[r][c]=true;
            solve(r-1,c,maze,ans,st+'U',vis);
            vis[r][c]=false;
        }
    }
    public List<String> ratInMaze(int[][] maze){
        List<String> res=new ArrayList<>();
        boolean vis[][]=new boolean[maze.length][maze[0].length];
        if(maze[0][0]==1){
            solve(0,0,maze,res,"",vis);
        }
        return res;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Rat_in_a_Maze ob = new Rat_in_a_Maze();
        int maze[][]={{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}};
        List<String> res=ob.ratInMaze(maze);
        System.out.println(res);
    }
}
