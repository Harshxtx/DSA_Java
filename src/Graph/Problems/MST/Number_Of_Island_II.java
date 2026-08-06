package Graph.Problems.MST;
// Number of Islands II
//
// Initially every cell is water.
//
// For each operation:
//
// • Convert water → land.
// • Assume it forms a new island.
// • Check its 4 neighbours.
// • Merge neighbouring islands
//   using DSU.
// • Every successful merge
//   reduces island count by 1.
//
// Store the island count after
// every operation.
//
// Time Complexity:
// O(K · α(R×C))
//
// Space Complexity:
// O(R×C)

import java.util.*;

public class Number_Of_Island_II {
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
    public List<Integer> numOfIslands(int r, int c, int[][] operators) {
        parent = new int[r*c];
        size = new int[r*c];
        for(int i = 0; i < r*c; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        boolean vis[][]=new boolean[r][c];
        int cnt=0;
        int dRow[]={-1,0,1,0};
        int dCol[]={0,1,0,-1};
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<operators.length;i++){
            int row=operators[i][0];
            int col=operators[i][1];
            if(vis[row][col]){
                ans.add(cnt);
                continue;
            }
            vis[row][col]=true;
            cnt++;
            for(int j=0;j<4;j++){
                int nrow=row+dRow[j];
                int ncol=col+dCol[j];
                if(nrow>=0 && nrow<r && ncol>=0 && ncol<c && vis[nrow][ncol]){
                    int nodeNo=row*c+col;
                    int adjNode=nrow*c+ncol;
                    if(findParent(nodeNo)!=findParent(adjNode)){
                        cnt--;
                        unionBySize(nodeNo,adjNode);
                    }
                }
            }
            ans.add(cnt);
        }
        return ans;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Number_Of_Island_II ob = new Number_Of_Island_II();
        int row=4;
        int col=5;
        int op[][]={{1,1},{0,1},{3,3},{3,4}};
        List<Integer> ans=ob.numOfIslands(row,col,op);
        System.out.println(ans);
    }
}
