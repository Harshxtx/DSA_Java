package Graph;
// Graph
//
// A Graph is a non-linear data structure consisting of:
// 1. Vertices (Nodes)
// 2. Edges (Connections)
//
// A graph is represented as G = (V, E) where:
// V = Set of Vertices
// E = Set of Edges
//
// Example:
//
//      0 ------- 1
//      |         |
//      |         |
//      2 ------- 3
//
// Vertices = {0,1,2,3}
// Edges = {(0,1),(1,3),(3,2),(2,0)}
//
// --------------------------------------------------
//
// Types of Graphs
//
// 1. Undirected Graph
//    0 ----- 1
//
//    Edge works in both directions.
//
//
// 2. Directed Graph
//    0 -----> 1
//
//    Edge has only one direction.
//
//
// 3. Weighted Graph
//
//    0 --5-- 1
//
//    Edge stores weight/cost.
//
//
// 4. Unweighted Graph
//
//    Only connection matters.
//
//
// 5. Cyclic Graph
//
//    Contains at least one cycle.
//
//
// 6. Acyclic Graph
//
//    No cycle exists.
//
// --------------------------------------------------
//
// Graph Terminology
//
// Degree
// Number of edges connected to a node.
//
// In-Degree
// Number of incoming edges.
//
// Out-Degree
// Number of outgoing edges.
//
// Path
// Sequence of vertices connected by edges.
//
// Cycle
// Path that starts and ends at same vertex.
//
// Connected Graph
// Every vertex is reachable.
//
// Disconnected Graph
// Some vertices are unreachable.
//
// --------------------------------------------------
//
// Graph Representations
// 1. Adjacency Matrix
// 2. Adjacency List
//
// --------------------------------------------------
//
// Graph Traversals
// 1. Breadth First Search (BFS)
// 2. Depth First Search (DFS)
//
// --------------------------------------------------
//
// Time Complexity:
//
// Adjacency Matrix
// Space : O(V²)
//
// Adjacency List
// Space : O(V + E)
//
// BFS
// O(V + E)
//
// DFS
// O(V + E)
public class Graph_Intro {
    public static void main(String args[]) {
        System.out.println("Welcome to Graph Introduction");
    }
}
