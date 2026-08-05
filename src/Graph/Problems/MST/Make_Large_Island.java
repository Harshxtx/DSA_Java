package Graph.Problems.MST;
// Making A Large Island
//
// Build all existing islands using DSU.
//
// Step 1:
// • Union adjacent land cells.
//
// Step 2:
// • For every water cell,
//   assume it becomes land.
// • Collect all unique neighbouring
//   components.
// • Sum their sizes + 1.
//
// Step 3:
// • Return the maximum possible island.
//
// Time Complexity:
// O(N² α(N))
//
// Space Complexity:
// O(N²)

import java.util.*;

public class Make_Large_Island {
    int[] parent;
    int[] size;
    int findParent(int node) {
        if (node == parent[node])
            return node;
        return parent[node]=findParent(parent[node]);
    }
    void unionBySize(int u, int v) {
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        if (ulp_u == ulp_v)
            return;

        if (size[ulp_u] < size[ulp_v]) {
            parent[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
        }
        else {
            parent[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
        }
    }
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        parent = new int[n*n];
        size = new int[n*n];
        for(int i = 0; i < n*n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        int cnt=0;
        int dRow[]={-1,0,1,0};
        int dCol[]={0,1,0,-1};
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    for(int k=0;k<4;k++){
                        int nrow=i+dRow[k];
                        int ncol=j+dCol[k];
                        if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && grid[nrow][ncol]==1){
                            int nodeNo=i*n+j;
                            int adjNode=nrow*n+ncol;
                            unionBySize(nodeNo,adjNode);
                        }
                    }
                }
            }
        }
        int max=0;
        boolean hasZero=false;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    hasZero=true;
                    Set<Integer> unique=new HashSet<>();
                    for(int k=0;k<4;k++){
                        int nrow=i+dRow[k];
                        int ncol=j+dCol[k];
                        if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && grid[nrow][ncol]==1){
                            int adjNode=nrow*n+ncol;
                            unique.add(findParent(adjNode));
                        }
                    }
                    int tSize=1;
                    for(int node:unique){
                        tSize+=size[node];
                    }
                    max=Math.max(max,tSize);
                }
            }
        }
        return hasZero?max:n*n;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Make_Large_Island ob = new Make_Large_Island();
        int grid[][]={{1,0},{0,1}};
        int islandSize=ob.largestIsland(grid);
        System.out.println("The Largest possible size of Island: "+islandSize);
    }
}
