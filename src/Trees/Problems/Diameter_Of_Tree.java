package Trees.Problems;

import java.util.*;

public class Diameter_Of_Tree {
    private Node root;

    private static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    void createTree(){
        //        1
        //       / \
        //      2   3
        //     / \   \
        //    4   5   6
        //   / \
        //  7   8
        root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.right = new Node(6);

        root.left.left.left = new Node(7);
        root.left.left.right = new Node(8);
    }
// Diameter of Binary Tree (Naive)
//
// Diameter of tree = maximum of
// 1. Diameter through current node
// 2. Left subtree diameter
// 3. Right subtree diameter
//
// Core Idea:
// Diameter through current node =
// leftHeight + rightHeight + 1
//
// Time Complexity : O(n²)
// Space Complexity : O(h)
// where h = height of the tree

     // 1st Method
//    int height(Node root) {
//        if(root==null)
//            return 0;
//        return 1+Math.max(height(root.left),height(root.right));
//    }
//    int diameter(Node root) {
//        if(root==null)
//            return 0;
//        int l=diameter(root.left);
//        int r=diameter(root.right);
//        int f=height(root.left)+height(root.right);        //for edges //use +1 if required in terms of nodes
//        int ans=Math.max(f,Math.max(l,r));
//        return ans;
//    }


// Diameter of Binary Tree (Optimized)
//
// Optimization:
// Height and diameter are computed together
// in a single DFS traversal, avoiding repeated
// height calculations.
//
// DFS returns height of current node.
//
// At every node:
// 1. Get left subtree height.
// 2. Get right subtree height.
// 3. Diameter through current node = leftHeight + rightHeight.
//    (+1 if diameter is required in nodes)
// 4. Update maximum diameter.
// 5. Return current node height.
//
// Time Complexity : O(n)
// Space Complexity : O(h)
// where h = height of the tree

    //2nd Method
    int diameter=0;
    int dfs(Node root){
        if(root==null)
            return 0;
        int leftHeight=dfs(root.left);
        int righHeight=dfs(root.right);
        int currdia=leftHeight+righHeight;                          //for edges //use +1 if required in terms of nodes
        diameter=Math.max(diameter,currdia);
        return 1+Math.max(leftHeight,righHeight);
    }
    public int diameterOfBinaryTree(Node root) {
        diameter=0;
        dfs(root);
        return diameter;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Diameter_Of_Tree tree = new Diameter_Of_Tree();
        tree.createTree();
        int dia= tree.diameterOfBinaryTree(tree.root);
        System.out.println("The diameter of the tree is "+dia);
    }
}
