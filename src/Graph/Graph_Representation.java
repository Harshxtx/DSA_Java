package Graph;
// Graph Representation
//
// A graph can be represented in two ways:
//
// 1. Adjacency Matrix
// 2. Adjacency List
//
// --------------------------------------------------
//
// 1. Adjacency Matrix
//
// Uses a 2D array of size V × V.
//
// matrix[i][j] = 1
// means an edge exists between vertex i and vertex j.
//
// For a weighted graph,
// matrix[i][j] stores the edge weight.
//
// Space Complexity : O(V²)
//
// Advantages:
// • Easy to implement.
// • Checking whether an edge exists takes O(1).
//
// Disadvantages:
// • Wastes memory for sparse graphs.
// • Iterating over neighbours takes O(V).
//
// --------------------------------------------------
//
// 2. Adjacency List
//
// Uses an ArrayList for every vertex.
//
// list[i] stores all neighbours of vertex i.
//
// For weighted graphs,
// each neighbour also stores its weight.
//
// Space Complexity : O(V + E)
//
// Advantages:
// • Space efficient.
// • Iterating over neighbours takes O(Degree of vertex).
//
// Disadvantages:
// • Checking whether an edge exists may take O(Degree).
//
// --------------------------------------------------
//
// Which one is preferred?
//
// Adjacency List
//
// Because most real-world graphs are sparse,
// making it much more space efficient.
//
// Almost all graph interview questions
// use Adjacency List representation.

import java.util.*;

public class Graph_Representation {
    // Undirected Graph
    // matrix[u][v]=1;      //graph.get(u).add(v);
    // matrix[v][u]=1;      //graph.get(v).add(u);

    // Directed Graph
    // matrix[u][v]=1;      //graph.get(u).add(v);

    // Weighted Graph (Undirected)
    // matrix[u][v] = weight;       //graph.get(u).add(new Pair(v, weight));
    // matrix[v][u] = weight;       //graph.get(v).add(new Pair(u, weight));

    // Weighted Graph (Directed)
    // matrix[u][v] = weight;       //graph.get(u).add(new Pair(v, weight));

    int [][] createGraphMatrix(int edges[][],int V){
        int [][]graph = new int[V][V];
        for(int a[]:edges){
            int u=a[0];
            int v=a[1];
            graph[u][v]=1;
            graph[v][u]=1;
        }
        return graph;
    }
    List<List<Integer>> createGraphList(int edges[][],int V){
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<V;i++){
            graph.add(new ArrayList<>());
        }
        for(int a[]:edges){
            int u=a[0];
            int v=a[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return graph;
    }
    void displayMatrix(int graph[][], int V){
        System.out.println("Adjacency Matrix: ");
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
    }
    void displayList(List<List<Integer>> graph,int V){
        System.out.println("Adjacency List: ");
        for(int i=0;i<V;i++) {
            System.out.print(i + " -> ");
            for(int neighbour:graph.get(i)) {
                System.out.print(neighbour + " ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Graph_Representation ob = new Graph_Representation();

        int vertices=4;

        // Undirected Unweighted Graph
        int edges[][]={{0,1},{0,2},{1,2},{1,3}};

        int matrix[][]=ob.createGraphMatrix(edges, vertices);
        List<List<Integer>> adjList=ob.createGraphList(edges, vertices);

        ob.displayMatrix(matrix,vertices);
        ob.displayList(adjList,vertices);
    }
}
