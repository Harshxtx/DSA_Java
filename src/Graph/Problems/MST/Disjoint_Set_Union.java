package Graph.Problems.MST;
// Disjoint Set Union (DSU) / Union Find
//
// Efficient Data Structure used to
// maintain multiple disjoint sets.
//
// Supports two operations:
//
// 1. Find
//    • Finds the Ultimate Parent
//      (Representative) of a node.
//    • Uses Path Compression.
//
// 2. Union
//    • Merges two different sets.
//    • Can be done by:
//      - Union By Rank
//      - Union By Size
//
// Path Compression:
// • While finding the Ultimate Parent,
//   every visited node directly points
//   to the Ultimate Parent.
// • Makes future Find operations
//   extremely fast.
//
// Union By Rank:
// • Rank represents the approximate
//   height of the tree.
// • Attach the tree having smaller
//   rank under the tree having
//   larger rank.
// • If both ranks are equal,
//   attach either one and increase
//   its rank by 1.
//
// Union By Size:
// • Size represents the number of
//   nodes in a component.
// • Always attach the smaller
//   component under the larger one.
// • Update the size of the new
//   Ultimate Parent.
//
// Time Complexity:
// • Find            : O(α(N))
// • Union By Rank   : O(α(N))
// • Union By Size   : O(α(N))
//
// α(N) = Inverse Ackermann Function,
// which is practically constant.
//
// Space Complexity:
// • O(N)
//
// Applications:
// • Kruskal's Algorithm
// • Number of Connected Components
// • Cycle Detection
// • Accounts Merge
// • Number of Islands II
// • Dynamic Connectivity Problems

import java.util.*;

public class Disjoint_Set_Union {
    int[] parent;
    int[] rank;
    int[] size;

    public Disjoint_Set_Union(int V) {
        parent = new int[V];
        rank = new int[V];
        size = new int[V];
        for(int i = 1; i < V; i++) {
            parent[i] = i;
            rank[i] = 0;
            size[i] = 1;
        }
    }

    // Find function with Path Compression
    int findParent(int node) {
        if (node == parent[node])
            return node;
        return parent[node]=findParent(parent[node]);
    }

    // Union By Rank
    void unionByRank(int u, int v) {                //currently not used here, can use either of them
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        if (ulp_u == ulp_v)
            return;

        if (rank[ulp_u] < rank[ulp_v]) {
            parent[ulp_u] = ulp_v;
        }
        else if (rank[ulp_v] < rank[ulp_u]) {
            parent[ulp_v] = ulp_u;
        }
        else {
            parent[ulp_v] = ulp_u;
            rank[ulp_u]++;
        }
    }

    // Union By Size
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
    public static void main(String[] args) {
        Disjoint_Set_Union ds = new Disjoint_Set_Union(8);
        ds.unionBySize(1, 2);
        ds.unionBySize(2, 3);
        ds.unionBySize(4, 5);
        ds.unionBySize(6, 7);
        ds.unionBySize(5, 6);

        // Check if 3 and 7 belong to the same component
        if (ds.findParent(3) == ds.findParent(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not Same");
        }

        ds.unionBySize(3, 7);

        // Check again after connecting 3 and 7
        if (ds.findParent(3) == ds.findParent(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not Same");
        }
    }
}
