package Graph.Problems;
// Flood Fill
//
// Given a starting pixel, replace its colour and all
// connected pixels having the same original colour.
//
// We perform DFS/BFS from the starting pixel.
//
// Every connected pixel with the
// original colour is replaced.
//
// Time Complexity : O(N × M)
//
// Space Complexity : O(N × M)
//
// Applications:
// • Paint Bucket Tool
// • Image Processing
// • Region Filling
// • Connected Component Labelling
import java.util.*;

public class Flood_Fill_Algo {
    void dfs(int img[][],int i,int j,int color,int src){
        if(i<0 || i>=img.length || j<0 || j>=img[0].length)
            return ;
        if(img[i][j]!=src)
            return;
        img[i][j]=color;
        dfs(img,i-1,j,color,src);
        dfs(img,i,j-1,color,src);
        dfs(img,i+1,j,color,src);
        dfs(img,i,j+1,color,src);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color)
            return image;
        dfs(image,sr,sc,color,image[sr][sc]);
        return image;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Flood_Fill_Algo ob = new Flood_Fill_Algo();
        int image[][]= {{1,1,1},
                        {1,1,0},
                        {1,0,1}};
        int color=2;
        System.out.println("Initial Image: ");
        for(int arr[]:image){
            System.out.println(Arrays.toString(arr));
        }
        int res[][]= ob.floodFill(image,1,1,color);
        System.out.println("Image after flood fill: ");
        for(int arr[]:res){
            System.out.println(Arrays.toString(arr));
        }
    }
}
