package Trees.Problems;
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
    int height(Node root) {
        if(root==null)
            return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }
    int diameter(Node root) {
        if(root==null)
            return 0;
        int l=diameter(root.left);
        int r=diameter(root.right);
        int f=height(root.left)+height(root.right)+1;        //for nodes //remove +1 for no. of edges
        int ans=Math.max(f,Math.max(l,r));
        return ans;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Diameter_Of_Tree tree = new Diameter_Of_Tree();
        tree.createTree();
        int dia= tree.diameter(tree.root);
        System.out.println("The diameter of the tree is "+dia);
    }
}
