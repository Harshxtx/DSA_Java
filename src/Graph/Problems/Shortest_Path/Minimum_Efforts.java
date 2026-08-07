package Graph.Problems.Shortest_Path;

import java.util.*;

public class Minimum_Efforts {
    class Tuple{
        int distance;
        int row;
        int col;
        Tuple(int distance,int row,int col){
            this.distance=distance;
            this.row=row;
            this.col=col;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Tuple> pq=new PriorityQueue<>((a,b) -> a.distance-b.distance);
        pq.add(new Tuple(0,0,0));
        int n=heights.length,m=heights[0].length;
        int dis[][]=new int[n][m];
        for(int a[]:dis){
            Arrays.fill(a,(int)1e9);
        }
        dis[0][0]=0;
        int dRow[]={-1,0,1,0};
        int dCol[]={0,1,0,-1};
        while(!pq.isEmpty()){
            Tuple curr=pq.poll();
            int diff=curr.distance;
            int r=curr.row;
            int c=curr.col;
            if(r==n-1 && c==m-1)
                return diff;
            for(int i=0;i<4;i++){
                int nrow=r+dRow[i];
                int ncol=c+dCol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m){
                    int newEff=Math.max(Math.abs(heights[r][c]-heights[nrow][ncol]),diff);
                    if(newEff<dis[nrow][ncol]){
                        dis[nrow][ncol]=newEff;
                        pq.add(new Tuple(newEff,nrow,ncol));
                    }
                }
            }
        }
        return 0;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Minimum_Efforts ob = new Minimum_Efforts();
        int heights[][]={{1,2,2},{3,8,2},{5,3,5}};
        int minEff=ob.minimumEffortPath(heights);
        System.out.println("Minimum Efforts required: "+minEff);
    }
}
