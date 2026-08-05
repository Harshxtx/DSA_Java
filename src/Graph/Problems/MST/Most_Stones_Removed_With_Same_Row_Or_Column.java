package Graph.Problems.MST;

import java.util.*;

public class Most_Stones_Removed_With_Same_Row_Or_Column {
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
    public int removeStones(int[][] stones) {
        int maxRow=0;
        int maxCol=0;
        int n=stones.length;
        for(int i=0;i<n;i++){
            maxRow=Math.max(maxRow,stones[i][0]);
            maxCol=Math.max(maxCol,stones[i][1]);
        }
        parent = new int[maxRow+maxCol+2];
        size = new int[maxRow+maxCol+2];
        for(int i=0;i<maxRow+maxCol+2;i++) {
            parent[i]=i;
            size[i]=1;
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            int r=stones[i][0];
            int c=stones[i][1]+maxRow+1;
            unionBySize(r,c);
            map.put(r,1);
            map.put(c,1);
        }
        int cnt=0;
        for(Map.Entry<Integer, Integer> it:map.entrySet()){
            if(findParent(it.getKey())==it.getKey())
                cnt++;
        }
        return n-cnt;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Most_Stones_Removed_With_Same_Row_Or_Column ob = new Most_Stones_Removed_With_Same_Row_Or_Column();
        int stones[][]={{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        int removed=ob.removeStones(stones);
        System.out.println("No. of stones removed: "+removed);
    }
}
