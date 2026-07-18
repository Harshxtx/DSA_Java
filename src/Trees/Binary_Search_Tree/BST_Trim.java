package Trees.Binary_Search_Tree;
// Method: Recursive Solution
//
// Idea:
// Remove all nodes whose values
// are outside the given range [low, high].
//
// Cases:
//
// 1. If root.data < low
//    -> Entire left subtree is smaller,
//       so discard it and move to right.
//
// 2. If root.data > high
//    -> Entire right subtree is larger,
//       so discard it and move to left.
//
// 3. Otherwise,
//    -> Root lies within the range.
//       Recursively trim both subtrees.
//
// Time Complexity : O(n)
// Space Complexity : O(h)

import java.util.*;

public class BST_Trim {
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
        //        8
        //       / \
        //      3   10
        //     / \   \
        //    1   6   17
        root = new Node(8);

        root.left = new Node(3);
        root.right = new Node(10);

        root.left.left = new Node(1);
        root.left.right = new Node(6);

        root.right.right = new Node(17);
    }
    void display(Node root){
        if(root==null){
            return;
        }
        display(root.left);
        System.out.print(root.data+" ");
        display(root.right);
    }
    Node trimBST(Node root, int low, int high) {
        if(root==null)
            return null;

        if(root.data<low)
            return trimBST(root.right,low,high);
        if(root.data>high)
            return trimBST(root.left,low,high);

        root.left=trimBST(root.left,low,high);
        root.right=trimBST(root.right,low,high);

        return root;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        BST_Trim tree = new BST_Trim();
        tree.createTree();
        int low=3, high=10;
        System.out.print("Original Tree: ");
        tree.display(tree.root);
        tree.root=tree.trimBST(tree.root,low,high);
        System.out.print("\nTree after Trim: ");
        tree.display(tree.root);
    }
}
